package com.api.model.operationManagement;

import java.util.Arrays;
import java.util.Date;

/**
 * 社区介绍model信息
 */
public class SysCommunityIntroduction {
    /**
     * 主键id
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
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 照片路径数组
     */
    private String[] imgUrls;

    @Override
    public String toString() {
        return "SysCommunityIntroduction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", imgUrls=" + Arrays.toString(imgUrls) +
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

    public String[] getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String[] imgUrls) {
        this.imgUrls = imgUrls;
    }

    public SysCommunityIntroduction() {
    }

    public SysCommunityIntroduction(Integer id, String name, String content, Integer status, Integer createId, Date createDate, Integer modifyId, Date modifyDate, String[] imgUrls) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.status = status;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.imgUrls = imgUrls;
    }
}
