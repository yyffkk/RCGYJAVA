package com.api.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 过滤掉emoji表情 或者其他非文字类型的字符
 * mysql 5.5以上  可以考虑数据库字符集改为utf8mb4来存储
 */
public class EmojiUtils {
    /**
     * 过滤emoji表情 或者 其他非文字类型的字符
     *
     * @param source 原字符串
     * @param slipStr Emoji表情替换成的字符串
     * @return 过滤后的字符串
     */
    public static String filterEmoji(String source,String slipStr) {
        if (StringUtils.isBlank(source)) {
            return source;
        }
        StringBuilder buf = new StringBuilder(source.length());
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (isEmojiCharacter(codePoint)) {
                buf.append(codePoint);
            } else {
                buf.append(slipStr);
                //应为emoji表情长度占2，所以需要再+1
                i=i+1;
            }
        }
        return buf.toString();
    }

    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0)
                || (codePoint == 0x9)
                || (codePoint == 0xA)
                || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

}
