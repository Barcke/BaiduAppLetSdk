package com.barcke.y.baidu.service;

import com.barcke.y.baidu.pojo.thirdpart.template.response.AddToTemplateResponse;
import com.barcke.y.baidu.pojo.thirdpart.template.response.GetTemplateDraftListResponse;
import com.barcke.y.baidu.pojo.thirdpart.template.response.GetTemplateListResponse;

import java.util.Map;

/**
 * @author barcke
 * @version 1.0
 * 模板相关服务类
 **/
public interface BaiduThirdPartTemplateService {


    //--------------------------------------------模板草稿列表--------------------------------------------

    /**
     * 获取模板草稿列表
     * 获取第三方平台下的模板草稿。
     * @param accessToken 第三方平台的接口调用凭据
     * @param page 	页码(默认1) 给空则表示使用默认值
     * @param pageSize 条数(默认10) 给空则表示使用默认值
     * @return GetTemplateDraftListResponse
     */
    GetTemplateDraftListResponse getTemplateDraftList(String accessToken,String page,String pageSize);

    /**
     * 重载方法 从localCache中获取accessToken
     * 获取模板草稿列表
     * 获取第三方平台下的模板草稿。
     * @param page 	页码(默认1) 给空则表示使用默认值
     * @param pageSize 条数(默认10) 给空则表示使用默认值
     * @return GetTemplateDraftListResponse
     */
    GetTemplateDraftListResponse getTemplateDraftList(String page,String pageSize);

    /**
     * 重载方法 从localCache中获取accessToken 切页码以及条数都用默认值
     * 获取模板草稿列表
     * 获取第三方平台下的模板草稿。
     * @return GetTemplateDraftListResponse
     */
    GetTemplateDraftListResponse getTemplateDraftList();

    /**
     * 重载方法 切页码以及条数都用默认值
     * 获取模板草稿列表
     * 获取第三方平台下的模板草稿。
     * @param accessToken 第三方平台的接口调用凭据
     * @return GetTemplateDraftListResponse
     */
    GetTemplateDraftListResponse getTemplateDraftList(String accessToken);

    /**
     * 重载方法 通过ticket获取accessToken后查询模板草稿列表
     * 获取模板草稿列表
     * 获取第三方平台下的模板草稿。
     * @param ticket 百度回调过来解密后的ticket
     * @param page 	页码(默认1) 给空则表示使用默认值
     * @param pageSize 条数(默认10) 给空则表示使用默认值
     * @return GetTemplateDraftListResponse
     */
    GetTemplateDraftListResponse getTemplateDraftListByTicket(String ticket,String page,String pageSize);

    /**
     * 重载方法 通过ticket获取accessToken后查询模板草稿列表 切页码以及条数都用默认值
     * 获取模板草稿列表
     * 获取第三方平台下的模板草稿。
     * @param ticket 百度回调过来解密后的ticket
     * @return GetTemplateDraftListResponse
     */
    GetTemplateDraftListResponse getTemplateDraftListByTicket(String ticket);

    /**
     * 重载方法 通过ticket获取accessToken后查询模板草稿列表
     * 获取模板草稿列表
     * 获取第三方平台下的模板草稿。
     * @param params 百度回调过来解密前的ticket
     * @param page 	页码(默认1) 给空则表示使用默认值
     * @param pageSize 条数(默认10) 给空则表示使用默认值
     * @return GetTemplateDraftListResponse
     */
    GetTemplateDraftListResponse getTemplateDraftListByTicket(Map<String,Object> params, String page, String pageSize);

    /**
     * 重载方法 通过ticket获取accessToken后查询模板草稿列表 切页码以及条数都用默认值
     * 获取模板草稿列表
     * 获取第三方平台下的模板草稿。
     * @param params 百度回调过来解密前的ticket
     * @return GetTemplateDraftListResponse
     */
    GetTemplateDraftListResponse getTemplateDraftListByTicket(Map<String,Object> params);


    //--------------------------------------------模板列表--------------------------------------------

    /**
     * 获取模板列表
     * 获取某第三方平台下的模板列表信息。
     * @param accessToken 第三方平台的接口调用凭据
     * @param page 	页码(默认1) 给空则表示使用默认值
     * @param pageSize 条数(默认10) 给空则表示使用默认值
     * @return GetTemplateListResponse
     */
    GetTemplateListResponse getTemplateList(String accessToken, String page, String pageSize);

