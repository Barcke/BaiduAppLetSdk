package com.barcke.y.baidu.service;

import com.barcke.y.baidu.pojo.auto.response.AccessTokenResponse;
import com.barcke.y.baidu.pojo.auto.response.MiniTokenResponse;
import com.barcke.y.baidu.pojo.auto.response.PreAuthCodeResponse;

import java.util.Map;

/**
 *                 ,;,,;
 *                ,;;'(    社
 *      __      ,;;' ' \   会
 *   /'  '\'~~'~' \ /'\.)  主
 * ,;(      )    /  |.     义
 *,;' \    /-.,,(   ) \    码
 *     ) /       ) / )|    农
 *     ||        ||  \)
 *     (_\       (_\
 * @ProjectName api
 * @ClassName BaiduService
 * @Description TODO
 * @Author Barcke
 * @Date 2020/4/29 7:45 下午
 * @Version 1.0
 **/
public interface BaiduThirdPartAuthService {

    /**
     * 获取第三方平台的接口调用凭据access_token
     * 第三方平台 access_token 是第三方平台的接口调用凭据，也叫做令牌（access_token）。
     * 每个令牌是有效期一个月，且令牌的调用次数有限，请第三方平台做好令牌的管理，在令牌过期之前进行刷新。
     * @author barcke
     * @date 2020/5/26
     * @param
     * @return AccessTokenResponse
     */
    AccessTokenResponse getToken(String ticken);

    /**
     * 获取预授权码pre_auth_code
     * 用于获取预授权码，预授权码用于小程序授权时的第三方平台方安全验证。
     * @author barcke
     * @date 2020/5/26
     * @param accessToken 第三方平台的接口调用凭据
     * @return com.barcke.y.baidu.pojo.auto.response.PreAuthCodeResponse
     */
    PreAuthCodeResponse getPreAuthCode(String accessToken);

    /**
     * 引导小程序管理员对第三方平台进行授权
     * 将用户浏览器从第三方平台授权发起页地址跳转到的如下授权页面，生成授权二维码。
     * 注意：在授权前需要在第三方平台-设置-修改授权发起页域名处设置域名，否则提示发起页域名错误
     * @author barcke
     * @date 2020/5/26
     * @param preAuthCode 预授权码
     * @param redirectUri 回调URI
     * @return String 返回一个html文本
     */
    String getAuthorizationUrl(String preAuthCode,String redirectUri);

    /**
     * 使用授权码换小程序的接口调用凭据和授权信息
     * 使用授权码换取小程序的授权信息，并换取 access_token和refresh_token。
     * 授权码的获取，需要在用户在第三方平台授权页中完成授权流程后，在回调 URI 中通过 URL 参数提供给第三方平台方。
     * 说明：
     * 小程序可以自定义选择部分权限授权给第三方平台，因此第三方平台开发者需要通过步骤"8、
     * 获取小程序基础信息接口"来判断来获取小程序具体授权了哪些权限，而不是简单地认为自己声明的权限就是小程序授权的权限。
     * @author barcke
     * @date 2020/5/26
     * @param access_token 第三方平台的接口调用凭据
     * @param code 授权码
     * @return com.barcke.y.baidu.pojo.auto.response.CodeChangeTokenResponse
     */
    MiniTokenResponse codeChangeMiniToken(String access_token, String code);

    /**
     * 刷新授权小程序的接口调用凭据
     * 当在授权小程序的接口调用凭据（access_token）失效时，可用刷新令牌（refresh_token）获取新的令牌。
     * 当换取refresh_token后建议保存。
     * @author barcke
     * @date 2020/5/26
     * @param accessToken 第三方平台的接口调用凭据
     * @param refreshToken 接口调用凭据刷新令牌，有效期10年，使用后失效
     * @return com.barcke.y.baidu.pojo.auto.response.RefreshMiniTokenResponse
     */
    MiniTokenResponse refreshMiniToken(String accessToken, String refreshToken);

