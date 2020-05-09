package com.barcke.y.baidu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
 * @ClassName BaiduGetSessionKeyResponseDTO
 * @Description TODO
 * @Author Barcke
 * @Date 2020/4/29 8:26 下午
 * @Version 1.0
 * 百度获取sessionkey返回数据DTO
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaiduGetSessionKeyResponseDTO {

    //用户身份标识，由 appid 和 uid 生成。
    //不同用户登录同一个小程序获取到的 openid 不同，同一个用户使用登录不同一个小程序获取到的 openid 也不同 。
    private String openid;

    //用户的Session Key
    private String session_key;

    //错误码
    private String error;

    //错误描述信息
    private String error_description;

    //错误number
    private String errno;
}
