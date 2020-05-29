package com.barcke.y.baidu.core;

import com.barcke.y.baidu.service.*;

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
public interface BaiduServiceFactory {

    /**
     * 认证授权用service
     * @return com.barcke.y.baidu.service.BaiduAuthService
     */
    BaiduThirdPartAuthService getBaiduAuthService();

    /**
     * 模板消息service
     * @return com.barcke.y.baidu.service.BaiduTemplateService
     */
    BaiduThirdPartTemplateService getBaiduTemplateService();

    /**
     * 小程序授权service
     * @return BaiduMiniAuthService
     */
    BaiduMiniAuthService getBaiduMiniAuthService();

    /**
     * 用户相关service
     * @return BaiduMiniUserService
     */
    BaiduMiniUserService getBaiduMiniUserService();

    /**
     * 图片上传service
     * @return BaiduImageUploadService
     */
    BaiduImageUploadService getBaiduImageUploadService();

}
