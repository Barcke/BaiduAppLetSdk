package com.barcke.y.baidu.pojo.auto.request;

import com.barcke.y.baidu.annotation.BaiduFieldName;
import lombok.AllArgsConstructor;
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
  * @ClassName PreAuthCodeRequest
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/26 5:35 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 
  **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreAuthCodeRequest {

    /**
     * 第三方平台的接口调用凭据
     * @author barcke
     * @date 2020/5/26
     * @return
     */
    @BaiduFieldName("access_token")
    private String accessToekn;
}
