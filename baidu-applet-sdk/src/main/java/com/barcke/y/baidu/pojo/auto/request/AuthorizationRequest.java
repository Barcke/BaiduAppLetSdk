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
  * @ClassName AuthorizationRequest
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/26 6:02 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 引导小程序管理员对第三方平台进行授权
  **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorizationRequest {

    /**
     * 第三方平台Key
     * @author barcke
     * @date 2020/5/26
     */
    @BaiduFieldName("client_id")
    private String thirdPartAppKey;

    /**
     * 预授权码
     * @author barcke
     * @date 2020/5/26
     */
    @BaiduFieldName("pre_auth_code")
    private String preAuthCode;

    /**
     * 回调URI
     * @author barcke
     * @date 2020/5/26
     */
    @BaiduFieldName("redirect_uri")
    private String redirectUri;
}
