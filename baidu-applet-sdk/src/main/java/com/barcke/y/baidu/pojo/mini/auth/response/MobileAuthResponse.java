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
  * @ClassName MobileauthResponse
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/27 3:51 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 
  **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileAuthResponse {

    /**
     * 状态码
     * @author barcke
     * @date 2020/5/27
     */
    private String errno;

    /**
     * 	状态描述
     * @author barcke
     * @date 2020/5/27
     */
    private String msg;

    /**
     * 	响应参数
     * @author barcke
     * @date 2020/5/27
     */
    private Data data;

    @lombok.Data
    public class Data{

    }
}
