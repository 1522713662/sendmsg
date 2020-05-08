package com.gree.scada.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: WeChat
 * @CladdName Sha1Util.java
 * @description: SHA1加密
 * @author: 260340
 * @create: 2020-04-30 15:04
 **/
public class Sha1Util {

    public static String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}

