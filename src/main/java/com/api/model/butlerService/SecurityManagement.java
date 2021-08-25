package com.api.model.butlerService;

import java.util.Arrays;
import java.util.Date;

/**
 * 安全管理
 */
public class SecurityManagement {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 记录编号
     */
    private String code;
    /**
     * 事件名称
     */
    private String name;
    /**
     * 事件类型（1.消防演习，2.纠纷处理，3.小区火警，4.其他）
     */
    private Integer type;
    /**
     * 事件详情
     */
    private String details;
    /**
     * 发生时间
     */
    private Date happenDate;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人id
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 上传文件路径数组
     */
    private String[] imgUrls;

    @Override
    public String toString() {
        return "SecurityManagement{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", details='" + details + '\'' +
                ", happenDate=" + happenDate +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getHappenDate() {
        return happenDate;
    }

    public void setHappenDate(Date happenDate) {
        this.happenDate = happenDate;
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

    public SecurityManagement() {
    }

    public SecurityManagement(Integer id, String code, String name, Integer type, String details, Date happenDate, Integer createId, Date createDate, Integer modifyId, Date modifyDate, String[] imgUrls) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.details = details;
        this.happenDate = happenDate;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.imgUrls = imgUrls;
    }
}
