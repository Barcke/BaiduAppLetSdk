package com.barcke.y.baidu.component.context;

import com.barcke.y.baidu.component.LocalCache;
import com.barcke.y.baidu.component.constants.LocalCacheConstants;
import com.barcke.y.baidu.pojo.thirdpart.auto.response.AccessTokenResponse;
import com.barcke.y.baidu.pojo.thirdpart.auto.response.MiniTokenResponse;
import com.barcke.y.baidu.pojo.thirdpart.auto.response.PreAuthCodeResponse;
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
  * @ClassName BaiduApplicationContext
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/27 4:17 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 
  **/
public class BaiduApplicationContext {

    @Autowired
    private LocalCache localCache;

    public String getMiniToken(){
        return ((MiniTokenResponse)localCache.getCache(LocalCacheConstants.GET_THIRD_PART_CHANGE_MINI_TOKEN_KEY)).getAccess_token();
    }

    public String getMiniRefreshToken(){
        return ((MiniTokenResponse)localCache.getCache(LocalCacheConstants.GET_THIRD_PART_CHANGE_MINI_TOKEN_KEY)).getRefresh_token();
    }

    public String getAccessToken(){
        return ((AccessTokenResponse)localCache.getCache(LocalCacheConstants.GET_THIRD_PART_ACCESS_TOKEN)).getData().getAccess_token();
    }

    public String getPreAuthCode(){
        return ((PreAuthCodeResponse)localCache.getCache(LocalCacheConstants.GET_THIRD_PART_PRE_AUTH_CODE)).getData().getPre_auth_code();
    }
}
