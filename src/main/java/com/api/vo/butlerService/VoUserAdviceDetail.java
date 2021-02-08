package com.api.vo.butlerService;

/**
 * 反馈内容Vo 回显信息
 */
public class VoUserAdviceDetail {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 反馈内容
     */
    private String content;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建人类型（住户，装修人员，物业）
     */
    private Integer createUserType;
    /**
     * 创建人姓名
     */
    private String createName;
    /**
     * 创建时间
     */
    private String createDate;
    /**
     * 上级id，顶层为0
     */
    private Integer parentId;

    @Override
    public String toString() {
        return "VoUserAdviceDetail{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createId=" + createId +
                ", createUserType=" + createUserType +
                ", createName='" + createName + '\'' +
                ", createDate='" + createDate + '\'' +
                ", parentId=" + parentId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getCreateUserType() {
        return createUserType;
    }

    public void setCreateUserType(Integer createUserType) {
        this.createUserType = createUserType;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public VoUserAdviceDetail() {
    }

    public VoUserAdviceDetail(Integer id, String content, Integer createId, Integer createUserType, String createName, String createDate, Integer parentId) {
        this.id = id;
        this.content = content;
        this.createId = createId;
        this.createUserType = createUserType;
        this.createName = createName;
        this.createDate = createDate;
        this.parentId = parentId;
    }
}
