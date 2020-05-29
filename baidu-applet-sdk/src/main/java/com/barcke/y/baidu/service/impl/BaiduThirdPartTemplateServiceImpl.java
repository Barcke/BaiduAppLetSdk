package com.barcke.y.baidu.service.impl;

import com.barcke.y.baidu.component.bd.utils.HttpUtil;
import com.barcke.y.baidu.component.constants.BaiduResponseMsgConstants;
import com.barcke.y.baidu.component.constants.BaiduUrlConstants;
import com.barcke.y.baidu.component.context.BaiduApplicationContext;
import com.barcke.y.baidu.component.exception.BaiduException;
import com.barcke.y.baidu.pojo.thirdpart.template.request.AddToTemplateRequest;
import com.barcke.y.baidu.pojo.thirdpart.template.request.GetTemplateDraftListRequest;
import com.barcke.y.baidu.pojo.thirdpart.template.request.GetTemplateListRequest;
import com.barcke.y.baidu.pojo.thirdpart.template.response.AddToTemplateResponse;
import com.barcke.y.baidu.pojo.thirdpart.template.response.GetTemplateDraftListResponse;
import com.barcke.y.baidu.pojo.thirdpart.template.response.GetTemplateListResponse;
import com.barcke.y.baidu.service.BaiduThirdPartAuthService;
import com.barcke.y.baidu.service.BaiduThirdPartTemplateService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author barcke
 * @version 1.0
 **/
@Slf4j
public class BaiduThirdPartTemplateServiceImpl implements BaiduThirdPartTemplateService {

    @Autowired
    private BaiduApplicationContext baiduApplicationContext;

    @Autowired
    private BaiduThirdPartAuthService baiduThirdPartAuthService;

    @Override
    public GetTemplateDraftListResponse getTemplateDraftList(String accessToken, String page, String pageSize) {
        if (StringUtils.isAnyBlank(accessToken,page,pageSize)){
            throw new BaiduException(String.format("参数信息不能为空===》accessToken,page,pageSize===》%s,%s,%s",accessToken,page,pageSize));
        }

        String response = HttpUtil.sendGet(BaiduUrlConstants.GET_TEMPLATE_DRAFT_LIST_URL,new GetTemplateDraftListRequest(accessToken,page,pageSize));

        GetTemplateDraftListResponse getTemplateDraftListResponse=new Gson().fromJson(response,GetTemplateDraftListResponse.class);

        if (!BaiduResponseMsgConstants.SUCCESS_CODE.equals(getTemplateDraftListResponse.getErrno())){
            throw new BaiduException(String.format("获取模板草稿列表异常===》%s",response));
        }

        return getTemplateDraftListResponse;
    }

    @Override
    public GetTemplateDraftListResponse getTemplateDraftList(String page, String pageSize) {
        return getTemplateDraftList(
                baiduApplicationContext.getAccessToken(),page,pageSize
        );
    }

    @Override
    public GetTemplateDraftListResponse getTemplateDraftList() {
        return getTemplateDraftList(
                null,null
        );
    }

    @Override
    public GetTemplateDraftListResponse getTemplateDraftList(String accessToken) {
        return getTemplateDraftList(accessToken,null,null);
    }

    @Override
    public GetTemplateDraftListResponse getTemplateDraftListByTicket(String ticket, String page, String pageSize) {
        return getTemplateDraftList(
                baiduThirdPartAuthService.getToken(ticket).getData().getAccess_token(),page,pageSize
        );
    }

    @Override
    public GetTemplateDraftListResponse getTemplateDraftListByTicket(String ticket) {
        return getTemplateDraftListByTicket(
                ticket,null,null
        );
    }

    @Override
    public GetTemplateDraftListResponse getTemplateDraftListByTicket(Map<String, Object> params, String page, String pageSize) {
        return getTemplateDraftList(
                baiduThirdPartAuthService.getToken(params).getData().getAccess_token(),page,pageSize
        );
    }

