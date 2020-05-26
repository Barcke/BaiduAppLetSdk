/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.barcke.y.baidu.component.bd.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * JAVA AES 消息加解密
 */
public class AesDecryptUtil {

    private static Charset CHARSET = Charset.forName("utf-8");
    private Cipher decCipher;

    /**
     * 构造函数
     *
     * @param encodingAesKey encodingAESKey
     *
     * @throws Exception 异常错误信息
     */
    public AesDecryptUtil(String encodingAesKey) throws Exception {
        int encodingAesKeyLength = 43;
        if (encodingAesKey.length() != encodingAesKeyLength) {
            throw new Exception("ILLEGAL_AES_KEY_ERROR");
        }
        byte[] aesKey = Base64.decodeBase64(encodingAesKey + "=");

        SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
        IvParameterSpec iv = new IvParameterSpec(aesKey, 0, 16);
        Cipher encCipher = Cipher.getInstance("AES/CBC/NoPadding");
        encCipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);

        decCipher = Cipher.getInstance("AES/CBC/NoPadding");
        decCipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
    }

    /**
     * 还原4个字节的网络字节序
     *
     * @param orderBytes 字节码
     *
     * @return sourceNumber
     */
    private int recoverNetworkBytesOrder(byte[] orderBytes) {
        int sourceNumber = 0;
        int length = 4;
        int number = 8;
        for (int i = 0; i < length; i++) {
            sourceNumber <<= number;
            sourceNumber |= orderBytes[i] & 0xff;
        }
        return sourceNumber;
    }

    /**
     * 对密文进行解密
     *
     * @param text 需要解密的密文
     *
     * @return 解密得到的明文
     *
     * @throws Exception 异常错误信息
     */
    public String decrypt(String text)
            throws Exception {
        byte[] original;
        try {

            byte[] encrypted = Base64.decodeBase64(text);
            original = decCipher.doFinal(encrypted);
        } catch (Exception e) {
            throw new Exception("DECRYPT_AES_ERROR");
        }
        String xmlContent;
        try {
            // 去除补位字符
            byte[] bytes = PKCS7Encoder.decode(original);
            // 分离16位随机字符串,网络字节序和ClientId
            byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);
            int xmlLength = recoverNetworkBytesOrder(networkOrder);
            xmlContent = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), CHARSET);
        } catch (Exception e) {
            throw new Exception("ILLEGAL_BUFFER_ERROR");
        }
        return xmlContent;
    }

}
