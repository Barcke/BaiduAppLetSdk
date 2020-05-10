package com.barcke.y.baidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.barcke.y.baidu.constants.BaiduConstants;
import com.barcke.y.baidu.dto.BaiduGetSessionKeyDTO;
import com.barcke.y.baidu.dto.BaiduGetSessionKeyResponseDTO;
import com.barcke.y.baidu.exception.BaiduException;
import com.barcke.y.baidu.service.BaiduService;
import com.barcke.y.baidu.service.BaiduTemplateService;
import com.barcke.y.baidu.util.HttpUtil;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

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
public class BaiduServiceImpl implements BaiduService {

    private String appKey;

    private String appSecret;

    public BaiduServiceImpl(String appKey,String appSecret){
        this.appKey=appKey;
        this.appSecret=appSecret;
    }

    public BaiduGetSessionKeyResponseDTO getSessionKey(String code) throws BaiduException {
        BaiduGetSessionKeyDTO baiduGetSessionKeyDTO=new BaiduGetSessionKeyDTO(appKey,code,appSecret);

        String jsonString = JSONObject.toJSONString(baiduGetSessionKeyDTO);

        log.info("获取百度SessionKey，DTO===>{}", jsonString);

        String responseData = HttpUtil.sendPost(BaiduConstants.GET_SESSION_KEY_URL, JSON.parseObject(jsonString));

        log.info("ResponseData====>{}",responseData);

        Gson gson=new Gson();
        BaiduGetSessionKeyResponseDTO baiduGetSessionKeyResponseDTO = gson.fromJson(responseData, BaiduGetSessionKeyResponseDTO.class);

        if (StringUtils.isNotBlank(baiduGetSessionKeyResponseDTO.getErrno())) {
            throw new BaiduException("验签信息获取失败");
        }

        return baiduGetSessionKeyResponseDTO;
    }

    public BaiduTemplateService getBaiduTemplateService() {
        return BaiduTemplateServiceHolder.baiduTemplateService;
    }


    private static class BaiduTemplateServiceHolder{
        private static final BaiduTemplateService baiduTemplateService=new BaiduTemplateServiceImpl();
    }
}
