package com.api.util.pdf;

/**
 * pdf需要交换的字符串map
 */
public class PdfReplaceMap {
    /**
     * 原字符串/占位符
     */
    private String oldStr;
    /**
     * 新字符串/照片路径
     */
    private String newStr;

    @Override
    public String toString() {
        return "PdfReplaceMap{" +
                "oldStr='" + oldStr + '\'' +
                ", newStr='" + newStr + '\'' +
                '}';
    }

    public String getOldStr() {
        return oldStr;
    }

    public void setOldStr(String oldStr) {
        this.oldStr = oldStr;
    }

    public String getNewStr() {
        return newStr;
    }

    public void setNewStr(String newStr) {
        this.newStr = newStr;
    }

    public PdfReplaceMap() {
    }

    public PdfReplaceMap(String oldStr, String newStr) {
        this.oldStr = oldStr;
        this.newStr = newStr;
    }
}
