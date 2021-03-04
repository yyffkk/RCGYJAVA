package com.api.vo.app;

/**
 * app装修跟踪记录明细Vo 回显
 */
public class AppTrackRecordDetailVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 跟踪检查内容
     */
    private String checksContent;
    /**
     * 是否合格（1.正常，0.异常）
     */
    private Integer isQualified;

    @Override
    public String toString() {
        return "AppTrackRecordDetailVo{" +
                "id=" + id +
                ", checksContent='" + checksContent + '\'' +
                ", isQualified=" + isQualified +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChecksContent() {
        return checksContent;
    }

    public void setChecksContent(String checksContent) {
        this.checksContent = checksContent;
    }

    public Integer getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(Integer isQualified) {
        this.isQualified = isQualified;
    }

    public AppTrackRecordDetailVo() {
    }

    public AppTrackRecordDetailVo(Integer id, String checksContent, Integer isQualified) {
        this.id = id;
        this.checksContent = checksContent;
        this.isQualified = isQualified;
    }
}
