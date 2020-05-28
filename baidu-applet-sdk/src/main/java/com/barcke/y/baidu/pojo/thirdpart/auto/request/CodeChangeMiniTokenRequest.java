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
public class CodeChangeMiniTokenRequest {

    /**
     * 第三方平台的接口调用凭据
     */
    @BaiduFieldName("access_token")
    private String accessToken;

    /**
     * 授权码
     */
    @BaiduFieldName("code")
    private String code;

    /**
     * 固定字符串：app_to_tp_authorization_code
     */
    @BaiduFieldName("grant_type")
    private String grantType = "app_to_tp_authorization_code";

    public CodeChangeMiniTokenRequest(String accessToken, String code){
        this.accessToken=accessToken;
        this.code=code;
    }
}
