package com.barcke.y.baidu.pojo.thirdpart.template.request;

import com.barcke.y.baidu.component.annotation.BaiduFieldName;
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
public class GetTemplateDraftListRequest {

    /**
     * 	第三方平台的接口调用凭据
     */
    @BaiduFieldName("access_token")
    private String accessToken;

    /**
     * 	页码(默认1)
     * 	非必填
     */
    @BaiduFieldName("page")
    private String page;

    /**
     * 	条数(默认10)
     * 	非必填
     */
    @BaiduFieldName("page_size")
    private String pageSize;
}
