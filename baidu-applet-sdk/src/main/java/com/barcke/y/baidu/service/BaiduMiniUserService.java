package com.barcke.y.baidu.service;

import com.barcke.y.baidu.pojo.mini.user.response.GetUserInfoResponse;

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
public interface BaiduMiniUserService {

    /**
     * 通过sessionKey解密前端传递的data信息得到用户信息
     * @author barcke
     * @param data 百度加密传递的数据
     * @param sessionKey 解密用的key 通过用户登录接口获取
     * @return com.barcke.y.baidu.pojo.mini.user.response.GetUserInfoResponse
     */
    GetUserInfoResponse getUserInfo(String data,String sessionKey);

}
