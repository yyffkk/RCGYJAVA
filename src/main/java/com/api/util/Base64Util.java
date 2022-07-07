package com.api.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * 将String类型的字符串进行base64编码与解码，使用utf-8
 */
@Slf4j
public class Base64Util {

    /**
     * 对给定的字符串进行base64加密
     */
    public static String encodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.encodeBase64(inputData.getBytes("utf-8")), "utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error(inputData, e);
        }

        return null;
    }
    /**
     * 对给定的字符串进行base64解密
     */
    public static String decodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.decodeBase64(inputData.getBytes("utf-8")), "utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error(inputData, e);
        }

        return null;
    }
}
