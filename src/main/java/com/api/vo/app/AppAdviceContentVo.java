package com.api.vo.app;

import java.util.Date;

/**
 * app咨询建议反馈文本内容
 */
public class AppAdviceContentVo {
    /**
     * 反馈信息主键id
     */
    private Integer id;
    /**
     * 反馈人类型（1.住户，2.装修公司，3.物业）
     */
    private Integer createUserType;
    /**
     * 反馈内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 上级id，顶层为0
     */
    private Integer parentId;

    @Override
    public String toString() {
        return "AppAdviceContentVo{" +
                "id=" + id +
                ", createUserType=" + createUserType +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", parentId=" + parentId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreateUserType() {
        return createUserType;
    }

    public void setCreateUserType(Integer createUserType) {
        this.createUserType = createUserType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public AppAdviceContentVo() {
    }

    public AppAdviceContentVo(Integer id, Integer createUserType, String content, Date createDate, Integer parentId) {
        this.id = id;
        this.createUserType = createUserType;
        this.content = content;
        this.createDate = createDate;
        this.parentId = parentId;
    }
}
