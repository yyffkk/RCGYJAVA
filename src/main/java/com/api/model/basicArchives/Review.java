package com.api.model.basicArchives;

import java.util.Arrays;

/**
 * 审核内容
 */
public class Review {
    /**
     * 审核结果，1.通过，2.不通过
     */
    private Integer type;
    /**
     * 备注
     */
    private String remakes;
    /**
     * 审核相关照片
     */
    private String[] reviewFiles;

    @Override
    public String toString() {
        return "Review{" +
                "type=" + type +
                ", remakes='" + remakes + '\'' +
                ", reviewFiles=" + Arrays.toString(reviewFiles) +
                '}';
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemakes() {
        return remakes;
    }

    public void setRemakes(String remakes) {
        this.remakes = remakes;
    }

    public String[] getReviewFiles() {
        return reviewFiles;
    }

    public void setReviewFiles(String[] reviewFiles) {
        this.reviewFiles = reviewFiles;
    }

    public Review() {
    }

    public Review(Integer type, String remakes, String[] reviewFiles) {
        this.type = type;
        this.remakes = remakes;
        this.reviewFiles = reviewFiles;
    }
}
