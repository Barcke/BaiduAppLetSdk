package com.barcke.y.baidu.pojo.mini.auth.request;

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
  * @ProjectName BaiduAppLetSdk
  * @ClassName GetUnionIdRequest
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/27 9:58 上午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 获取unionid
  **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUnionIdRequest {

    @BaiduFieldName("access_token")
    private String accessToken;

    @BaiduFieldName("open_id")
    private String openId;
}
