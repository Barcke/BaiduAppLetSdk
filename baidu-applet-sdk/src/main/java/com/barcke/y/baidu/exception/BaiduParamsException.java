package com.barcke.y.baidu.exception;

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
 * @ProjectName api
 * @ClassName BaiduException
 * @Description TODO
 * @Author Barcke
 * @Date 2020/4/30 10:49 上午
 * @Version 1.0
 * @description:
 **/
public class BaiduParamsException extends RuntimeException {

    public BaiduParamsException(){

    }

    public BaiduParamsException(String msg){
        super(msg);
    }

}
