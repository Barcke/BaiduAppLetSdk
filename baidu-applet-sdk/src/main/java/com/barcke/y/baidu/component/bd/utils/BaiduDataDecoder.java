package com.barcke.y.baidu.component.bd.utils;

import com.barcke.y.baidu.pojo.mini.user.response.GetUserInfoResponse;
import com.barcke.y.baidu.component.exception.BaiduException;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.util.Arrays;

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
 * @author Barcke
 * @version 1.0
 **/
@Slf4j
public class BaiduDataDecoder {

    private static Charset CHARSET = Charset.forName("utf-8");

    /**
     * 对密文进行解密
     *
     * @param text 需要解密的密文
     * @param sessionKey 通过code换取的sessionKey
     *
     * @return 解密得到的明文
     *
     * @throws BaiduException 异常错误信息
     */
    public String decrypt(String text, String sessionKey)
            throws BaiduException {
        byte [] aesKey = Base64.decodeBase64(sessionKey + "=");
        byte[] original;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
            IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aesKey, 0, 16));
            cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
            byte[] encrypted = Base64.decodeBase64(text);
            original = cipher.doFinal(encrypted);
        } catch (Exception e) {
            throw new BaiduException(e.getMessage());
        }
        String xmlContent;
        String fromClientId;
        try {
            // 去除补位字符
            byte[] bytes = PKCS7Encoder.decode(original);
            // 分离16位随机字符串,网络字节序和ClientId
            byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);
            int xmlLength = recoverNetworkBytesOrder(networkOrder);
            xmlContent = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), CHARSET);
            fromClientId = new String(Arrays.copyOfRange(bytes, 20 + xmlLength, bytes.length), CHARSET);
        } catch (Exception e) {
            throw new BaiduException(e.getMessage());
        }
        return xmlContent;
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


    public static void main(String[] args) {
        String dy = "Tkl2sKXzQbDGejO/DqjfemCkfmSwfhqYOAs32Pi+8by31JM+nVft7gDDutxiXk+AAzB75F2LbzBq8AoeusqTngZl37zqnvGrNvkNr4Zn0WrEv9GhyckcDvH9DbCkH20nHuj1C1h4y//xNJREYdApargMB1joxVSl+9KOEA7Uem5E/PxZxlt/YkPesP9O0aZ/3y/hwjpdK4udvEKYM/obs7L0/7h4s1Ne8fVw7G9d/XDf3WHy/0J67ESccr7eGPORoY95Buyc0wYbJvba2i4MtA==";

//        String dy = "ZOrJtrJ4eWkDOciQmyXPfqJhcF4t+SJsLYuIWufKt+/aBsXjKH/3iv7GafIE5DqqfEQjor4=";

        String sessionKey = "2144a9f7a91f8ac81c2ca7640431228d";
        BaiduDataDecoder demo=new BaiduDataDecoder();
        String dd = demo.decrypt(dy, sessionKey);
        Gson gson=new Gson();
        GetUserInfoResponse baiduGetUserInfoResponseDTO = gson.fromJson(dd, GetUserInfoResponse.class);
        System.out.println(dd);
    }
}
