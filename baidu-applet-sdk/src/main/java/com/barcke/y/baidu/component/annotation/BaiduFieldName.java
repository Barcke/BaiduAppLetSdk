package com.barcke.y.baidu.component.annotation;

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
  * @author Barcke
  * @version 1.0
  **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BaiduFieldName {

    /**
     * 百度接口中指定的key名称
     * @return String
     */
    String value();

    /**
     * 是否在url中拼接
     * @return boolean
     */
    boolean joinerUrl() default false;

    /**
     * 判断是否为文件
     * @return boolean
     */
    boolean file() default false;

}
