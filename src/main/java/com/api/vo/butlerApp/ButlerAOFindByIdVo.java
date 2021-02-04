package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 管家app 物品出门Vo findById 回显
 */
public class ButlerAOFindByIdVo {
    /**
     * 物品出户主键id
     */
    private Integer id;
    /**
     * 状态(1.待出门，2.已出门，3.驳回申请)
     */
    private Integer status;
    /**
     * 详细地址（房产名称）
     */
    private String roomName;
    /**
     * 出户人（申请人）
     */
    private String applicantName;
    /**
     * 身份（1业主，2亲属，3租客）
     */
    private Integer identity;
    /**
     * 联系方式（申请人电话）
     */
    private String applicantTel;
    /**
     * 预计出户时间
     */
    private Date expectedTime;
    /**
     * 出户物品
     */
    private String articleOutName;
    /**
     * 物品重量(1. <50kg , 2. 50kg-100kg , 3. >100kg)
     */
    private Integer weight;
    /**
     * 搬运方式（1.自己搬运，2.搬家公司）
     */
    private Integer approach;
    /**
     * 物品照片
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "ButlerAOFindByIdVo{" +
                "id=" + id +
                ", status=" + status +
                ", roomName='" + roomName + '\'' +
                ", applicantName='" + applicantName + '\'' +
                ", identity=" + identity +
                ", applicantTel='" + applicantTel + '\'' +
                ", expectedTime=" + expectedTime +
                ", articleOutName='" + articleOutName + '\'' +
                ", weight=" + weight +
                ", approach=" + approach +
                ", imgUrls=" + imgUrls +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public String getApplicantTel() {
        return applicantTel;
    }

    public void setApplicantTel(String applicantTel) {
        this.applicantTel = applicantTel;
    }

    public Date getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Date expectedTime) {
        this.expectedTime = expectedTime;
    }

    public String getArticleOutName() {
        return articleOutName;
    }

    public void setArticleOutName(String articleOutName) {
        this.articleOutName = articleOutName;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getApproach() {
        return approach;
    }

    public void setApproach(Integer approach) {
        this.approach = approach;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public ButlerAOFindByIdVo() {
    }

    public ButlerAOFindByIdVo(Integer id, Integer status, String roomName, String applicantName, Integer identity, String applicantTel, Date expectedTime, String articleOutName, Integer weight, Integer approach, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.status = status;
        this.roomName = roomName;
        this.applicantName = applicantName;
        this.identity = identity;
        this.applicantTel = applicantTel;
        this.expectedTime = expectedTime;
        this.articleOutName = articleOutName;
        this.weight = weight;
        this.approach = approach;
        this.imgUrls = imgUrls;
    }
}
