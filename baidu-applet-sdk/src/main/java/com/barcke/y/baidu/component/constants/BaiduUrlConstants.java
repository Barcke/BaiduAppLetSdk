package com.barcke.y.baidu.component.constants;

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
 * @ClassName BaiduConstants
 * @Description TODO
 * @Author Barcke
 * @Date 2020/4/29 7:49 下午
 * @Version 1.0
 * baidu接口常量类
 **/
public class BaiduUrlConstants {

    /**
     * 获取Session Key的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String GET_SESSION_KEY_URL = "https://spapi.baidu.com/oauth/jscode2sessionkey";

    private static final String PATH = "https://openapi.baidu.com/rest/2.0/smartapp/";

    /**
     * 通过ticket获取token的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String GET_TOKEN_URL = "https://openapi.baidu.com/public/2.0/smartapp/auth/tp/token";

    /**
     * 授权小程序登录URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String GET_SESSION_KEY_BY_CODE_URL = "https://openapi.baidu.com/rest/2.0/oauth/getsessionkeybycode";

    /**
     * 通过token获取预授权码pre_auth_code的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String GET_PRE_AUTH_CODE_URL = PATH + "tp/createpreauthcode";

    /**
     * 引导小程序管理员对第三方平台进行授权的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String GET_AUTHORIZATION_URL = "https://smartprogram.baidu.com/mappconsole/tp/authorization";

    /**
     * 使用授权码换小程序的接口调用凭据和授权信息的url地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String GET_MINI_TOKEN_URL = "https://openapi.baidu.com/rest/2.0/oauth/token";

    /**
     * 获取unionid的URL地址
     * @author barcke
     * @date 2020/5/27
     */
    public static final String GET_UNION_ID_URL = "https://openapi.baidu.com/rest/2.0/smartapp/unionId/get";

    /**
     * 图片上传的URL地址
     * @author barcke
     * @date 2020/5/27
     */
    public static final String POST_IMAGE_UPLOAD_URL = "https://openapi.baidu.com/file/2.0/smartapp/upload/image";

    /**
     * 申请手机号权限
     * @author barcke
     * @date 2020/5/27
     */
    public static final String POST_MOBILE_AUTH_URL = "https://openapi.baidu.com/rest/2.0/smartapp/app/apply/mobileauth";

    /**
     * 取消手机号权限
     * @author barcke
     * @date 2020/5/27
     */
    public static final String POST_CANCEL_MOBILE_AUTH_URL = "https://openapi.baidu.com/rest/2.0/smartapp/app/cancel/mobileauth";

    /**
     * 查询手机号权限状态
     * @author barcke
     * @date 2020/5/27
     */
    public static final String GET_MOBILE_AUTH_STATUS_URL = "https://openapi.baidu.com/rest/2.0/smartapp/app/get/mobileauthstatus";

    /**
     * 法人人脸识别认证
     * @author barcke
     * @date 2020/5/27
     */
    public static final String GET_FACE_AUTHEN_URL = "https://openapi.baidu.com/rest/2.0/smartapp/auth/faceauthen";

    /**
     * 获取帐号下已存在的模板列表的URL地址的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String GET_TEMPLATE_LIBRARY_LIST_URL = PATH + "template/librarylist";

    /**
     * 获取模板库某个模板标题下关键词库的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String GET_TEMPLATE_LIBRARY_BY_ID_URL = PATH + "template/libraryget";

    /**
     * 获取模板库某个模板标题下关键词库的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String ADD_TEMPLATE_URL = PATH + "template/templateadd";

    /**
     * 获取帐号下已存在的模板列表的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String GET_TEMPLATE_LIST_URL = PATH + "template/templatelist";

    /**
     * 删除帐号下的某个模板的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String DELETE_TEMPLATE_URL = PATH + "template/templatedel";

    /**
     * 推送模板消息的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String SEND_TEMPLATE_MESSAGE_URL = PATH + "template/send";

    /**
     * 发送客服消息接口的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String SEND_CUSTOM_MESSAGE_URL = PATH + "message/custom/send";

    /**
     * 检测用户是否是作弊用户的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String DETECT_RISK_URL = PATH + "detectrisk";

    /**
     * 获取小程序二维码，适用于需要的码数量较少的业务场景。通过该接口生成的二维码，永久有效，有数量限制。的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String GET_QR_CODE_URL = PATH + "qrcode/get";

    /**
     * 获取小程序二维码，适用于需要的码数量较多的业务场景。通过该接口生成的二维码，永久有效，无数量限制。的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String GET_UN_LIMITED_URL = PATH + "qrcode/getunlimited";

    /**
     * 导入订单信息的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String ORDER_CENTER_ADD_INFO_URL = PATH + "ordercenter/app/add/main/info";

    /**
     * 更新订单信息的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String ORDER_CENTER_UPDATE_INFO_URL = PATH + "ordercenter/app/update/main/info";

    /**
     * 更新订单状态的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String ORDER_CENTER_UPDATE_STATUS_URL = PATH + "ordercenter/app/update/main/status";

    /**
     * 导入售后订单信息的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String ORDER_CENTER_ADD_SUB_INFO_URL = PATH + "ordercenter/app/append/sub/info";

    /**
     * 更新售后订单信息的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String ORDER_CENTER_UPDATE_SUB_INFO_URL = PATH + "ordercenter/app/update/sub/info";

    /**
     * 更新售后订单状态的URL地址
     * @author barcke
     * @date 2020/5/26
     */
    public static final String ORDER_CENTER_UPDATE_SUB_STATUS_URL = PATH + "app/update/sub/status";
}
