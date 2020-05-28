package com.barcke.y.baidu.component.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

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
@NoArgsConstructor
@AllArgsConstructor
public enum BaiduErrorInfoEnums {

    INVALID_REQUEST("invalid_request","请求缺少某个必需参数，包含一个不支持的参数或参数值，或者格式不正确。"),
    INVALID_CLIENT("invalid_client","client_id”、“client_secret”参数无效。"),
    INVALID_GRANT("invalid_grant","提供的Access Grant是无效的、过期的或已撤销的，例如，Authorization Code无效(一个授权码只能使用一次)、Refresh Token无效、redirect_uri与获取Authorization Code时提供的不一致、Devie Code无效(一个设备授权码只能使用一次)等。"),
    UNAUTHORIZED_CLIENT("unauthorized_client","应用没有被授权，无法使用所指定的grant_type。"),
    UNSUPPORTED_GRANT_TYPE("unsupported_grant_type","“grant_type”百度OAuth2.0服务不支持该参数。"),
    INVALID_SCOPE("invalid_scope","请求的“scope”参数是无效的、未知的、格式不正确的、或所请求的权限范围超过了数据拥有者所授予的权限范围。"),
    EXPIRED_TOKEN("expired_token","提供的Refresh Token已过期"),
    REDIRECT_URI_MISMATCH("redirect_uri_mismatch","“redirect_uri”所在的根域与开发者注册应用时所填写的根域名不匹配。"),
    UNSUPPORTED_RESPONSE_TYPE("unsupported_response_type","“response_type”参数值不为百度OAuth2.0服务所支持，或者应用已经主动禁用了对应的授权模式"),
    SLOW_DOWN("slow_down","Device Flow中，设备通过Device Code换取Access Token的接口过于频繁，两次尝试的间隔应大于5秒。"),
    AUTHORIZATION_PENDING("authorization_pending","Device Flow中，用户还没有对Device Code完成授权操作。"),
    AUTHORIZATION_DECLINED("authorization_declined","Device Flow中，用户拒绝了对Device Code的授权操作。"),
    INVALID_REFERER("invalid_referer","Implicit Grant模式中，浏览器请求的Referer与根域名绑定不匹配"),
    ;

    /**
     * 错误码
     */
    @Getter
    private String error;
    /**
     * 详细描述
     */
    @Getter
    private String msg;

    /**
     * 通过错误吗获得描述信息
     * @param error 错误码
     * @return java.lang.String
     */
    public static final String getMsgByErrorCode(String error){
        if (StringUtils.isBlank(error)) {
            return "";
        }
        BaiduErrorInfoEnums baiduErrorInfo = Arrays.stream(BaiduErrorInfoEnums.values()).filter(
                baiduErrorInfoEnums -> baiduErrorInfoEnums.error.equals(error)
        ).findFirst().orElseGet(null);
        if (null==baiduErrorInfo) {
            return "";
        }
        return baiduErrorInfo.msg;
    }
}
