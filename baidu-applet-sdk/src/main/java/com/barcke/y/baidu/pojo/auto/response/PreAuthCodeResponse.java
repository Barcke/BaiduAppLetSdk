package com.barcke.y.baidu.pojo.auto.response;

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
  * @ClassName PreAuthCodeResponse
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/26 5:36 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 
  **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreAuthCodeResponse {

    /**
     * 错误情况下: 错误码；关于错误码的详细信息请参考 https://developer.baidu.com/wiki/index.php?title=docs/oauth/error 。
     * @author barcke
     * @date 2020/5/26
     */
    private String errno;

    /**
     * 错误情况下: 错误描述信息，用来帮助理解和解决发生的错误。
     * @author barcke
     * @date 2020/5/26
     */
    private String msg;

    private Data data;

    @lombok.Data
    public class Data{

        /**
         * 预授权码
         * @author barcke
         * @date 2020/5/26
         */
        private String pre_auth_code;

        /**
         * 凭证有效时间，单位：秒，默认20分钟
         * @author barcke
         * @date 2020/5/26
         */
        private String expires_in;
    }
}
