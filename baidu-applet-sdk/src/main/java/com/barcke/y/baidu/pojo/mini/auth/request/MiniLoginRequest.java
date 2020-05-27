package com.barcke.y.baidu.pojo.mini.auth.request;

import com.barcke.y.baidu.component.annotation.BaiduFieldName;
import lombok.*;


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
 * @ClassName MiniLoginRequest
 * @Description TODO
 * @Author Barcke
 * @Date 2020/5/26 4:37 下午
 * @Version 1.0
 * @slogan: 源于生活 高于生活
 * @description: 授权小程序登录 请求实体类
 **/
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MiniLoginRequest {

    @BaiduFieldName("access_token")
    private String accessToken;

    /**
     * 调用swan.login后获取的code
     * @author barcke
     * @date 2020/5/26
     */
    @BaiduFieldName("code")
    private String code;

    /**
     * 授权类型，固定字符串："authorization_code"
     * @author barcke
     * @date 2020/5/26
     */
    @BaiduFieldName("grant_type")
    private String grantType = "authorization_code";

    public MiniLoginRequest(String code,String accessToken){
        this.code=code;
        this.accessToken=accessToken;
    }
}
