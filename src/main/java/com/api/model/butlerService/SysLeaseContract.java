package com.api.model.butlerService;

import java.util.Arrays;
import java.util.Date;

/**
 * 租赁合同model
 */
public class SysLeaseContract {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 模版名称
     */
    private String name;
    /**
     * 状态：1.启用，2.停用
     */
    private Integer status;
    /**
     * 上传照片文件路径数组
     */
    private String[] fileUrls;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SysLeaseContract{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", fileUrls=" + Arrays.toString(fileUrls) +
                ", createId=" + createId +
                ", createDate=" + createDate +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String[] getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(String[] fileUrls) {
        this.fileUrls = fileUrls;
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

    public SysLeaseContract() {
    }

    public SysLeaseContract(Integer id, String name, Integer status, String[] fileUrls, Integer createId, Date createDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.fileUrls = fileUrls;
        this.createId = createId;
        this.createDate = createDate;
    }
}
