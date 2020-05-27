package com.barcke.y.baidu.service;

import com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
  * @ProjectName BaiduAppLetSdk
  * @ClassName BaiduImageUploadService
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/27 11:26 上午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 图片上传服务类
  **/
public interface BaiduImageUploadService {

    /**
     * 图片上传
     * 百度第三方服务所有的api中只要涉及图片url的字段，都需要使用这个图片上传接口返回的图片地址，否则会提示图片来源非法，目前只支持bmp、jpeg、jpg、png格式。
     * @author barcke
     * @date 2020/5/27
     * @param accessToken 	第三方平台的接口调用凭据
     * @param multipartFile 	文件
     * @param type 	图片用途
     * type 说明：
     * 参数值	图片用途	文件大小限制	图片像素限制
     * 1/null	小程序头像	小于等于2M	256px * 256px以内推荐144px * 144px
     * 2	服务类目资质图片	小于等于5M
     * 3	小程序名称审核资料	小于等于5M
     * @return com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse
     */
    UploadResponse upload(String accessToken, InputStream multipartFile, String type);

    /**
     * 重载方法
     * 图片上传
     * 百度第三方服务所有的api中只要涉及图片url的字段，都需要使用这个图片上传接口返回的图片地址，否则会提示图片来源非法，目前只支持bmp、jpeg、jpg、png格式。
     * @author barcke
     * @date 2020/5/27
     * @param multipartFile 	文件
     * @param type 	图片用途
     * type 说明：
     * 参数值	图片用途	文件大小限制	图片像素限制
     * 1/null	小程序头像	小于等于2M	256px * 256px以内推荐144px * 144px
     * 2	服务类目资质图片	小于等于5M
     * 3	小程序名称审核资料	小于等于5M
     * @return com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse
     */
    UploadResponse upload(String accessToken, File multipartFile, String type) throws FileNotFoundException;

    /**
     * 重载方法 从localCache中获取accesstToken
     * 图片上传
     * 百度第三方服务所有的api中只要涉及图片url的字段，都需要使用这个图片上传接口返回的图片地址，否则会提示图片来源非法，目前只支持bmp、jpeg、jpg、png格式。
     * @author barcke
     * @date 2020/5/27
     * @param multipartFile 	文件
     * @param type 	图片用途
     * type 说明：
     * 参数值	图片用途	文件大小限制	图片像素限制
     * 1/null	小程序头像	小于等于2M	256px * 256px以内推荐144px * 144px
     * 2	服务类目资质图片	小于等于5M
     * 3	小程序名称审核资料	小于等于5M
     * @return com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse
     */
    UploadResponse upload(File multipartFile, String type) throws FileNotFoundException;

    /**
     * 图片上传
     * 百度第三方服务所有的api中只要涉及图片url的字段，都需要使用这个图片上传接口返回的图片地址，否则会提示图片来源非法，目前只支持bmp、jpeg、jpg、png格式。
     * @author barcke
     * @date 2020/5/27
     * @param accessToken 	第三方平台的接口调用凭据
     * @param path 	本地文件地址
     * @param type 	图片用途
     * type 说明：
     * 参数值	图片用途	文件大小限制	图片像素限制
     * 1/null	小程序头像	小于等于2M	256px * 256px以内推荐144px * 144px
     * 2	服务类目资质图片	小于等于5M
     * 3	小程序名称审核资料	小于等于5M
     * @return com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse
     */
    UploadResponse upload(String accessToken, String path, String type) throws FileNotFoundException;

    /**
     * 重载方法 从localCache中获取accesstToken
     * 图片上传
     * 百度第三方服务所有的api中只要涉及图片url的字段，都需要使用这个图片上传接口返回的图片地址，否则会提示图片来源非法，目前只支持bmp、jpeg、jpg、png格式。
     * @author barcke
     * @date 2020/5/27
     * @param path 	本地文件地址
     * @param type 	图片用途
     * type 说明：
     * 参数值	图片用途	文件大小限制	图片像素限制
     * 1/null	小程序头像	小于等于2M	256px * 256px以内推荐144px * 144px
     * 2	服务类目资质图片	小于等于5M
     * 3	小程序名称审核资料	小于等于5M
     * @return com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse
     */
    UploadResponse upload(String path, String type) throws FileNotFoundException;

