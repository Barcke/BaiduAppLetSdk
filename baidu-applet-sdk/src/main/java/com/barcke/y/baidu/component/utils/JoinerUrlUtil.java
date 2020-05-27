package com.barcke.y.baidu.component.utils;

import com.barcke.y.baidu.component.annotation.BaiduFieldName;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

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
  * @ClassName JoinerUrlUtil
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/26 8:11 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 
  **/
@UtilityClass
public class JoinerUrlUtil {

    public String joinerUrl(String url,Object o){
        StringBuilder sb=new StringBuilder();
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

            if (StringUtils.isNotBlank(sb)){
                sb.append("&");
            }

            if (field.isAnnotationPresent(BaiduFieldName.class)){
                sb.append(field.getAnnotation(BaiduFieldName.class).value()+ "=" +value);
                continue;
            }
            sb.append(field.getName() + "=" +value);
        }

        return url + "?" + sb.toString();
    }
}
