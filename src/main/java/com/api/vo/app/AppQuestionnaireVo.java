package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * app问卷调查Vo
 */
public class AppQuestionnaireVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 问卷标题
     */
    private String title;
    /**
     * 问卷说明
     */
    private String description;
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
     * 答题人数（初始为0）
     */
    private Integer answerNum;
    /**
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 答卷人 头像资源集合（取前3）
     */
    private List<VoResourcesImg> headImgURls;

    @Override
    public String toString() {
        return "AppQuestionnaireVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", answerNum=" + answerNum +
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
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

    public AppQuestionnaireVo() {
    }

    public AppQuestionnaireVo(Integer id, String title, String description, Date beginDate, Date endDate, Integer status, Integer answerNum, List<VoResourcesImg> imgUrls, List<VoResourcesImg> headImgURls) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.status = status;
        this.answerNum = answerNum;
        this.imgUrls = imgUrls;
        this.headImgURls = headImgURls;
    }
}
