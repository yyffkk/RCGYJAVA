package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 活动投票model
 */
public class AppEventVotingVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 投票开始时间
     */
    private Date beginDate;
    /**
     * 投票结束时间
     */
    private Date endDate;
    /**
     * 状态（1.未开始，2.进行中，3.已结束，4.已投票）
     */
    private Integer status;
    /**
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 投票人头像资源集合（取前3）
     */
    private List<VoResourcesImg> headImgURls;

    @Override
    public String toString() {
        return "AppEventVotingVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", imgUrls=" + imgUrls +
                ", headImgURls=" + headImgURls +
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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public List<VoResourcesImg> getHeadImgURls() {
        return headImgURls;
    }

    public void setHeadImgURls(List<VoResourcesImg> headImgURls) {
        this.headImgURls = headImgURls;
    }

    public AppEventVotingVo() {
    }

    public AppEventVotingVo(Integer id, String title, Date beginDate, Date endDate, Integer status, List<VoResourcesImg> imgUrls, List<VoResourcesImg> headImgURls) {
        this.id = id;
        this.title = title;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.status = status;
        this.imgUrls = imgUrls;
        this.headImgURls = headImgURls;
    }
}
