package com.barcke.y.baidu.component.bd.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.barcke.y.baidu.component.annotation.BaiduFieldName;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
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
 * @ClassName HttpUtil
 * @Description TODO
 * @Author Barcke
 * @Date 2020/4/29 8:12 下午
 * @Version 1.0
 **/
@Slf4j
public class HttpUtil {


    //请求超时时间
    private static final int CONNECT_TIME_OUT = 5000;

    //等待时间
    private static final int READ_TIME_OUT = 5000;

    //数据传输的超时时间
    private static final int SOCKET_TIME_OUT = 10 * 1000;

    //请求前测试连接是否可用
    private static final boolean STALE_CONNECT_ENABLED = true;

    /**
     * Post请求
     * @author barcke
     * @date 2020/4/29
     * @param url 请求地址
     * @param headers 请求头
     * @param data 传递的数据信息即请求体
     * @param encoding response数据格式 列：UTF-8
     * @return java.lang.String
     */
    public static String sendPost(String url, Map<String, String> headers, JSONObject data, String encoding, Map<String, InputStream> files) {
        String resultJson = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost();

        try {
            httpPost.setURI(new URI(url));
            int i;
            if (headers != null) {
                Header[] allHeader = new BasicHeader[headers.size()];
                i = 0;

                for(Iterator var9 = headers.entrySet().iterator(); var9.hasNext(); ++i) {
                    Map.Entry<String, String> entry = (Map.Entry)var9.next();
                    allHeader[i] = new BasicHeader(entry.getKey(), entry.getValue());
                }

                httpPost.setHeaders(allHeader);
            }

            if (null!=data) {
                httpPost.setEntity(new StringEntity(JSON.toJSONString(data)));
            }

            if (null!=files&&!files.isEmpty()){
                MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                files.entrySet().stream().forEach(k ->{
                    builder.addBinaryBody(k.getKey(),k.getValue(), ContentType.MULTIPART_FORM_DATA,k.getKey());
                });
                httpPost.setEntity(builder.build());
            }

            //构建超时等配置信息
            RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECT_TIME_OUT) //连接超时时间
                    .setConnectionRequestTimeout(READ_TIME_OUT) //从连接池中取的连接的最长时间
                    .setSocketTimeout(SOCKET_TIME_OUT) //数据传输的超时时间
                    .setStaleConnectionCheckEnabled(STALE_CONNECT_ENABLED) //提交请求前测试连接是否可用
                    .build();

            httpPost.setConfig(config);

            CloseableHttpResponse response = client.execute(httpPost);
            i = response.getStatusLine().getStatusCode();
            if (i == 200) {
                resultJson = EntityUtils.toString(response.getEntity(), encoding);
            } else {
                log.error("响应失败，状态码：" + i);
            }
        } catch (Exception var14) {
            log.error("发送post请求失败", var14);
        } finally {
            httpPost.releaseConnection();
        }

