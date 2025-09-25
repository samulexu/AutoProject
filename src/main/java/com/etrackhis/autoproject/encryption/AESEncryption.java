package com.etrackhis.autoproject.encryption;

import lombok.experimental.UtilityClass;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;


@UtilityClass
public class AESEncryption {
    private static final int KEY_LENGTH_16 = 16;
    private static final int KEY_LENGTH_32 = 32;
    private static final String AES_ECB_PKCS_5_PADDING = "AES/ECB/PKCS5Padding";
    private static final String AES = "AES";
    private static final String utf8 = "UTF-8";

    /**
     * 加密
     *
     * @param encryptStr 需要加密的明文
     * @param keyStr 加密密钥
     * @return
     */
    public static String enECB5(String encryptStr, String keyStr) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        String result = "";
        //获取 key 对象
        Key key = new SecretKeySpec(keyStr.getBytes(), AES);
        //获取 Cipher 对象,采用 ECB 工作模式
        Cipher cipher = Cipher.getInstance(AES_ECB_PKCS_5_PADDING);
        //初始化 cipher，选择加密
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(encryptStr.getBytes(utf8));
        result = Base64.encodeBase64String(bytes);
        return result;
    }

    /**
     * 解密
     *
     * @param decryptStr 需要解密的密文
     * @param keyStr 解密密钥
     * @return
     */
    public static String deECB5(String decryptStr, String keyStr) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String result = "";
        //获取 key 对象
        Key key = new SecretKeySpec(keyStr.getBytes(), AES);
        //获取 Cipher 对象,采用 ECB 工作模式
        Cipher cipher = Cipher.getInstance(AES_ECB_PKCS_5_PADDING);
        //初始化 cipher，选择解密
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(Base64.decodeBase64(decryptStr));
        result = new String(bytes);
        return result;
    }

}
