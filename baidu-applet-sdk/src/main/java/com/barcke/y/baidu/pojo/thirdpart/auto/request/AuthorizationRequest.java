package com.barcke.y.baidu.pojo.thirdpart.auto.request;

import com.barcke.y.baidu.component.annotation.BaiduFieldName;
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
  **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorizationRequest {

    /**
     * 第三方平台Key
     */
    @BaiduFieldName("client_id")
    private String thirdPartAppKey;

    /**
     * 预授权码
     */
    @BaiduFieldName("pre_auth_code")
    private String preAuthCode;

    /**
     * 回调URI
     */
    @BaiduFieldName("redirect_uri")
    private String redirectUri;
}
