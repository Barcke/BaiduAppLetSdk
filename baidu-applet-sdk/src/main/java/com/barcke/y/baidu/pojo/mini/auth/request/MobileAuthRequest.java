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
  * @author Barcke
  * @version 1.0
  **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MobileAuthRequest {

    /**
     * 授权小程序的接口调用凭据
     */
    @BaiduFieldName(value = "access_token",joinerUrl = true)
    private String miniToken;

    /**
     * 	申请原因
     * (0:"用于登录"
     * 1:"收货联系方式"
     * 2："其他")
     */
    @BaiduFieldName("reason")
    private String reason;

    /**
     * 	使用场景
     * (0:"网络购物"
     * 1:"账号下信息内容同步"
     * 2:"票务预订"
     * 3:"业务办理"
     * 4:"信息查询（如社保、公积金查询"
     * 5:预约")
     */
    @BaiduFieldName("used_scene")
    private String usedScene;

    /**
     * 使用场景描述  "使用场景描述不得超过500字"
     */
    @BaiduFieldName("scene_desc")
    private String sceneDesc;

    /**
     * 使用场景demo(场景实例图片)  "实例图片路径需先调用上传图片接口"
     */
    @BaiduFieldName("scene_demo")
    private String sceneDemo;
}
