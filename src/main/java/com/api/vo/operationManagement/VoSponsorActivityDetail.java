package com.api.vo.operationManagement;

/**
 * 主办活动详情
 */
public class VoSponsorActivityDetail {
    /**
     * 活动id
     */
    private Integer id;
    /**
     * 活动标题
     */
    private String title;

    @Override
    public String toString() {
        return "VoSponsorActivityDetail{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public VoSponsorActivityDetail() {
    }

    public VoSponsorActivityDetail(Integer id, String title) {
        this.id = id;
        this.title = title;
    }
}
