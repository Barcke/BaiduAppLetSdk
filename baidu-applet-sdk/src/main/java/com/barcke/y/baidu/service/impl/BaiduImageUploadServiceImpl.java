package com.barcke.y.baidu.service.impl;

import com.barcke.y.baidu.component.bd.utils.HttpUtil;
import com.barcke.y.baidu.component.constants.BaiduResponseMsgConstants;
import com.barcke.y.baidu.component.constants.BaiduUrlConstants;
import com.barcke.y.baidu.component.context.BaiduApplicationContext;
import com.barcke.y.baidu.component.exception.BaiduException;
import com.barcke.y.baidu.pojo.thirdpart.upload.request.UploadRequest;
import com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse;
import com.barcke.y.baidu.service.BaiduImageUploadService;
import com.barcke.y.baidu.service.BaiduThirdPartAuthService;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.URL;
import java.util.Map;

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
public class BaiduImageUploadServiceImpl implements BaiduImageUploadService {

    @Autowired
    private BaiduThirdPartAuthService baiduThirdPartAuthService;

    @Autowired
    private BaiduApplicationContext baiduApplicationContext;

    @Override
    public UploadResponse upload(String accessToken, InputStream multipartFile, String type) {
        if (StringUtils.isAnyBlank(accessToken,type)||null==multipartFile){
            throw new BaiduException(String.format(
                    "参数不能为空且文件可能找不到===》accessToken,type,multipartFile===》%s,%s,%s",
                    accessToken,type,multipartFile
            ));
        }

        String response = HttpUtil.sendPost(
                BaiduUrlConstants.POST_IMAGE_UPLOAD_URL, new UploadRequest(accessToken,multipartFile, type)
        );

        UploadResponse uploadResponse = new Gson().fromJson(response, UploadResponse.class);
        if (!BaiduResponseMsgConstants.SUCCESS_CODE.equals(uploadResponse.getErrno())){
            throw new BaiduException(String.format("上传图片异常===》%s",response));
        }
        return uploadResponse;
    }

    @Override
    public UploadResponse upload(String accessToken, File multipartFile, String type) throws FileNotFoundException {
        return upload(accessToken,new FileInputStream(multipartFile),type);
    }

    @Override
    public UploadResponse upload(File multipartFile, String type) throws FileNotFoundException {
        return upload(
                baiduApplicationContext.getAccessToken(),
                new FileInputStream(multipartFile),type
        );
    }

    @Override
    public UploadResponse upload(String accessToken, String path, String type) throws FileNotFoundException {
            return upload(accessToken,new File(path),type);
    }

    @Override
    public UploadResponse upload(String path, String type) throws FileNotFoundException {
        return upload(new File(path),type);
    }

    @Override
    public UploadResponse uploadByTicket(String ticket, File multipartFile, String type) throws FileNotFoundException {
        return upload(
                baiduThirdPartAuthService.getToken(ticket).getData().getAccess_token(),
                new FileInputStream(multipartFile),type
        );
    }

    @Override
    public UploadResponse uploadByTicket(Map<String, Object> params, File multipartFile, String type) throws FileNotFoundException {
        return upload(
                baiduThirdPartAuthService.getToken(params).getData().getAccess_token(),
                new FileInputStream(multipartFile),type
        );
    }

    @Override
    public UploadResponse uploadByTicket(String ticket, InputStream multipartFile, String type) throws FileNotFoundException {
        return upload(
                baiduThirdPartAuthService.getToken(ticket).getData().getAccess_token(),
                multipartFile,type
        );
    }

    @Override
    public UploadResponse uploadByTicket(Map<String, Object> params, InputStream multipartFile, String type) throws FileNotFoundException {
        return upload(
                baiduThirdPartAuthService.getToken(params).getData().getAccess_token(),
                multipartFile,type
        );
    }

    @Override
    public UploadResponse uploadByTicket(String ticket, String path, String type) throws FileNotFoundException {
        return upload(
                baiduThirdPartAuthService.getToken(ticket).getData().getAccess_token(),
                path,type
        );
    }

    @Override
    public UploadResponse uploadByTicket(Map<String, Object> params, String path, String type) throws FileNotFoundException {
        return upload(
                baiduThirdPartAuthService.getToken(params).getData().getAccess_token(),
                path,type
        );
    }

    @Override
    public UploadResponse uploadHttpUrl(String accessToken, String url, String type) throws IOException {
        if (StringUtils.isBlank(url)){
            throw new BaiduException(String.format(
                    "参数不能为空===》url===》%s",
                    url
            ));
        }
        return upload(
                accessToken,new URL(url).openStream(),type
        );
    }

    @Override
    public UploadResponse uploadHttpUrl(String url, String type) throws IOException {
        return uploadHttpUrl(
                baiduApplicationContext.getAccessToken()
                ,url,type
        );
    }

    @Override
    public UploadResponse uploadHttpUrlByTicket(String ticket, String url, String type) throws IOException {
        return uploadHttpUrl(
                baiduThirdPartAuthService.getToken(ticket).getData().getAccess_token(),
                url,type
        );
    }

    @Override
    public UploadResponse uploadHttpUrlByTicket(Map<String, Object> params, String url, String type) throws IOException {
        return uploadHttpUrl(
                baiduThirdPartAuthService.getToken(params).getData().getAccess_token(),
                url,type
        );
    }
}
