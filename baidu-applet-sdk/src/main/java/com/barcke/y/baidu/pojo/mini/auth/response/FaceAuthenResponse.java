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
  * @author Barcke
  * @version 1.0
  **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaceAuthenResponse {

    /**
     * 状态码
     */
    private String errno;

    /**
     * 状态描述
     */
    private String msg;
    private Data data;

    @lombok.Data
    public class Data{

        /**
         * 二维码(base64编码图片)
         */
        private String qrcode;

        /**
         * 过期时间
         */
        private String timeout;

        /**
         * 认证任务状态(1：初始化；2：通过；4：拒绝；6：进行中)
         */
        private String legal_face_status;
    }
}
