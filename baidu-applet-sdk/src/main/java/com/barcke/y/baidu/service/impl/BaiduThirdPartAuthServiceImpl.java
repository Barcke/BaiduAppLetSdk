package com.barcke.y.baidu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.barcke.y.baidu.component.LocalCache;
import com.barcke.y.baidu.component.bd.utils.AesDecryptUtil;
import com.barcke.y.baidu.component.bd.utils.HttpUtil;
import com.barcke.y.baidu.component.context.BaiduApplicationContext;
import com.barcke.y.baidu.component.enums.BaiduErrorInfoEnums;
import com.barcke.y.baidu.component.utils.JoinerUrlUtil;
import com.barcke.y.baidu.component.constants.BaiduParamsConstants;
import com.barcke.y.baidu.component.constants.BaiduResponseMsgConstants;
import com.barcke.y.baidu.component.constants.BaiduUrlConstants;
import com.barcke.y.baidu.component.constants.LocalCacheConstants;
import com.barcke.y.baidu.component.exception.BaiduException;
import com.barcke.y.baidu.component.exception.BaiduParamsException;
import com.barcke.y.baidu.pojo.thirdpart.auto.request.*;
import com.barcke.y.baidu.pojo.thirdpart.auto.response.AccessTokenResponse;
import com.barcke.y.baidu.pojo.thirdpart.auto.response.PreAuthCodeResponse;
import com.barcke.y.baidu.pojo.thirdpart.auto.response.MiniTokenResponse;
import com.barcke.y.baidu.service.BaiduThirdPartAuthService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 *                 ,;,,;
 *                ,;;'(    社
 *      __      ,;;' ' \   会
 *   /'  '\'~~'~' \ /'\.)  主
 * ,;(      )    /  |.     义
 *,;' \    /-.,,(   ) \    码
 *     ) /       ) / )|    农
 *     ||        ||  \)
 *     (_\       (_\
 * @ProjectName api
 * @ClassName BaiduServiceImpl
 * @Description TODO
 * @Author Barcke
 * @Date 2020/4/29 7:46 下午
 * @Version 1.0
 **/
@Slf4j
public class BaiduThirdPartAuthServiceImpl implements BaiduThirdPartAuthService {

    private String thirdPartAppKey;

    private String thirdPartAppSecret;

    private String aesDecryptSecretKey;

    public BaiduThirdPartAuthServiceImpl(String thirdPartAppKey, String thirdPartAppSecret,String aesDecryptSecretKey){
        this.thirdPartAppKey=thirdPartAppKey;
        this.thirdPartAppSecret=thirdPartAppSecret;
        this.aesDecryptSecretKey=aesDecryptSecretKey;
    }

    @Autowired
    private LocalCache localCache;

    @Autowired
    private BaiduApplicationContext baiduApplicationContext;

    @Override
    public AccessTokenResponse getToken(String ticken) {
        if (StringUtils.isBlank(ticken)) {
            throw new BaiduParamsException("ticket不能为空");
        }

        String response = HttpUtil.sendGet(BaiduUrlConstants.GET_TOKEN_URL, new AccessTokenRequest(thirdPartAppKey, ticken));

        AccessTokenResponse accessTokenResponse = new Gson().fromJson(response, AccessTokenResponse.class);
        if (!BaiduResponseMsgConstants.SUCCESS_CODE.equals(accessTokenResponse.getErrno())){
            throw new BaiduException("获取accessToken异常===》"+response);
        }

        localCache.setLocalCache(LocalCacheConstants.GET_THIRD_PART_ACCESS_TOKEN,accessTokenResponse);

        return accessTokenResponse;
    }

    @Override
    public PreAuthCodeResponse getPreAuthCode(String accessToken) {
        if (StringUtils.isBlank(accessToken)) {
            throw new BaiduParamsException("accessToken不能为空");
        }
        String response = HttpUtil.sendGet(BaiduUrlConstants.GET_PRE_AUTH_CODE_URL, new PreAuthCodeRequest(accessToken));

        PreAuthCodeResponse preAuthCodeResponse = new Gson().fromJson(response, PreAuthCodeResponse.class);

        if (!BaiduResponseMsgConstants.SUCCESS_CODE.equals(preAuthCodeResponse.getErrno())){
            throw new BaiduException("获取preAuthCode异常===》"+response);
        }

        localCache.setLocalCache(LocalCacheConstants.GET_THIRD_PART_PRE_AUTH_CODE,preAuthCodeResponse);

        return preAuthCodeResponse;
    }

    @Override
    public String getAuthorizationUrl(String preAuthCode, String redirectUri) {
        if (StringUtils.isAnyBlank(preAuthCode,redirectUri)) {
            throw new BaiduParamsException(String.format("参数不能为空preAuthCode、redirectUri===》%s,%s",preAuthCode,redirectUri));
        }

        return JoinerUrlUtil.joinerUrl(BaiduUrlConstants.GET_AUTHORIZATION_URL, new AuthorizationRequest(thirdPartAppKey,preAuthCode,redirectUri));
    }

    @Override
    public MiniTokenResponse codeChangeMiniToken(String accessToken, String code) {
        if (StringUtils.isAnyBlank(accessToken,code)) {
            throw new BaiduParamsException(String.format("参数不能为空accessToken、code===》%s,%s",accessToken,code));
        }
        String response = HttpUtil.sendGet(BaiduUrlConstants.GET_MINI_TOKEN_URL, new CodeChangeMiniTokenRequest(accessToken,code));

        MiniTokenResponse miniTokenResponse = new Gson().fromJson(response, MiniTokenResponse.class);

        if (StringUtils.isNotBlank(miniTokenResponse.getError())){
            throw new BaiduException("换取小程序token异常===》"+response+"\n异常解析===》"+ BaiduErrorInfoEnums.getMsgByErrorCode(miniTokenResponse.getError()));
        }

        localCache.setLocalCache(LocalCacheConstants.GET_THIRD_PART_CHANGE_MINI_TOKEN_KEY,miniTokenResponse);

        return miniTokenResponse;
    }

    @Override
    public MiniTokenResponse refreshMiniToken(String accessToken, String refreshToken) {
        if (StringUtils.isAnyBlank(accessToken,refreshToken)) {
            throw new BaiduParamsException(String.format("参数不能为空accessToken、refreshToken===》%s,%s",accessToken,refreshToken));
        }
        String response = HttpUtil.sendGet(BaiduUrlConstants.GET_MINI_TOKEN_URL, new RefreshMiniTokenRequest(accessToken,refreshToken));

        MiniTokenResponse miniTokenResponse = new Gson().fromJson(response, MiniTokenResponse.class);

        if (StringUtils.isNotBlank(miniTokenResponse.getError())){
            throw new BaiduException("刷新小程序token异常===》"+response+"\n异常解析===》"+ BaiduErrorInfoEnums.getMsgByErrorCode(miniTokenResponse.getError()));
        }

        localCache.setLocalCache(LocalCacheConstants.GET_THIRD_PART_CHANGE_MINI_TOKEN_KEY,miniTokenResponse);

        return miniTokenResponse;
    }

    @Override
    public AccessTokenResponse getToken(Map<String, Object> params) {
        if (null == params || params.isEmpty()) {
            throw new BaiduParamsException("params不能为空");
        }
        Object o = params.get(BaiduParamsConstants.THIRD_PART_TICKET_DECRYPT_KEY);
        if (null == o) {
            throw new BaiduParamsException(String.format("未从params中找到对应需解密的Ticket数据-----%s未找到===》params===》%s",
                    BaiduParamsConstants.THIRD_PART_TICKET_DECRYPT_KEY,
                    JSONObject.toJSONString(params)));
        }

        String ticket = "";

        try {
            ticket = JSONObject.parseObject(new AesDecryptUtil(aesDecryptSecretKey).decrypt(String.valueOf(o))).getString(BaiduParamsConstants.THIRD_PART_GET_TICKET_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null == ticket) {
            throw new BaiduParamsException(String.format("未从params中找到对应解密数据中的Ticket数据-----%s未找到===》params===》%s",
                    BaiduParamsConstants.THIRD_PART_GET_TICKET_KEY,
                    JSONObject.toJSONString(params)));
        }

        return getToken(ticket);
    }

    @Override
    public PreAuthCodeResponse getPreAuthCode() {
        return getPreAuthCode(baiduApplicationContext.getAccessToken());
    }

    @Override
    public PreAuthCodeResponse getPreAuthCodeByTicket(String ticket) {
        return getPreAuthCode(getToken(ticket).getData().getAccess_token());
    }

    @Override
    public PreAuthCodeResponse getPreAuthCodeByTicket(Map<String, Object> params) {
        return getPreAuthCode(getToken(params).getData().getAccess_token());
    }

    @Override
    public String getAuthorizationUrlByTicket(String ticket, String redirectUri) {
        return getAuthorizationUrl(
                getPreAuthCodeByTicket(
                        ticket
                ).getData().getPre_auth_code(),redirectUri
        );
    }

    @Override
    public String getAuthorizationUrlByTicket(Map<String, Object> params, String redirectUri) {
        return getAuthorizationUrl(
                getPreAuthCodeByTicket(params).getData().getPre_auth_code(),redirectUri
        );
    }

    @Override
    public String getAuthorizationUrl(String redirectUri) {
        return getAuthorizationUrl(
                baiduApplicationContext.getPreAuthCode(),
                redirectUri
        );
    }

    @Override
    public MiniTokenResponse codeChangeMiniTokenByTicket(String ticket, String code) {
        return codeChangeMiniToken(
                getToken(ticket).getData().getAccess_token(),code
        );
    }

    @Override
    public MiniTokenResponse codeChangeMiniTokenByTicket(Map<String, Object> params, String code) {
        return codeChangeMiniToken(
                getToken(params).getData().getAccess_token(),code
        );
    }

    @Override
    public MiniTokenResponse codeChangeMiniToken(String code) {
        return codeChangeMiniToken(
                baiduApplicationContext.getAccessToken(),
                code
        );
    }

    @Override
    public MiniTokenResponse refreshMiniTokenByTicket(String ticket, String refreshToken) {
        return refreshMiniToken(
                getToken(ticket).getData().getAccess_token(),
                refreshToken
        );
    }

    @Override
    public MiniTokenResponse refreshMiniTokenByTicket(Map<String, Object> params, String refreshToken) {
        return refreshMiniToken(
                getToken(params).getData().getAccess_token(),
                refreshToken
        );
    }

    @Override
    public MiniTokenResponse refreshMiniToken(String refreshToken) {
        return refreshMiniToken(
                baiduApplicationContext.getAccessToken(),
                refreshToken
        );
    }

    @Override
    public MiniTokenResponse refreshMiniToken() {
        return refreshMiniToken(
                baiduApplicationContext.getAccessToken(),
                baiduApplicationContext.getMiniRefreshToken()
        );
    }

}