        return resultJson;
    }

    /**
     * get请求
     * @author barcke
     * @date 2020/4/30
     * @param url
     * @param headers
     * @param encoding
     * @return java.lang.String
     */
    public static String sendGet(String url, Map<String, String> headers, String encoding) {
        String resultJson = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet();

        try {
            httpGet.setURI(new URI(url));
            int i;
            if (headers != null) {
                Header[] allHeader = new BasicHeader[headers.size()];
                i = 0;

                for(Iterator var9 = headers.entrySet().iterator(); var9.hasNext(); ++i) {
                    Map.Entry<String, String> entry = (Map.Entry)var9.next();
                    allHeader[i] = new BasicHeader(entry.getKey(), entry.getValue());
                }

                httpGet.setHeaders(allHeader);
            }

            //构建超时等配置信息
            RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECT_TIME_OUT) //连接超时时间
                    .setConnectionRequestTimeout(READ_TIME_OUT) //从连接池中取的连接的最长时间
                    .setSocketTimeout(SOCKET_TIME_OUT) //数据传输的超时时间
                    .setStaleConnectionCheckEnabled(STALE_CONNECT_ENABLED) //提交请求前测试连接是否可用
                    .build();

            httpGet.setConfig(config);

            CloseableHttpResponse response = client.execute(httpGet);
            i = response.getStatusLine().getStatusCode();
            if (i == 200) {
                resultJson = EntityUtils.toString(response.getEntity(), encoding);
            } else {
                log.error("响应失败，状态码：" + i);
            }
        } catch (Exception var14) {
            log.error("发送post请求失败", var14);
        } finally {
            httpGet.releaseConnection();
        }

        return resultJson;
    }

    public static String sendGet(String url){
        return sendGet(url,null,"UTF-8");
    }

    public static String sendGet(String url,Object o){
        if (o == null) {
            return sendGet(url,null,"UTF-8");
        }

        return sendGet(url,o,null);
    }

    public static String sendGet(String url,Object o,Map<String, String> headers){
        if (o == null) {
            return sendGet(url,null,"UTF-8");
        }

        String join = Joiner.on("&").useForNull("").withKeyValueSeparator("=").join(parsingBaiduFieldNameValue(o));

        return sendGet(url + "?" + join,headers,"UTF-8");
    }

    public static String sendGet(String url,Map<String,Object> params) {
        if (null==params||params.isEmpty()){
            return sendGet(url,null,"UTF-8");
        }
        StringBuilder sb=new StringBuilder();
        for (String key :
                params.keySet()) {

            if (StringUtils.isNotBlank(sb)){
                sb.append("&"+key+"="+params.get(key));
                continue;
            }

            sb.append(key+"="+params.get(key));
        }
        return sendGet(url + "?" +sb.toString());
    }

    public static String sendGet(String url,JSONObject params) {
        if (null==params||params.isEmpty()){
            return sendGet(url,null,"UTF-8");
        }

        StringBuilder sb=new StringBuilder();
        for (String key :
                params.keySet()) {

            if (StringUtils.isNotBlank(sb)){
                sb.append("&"+key+"="+params.get(key));
                continue;
            }

            sb.append(key+"="+params.get(key));
        }

        return sendGet(url + "?" +sb.toString());
    }

    public static String sendPost(String url,Map<String,Object> params){
        String jsonString = JSON.toJSONString(params);
        return sendPost(url,null,JSON.parseObject(jsonString),"UTF-8",null);
    }

    public static String sendPost(String url, JSONObject jsonObject){
        return sendPost(url,null,jsonObject,"UTF-8",null);
    }

    public static String sendPost(String url, Object o){
        return sendPost(url,o,parsingBaiduFieldNameFile(o));
    }

    public static String sendPost(String url, Object o,Map<String,InputStream> files){
        if (null==o){
            return sendPost(url,null,null,"UTF-8",null);
        }

        String jsonString = JSON.toJSONString(parsingBaiduFieldNameValue(o));
        return sendPost(parsingBaiduFieldNameJoinerUrl(url,o),null,JSON.parseObject(jsonString),"UTF-8",files);
    }

    private static Map<String,Object> parsingBaiduFieldNameValue(Object o){
        Map<String,Object> map = new HashMap<String, Object>();
        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (Field field :
                declaredFields) {
            field.setAccessible(true);

            Object value = "";
            try {
                value=field.get(o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (value==null){
                continue;
            }

            if (field.isAnnotationPresent(BaiduFieldName.class)){
                BaiduFieldName baiduFieldName = field.getAnnotation(BaiduFieldName.class);
                if (!baiduFieldName.joinerUrl()) {
                    map.put(field.getAnnotation(BaiduFieldName.class).value(), value);
                    continue;
                }
            }
            map.put(field.getName(),value);
        }
        return map;
    }

    private static Map<String, InputStream> parsingBaiduFieldNameFile(Object o){
        Map<String,InputStream> map = new HashMap<String, InputStream>();
        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (Field field :
                declaredFields) {
            field.setAccessible(true);

            Object value = "";
            try {
                value=field.get(o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (value==null){
                continue;
            }

            if (!field.isAnnotationPresent(BaiduFieldName.class)){
               continue;
            }
            BaiduFieldName baiduFieldName = field.getAnnotation(BaiduFieldName.class);
            if (baiduFieldName.file()) {
                map.put(field.getAnnotation(BaiduFieldName.class).value(), (InputStream) value);
            }
        }
        return map;
    }

    private static String parsingBaiduFieldNameJoinerUrl(String url,Object o){
        if (null==o){
            return url;
        }
        Map<String,Object> map = new HashMap<String, Object>();
        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (Field field :
                declaredFields) {
            field.setAccessible(true);

            Object value = "";
            try {
                value=field.get(o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (value==null){
                continue;
            }

            if (field.isAnnotationPresent(BaiduFieldName.class)){
                BaiduFieldName baiduFieldName = field.getAnnotation(BaiduFieldName.class);
                if (baiduFieldName.joinerUrl()) {
                    map.put(field.getAnnotation(BaiduFieldName.class).value(), value);
                    continue;
                }
            }
            map.put(field.getName(),value);
        }
        return url+"?"+Joiner.on("&").useForNull("").withKeyValueSeparator("=").join(map);
    }

}
