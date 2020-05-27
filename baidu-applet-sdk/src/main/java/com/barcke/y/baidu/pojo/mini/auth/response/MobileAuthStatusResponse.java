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
  * @ClassName MobileAuthStatusResponse
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/27 4:28 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 查询手机号权限状态
  **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileAuthStatusResponse {

    /**
     * 	状态码
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
    private Data data;

    @lombok.Data
    public class Data{

        /**
         * 状态(0:取消 1:待审核 2:拒绝 3:通过)
         * @author barcke
         * @date 2020/5/27
         */
        private String status;

        /**
         * 	失败原因(仅在被拒绝时存在)
         * @author barcke
         * @date 2020/5/27
         */
        private String reason;
    }
}
