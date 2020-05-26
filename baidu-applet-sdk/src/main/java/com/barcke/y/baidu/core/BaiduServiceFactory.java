package com.barcke.y.baidu.core;

import com.barcke.y.baidu.service.BaiduMiniAuthService;
import com.barcke.y.baidu.service.BaiduThirdPartAuthService;
import com.barcke.y.baidu.service.BaiduTemplateService;

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
  * @ClassName BaiduServiceFarot
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/26 3:51 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 
  **/
public interface BaiduServiceFactory {

    /**
     * 认证授权用service
     * @author barcke
     * @date 2020/5/26
     * @return com.barcke.y.baidu.service.BaiduAuthService
     */
    BaiduThirdPartAuthService getBaiduAuthService();

    /**
     * 模板消息service
     * @author barcke
     * @date 2020/5/26
     * @return com.barcke.y.baidu.service.BaiduTemplateService
     */
    BaiduTemplateService getBaiduTemplateService();

    /**
     * 小程序授权service
     * @author barcke
     * @date 2020/5/26
     */
    BaiduMiniAuthService getBaiduMiniAuthService();

}
