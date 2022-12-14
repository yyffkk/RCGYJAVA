package com.api.model.app;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * app 新版家政服务 model
 */
public class AppHousekeepingService {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 家政房产id
     */
    private Integer estateId;
    /**
     * 服务类型(1.室内清洁，2.洗涤护理)
     */
    private Integer type;
    /**
     * 服务内容
     */
    private String content;
    /**
     * 状态：1.待派单，2.已派单（待接单），3.处理中，4.待支付，5.待评价，6.已完成，9.已取消
     */
    private Integer status;
    /**
     * 分配人
     */
    private Integer assigner;
    /**
     * 分配时间
     */
    private Date allocateTime;
    /**
     * 完成情况：1.未完成,2.已完成
     */
    private Integer completion;
    /**
     * 处理描述
     */
    private String processDescription;
    /**
     * 物料费
     */
    private BigDecimal materialFee;
    /**
     * 服务费
     */
    private BigDecimal serviceFee;
    /**
     * 支付费用
     */
    private BigDecimal payFee;
    /**
     * 处理人
     */
    private Integer handler;
    /**
     * 处理时间
     */
    private Date handlingTime;
    /**
     * 处理完成照片提交路径集合
     */
    private String[] handlerImgUrls;
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
     * 评价照片提交路径集合
     */
    private String[] evaluationImgUrls;
    /**
     * 申请人
     */
    private Integer proposer;
    /**
     * 申请时间
     */
    private Date applyTime;
    /**
     * 创建人（正数：业主id，负数：后台物业id）
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 家政照片提交路径集合
     */
    private String[] submitImgUrls;

    @Override
    public String toString() {
        return "AppHousekeepingService{" +
                "id=" + id +
                ", estateId=" + estateId +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", assigner=" + assigner +
                ", allocateTime=" + allocateTime +
                ", completion=" + completion +
                ", processDescription='" + processDescription + '\'' +
                ", materialFee=" + materialFee +
                ", serviceFee=" + serviceFee +
                ", payFee=" + payFee +
                ", handler=" + handler +
                ", handlingTime=" + handlingTime +
                ", handlerImgUrls=" + Arrays.toString(handlerImgUrls) +
                ", evaluation=" + evaluation +
                ", evaluationContent='" + evaluationContent + '\'' +
                ", evaluationTime=" + evaluationTime +
                ", evaluationImgUrls=" + Arrays.toString(evaluationImgUrls) +
                ", proposer=" + proposer +
                ", applyTime=" + applyTime +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", submitImgUrls=" + Arrays.toString(submitImgUrls) +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
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

    public Integer getAssigner() {
        return assigner;
    }

    public void setAssigner(Integer assigner) {
        this.assigner = assigner;
    }

    public Date getAllocateTime() {
        return allocateTime;
    }

    public void setAllocateTime(Date allocateTime) {
        this.allocateTime = allocateTime;
    }

    public Integer getCompletion() {
        return completion;
    }

    public void setCompletion(Integer completion) {
        this.completion = completion;
    }

    public String getProcessDescription() {
        return processDescription;
    }

    public void setProcessDescription(String processDescription) {
        this.processDescription = processDescription;
    }

    public BigDecimal getMaterialFee() {
        return materialFee;
    }

    public void setMaterialFee(BigDecimal materialFee) {
        this.materialFee = materialFee;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getPayFee() {
        return payFee;
    }

    public void setPayFee(BigDecimal payFee) {
        this.payFee = payFee;
    }

    public Integer getHandler() {
        return handler;
    }

    public void setHandler(Integer handler) {
        this.handler = handler;
    }

    public Date getHandlingTime() {
        return handlingTime;
    }

    public void setHandlingTime(Date handlingTime) {
        this.handlingTime = handlingTime;
    }

    public String[] getHandlerImgUrls() {
        return handlerImgUrls;
    }

    public void setHandlerImgUrls(String[] handlerImgUrls) {
        this.handlerImgUrls = handlerImgUrls;
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

    public String[] getEvaluationImgUrls() {
        return evaluationImgUrls;
    }

    public void setEvaluationImgUrls(String[] evaluationImgUrls) {
        this.evaluationImgUrls = evaluationImgUrls;
    }

    public Integer getProposer() {
        return proposer;
    }

    public void setProposer(Integer proposer) {
        this.proposer = proposer;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String[] getSubmitImgUrls() {
        return submitImgUrls;
    }

    public void setSubmitImgUrls(String[] submitImgUrls) {
        this.submitImgUrls = submitImgUrls;
    }

    public AppHousekeepingService() {
    }

    public AppHousekeepingService(Integer id, Integer estateId, Integer type, String content, Integer status, Integer assigner, Date allocateTime, Integer completion, String processDescription, BigDecimal materialFee, BigDecimal serviceFee, BigDecimal payFee, Integer handler, Date handlingTime, String[] handlerImgUrls, Integer evaluation, String evaluationContent, Date evaluationTime, String[] evaluationImgUrls, Integer proposer, Date applyTime, Integer createId, Date createDate, String[] submitImgUrls) {
        this.id = id;
        this.estateId = estateId;
        this.type = type;
        this.content = content;
        this.status = status;
        this.assigner = assigner;
        this.allocateTime = allocateTime;
        this.completion = completion;
        this.processDescription = processDescription;
        this.materialFee = materialFee;
        this.serviceFee = serviceFee;
        this.payFee = payFee;
        this.handler = handler;
        this.handlingTime = handlingTime;
        this.handlerImgUrls = handlerImgUrls;
        this.evaluation = evaluation;
        this.evaluationContent = evaluationContent;
        this.evaluationTime = evaluationTime;
        this.evaluationImgUrls = evaluationImgUrls;
        this.proposer = proposer;
        this.applyTime = applyTime;
        this.createId = createId;
        this.createDate = createDate;
        this.submitImgUrls = submitImgUrls;
    }
}
