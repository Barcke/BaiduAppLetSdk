package com.barcke.y.baidu.pojo.mini.user.response;

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
  * @ClassName BaiduGetUserInfoResponseDTO
  * @Description TODO
  * @Author Barcke
  * @Date 2020/4/30 11:50 上午
  * @Version 1.0
  * @description: 
  **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserInfoResponse {

    //用户昵称，用户未设置用户昵称时，将获取用户名。
    private String nickname;

    //	用户头像
    private String headimgurl;

    //性别:值为0时是未知，为1时是男性，为2时是女性。
    private String sex;

    //	用户openid
    private String openid;
}
