package com.barcke.y.baidu.component.context;

import com.barcke.y.baidu.component.LocalCache;
import com.barcke.y.baidu.component.constants.LocalCacheConstants;
import com.barcke.y.baidu.component.exception.BaiduException;
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
  * @author Barcke
  * @version 1.0
  **/
public class BaiduApplicationContext {

    @Autowired
    private LocalCache localCache;

    /**
     * 从缓存中获取小程序对应的授权密钥
     * @return String 小程序的授权密钥
     */
    public String getMiniToken(){
        return ((MiniTokenResponse)getCache(LocalCacheConstants.GET_THIRD_PART_CHANGE_MINI_TOKEN_KEY)).getAccess_token();
    }

    /**
     * 从缓存中获取小程序的刷新用密钥
     * @return String 小程序的刷新用密钥
     */
    public String getMiniRefreshToken(){
        return ((MiniTokenResponse)getCache(LocalCacheConstants.GET_THIRD_PART_CHANGE_MINI_TOKEN_KEY)).getRefresh_token();
    }

    /**
     * 从缓存中获取第三方的授权密钥
     * @return String 第三方的授权密钥
     */
    public String getAccessToken(){
        return ((AccessTokenResponse)getCache(LocalCacheConstants.GET_THIRD_PART_ACCESS_TOKEN)).getData().getAccess_token();
    }

    /**
     * 从缓存中获取第三方的预授权码
     * @return String 第三方的预授权码
     */
    public String getPreAuthCode(){
        return ((PreAuthCodeResponse)getCache(LocalCacheConstants.GET_THIRD_PART_PRE_AUTH_CODE)).getData().getPre_auth_code();
    }

    /**
     * 从缓存中拿取数据 如果没有找到则抛出异常
     * @param keys 缓存数据的key名称
     * @return Object 缓存数据对应的实体
     */
    private Object getCache(String keys){
        Object cache = localCache.getCache(keys);
        if (null==cache){
            throw new BaiduException(String.format("在本地缓存中未能找到对应的缓存数据===》%s",keys));
        }
        return cache;
    }
}
