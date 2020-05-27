package com.barcke.y.baidu.service.impl;

import com.barcke.y.baidu.component.bd.utils.BaiduDataDecoder;
import com.barcke.y.baidu.component.exception.BaiduException;
import com.barcke.y.baidu.pojo.mini.user.response.GetUserInfoResponse;
import com.barcke.y.baidu.service.BaiduMiniUserService;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

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
  * @ClassName BaiduMiniUserServiceImpl
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/27 11:14 上午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 
  **/
public class BaiduMiniUserServiceImpl implements BaiduMiniUserService {


    @Override
    public GetUserInfoResponse getUserInfo(String data, String sessionKey) {
        if (StringUtils.isAnyBlank(data, sessionKey)) {
            throw new BaiduException(String.format("参数不能为空data、sessionKey===》%s,%s",data,sessionKey));
        }

        BaiduDataDecoder baiduDataDecoder=new BaiduDataDecoder();
        String resultData = baiduDataDecoder.decrypt(data, sessionKey);
        Gson gson=new Gson();
        return gson.fromJson(resultData, GetUserInfoResponse.class);
    }
}