    /**
     * 重载方法 通过ticket取得token
     * 图片上传
     * 百度第三方服务所有的api中只要涉及图片url的字段，都需要使用这个图片上传接口返回的图片地址，否则会提示图片来源非法，目前只支持bmp、jpeg、jpg、png格式。
     * @author barcke
     * @date 2020/5/27
     * @param multipartFile 	文件
     * @param type 	图片用途
     * type 说明：
     * 参数值	图片用途	文件大小限制	图片像素限制
     * 1/null	小程序头像	小于等于2M	256px * 256px以内推荐144px * 144px
     * 2	服务类目资质图片	小于等于5M
     * 3	小程序名称审核资料	小于等于5M
     * @return com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse
     */
    UploadResponse uploadByTicket(String ticket,File multipartFile, String type) throws FileNotFoundException;

    /**
     * 重载方法 通过ticket取得token
     * 图片上传
     * 百度第三方服务所有的api中只要涉及图片url的字段，都需要使用这个图片上传接口返回的图片地址，否则会提示图片来源非法，目前只支持bmp、jpeg、jpg、png格式。
     * @author barcke
     * @date 2020/5/27
     * @param multipartFile 	文件
     * @param type 	图片用途
     * type 说明：
     * 参数值	图片用途	文件大小限制	图片像素限制
     * 1/null	小程序头像	小于等于2M	256px * 256px以内推荐144px * 144px
     * 2	服务类目资质图片	小于等于5M
     * 3	小程序名称审核资料	小于等于5M
     * @return com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse
     */
    UploadResponse uploadByTicket(Map<String,Object> params, File multipartFile, String type) throws FileNotFoundException;

    /**
     * 重载方法 通过ticket取得token
     * 图片上传
     * 百度第三方服务所有的api中只要涉及图片url的字段，都需要使用这个图片上传接口返回的图片地址，否则会提示图片来源非法，目前只支持bmp、jpeg、jpg、png格式。
     * @author barcke
     * @date 2020/5/27
     * @param multipartFile 	文件
     * @param type 	图片用途
     * type 说明：
     * 参数值	图片用途	文件大小限制	图片像素限制
     * 1/null	小程序头像	小于等于2M	256px * 256px以内推荐144px * 144px
     * 2	服务类目资质图片	小于等于5M
     * 3	小程序名称审核资料	小于等于5M
     * @return com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse
     */
    UploadResponse uploadByTicket(String ticket,InputStream multipartFile, String type) throws FileNotFoundException;

    /**
     * 重载方法 通过ticket取得token
     * 图片上传
     * 百度第三方服务所有的api中只要涉及图片url的字段，都需要使用这个图片上传接口返回的图片地址，否则会提示图片来源非法，目前只支持bmp、jpeg、jpg、png格式。
     * @author barcke
     * @date 2020/5/27
     * @param multipartFile 	文件
     * @param type 	图片用途
     * type 说明：
     * 参数值	图片用途	文件大小限制	图片像素限制
     * 1/null	小程序头像	小于等于2M	256px * 256px以内推荐144px * 144px
     * 2	服务类目资质图片	小于等于5M
     * 3	小程序名称审核资料	小于等于5M
     * @return com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse
     */
    UploadResponse uploadByTicket(Map<String,Object> params, InputStream multipartFile, String type) throws FileNotFoundException;

    /**
     * 重载方法 通过ticket取得token
     * 图片上传
     * 百度第三方服务所有的api中只要涉及图片url的字段，都需要使用这个图片上传接口返回的图片地址，否则会提示图片来源非法，目前只支持bmp、jpeg、jpg、png格式。
     * @author barcke
     * @date 2020/5/27
     * @param path 	本机文件路径
     * @param type 	图片用途
     * type 说明：
     * 参数值	图片用途	文件大小限制	图片像素限制
     * 1/null	小程序头像	小于等于2M	256px * 256px以内推荐144px * 144px
     * 2	服务类目资质图片	小于等于5M
     * 3	小程序名称审核资料	小于等于5M
     * @return com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse
     */
    UploadResponse uploadByTicket(String ticket,String path, String type) throws FileNotFoundException;

