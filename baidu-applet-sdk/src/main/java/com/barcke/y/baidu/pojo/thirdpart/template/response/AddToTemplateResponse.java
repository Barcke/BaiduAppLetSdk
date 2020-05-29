package com.barcke.y.baidu.pojo.thirdpart.template.response;

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
public class AddToTemplateResponse {

    /**
     * 	状态码
     */
    private String errno;

    /**
     * 	状态描述
     */
    private String msg;

    /**
     * 响应参数
     */
    private Data data;

    @lombok.Data
    public class Data{

        /**
         * 	返回模板id
         */
        private String template_id;
    }
}
