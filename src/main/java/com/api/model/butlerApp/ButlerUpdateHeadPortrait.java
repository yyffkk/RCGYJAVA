package com.api.model.butlerApp;

import java.util.Arrays;

/**
 * 管家app修改头像信息资源
 */
public class ButlerUpdateHeadPortrait {
    /**
     * 用户头像资源路径数组
     */
    private String[] fileUrls;

    @Override
    public String toString() {
        return "ButlerUpdateHeadPortrait{" +
                "fileUrls=" + Arrays.toString(fileUrls) +
                '}';
    }

    public String[] getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(String[] fileUrls) {
        this.fileUrls = fileUrls;
    }

    public ButlerUpdateHeadPortrait() {
    }

    public ButlerUpdateHeadPortrait(String[] fileUrls) {
        this.fileUrls = fileUrls;
    }
}
