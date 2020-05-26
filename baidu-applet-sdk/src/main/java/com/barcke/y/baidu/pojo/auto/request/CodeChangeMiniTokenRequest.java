package com.barcke.y.baidu.pojo.auto.request;

import com.barcke.y.baidu.annotation.BaiduFieldName;
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
  * @ClassName CodeChangeTokenRequest
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/26 8:31 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 
  **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CodeChangeMiniTokenRequest {

    /**
     * 第三方平台的接口调用凭据
     * @author barcke
     * @date 2020/5/26
     */
    @BaiduFieldName("access_token")
    private String accessToken;

    /**
     * 授权码
     * @author barcke
     * @date 2020/5/26
     */
    @BaiduFieldName("code")
    private String code;

    /**
     * 固定字符串：app_to_tp_authorization_code
     * @author barcke
     * @date 2020/5/26
     */
    @BaiduFieldName("grant_type")
    private String grantType = "app_to_tp_authorization_code";

    public CodeChangeMiniTokenRequest(String accessToken, String code){
        this.accessToken=accessToken;
        this.code=code;
    }
}