    /**
     * 重载方法 从localCache中获取accessToken
     * 获取模板列表
     * 获取某第三方平台下的模板列表信息。
     * @param page 	页码(默认1) 给空则表示使用默认值
     * @param pageSize 条数(默认10) 给空则表示使用默认值
     * @return GetTemplateListResponse
     */
    GetTemplateListResponse getTemplateList(String page,String pageSize);

    /**
     * 重载方法 从localCache中获取accessToken 切页码以及条数都用默认值
     * 获取模板列表
     * 获取某第三方平台下的模板列表信息。
     * @return GetTemplateListResponse
     */
    GetTemplateListResponse getTemplateList();

    /**
     * 重载方法 切页码以及条数都用默认值
     * 获取模板列表
     * 获取某第三方平台下的模板列表信息。
     * @param accessToken 第三方平台的接口调用凭据
     * @return GetTemplateListResponse
     */
    GetTemplateListResponse getTemplateList(String accessToken);

    /**
     * 重载方法 通过ticket获取accessToken后查询模板草稿列表
     * 获取模板列表
     * 获取某第三方平台下的模板列表信息。
     * @param ticket 百度回调过来解密后的ticket
     * @param page 	页码(默认1) 给空则表示使用默认值
     * @param pageSize 条数(默认10) 给空则表示使用默认值
     * @return GetTemplateListResponse
     */
    GetTemplateListResponse getTemplateListByTicket(String ticket,String page,String pageSize);

    /**
     * 重载方法 通过ticket获取accessToken后查询模板草稿列表 切页码以及条数都用默认值
     * 获取模板列表
     * 获取某第三方平台下的模板列表信息。
     * @param ticket 百度回调过来解密后的ticket
     * @return GetTemplateListResponse
     */
    GetTemplateListResponse getTemplateListByTicket(String ticket);

    /**
     * 重载方法 通过ticket获取accessToken后查询模板草稿列表
     * 获取模板列表
     * 获取某第三方平台下的模板列表信息。
     * @param params 百度回调过来解密前的ticket
     * @param page 	页码(默认1) 给空则表示使用默认值
     * @param pageSize 条数(默认10) 给空则表示使用默认值
     * @return GetTemplateListResponse
     */
    GetTemplateListResponse getTemplateListByTicket(Map<String,Object> params, String page, String pageSize);

    /**
     * 重载方法 通过ticket获取accessToken后查询模板草稿列表 切页码以及条数都用默认值
     * 获取模板列表
     * 获取某第三方平台下的模板列表信息。
     * @param params 百度回调过来解密前的ticket
     * @return GetTemplateListResponse
     */
    GetTemplateListResponse getTemplateListByTicket(Map<String,Object> params);


    //--------------------------------------------添加草稿至模板--------------------------------------------

    /**
     * 添加草稿至模板
     * 添加草稿至模板库中，模板上限为50个。
     * @param accessToken 	第三方平台的接口调用凭据
     * @param draftId 草稿id
     * @param userDesc 	自定义模板名称，30字以内
     * @return AddToTemplateResponse
     */
    AddToTemplateResponse addToTemplate(String accessToken,String draftId,String userDesc);

    /**
     * 重载方法 从localCache中获取accessToken
     * 添加草稿至模板
     * 添加草稿至模板库中，模板上限为50个。
     * @param draftId 草稿id
     * @param userDesc 	自定义模板名称，30字以内
     * @return AddToTemplateResponse
     */
    AddToTemplateResponse addToTemplate(String draftId,String userDesc);

    /**
     * 重载方法 通过ticket获取accessToken后添加草稿至模板
     * 添加草稿至模板
     * 添加草稿至模板库中，模板上限为50个。
     * @param ticket 百度回调过来解密后的ticket
     * @param draftId 草稿id
     * @param userDesc 	自定义模板名称，30字以内
     * @return AddToTemplateResponse
     */
    AddToTemplateResponse addToTemplateByTicket(String ticket,String draftId,String userDesc);

    /**
     * 重载方法 通过ticket获取accessToken后添加草稿至模板
     * 添加草稿至模板
     * 添加草稿至模板库中，模板上限为50个。
     * @param params 百度回调过来解密前的ticket
     * @param draftId 草稿id
     * @param userDesc 	自定义模板名称，30字以内
     * @return AddToTemplateResponse
     */
    AddToTemplateResponse addToTemplateByTicket(Map<String, Object> params,String draftId,String userDesc);


    //--------------------------------------------删除模板--------------------------------------------

//    DelTemplateResponse delTemplate(String accessToken,);

}
