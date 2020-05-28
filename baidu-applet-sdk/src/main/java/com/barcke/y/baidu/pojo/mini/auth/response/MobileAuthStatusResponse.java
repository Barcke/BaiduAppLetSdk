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
public class MobileAuthStatusResponse {

    /**
     * 	状态码
     */
    private String errno;

    /**
     * 	状态描述
     */
    private String msg;
    private Data data;

    @lombok.Data
    public class Data{

        /**
         * 状态(0:取消 1:待审核 2:拒绝 3:通过)
         */
        private String status;

        /**
         * 	失败原因(仅在被拒绝时存在)
         */
        private String reason;
    }
}