    /**
     * 重载方法  不需要手动解密
     * 获取第三方平台的接口调用凭据access_token
     * 第三方平台 access_token 是第三方平台的接口调用凭据，也叫做令牌（access_token）。
     * 每个令牌是有效期一个月，且令牌的调用次数有限，请第三方平台做好令牌的管理，在令牌过期之前进行刷新。
     * @author barcke
     * @date 2020/5/26
     * @param
     * @return AccessTokenResponse
     */
    AccessTokenResponse getToken(Map<String,Object> params);

    /**
     * 重载方法 accessToken从 localCache中取得
     * @author barcke
     * @date 2020/5/26
     * @return com.barcke.y.baidu.pojo.auto.response.PreAuthCodeResponse
     */
    PreAuthCodeResponse getPreAuthCode();

    /**
     * 通过ticket获取预授权码  重载方法并非百度提供～
     * 获取预授权码pre_auth_code
     * 用于获取预授权码，预授权码用于小程序授权时的第三方平台方安全验证。
     * @author barcke
     * @date 2020/5/26
     * @param ticket
     * @return com.barcke.y.baidu.pojo.auto.response.PreAuthCodeResponse
     */
    PreAuthCodeResponse getPreAuthCodeByTicket(String ticket);

    /**
     * 重载方法 不需手动解密
     * 通过ticket获取预授权码  重载方法并非百度提供～
     * 获取预授权码pre_auth_code
     * 用于获取预授权码，预授权码用于小程序授权时的第三方平台方安全验证。
     * @author barcke
     * @date 2020/5/26
     * @return com.barcke.y.baidu.pojo.auto.response.PreAuthCodeResponse
     */
    PreAuthCodeResponse getPreAuthCodeByTicket(Map<String,Object> params);

    /**
     * 重载方法 通过ticket直接获取授权页面
     * 引导小程序管理员对第三方平台进行授权
     * 将用户浏览器从第三方平台授权发起页地址跳转到的如下授权页面，生成授权二维码。
     * 注意：在授权前需要在第三方平台-设置-修改授权发起页域名处设置域名，否则提示发起页域名错误
     * @author barcke
     * @date 2020/5/26
     * @return String 返回一个html文本
     */
    String getAuthorizationUrlByTicket(String ticket,String redirectUri);

    /**
     * 重载方法 通过ticket直接获取授权页面 不需手动解密
     * 引导小程序管理员对第三方平台进行授权
     * 将用户浏览器从第三方平台授权发起页地址跳转到的如下授权页面，生成授权二维码。
     * 注意：在授权前需要在第三方平台-设置-修改授权发起页域名处设置域名，否则提示发起页域名错误
     * @author barcke
     * @date 2020/5/26
     * @return String 返回一个html文本
     */
    String getAuthorizationUrlByTicket(Map<String,Object> params,String redirectUri);

    /**
     * 重载方法 从localCache中取得预授权码
     * 引导小程序管理员对第三方平台进行授权
     * 将用户浏览器从第三方平台授权发起页地址跳转到的如下授权页面，生成授权二维码。
     * 注意：在授权前需要在第三方平台-设置-修改授权发起页域名处设置域名，否则提示发起页域名错误
     * @author barcke
     * @date 2020/5/26
     * @param redirectUri 回调URI
     * @return String 返回一个html文本
     */
    String getAuthorizationUrl(String redirectUri);

    /**
     * 重载方法 token通过ticket获取
     * 使用授权码换小程序的接口调用凭据和授权信息
     * 使用授权码换取小程序的授权信息，并换取 access_token和refresh_token。
     * 授权码的获取，需要在用户在第三方平台授权页中完成授权流程后，在回调 URI 中通过 URL 参数提供给第三方平台方。
     * 说明：
     * 小程序可以自定义选择部分权限授权给第三方平台，因此第三方平台开发者需要通过步骤"8、
     * 获取小程序基础信息接口"来判断来获取小程序具体授权了哪些权限，而不是简单地认为自己声明的权限就是小程序授权的权限。
     * @author barcke
     * @date 2020/5/26
     * @param code 授权码
     * @return com.barcke.y.baidu.pojo.auto.response.CodeChangeTokenResponse
     */
    MiniTokenResponse codeChangeMiniTokenByTicket(String ticket, String code);

