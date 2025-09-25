package com.etrackhis.autoproject.encryption;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import lombok.experimental.UtilityClass;

import java.security.MessageDigest;


@UtilityClass
public class SHA256Encryption {

    public static String en(String str){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] digest = messageDigest.digest(str.getBytes());
            String encode = HexBin.encode(digest);
            return encode;
        }catch (Exception e){
            return null;
        }
    }

}
