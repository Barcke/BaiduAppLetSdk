package com.barcke.y.baidu.pojo.mini.auth.request;

import com.barcke.y.baidu.component.annotation.BaiduFieldName;
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
  * @ClassName FaceAuthenRequest
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/27 7:29 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 法人人脸识别认证请求
  **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaceAuthenRequest {

    @BaiduFieldName("access_token")
    private String miniToken;
}