    /**
     * 重载方法 token通过ticket获取
     * 使用授权码换小程序的接口调用凭据和授权信息
     * 使用授权码换取小程序的授权信息，并换取 access_token和refresh_token。
     * 授权码的获取，需要在用户在第三方平台授权页中完成授权流程后，在回调 URI 中通过 URL 参数提供给第三方平台方。
     * 说明：
     * 小程序可以自定义选择部分权限授权给第三方平台，因此第三方平台开发者需要通过步骤"8、
     * 获取小程序基础信息接口"来判断来获取小程序具体授权了哪些权限，而不是简单地认为自己声明的权限就是小程序授权的权限。
     * @author barcke
     * @date 2020/5/26
     * @param code 授权码
     * @return com.barcke.y.baidu.pojo.auto.response.CodeChangeTokenResponse
     */
    MiniTokenResponse codeChangeMiniTokenByTicket(Map<String,Object> params, String code);

    /**
     * 重载方法 从localCache中获取token
     * 使用授权码换小程序的接口调用凭据和授权信息
     * 使用授权码换取小程序的授权信息，并换取 access_token和refresh_token。
     * 授权码的获取，需要在用户在第三方平台授权页中完成授权流程后，在回调 URI 中通过 URL 参数提供给第三方平台方。
     * 说明：
     * 小程序可以自定义选择部分权限授权给第三方平台，因此第三方平台开发者需要通过步骤"8、
     * 获取小程序基础信息接口"来判断来获取小程序具体授权了哪些权限，而不是简单地认为自己声明的权限就是小程序授权的权限。
     * @author barcke
     * @date 2020/5/26
     * @param code 授权码
     * @return com.barcke.y.baidu.pojo.auto.response.CodeChangeTokenResponse
     */
    MiniTokenResponse codeChangeMiniToken(String code);

    /**
     * 重载方法 通过ticket获取accessToken
     * 刷新授权小程序的接口调用凭据
     * 当在授权小程序的接口调用凭据（access_token）失效时，可用刷新令牌（refresh_token）获取新的令牌。
     * 当换取refresh_token后建议保存。
     * @author barcke
     * @date 2020/5/26
     * @param refreshToken 接口调用凭据刷新令牌，有效期10年，使用后失效
     * @return com.barcke.y.baidu.pojo.auto.response.RefreshMiniTokenResponse
     */
    MiniTokenResponse refreshMiniTokenByTicket(String ticket, String refreshToken);

    /**
     * 重载方法 通过ticket获取accessToken
     * 刷新授权小程序的接口调用凭据
     * 当在授权小程序的接口调用凭据（access_token）失效时，可用刷新令牌（refresh_token）获取新的令牌。
     * 当换取refresh_token后建议保存。
     * @author barcke
     * @date 2020/5/26
     * @param refreshToken 接口调用凭据刷新令牌，有效期10年，使用后失效
     * @return com.barcke.y.baidu.pojo.auto.response.RefreshMiniTokenResponse
     */
    MiniTokenResponse refreshMiniTokenByTicket(Map<String,Object> params, String refreshToken);

    /**
     * 重载方法 从localCache中获取token
     * 刷新授权小程序的接口调用凭据
     * 当在授权小程序的接口调用凭据（access_token）失效时，可用刷新令牌（refresh_token）获取新的令牌。
     * 当换取refresh_token后建议保存。
     * @author barcke
     * @date 2020/5/26
     * @param refreshToken 接口调用凭据刷新令牌，有效期10年，使用后失效
     * @return com.barcke.y.baidu.pojo.auto.response.RefreshMiniTokenResponse
     */
    MiniTokenResponse refreshMiniToken(String refreshToken);

    /**
     * 重载方法 从localCache中获取token和refreshToken
     * 刷新授权小程序的接口调用凭据
     * 当在授权小程序的接口调用凭据（access_token）失效时，可用刷新令牌（refresh_token）获取新的令牌。
     * 当换取refresh_token后建议保存。
     * @author barcke
     * @date 2020/5/26
     * @return com.barcke.y.baidu.pojo.auto.response.RefreshMiniTokenResponse
     */
    MiniTokenResponse refreshMiniToken();

}
