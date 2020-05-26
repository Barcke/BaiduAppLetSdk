package com.barcke.y.baidu.service;

import com.barcke.y.baidu.pojo.mini.response.MiniLoginResponse;

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
  * @ClassName BaiduMiniAuthService
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/26 9:31 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 小程序授权部分
  **/
public interface BaiduMiniAuthService {

    /**
     * 授权小程序登录
     * 第三方平台代替小程序实现登录功能请参考 小程序登录 。除了下述部分以外，其他接口的功能与小程序实现方式一致。
     * code换取session_key
     * 第三方平台开发者的服务器使用登录凭证 code 以及授权小程序 access_token 获取 session_key 和 openid。其中session_key 是对用户数据进行加密签名的密钥。
     * @author barcke
     * @date 2020/5/26
     * @param accessToken 授权小程序的接口调用凭据
     * @param code 	调用swan.login后获取的code
     * @return com.barcke.y.baidu.pojo.mini.response.MiniLoginResponse
     */
    MiniLoginResponse miniLogin(String accessToken, String code);

    /**
     * 重载方法 从localCache中获取miniToken
     * 授权小程序登录
     * 第三方平台代替小程序实现登录功能请参考 小程序登录 。除了下述部分以外，其他接口的功能与小程序实现方式一致。
     * code换取session_key
     * 第三方平台开发者的服务器使用登录凭证 code 以及授权小程序 access_token 获取 session_key 和 openid。其中session_key 是对用户数据进行加密签名的密钥。
     * @author barcke
     * @date 2020/5/26
     * @param code 	调用swan.login后获取的code
     * @return com.barcke.y.baidu.pojo.mini.response.MiniLoginResponse
     */
    MiniLoginResponse miniLogin(String code);
}
