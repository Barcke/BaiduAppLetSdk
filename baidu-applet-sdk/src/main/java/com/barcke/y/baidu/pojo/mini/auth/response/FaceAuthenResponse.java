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
  * @ClassName FaceAuthenResponse
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/27 7:30 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description:  法人人脸识别认证响应
  **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaceAuthenResponse {

    /**
     * 状态码
     * @author barcke
     * @date 2020/5/27
     */
    private String errno;

    /**
     * 状态描述
     * @author barcke
     * @date 2020/5/27
     */
    private String msg;
    private Data data;

    @lombok.Data
    public class Data{

        /**
         * 二维码(base64编码图片)
         * @author barcke
         * @date 2020/5/27
         */
        private String qrcode;

        /**
         * 过期时间
         * @author barcke
         * @date 2020/5/27
         */
        private String timeout;

        /**
         * 认证任务状态(1：初始化；2：通过；4：拒绝；6：进行中)
         * @author barcke
         * @date 2020/5/27
         */
        private String legal_face_status;
    }
}
