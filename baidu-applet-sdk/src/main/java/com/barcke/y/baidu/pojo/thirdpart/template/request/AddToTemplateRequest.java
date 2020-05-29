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
public class AddToTemplateRequest {

    /**
     * 第三方平台的接口调用凭据
     */
    @BaiduFieldName(value = "access_token",joinerUrl = true)
    private String accessToken;

    /**
     * 	草稿id
     */
    @BaiduFieldName("draft_id")
    private String draftId;

    /**
     * 	自定义模板名称，30字以内
     */
    @BaiduFieldName("user_desc")
    private String userDesc;

}