    /**
     * 重载方法 通过ticket取得token
     * 图片上传
     * 百度第三方服务所有的api中只要涉及图片url的字段，都需要使用这个图片上传接口返回的图片地址，否则会提示图片来源非法，目前只支持bmp、jpeg、jpg、png格式。
     * @author barcke
     * @date 2020/5/27
     * @param path 	本机文件路径
     * @param type 	图片用途
     * type 说明：
     * 参数值	图片用途	文件大小限制	图片像素限制
     * 1/null	小程序头像	小于等于2M	256px * 256px以内推荐144px * 144px
     * 2	服务类目资质图片	小于等于5M
     * 3	小程序名称审核资料	小于等于5M
     * @return com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse
     */
    UploadResponse uploadByTicket(Map<String,Object> params, String path, String type) throws FileNotFoundException;


    /**
     * 重载方法 http上获取文件信息
     * 图片上传
     * 百度第三方服务所有的api中只要涉及图片url的字段，都需要使用这个图片上传接口返回的图片地址，否则会提示图片来源非法，目前只支持bmp、jpeg、jpg、png格式。
     * @author barcke
     * @date 2020/5/27
     * @param url 	http地址
     * @param type 	图片用途
     * type 说明：
     * 参数值	图片用途	文件大小限制	图片像素限制
     * 1/null	小程序头像	小于等于2M	256px * 256px以内推荐144px * 144px
     * 2	服务类目资质图片	小于等于5M
     * 3	小程序名称审核资料	小于等于5M
     * @return com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse
     */
    UploadResponse uploadHttpUrl(String accessToken,String url, String type) throws IOException;

    /**
     * 重载方法 http上获取文件信息并从localCache中获取token
     * 图片上传
     * 百度第三方服务所有的api中只要涉及图片url的字段，都需要使用这个图片上传接口返回的图片地址，否则会提示图片来源非法，目前只支持bmp、jpeg、jpg、png格式。
     * @author barcke
     * @date 2020/5/27
     * @param url 	http地址
     * @param type 	图片用途
     * type 说明：
     * 参数值	图片用途	文件大小限制	图片像素限制
     * 1/null	小程序头像	小于等于2M	256px * 256px以内推荐144px * 144px
     * 2	服务类目资质图片	小于等于5M
     * 3	小程序名称审核资料	小于等于5M
     * @return com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse
     */
    UploadResponse uploadHttpUrl(String url, String type) throws IOException;

    /**
     * 重载方法 http上获取文件信息
     * 图片上传
     * 百度第三方服务所有的api中只要涉及图片url的字段，都需要使用这个图片上传接口返回的图片地址，否则会提示图片来源非法，目前只支持bmp、jpeg、jpg、png格式。
     * @author barcke
     * @date 2020/5/27
     * @param url 	http地址
     * @param type 	图片用途
     * type 说明：
     * 参数值	图片用途	文件大小限制	图片像素限制
     * 1/null	小程序头像	小于等于2M	256px * 256px以内推荐144px * 144px
     * 2	服务类目资质图片	小于等于5M
     * 3	小程序名称审核资料	小于等于5M
     * @return com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse
     */
    UploadResponse uploadHttpUrlByTicket(String ticket,String url, String type) throws IOException;


    /**
     * 重载方法 http上获取文件信息
     * 图片上传
     * 百度第三方服务所有的api中只要涉及图片url的字段，都需要使用这个图片上传接口返回的图片地址，否则会提示图片来源非法，目前只支持bmp、jpeg、jpg、png格式。
     * @author barcke
     * @date 2020/5/27
     * @param url 	http地址
     * @param type 	图片用途
     * type 说明：
     * 参数值	图片用途	文件大小限制	图片像素限制
     * 1/null	小程序头像	小于等于2M	256px * 256px以内推荐144px * 144px
     * 2	服务类目资质图片	小于等于5M
     * 3	小程序名称审核资料	小于等于5M
     * @return com.barcke.y.baidu.pojo.thirdpart.upload.response.UploadResponse
     */
    UploadResponse uploadHttpUrlByTicket(Map<String,Object> params,String url, String type) throws IOException;

}
