package com.aku.model.butlerService;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 咨询建议表信息
 */
public class SysAdvice {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 类型(1.咨询，2.建议)
     */
    private Integer type;
    /**
     * 咨询建议内容
     */
    private String content;
    /**
     * 点击数
     */
    private Integer hits;
    /**
     * 评分数1-10分
     */
    private Integer score;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 创建人类型（住户，装修公司，物业）
     */
    private Integer createUserType;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 修改人类型（住户，装修公司，物业）
     */
    private Integer modifyUserType;
    /**
     * 是否删除（0删除，1非删）
     */
    private Integer isDelete;
    /**
     * 上传文件（照片）
     */
    private MultipartFile file;

    @Override
    public String toString() {
        return "SysAdvice{" +
                "id=" + id +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", hits=" + hits +
                ", score=" + score +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", createUserType=" + createUserType +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", modifyUserType=" + modifyUserType +
                ", isDelete=" + isDelete +
                ", file=" + file +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

    public Integer getCreateUserType() {
        return createUserType;
    }

    public void setCreateUserType(Integer createUserType) {
        this.createUserType = createUserType;
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

    public Integer getModifyUserType() {
        return modifyUserType;
    }

    public void setModifyUserType(Integer modifyUserType) {
        this.modifyUserType = modifyUserType;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public SysAdvice() {
    }

    public SysAdvice(Integer id, Integer type, String content, Integer hits, Integer score, Integer createId, Date createDate, Integer createUserType, Integer modifyId, Date modifyDate, Integer modifyUserType, Integer isDelete, MultipartFile file) {
        this.id = id;
        this.type = type;
        this.content = content;
        this.hits = hits;
        this.score = score;
        this.createId = createId;
        this.createDate = createDate;
        this.createUserType = createUserType;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.modifyUserType = modifyUserType;
        this.isDelete = isDelete;
        this.file = file;
    }
}
