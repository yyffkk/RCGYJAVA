package com.api.model.butlerService;

import java.util.Date;

/**
 * 建议反馈表信息
 */
public class SysAdviceDetail {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 咨询建议id
     */
    private Integer adviceId;
    /**
     * 反馈内容
     */
    private String content;
    /**
     * 是否删除
     */
    private Integer isDelete;
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
     * 上级id，顶层为0
     */
    private Integer parentId;

    @Override
    public String toString() {
        return "SysAdviceDetail{" +
                "id=" + id +
                ", adviceId=" + adviceId +
                ", content='" + content + '\'' +
                ", isDelete=" + isDelete +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", createUserType=" + createUserType +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", modifyUserType=" + modifyUserType +
                ", parentId=" + parentId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(Integer adviceId) {
        this.adviceId = adviceId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public SysAdviceDetail() {
    }

    public SysAdviceDetail(Integer id, Integer adviceId, String content, Integer isDelete, Integer createId, Date createDate, Integer createUserType, Integer modifyId, Date modifyDate, Integer modifyUserType, Integer parentId) {
        this.id = id;
        this.adviceId = adviceId;
        this.content = content;
        this.isDelete = isDelete;
        this.createId = createId;
        this.createDate = createDate;
        this.createUserType = createUserType;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.modifyUserType = modifyUserType;
        this.parentId = parentId;
    }
}
