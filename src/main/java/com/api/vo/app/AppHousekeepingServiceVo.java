package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * app新版家政服务 Vo list 回显
 */
public class AppHousekeepingServiceVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 申请人姓名
     */
    private String proposerName;
    /**
     * 申请人手机号
     */
    private String proposerTel;
    /**
     * 房屋名称
     */
    private String roomName;
    /**
     * 服务类型(1.室内清洁，2.洗涤护理)
     */
    private Integer type;
    /**
     * 服务内容
     */
    private String content;
    /**
     * 状态：1.待派单，2.已派单（待接单），3.处理中，4.待支付，5.待评价，6.已完成，9.已取消，10.已作废
     */
    private Integer status;
    /**
     * 完成情况：1.未完成,2.已完成
     */
    private Integer completion;
    /**
     * 处理人名称
     */
    private String handlerName;
    /**
     * 处理人电话
     */
    private String handlerTel;
    /**
     * 处理描述
     */
    private String processDescription;
    /**
     * 处理时间
     */
    private Date handlingTime;
    /**
     * 处理完成照片资源信息
     */
    private List<VoResourcesImg> handlerImgList;
    /**
     * 支付费用
     */
    private Double payFee;
    /**
     * 评价，1-10分
     */
    private Integer evaluation;
    /**
     * 评价内容
     */
    private String evaluationContent;
    /**
     * 评价时间
     */
    private Date evaluationTime;
    /**
     * 评价照片资源信息
     */
    private List<VoResourcesImg> evaluationImgList;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 提交照片资源信息
     */
    private List<VoResourcesImg> submitImgList;

    @Override
    public String toString() {
        return "AppHousekeepingServiceVo{" +
                "id=" + id +
                ", proposerName='" + proposerName + '\'' +
                ", proposerTel='" + proposerTel + '\'' +
                ", roomName='" + roomName + '\'' +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", completion=" + completion +
                ", handlerName='" + handlerName + '\'' +
                ", handlerTel='" + handlerTel + '\'' +
                ", processDescription='" + processDescription + '\'' +
                ", handlingTime=" + handlingTime +
                ", handlerImgList=" + handlerImgList +
                ", payFee=" + payFee +
                ", evaluation=" + evaluation +
                ", evaluationContent='" + evaluationContent + '\'' +
                ", evaluationTime=" + evaluationTime +
                ", evaluationImgList=" + evaluationImgList +
                ", createDate=" + createDate +
                ", submitImgList=" + submitImgList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProposerName() {
        return proposerName;
    }

    public void setProposerName(String proposerName) {
        this.proposerName = proposerName;
    }

    public String getProposerTel() {
        return proposerTel;
    }

    public void setProposerTel(String proposerTel) {
        this.proposerTel = proposerTel;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCompletion() {
        return completion;
    }

    public void setCompletion(Integer completion) {
        this.completion = completion;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getHandlerTel() {
        return handlerTel;
    }

    public void setHandlerTel(String handlerTel) {
        this.handlerTel = handlerTel;
    }

    public String getProcessDescription() {
        return processDescription;
    }

    public void setProcessDescription(String processDescription) {
        this.processDescription = processDescription;
    }

    public Date getHandlingTime() {
        return handlingTime;
    }

    public void setHandlingTime(Date handlingTime) {
        this.handlingTime = handlingTime;
    }

    public List<VoResourcesImg> getHandlerImgList() {
        return handlerImgList;
    }

    public void setHandlerImgList(List<VoResourcesImg> handlerImgList) {
        this.handlerImgList = handlerImgList;
    }

    public Double getPayFee() {
        return payFee;
    }

    public void setPayFee(Double payFee) {
        this.payFee = payFee;
    }

    public Integer getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Integer evaluation) {
        this.evaluation = evaluation;
    }

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent;
    }

    public Date getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(Date evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    public List<VoResourcesImg> getEvaluationImgList() {
        return evaluationImgList;
    }

    public void setEvaluationImgList(List<VoResourcesImg> evaluationImgList) {
        this.evaluationImgList = evaluationImgList;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<VoResourcesImg> getSubmitImgList() {
        return submitImgList;
    }

    public void setSubmitImgList(List<VoResourcesImg> submitImgList) {
        this.submitImgList = submitImgList;
    }

    public AppHousekeepingServiceVo() {
    }

    public AppHousekeepingServiceVo(Integer id, String proposerName, String proposerTel, String roomName, Integer type, String content, Integer status, Integer completion, String handlerName, String handlerTel, String processDescription, Date handlingTime, List<VoResourcesImg> handlerImgList, Double payFee, Integer evaluation, String evaluationContent, Date evaluationTime, List<VoResourcesImg> evaluationImgList, Date createDate, List<VoResourcesImg> submitImgList) {
        this.id = id;
        this.proposerName = proposerName;
        this.proposerTel = proposerTel;
        this.roomName = roomName;
        this.type = type;
        this.content = content;
        this.status = status;
        this.completion = completion;
        this.handlerName = handlerName;
        this.handlerTel = handlerTel;
        this.processDescription = processDescription;
        this.handlingTime = handlingTime;
        this.handlerImgList = handlerImgList;
        this.payFee = payFee;
        this.evaluation = evaluation;
        this.evaluationContent = evaluationContent;
        this.evaluationTime = evaluationTime;
        this.evaluationImgList = evaluationImgList;
        this.createDate = createDate;
        this.submitImgList = submitImgList;
    }
}
