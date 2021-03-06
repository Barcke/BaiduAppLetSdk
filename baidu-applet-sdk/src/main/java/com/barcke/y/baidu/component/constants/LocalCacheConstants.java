package com.barcke.y.baidu.component.constants;

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
public class LocalCacheConstants {

    /**
     * 通过该key 可在localCache（本地缓存）中获取百度第三方token 返回值为 AccessTokenResponse 该类
     */
    public static final String GET_THIRD_PART_ACCESS_TOKEN = "thirdPartAccessToken";

    /**
     * 通过该key 可在localCache（本地缓存）中获取百度第三方预授权码 返回值为 PreAuthCodeResponse 该类
     */
    public static final String GET_THIRD_PART_PRE_AUTH_CODE = "thirdPartPreAuthCode";

    /**
     * 通过该key 可在localCache（本地缓存）中获取百度第三方小程序授权信息 返回值为 MiniTokenResponse 该类
     */
    public static final String GET_THIRD_PART_CHANGE_MINI_TOKEN_KEY = "thirdPartMiniToken";

    /**
     * 通过该key 可在localCache（本地缓存）中获取百度小程序登录信息 返回值为 MiniLoginResponse 该类
     */
    public static final String GET_MINI_LOGIN = "miniLogin";
}
