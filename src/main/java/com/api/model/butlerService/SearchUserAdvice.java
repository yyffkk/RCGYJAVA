package com.api.model.butlerService;

import java.util.Date;

/**
 * 咨询建议 搜索条件
 */
public class SearchUserAdvice {
    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer size;
    /**
     * 发布人
     */
    private String releaseName;
    /**
     * 发布时间 开始
     */
    private Date releaseDateStart;
    /**
     * 发布时间 结束
     */
    private Date releaseDateEnd;
    /**
     * 状态（1.未反馈，2.反馈中，3.已反馈）
     */
    private Integer status;
    /**
     * 评分数1-10分
     */
    private Integer score;
    /**
     * 类型 1.咨询，2.建议,3.投诉，4.建议
     */
    private Integer type;

    @Override
    public String toString() {
        return "SearchUserAdvice{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", releaseName='" + releaseName + '\'' +
                ", releaseDateStart=" + releaseDateStart +
                ", releaseDateEnd=" + releaseDateEnd +
                ", status=" + status +
                ", score=" + score +
                ", type=" + type +
                '}';
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getReleaseName() {
        return releaseName;
    }

    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

    public Date getReleaseDateStart() {
        return releaseDateStart;
    }

    public void setReleaseDateStart(Date releaseDateStart) {
        this.releaseDateStart = releaseDateStart;
    }

    public Date getReleaseDateEnd() {
        return releaseDateEnd;
    }

    public void setReleaseDateEnd(Date releaseDateEnd) {
        this.releaseDateEnd = releaseDateEnd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public SearchUserAdvice() {
    }

    public SearchUserAdvice(Integer pageNum, Integer size, String releaseName, Date releaseDateStart, Date releaseDateEnd, Integer status, Integer score, Integer type) {
        this.pageNum = pageNum;
        this.size = size;
        this.releaseName = releaseName;
        this.releaseDateStart = releaseDateStart;
        this.releaseDateEnd = releaseDateEnd;
        this.status = status;
        this.score = score;
        this.type = type;
    }
}
