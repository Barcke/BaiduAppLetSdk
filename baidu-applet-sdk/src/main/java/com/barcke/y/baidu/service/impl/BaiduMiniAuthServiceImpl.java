package com.barcke.y.baidu.service.impl;

import com.barcke.y.baidu.component.LocalCache;
import com.barcke.y.baidu.component.bd.utils.HttpUtil;
import com.barcke.y.baidu.component.constants.BaiduResponseMsgConstants;
import com.barcke.y.baidu.component.constants.BaiduUrlConstants;
import com.barcke.y.baidu.component.constants.LocalCacheConstants;
import com.barcke.y.baidu.component.context.BaiduApplicationContext;
import com.barcke.y.baidu.component.exception.BaiduException;
import com.barcke.y.baidu.component.exception.BaiduParamsException;
import com.barcke.y.baidu.component.utils.ZxingUtil;
import com.barcke.y.baidu.pojo.mini.auth.request.*;
import com.barcke.y.baidu.pojo.mini.auth.response.*;
import com.barcke.y.baidu.service.BaiduMiniAuthService;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

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
  * @ClassName BaiduMiniAuthServiceImpl
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/26 9:31 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 
  **/
public class BaiduMiniAuthServiceImpl implements BaiduMiniAuthService {

    @Autowired
    private LocalCache localCache;

    @Autowired
    private BaiduApplicationContext baiduApplicationContext;

    @Override
    public MiniLoginResponse miniLogin(String miniToken, String code) {
        if (StringUtils.isAnyBlank(miniToken,code)) {
            throw new BaiduParamsException(String.format("参数不能为空miniToken、code===》%s,%s",miniToken,code));
        }
        String response = HttpUtil.sendGet(BaiduUrlConstants.GET_SESSION_KEY_BY_CODE_URL, new MiniLoginRequest(code,miniToken));

        MiniLoginResponse miniLoginResponse = new Gson().fromJson(response, MiniLoginResponse.class);

        if (StringUtils.isNotBlank(miniLoginResponse.getError())){
            throw new BaiduException("小程序登录异常===》"+response);
        }

        localCache.setLocalCache(LocalCacheConstants.GET_MINI_LOGIN,miniLoginResponse);

        return miniLoginResponse;
    }

    @Override
    public GetUnionIdResponse getUnionId(String miniToken, String openId) {
        if (StringUtils.isAnyBlank(miniToken,openId)) {
            throw new BaiduParamsException(String.format("参数不能为空miniToken、openId===》%s,%s",miniToken,openId));
        }
        String response = HttpUtil.sendGet(BaiduUrlConstants.GET_UNION_ID_URL, new GetUnionIdRequest(miniToken,openId));

        GetUnionIdResponse getUnionIdResponse = new Gson().fromJson(response, GetUnionIdResponse.class);

        if (!BaiduResponseMsgConstants.SUCCESS_CODE.equals(getUnionIdResponse.getErrno())){
            throw new BaiduException("小程序登录异常===》"+response);
        }

        return getUnionIdResponse;
    }

    @Override
    public MobileAuthResponse mobileAuth(MobileAuthRequest mobileAuthRequest) {
        if (null == mobileAuthRequest) {
            throw new BaiduException(String.format("参数不能为空"));
        }

        if (StringUtils.isBlank(mobileAuthRequest.getMiniToken())){
            mobileAuthRequest.setMiniToken(
                    baiduApplicationContext.getMiniToken()
            );
        }

        String response = HttpUtil.sendPost(BaiduUrlConstants.POST_MOBILE_AUTH_URL, mobileAuthRequest);

        MobileAuthResponse mobileAuthResponse=new Gson().fromJson(response,MobileAuthResponse.class);

        if (!BaiduResponseMsgConstants.SUCCESS_CODE.equals(mobileAuthResponse.getErrno())){
            throw new BaiduException(String.format("申请手机号权限异常===》%s",response));
        }

        return mobileAuthResponse;
    }

    @Override
    public MobileAuthResponse cancelMobileAuth(String miniToken) {
        if (StringUtils.isBlank(miniToken)){
            throw new BaiduException("miniToken不能为空");
        }
        String response = HttpUtil.sendPost(BaiduUrlConstants.POST_CANCEL_MOBILE_AUTH_URL, new CancelMobileAuthRequest(miniToken));

        MobileAuthResponse mobileAuthResponse=new Gson().fromJson(response,MobileAuthResponse.class);

        if (!BaiduResponseMsgConstants.SUCCESS_CODE.equals(mobileAuthResponse.getErrno())){
            throw new BaiduException(String.format("取消申请手机号权限异常===》%s",response));
        }

        return mobileAuthResponse;
    }

    @Override
    public MobileAuthStatusResponse mobileAuthStatus(String miniToken) {
        if (StringUtils.isBlank(miniToken)){
            throw new BaiduException("miniToken不能为空");
        }

        String response = HttpUtil.sendGet(BaiduUrlConstants.GET_MOBILE_AUTH_STATUS_URL,new MobileAuthStatusRequest(miniToken));

        MobileAuthStatusResponse mobileAuthStatusResponse=new Gson().fromJson(response,MobileAuthStatusResponse.class);

        if (!BaiduResponseMsgConstants.SUCCESS_CODE.equals(mobileAuthStatusResponse.getErrno())){
            throw new BaiduException(String.format("查询手机号权限状态异常===》%s",response));
        }

        return mobileAuthStatusResponse;
    }

    @Override
    public FaceAuthenResponse faceAuthen(String miniToken) {
        if (StringUtils.isBlank(miniToken)){
            throw new BaiduException("miniToken不能为空");
        }

        String response = HttpUtil.sendGet(BaiduUrlConstants.GET_FACE_AUTHEN_URL,new MobileAuthStatusRequest(miniToken));

        FaceAuthenResponse faceAuthenResponse=new Gson().fromJson(response,FaceAuthenResponse.class);

        if (!BaiduResponseMsgConstants.SUCCESS_CODE.equals(faceAuthenResponse.getErrno())){
            throw new BaiduException(String.format("查询手机号权限状态异常===》%s",response));
        }

        return faceAuthenResponse;
    }

    @Override
    public File faceAuthenGetFile(String miniToken, int width, String imgPath) {
        if (StringUtils.isAnyBlank(miniToken,imgPath)){
            throw new BaiduException("miniToken、imgPath不能为空");
        }

        return ZxingUtil.getQRCodeImge(
                faceAuthen(miniToken).getData().getQrcode(),width,imgPath
        );
    }

    @Override
    public MiniLoginResponse miniLogin(String code) {
        return miniLogin(
                baiduApplicationContext.getMiniToken(),
                code
        );
    }

    @Override
    public GetUnionIdResponse getUnionId(String openId) {
        return getUnionId(
                baiduApplicationContext.getMiniToken(),
                openId
        );
    }

    @Override
    public MobileAuthResponse cancelMobileAuth() {
        return cancelMobileAuth(
                baiduApplicationContext.getMiniToken()
        );
    }

    @Override
    public MobileAuthStatusResponse mobileAuthStatus() {
        return mobileAuthStatus(
                baiduApplicationContext.getMiniToken()
        );
    }

    @Override
    public FaceAuthenResponse faceAuthen() {
        return faceAuthen(
                baiduApplicationContext.getMiniToken()
        );
    }

    @Override
    public File faceAuthenGetFile(int width, String imgPath) {
        return faceAuthenGetFile(
                baiduApplicationContext.getMiniToken(),width,imgPath
        );
    }

}
