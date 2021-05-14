package com.api.vo.operationManagement;

/**
 * 社区介绍Vo findById 回显
 */
public class VoFBICommunityIntroduction {
    /**
     * 社区介绍主键id
     */
    private Integer id;
    /**
     * 模版名称
     */
    private String name;
    /**
     * 内容
     */
    private String content;
    /**
     * 启用状态 ，1.启用中，2.未启用
     */
    private Integer status;
    /**
     * 创建人名称
     */
    private String createName;

    @Override
    public String toString() {
        return "VoFBICommunityIntroduction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", createName='" + createName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public VoFBICommunityIntroduction() {
    }

    public VoFBICommunityIntroduction(Integer id, String name, String content, Integer status, String createName) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.status = status;
        this.createName = createName;
    }
}
