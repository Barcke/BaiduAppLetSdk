package com.barcke.y.baidu.service;

import com.barcke.y.baidu.dto.BaiduGetSessionKeyResponseDTO;
import com.barcke.y.baidu.exception.BaiduException;

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
 * @ClassName BaiduService
 * @Description TODO
 * @Author Barcke
 * @Date 2020/4/29 7:45 下午
 * @Version 1.0
 **/
public interface BaiduService {

    /**
     * 获取百度SessionKey信息
     * @author barcke
     * @date 2020/4/29
     * @param code 通过上面第一步所获得的Authorization Code。 特殊说明：code中有@符号时，会请求对应的开源宿主，用户身份校验及SessionKey生成过程由开源宿主实现
     * @return cn.ideamake.common.response.Result
     */
    BaiduGetSessionKeyResponseDTO getSessionKey(String code) throws BaiduException;
}
