package com.barcke.y.baidu.service;

import com.barcke.y.baidu.pojo.mini.auth.request.MobileAuthRequest;
import com.barcke.y.baidu.pojo.mini.auth.response.*;

import java.io.File;

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
     * @param miniToken 授权小程序的接口调用凭据
     * @param code 	调用swan.login后获取的code
     * @return com.barcke.y.baidu.pojo.mini.auth.response.MiniLoginResponse
     */
    MiniLoginResponse miniLogin(String miniToken, String code);

    /**
     * 获取unionid
     * unionid说明：
     * 一个开发者可以创建多个小程序， 开发者可以通过unionid实现跨小程序的用户区分。从用户角度看，每个用户在一个开发者所有的小程序下的unionid是唯一的。
     * unionid 获取依赖用户登录授权，请妥善处理用户未授权场景。
     * @author barcke
     * @date 2020/5/27
     * @param miniToken 授权小程序的接口调用凭据
     * @param openId 用户openid, 需要经过用户登录授权过程获取
     * @return com.barcke.y.baidu.pojo.mini.auth.response.GetUnionIdResponse
     */
    GetUnionIdResponse getUnionId(String miniToken, String openId);

    /**
     * 申请手机号权限
     * 对于miniToken如果有给定用给定的如果没有给定则从localCache中取得如果localCache中没有则抛出异常
     * @author barcke
     * @date 2020/5/27
     * @param mobileAuthRequest 请求值
     * @return MobileAuthResponse
     */
    MobileAuthResponse mobileAuth(MobileAuthRequest mobileAuthRequest);

    /**
     * 取消申请手机号权限
     * @author barcke
     * @date 2020/5/27
     * @param miniToken 小程序token
     * @return MobileAuthResponse
     */
    MobileAuthResponse cancelMobileAuth(String miniToken);

    /**
     * 查询手机号权限状态
     * @author barcke
     * @date 2020/5/27
     * @param miniToken 小程序token
     * @return MobileAuthResponse
     */
    MobileAuthStatusResponse mobileAuthStatus(String miniToken);

    /**
     * 法人人脸识别认证
     * @author barcke
     * @date 2020/5/27
     * @param miniToken 小程序token
     * @return MobileAuthResponse
     */
    FaceAuthenResponse faceAuthen(String miniToken);

    /**
     * 重载方法 直接获取二维码文件
     * 法人人脸识别认证
     * @author barcke
     * @date 2020/5/27
     * @param miniToken 小程序token
     * @param width 生成长宽一致的二维码
     * @param imgPath 图片存储地址
     * @return MobileAuthResponse
     */
    File faceAuthenGetFile(String miniToken,int width, String imgPath);

    /**
     * 重载方法 从localCache中获取miniToken
     * 授权小程序登录
     * 第三方平台代替小程序实现登录功能请参考 小程序登录 。除了下述部分以外，其他接口的功能与小程序实现方式一致。
     * code换取session_key
     * 第三方平台开发者的服务器使用登录凭证 code 以及授权小程序 access_token 获取 session_key 和 openid。其中session_key 是对用户数据进行加密签名的密钥。
     * @author barcke
     * @date 2020/5/26
     * @param code 	调用swan.login后获取的code
     * @return com.barcke.y.baidu.pojo.mini.auth.response.MiniLoginResponse
     */
    MiniLoginResponse miniLogin(String code);

    /**
     * 重载方法 从localCache中获取miniToken
     * 获取unionid
     * unionid说明：
     * 一个开发者可以创建多个小程序， 开发者可以通过unionid实现跨小程序的用户区分。从用户角度看，每个用户在一个开发者所有的小程序下的unionid是唯一的。
     * unionid 获取依赖用户登录授权，请妥善处理用户未授权场景。
     * @author barcke
     * @date 2020/5/27
     * @param openId 用户openid, 需要经过用户登录授权过程获取
     * @return com.barcke.y.baidu.pojo.mini.auth.response.GetUnionIdResponse
     */
    GetUnionIdResponse getUnionId(String openId);

    /**
     * 重载方法从lcoalCache中获取miniToken
     * 取消申请手机号权限
     * 对于miniToken如果有给定用给定的如果没有给定则从localCache中取得如果localCache中没有则抛出异常
     * @author barcke
     * @date 2020/5/27
     * @return MobileAuthResponse
     */
    MobileAuthResponse cancelMobileAuth();

    /**
     * 重载方法从lcoalCache中获取miniToken
     * 查询手机号权限状态
     * @author barcke
     * @date 2020/5/27
     * @return MobileAuthResponse
     */
    MobileAuthStatusResponse mobileAuthStatus();

    /**
     * 法人人脸识别认证
     * @author barcke
     * @date 2020/5/27
     * @return MobileAuthResponse
     */
    FaceAuthenResponse faceAuthen();

    /**
     * 重载方法 直接获取二维码文件
     * 法人人脸识别认证
     * @author barcke
     * @date 2020/5/27
     * @return MobileAuthResponse
     */
    File faceAuthenGetFile(int width, String imgPath);
}
