package com.barcke.y.baidu.pojo.thirdpart.template.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class GetTemplateDraftListResponse {

    /**
     * 	状态码
     */
    private String errno;

    /**
     * 状态描述
     */
    private String msg;

    /**
     * 	响应参数
     */
    private Data data;

    @lombok.Data
    public class Data{

        /**
         * 总共拥有的模板草稿数量
         */
        private String count;

        private List<Details> list;

        @lombok.Data
        public class Details{
            /**
             * 	草稿id
             */
            private String draft_id;

            /**
             * 模板版本信息
             */
            private String user_version;

            /**
             * 模板描述信息
             */
            private String user_desc;

            /**
             * 	创建时间
             */
            private String create_time;

            /**
             * 是否支持web化，开发者工具编译版本2.15.07以上传的草稿支持web化。
             */
            private String web_status;
        }

    }

}
