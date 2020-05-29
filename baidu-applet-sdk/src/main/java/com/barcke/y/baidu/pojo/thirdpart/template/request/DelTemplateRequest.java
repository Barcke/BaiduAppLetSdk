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
public class DelTemplateRequest {

    @BaiduFieldName("access_token")
    private String accessToken;
}
