package com.api.model.app;


import java.util.Arrays;

/**
 * 修改头像信息资源
 */
public class UpdateHeadPortrait {
    /**
     * 头像资源路径
     */
    private String[] fileUrls;

    @Override
    public String toString() {
        return "UpdateHeadPortrait{" +
                "fileUrls=" + Arrays.toString(fileUrls) +
                '}';
    }

    public String[] getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(String[] fileUrls) {
        this.fileUrls = fileUrls;
    }

    public UpdateHeadPortrait() {
    }

    public UpdateHeadPortrait(String[] fileUrls) {
        this.fileUrls = fileUrls;
    }
}
