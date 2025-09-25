package com.etrackhis.autoproject.encryption;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import lombok.experimental.UtilityClass;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@UtilityClass
public class RSAEncryption {

    public static String sign(String data,String key) throws IOException {
        RSA signer = new RSA((new BASE64Decoder()).decodeBuffer(key), (byte[])null);
        return signer.encryptBcd(data, KeyType.PrivateKey, StandardCharsets.UTF_8);
    }
}
