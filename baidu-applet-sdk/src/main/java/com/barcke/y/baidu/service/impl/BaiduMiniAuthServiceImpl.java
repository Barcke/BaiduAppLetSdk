package com.barcke.y.baidu.service.impl;

import com.barcke.y.baidu.component.LocalCache;
import com.barcke.y.baidu.component.bd.utils.HttpUtil;
import com.barcke.y.baidu.constants.BaiduUrlConstants;
import com.barcke.y.baidu.constants.LocalCacheConstants;
import com.barcke.y.baidu.exception.BaiduException;
import com.barcke.y.baidu.exception.BaiduParamsException;
import com.barcke.y.baidu.pojo.auto.response.MiniTokenResponse;
import com.barcke.y.baidu.pojo.mini.request.MiniLoginRequest;
import com.barcke.y.baidu.pojo.mini.response.MiniLoginResponse;
import com.barcke.y.baidu.service.BaiduMiniAuthService;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
  *                  ,;,,;
  *                ,;;'(    社
  *      __      ,;;' ' \   会
  *   /'  '\'~~'~' \ /'\.)  主
  * ,;(      )    /  |.     义
  *,;' \    /-.,,(   ) \    码
  *     ) /       ) / )|    农
  *     ||        ||  \)     
  *     (_\       (_\
  *
  * @ProjectName BaiduAppLetSdk
  * @ClassName BaiduMiniAuthServiceImpl
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/26 9:31 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 
  **/
public class BaiduMiniAuthServiceImpl implements BaiduMiniAuthService {

    @Autowired
    private LocalCache localCache;

    @Override
    public MiniLoginResponse miniLogin(String accessToken, String code) {
        if (StringUtils.isAnyBlank(accessToken,code)) {
            throw new BaiduParamsException("参数不能为空");
        }
        String response = HttpUtil.sendGet(BaiduUrlConstants.GET_SESSION_KEY_BY_CODE_URL, new MiniLoginRequest(code,accessToken));

        MiniLoginResponse miniLoginResponse = new Gson().fromJson(response, MiniLoginResponse.class);

        if (StringUtils.isNotBlank(miniLoginResponse.getError())){
            throw new BaiduException("小程序登录异常===》"+response);
        }

        localCache.setLocalCache(LocalCacheConstants.GET_MINI_LOGIN,miniLoginResponse);

        return miniLoginResponse;
    }

    @Override
    public MiniLoginResponse miniLogin(String code) {
        return miniLogin(
                ((MiniTokenResponse)localCache.getCache(LocalCacheConstants.GET_THIRD_PART_CHANGE_MINI_TOKEN_KEY)).getAccess_token(),
                code
        );
    }
}
