package com.api.util;


import org.apache.commons.codec.binary.Hex;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class LiLinSignGetHmac {
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";


    /**
     * @description: hmac加密
     * @author: huabin@2019/10/4 15:37
     * @param: data 签名内容
     * @param: key 秘钥（立林提供的clientSecret）
     * @return: 加密结果
     * @throws:
     */
    public static String genHMAC(String data, String key) throws Exception {
        //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKeySpec signinKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
        //生成一个指定 Mac 算法 的 Mac 对象f
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        //用给定密钥初始化 Mac 对象
        mac.init(signinKey);
        //完成 Mac 操作
        byte[] rawHmac = mac.doFinal(data.getBytes("UTF-8"));
        String s = new BASE64Encoder().encodeBuffer(Hex.encodeHexString(rawHmac).getBytes());
        //去掉换行符和特殊符号
        String s2 = s.replaceAll("[\\s*\t\n\r]", "");

        return s2;
    }
}
