package com.barcke.y.baidu.pojo.thirdpart.auto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
  * @ClassName AccessTokenResponse
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/26 11:10 上午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 通过ticket获取token返回值信息
  * 返回值示例：
  * {
  *     "errno":0,
  *     "msg":"success",
  *     "data" :{
  *         "access_token": "42.12835b16c449ae00f7d9a61570516b4f.2592000.1535536744.aPk4Eh420Yt-2JdTBB_F-34gJWz93WxN4e9rQhN",
  *         "expires_in": 2592000,
  *         "scope": "smartapp_tp_smtapp_common public"
  *     }
  * }
  **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccessTokenResponse {

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
         * 第三方平台的接口调用凭据
         * @author barcke
         * @date 2020/5/26
         */
        private String access_token;
        /**
         * 凭证有效时间，单位：秒
         * @author barcke
         * @date 2020/5/26
         */
        private String expires_in;
        /**
         * 拥有的权限说明
         * @author barcke
         * @date 2020/5/26
         */
        private String scope;
    }

}
