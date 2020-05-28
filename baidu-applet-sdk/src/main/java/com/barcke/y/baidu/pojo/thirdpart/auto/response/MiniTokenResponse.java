package com.barcke.y.baidu.pojo.thirdpart.auto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
  * 刷新授权小程序的接口调用凭据
  **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MiniTokenResponse {

    /**
     * 授权小程序的接口调用凭据
     */
    private String access_token;

    /**
     * 接口调用凭据刷新令牌，有效期10年，使用一次后失效
     */
    private String refresh_token;

    /**
     * 	Access Token的有效期，单位：秒，默认1小时
     */
    private String expires_in;

    /**
     * 错误码；关于错误码的详细信息请参考 https://developer.baidu.com/wiki/index.php?title=docs/oauth/error
     */
    private String error;

    /**
     * 错误描述信息，用来帮助理解和解决发生的错误
     */
    private String error_description;
}
