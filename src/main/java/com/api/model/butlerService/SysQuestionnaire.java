package com.api.model.butlerService;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 问卷调查表信息
 */
public class SysQuestionnaire {
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
     * 答题人员类型(1.无限制，2.业主，3.租客)
     */
    private Integer answerType;
    /**
     * 答题开始时间
     */
    private Date beginDate;
    /**
     * 答题结束时间
     */
    private Date endDate;
    /**
     * 是否删除
     */
    private Integer isDelete;
    /**
     * 题目信息集合
     */
    private List<SysQuestionnaireTopic> sysQuestionnaireTopicList;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人（物业表）
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 是否发布（默认未发布）（1.发布，0.未发布）
     */
    private Integer isRelease;
    /**
     * 答题数量
     */
    private Integer answerNum;
    /**
     * 上传文件路径
     */
    private String[] files;

    @Override
    public String toString() {
        return "SysQuestionnaire{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", answerType=" + answerType +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", isDelete=" + isDelete +
                ", sysQuestionnaireTopicList=" + sysQuestionnaireTopicList +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", isRelease=" + isRelease +
                ", answerNum=" + answerNum +
                ", files=" + Arrays.toString(files) +
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

    public Integer getAnswerType() {
        return answerType;
    }

    public void setAnswerType(Integer answerType) {
        this.answerType = answerType;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public List<SysQuestionnaireTopic> getSysQuestionnaireTopicList() {
        return sysQuestionnaireTopicList;
    }

    public void setSysQuestionnaireTopicList(List<SysQuestionnaireTopic> sysQuestionnaireTopicList) {
        this.sysQuestionnaireTopicList = sysQuestionnaireTopicList;
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

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getIsRelease() {
        return isRelease;
    }

    public void setIsRelease(Integer isRelease) {
        this.isRelease = isRelease;
    }

    public Integer getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
    }

    public String[] getFiles() {
        return files;
    }

    public void setFiles(String[] files) {
        this.files = files;
    }

    public SysQuestionnaire() {
    }

    public SysQuestionnaire(Integer id, String title, String description, Integer answerType, Date beginDate, Date endDate, Integer isDelete, List<SysQuestionnaireTopic> sysQuestionnaireTopicList, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isRelease, Integer answerNum, String[] files) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.answerType = answerType;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.isDelete = isDelete;
        this.sysQuestionnaireTopicList = sysQuestionnaireTopicList;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.isRelease = isRelease;
        this.answerNum = answerNum;
        this.files = files;
    }
}