    @Override
    public GetTemplateDraftListResponse getTemplateDraftListByTicket(Map<String, Object> params) {
        return getTemplateDraftListByTicket(
                params,null,null
        );
    }

    @Override
    public GetTemplateListResponse getTemplateList(String accessToken, String page, String pageSize) {
        if (StringUtils.isAnyBlank(accessToken,page,pageSize)){
            throw new BaiduException(String.format("参数信息不能为空===》accessToken,page,pageSize===》%s,%s,%s",accessToken,page,pageSize));
        }

        String response = HttpUtil.sendGet(BaiduUrlConstants.GET_TEMPLATE_LIST_URL,new GetTemplateListRequest(accessToken,page,pageSize));

        GetTemplateListResponse getTemplateListResponse=new Gson().fromJson(response,GetTemplateListResponse.class);

        if (!BaiduResponseMsgConstants.SUCCESS_CODE.equals(getTemplateListResponse.getErrno())){
            throw new BaiduException(String.format("获取模板列表异常===》%s",response));
        }

        return getTemplateListResponse;
    }

    @Override
    public GetTemplateListResponse getTemplateList(String page, String pageSize) {
        return getTemplateList(
                baiduApplicationContext.getAccessToken(),page,pageSize
        );
    }

    @Override
    public GetTemplateListResponse getTemplateList() {
        return getTemplateList(null,null);
    }

    @Override
    public GetTemplateListResponse getTemplateList(String accessToken) {
        return getTemplateList(
                baiduApplicationContext.getAccessToken(),null,null
        );
    }

    @Override
    public GetTemplateListResponse getTemplateListByTicket(String ticket, String page, String pageSize) {
        return getTemplateList(
                baiduThirdPartAuthService.getToken(ticket).getData().getAccess_token(),
                page,pageSize
        );
    }

    @Override
    public GetTemplateListResponse getTemplateListByTicket(String ticket) {
        return getTemplateListByTicket(
                ticket,null,null
        );
    }

    @Override
    public GetTemplateListResponse getTemplateListByTicket(Map<String, Object> params, String page, String pageSize) {
        return getTemplateList(
                baiduThirdPartAuthService.getToken(params).getData().getAccess_token(),
                page,pageSize
        );
    }

    @Override
    public GetTemplateListResponse getTemplateListByTicket(Map<String, Object> params) {
        return getTemplateListByTicket(
                params,null,null
        );
    }

    @Override
    public AddToTemplateResponse addToTemplate(String accessToken, String draftId, String userDesc) {
        if (StringUtils.isAnyBlank(accessToken,draftId,userDesc)){
            throw new BaiduException(String.format("参数信息不能为空===》accessToken,draftId,userDesc===》%s,%s,%s",accessToken,draftId,userDesc));
        }

        String response = HttpUtil.sendPost(BaiduUrlConstants.POST_ADD_TO_TEMPLATE_URL,new AddToTemplateRequest(accessToken,draftId,userDesc));

        AddToTemplateResponse addToTemplateResponse=new Gson().fromJson(response,AddToTemplateResponse.class);

        if (!BaiduResponseMsgConstants.SUCCESS_CODE.equals(addToTemplateResponse.getErrno())){
            throw new BaiduException(String.format("添加草稿至模板异常===》%s",response));
        }

        return addToTemplateResponse;
    }

    @Override
    public AddToTemplateResponse addToTemplate(String draftId, String userDesc) {
        return addToTemplate(
                baiduApplicationContext.getAccessToken(),draftId,userDesc
        );
    }

    @Override
    public AddToTemplateResponse addToTemplateByTicket(String ticket, String draftId, String userDesc) {
        return addToTemplate(
                baiduThirdPartAuthService.getToken(ticket).getData().getAccess_token(),
                draftId,userDesc
        );
    }

    @Override
    public AddToTemplateResponse addToTemplateByTicket(Map<String, Object> params, String draftId, String userDesc) {
        return addToTemplate(
                baiduThirdPartAuthService.getToken(params).getData().getAccess_token(),
                draftId,userDesc
        );
    }
}
