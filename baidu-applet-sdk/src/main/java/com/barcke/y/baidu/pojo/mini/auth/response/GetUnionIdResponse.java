package com.barcke.y.baidu.pojo.mini.auth.response;

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
  * @ClassName GetUnionIdResponse
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/27 9:59 上午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: unionid响应类
  **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetUnionIdResponse {

    /**
     * 状态码
     * @author barcke
     * @date 2020/5/27
     */
    private String errno;

    /**
     * 状态信息
     * @author barcke
     * @date 2020/5/27
     */
    private String msg;

    private Data data;

    @lombok.Data
    public class Data{

        /**
         * 对应的 union id
         * @author barcke
         * @date 2020/5/27
         */
        private String union_id;
    }
}
