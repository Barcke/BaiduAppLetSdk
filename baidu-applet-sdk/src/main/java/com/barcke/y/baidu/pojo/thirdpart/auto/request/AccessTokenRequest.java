package com.barcke.y.baidu.pojo.thirdpart.auto.request;

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
public class AccessTokenRequest {

    /**
     * 第三方平台Key
     */
    @BaiduFieldName("client_id")
    private String thirdPartAppKey;

    /**
     * 第三方平台服务器推送的 ticket，此 ticket 会定时推送.
     * 出于安全考虑，在第三方平台创建审核通过后，小程序TP平台服务器每隔10分钟会向第三方的消息接收地址推送一次 ticket，用于获取第三方平台接口调用凭据,接收到后必须直接返回字符串 success。
     */
    @BaiduFieldName("ticket")
    private String ticket;
}
