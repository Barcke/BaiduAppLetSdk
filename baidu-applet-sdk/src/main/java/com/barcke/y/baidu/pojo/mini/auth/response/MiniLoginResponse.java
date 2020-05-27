package com.barcke.y.baidu.pojo.mini.auth.response;

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
  * @ClassName MiniLoginResponse
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/26 4:41 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 
  **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MiniLoginResponse {

    private String openid;

    private String session_key;
    private String error;
    private String error_description;
}
