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
public class RefreshMiniTokenRequest {

    /**
     * 第三方平台的接口调用凭据
     */
    @BaiduFieldName("access_token")
    private String accessToken;

    /**
     * 接口调用凭据刷新令牌，有效期10年，使用后失效
     */
    @BaiduFieldName("refresh_token")
    private String refreshToken;

    /**
     * 固定字符串： app_to_tp_refresh_token
     */
    @BaiduFieldName("grant_type")
    private String grantType = "app_to_tp_refresh_token";

    public RefreshMiniTokenRequest(String accessToken, String refreshToken){
        this.accessToken=accessToken;
        this.refreshToken=refreshToken;
    }
}
