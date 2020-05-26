package com.barcke.y.baidu.annotation;

import java.lang.annotation.*;

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
  * @ClassName BaiduFieldName
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/26 11:12 上午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 
  **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BaiduFieldName {

    /**
     * 百度接口中指定的key名称
     * @author barcke
     * @date 2020/5/26
     */
    String value();

}
