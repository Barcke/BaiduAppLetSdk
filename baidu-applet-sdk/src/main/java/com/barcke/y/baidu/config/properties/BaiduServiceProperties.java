package com.barcke.y.baidu.config.properties;

import com.barcke.y.baidu.component.bd.utils.AesDecryptUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

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
@Data
@ConfigurationProperties("baidu.applet.info")
public class BaiduServiceProperties {

    /**
     * 小程序的Key
     */
    private String appKey;

    /**
     * 小程序的Secret
     */
    private String appSecret;

    /**
     * 小程序的appId
     */
    private String appId;

    /**
     * 第三方平台的Key
     */
    private String thirdPartAppKey;

    /**
     * 第三方平台的Secret
     */
    private String thirdPartAppSecret;

    //700bd810b0a6482bb6efb666acb01714  消息校验Token  申请第三方平台时填写的tokent
    private String token;
    //00c56064b3984dfea5f8asd321vfd545b7261636334  消息加解密Key  申请第三方平台是填写的消息加解密Key
    private String aesDecryptSecretKey;

    //"access_token":"42.1c78c3f81346571584e9842ffce9957c.2592000.1593074168.SBfHM2_KZOo-ucjltv-s-Hg0Ylh9keXH2FSCX6J"
    //c210YXBwMzQyMDM4MDI0NjViMjhjMTA3MDNmZjIwNzZhMWViNmQwN2Q3MzkxNzY=  pre_auth_code

    //46.5a7ed7b1b6eb8304bdd19564fc338b5e.315360000.1905858142.eThpoKH2Es8-r0P-_x6-wQiVMXTO-Hg0Ylh9keXH2FSCX6J  reftoken

    public static void main(String[] args) throws Exception {
        System.out.println(new AesDecryptUtil("00c56064b3984dfea5f8asd321vfd545b7261636334").decrypt("OlbcH4hkquwJtpgdI2ztCCVrKmOOacm/IdpR9sIijqRiQ/Ose7BVDMu10fUHB++06osovu/i/av1qrHGQkprkcsqDTsydIqBPrDGQ72SRk30D9LrX69LNamzBq9nq00RtWXtQdBSTB47Eq3OsqWsd7SFmIxA5iQW9w9rAbqjjSp1ghCWR+2k2l4Ojy9KQArX4w3hF/D1s/7AtH/Y0z8vhg=="));
    }
}
