package com.barcke.y.baidu.pojo.thirdpart.auto.response;

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
  * @author Barcke
  * @version 1.0
  **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreAuthCodeResponse {

    /**
     * 错误情况下: 错误码；关于错误码的详细信息请参考 https://developer.baidu.com/wiki/index.php?title=docs/oauth/error 。
     */
    private String errno;

    /**
     * 错误情况下: 错误描述信息，用来帮助理解和解决发生的错误。
     */
    private String msg;

    private Data data;

    @lombok.Data
    public class Data{

        /**
         * 预授权码
         */
        private String pre_auth_code;

        /**
         * 凭证有效时间，单位：秒，默认20分钟
         */
        private String expires_in;
    }
}
