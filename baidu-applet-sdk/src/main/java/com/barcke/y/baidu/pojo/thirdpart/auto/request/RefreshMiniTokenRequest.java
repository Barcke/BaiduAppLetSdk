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
  * @ProjectName BaiduAppLetSdk
  * @ClassName RefreshTokenRequest
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/26 9:05 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 刷新授权小程序的接口调用凭据
  **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshMiniTokenRequest {

    /**
     * 第三方平台的接口调用凭据
     * @author barcke
     * @date 2020/5/26
     */
    @BaiduFieldName("access_token")
    private String accessToken;

    /**
     * 接口调用凭据刷新令牌，有效期10年，使用后失效
     * @author barcke
     * @date 2020/5/26
     */
    @BaiduFieldName("refresh_token")
    private String refreshToken;

    /**
     * 固定字符串： app_to_tp_refresh_token
     * @author barcke
     * @date 2020/5/26
     */
    @BaiduFieldName("grant_type")
    private String grantType = "app_to_tp_refresh_token";

    public RefreshMiniTokenRequest(String accessToken, String refreshToken){
        this.accessToken=accessToken;
        this.refreshToken=refreshToken;
    }
}
