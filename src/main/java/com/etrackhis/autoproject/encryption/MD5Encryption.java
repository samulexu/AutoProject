package com.etrackhis.autoproject.encryption;

import lombok.experimental.UtilityClass;

import java.security.MessageDigest;


@UtilityClass
public class MD5Encryption {

    public static String en16(String str){
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0){ i += 256;}
                if (i < 16){ buf.append("0");}
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            return buf.toString().substring(8, 24);
        } catch (Exception e) {
            return null;
        }
    }

    public static String en32(String str){
        try {
            byte[] btInput = str.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                int val = ((int) md[i]) & 0xff;
                if (val < 16){sb.append("0");}
                sb.append(Integer.toHexString(val));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

}
