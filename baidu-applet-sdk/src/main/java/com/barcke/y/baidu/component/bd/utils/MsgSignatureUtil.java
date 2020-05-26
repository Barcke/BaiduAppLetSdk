/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.barcke.y.baidu.component.bd.utils;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * 计算智能小程序第三方平台的消息签名接口
 */
public class MsgSignatureUtil {

    /**
     * 用SHA1算法生成安全签名
     *
     * @param token     消息验证TOKEN
     * @param timestamp 时间戳
     * @param nonce     随机字符串
     * @param encrypt   密文
     *
     * @return 安全签名
     */
    public static String getMsgSignature(String token, String timestamp, String nonce, String encrypt) {
        try {
            String[] array = new String[] {token, timestamp, nonce, encrypt};
            StringBuilder sb = new StringBuilder();
            Arrays.sort(array);
            for (int i = 0; i < 4; i++) {
                sb.append(array[i]);
            }
            String str = sb.toString();
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();

            StringBuilder hexStr = new StringBuilder();
            String shaHex;
            for (byte aDigest : digest) {
                shaHex = Integer.toHexString(aDigest & 0xFF);
                if (shaHex.length() < 2) {
                    hexStr.append(0);
                }
                hexStr.append(shaHex);
            }
            return hexStr.toString();
        } catch (Exception e) {
            throw new RuntimeException("生成安全签名失败");
        }
    }
}
