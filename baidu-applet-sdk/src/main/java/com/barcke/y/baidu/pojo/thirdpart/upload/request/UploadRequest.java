package com.barcke.y.baidu.pojo.thirdpart.upload.request;

import com.barcke.y.baidu.component.annotation.BaiduFieldName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

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
public class UploadRequest {

    /**
     * 第三方平台的接口调用凭据
     */
    @BaiduFieldName(value = "access_token",joinerUrl = true)
    private String accessToken;

    /**
     * 文件
     */
    @BaiduFieldName(value = "multipartFile",file = true)
    private InputStream multipartFile;

    /**
     * 	图片用途
     * 	参数值	图片用途	文件大小限制	图片像素限制
     * 	1/null	小程序头像	小于等于2M	256px * 256px以内推荐144px * 144px
     * 	2	服务类目资质图片	小于等于5M
     * 	3	小程序名称审核资料	小于等于5M
     */
    @BaiduFieldName("type")
    private String type;
}
