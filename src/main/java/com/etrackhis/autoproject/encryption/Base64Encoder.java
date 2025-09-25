package com.etrackhis.autoproject.encryption;

import lombok.experimental.UtilityClass;

import java.util.Base64;


@UtilityClass
public class Base64Encoder  {

    /**
     * @param bytes
     * @return
     */
    public static byte[] decode(final byte[] bytes) {
        byte[] b = Base64.getDecoder().decode(bytes);
        return b;
    }

    /**
     * @param str
     * @return
     */
    public static String decode(String str) {
        String result = new String(Base64.getDecoder().decode(str.getBytes()));
        return result;
    }

    /**
     * 二进制数据编码为BASE64字符串
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String encode(final byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * @param str
     * @return
     * @throws Exception
     */
    public static String encode(String str) {
        String result = Base64.getEncoder().encodeToString(str.getBytes());
        return result;
    }
}
