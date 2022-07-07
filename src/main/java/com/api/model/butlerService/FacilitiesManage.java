package com.api.model.butlerService;

import java.util.Date;

/**
 * 设施管理信息model
 */
public class FacilitiesManage {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 设施编号
     */
    private String code;
    /**
     * 设施名称
     */
    private String name;
    /**
     * 设施地址
     */
    private String address;
    /**
     * 设施分类主键id
     */
    private Integer facilitiesCategoryId;
    /**
     * 设施状态（1.空置中，2.使用中，3.已停用）
     */
    private Integer status;
    /**
     * 上传doc文件路径
     */
    private String fileDocUrl;
    /**
     * 上传doc文件名称
     */
    private String fileDocName;
    /**
     * 备注
     */
    private String remakes;
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
     * 是否删除，1.非删 0.删除
     */
    private Integer isDelete;

    @Override
    public String toString() {
        return "FacilitiesManage{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", facilitiesCategoryId=" + facilitiesCategoryId +
                ", status=" + status +
                ", fileDocUrl='" + fileDocUrl + '\'' +
                ", fileDocName='" + fileDocName + '\'' +
                ", remakes='" + remakes + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", isDelete=" + isDelete +
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFacilitiesCategoryId() {
        return facilitiesCategoryId;
    }

    public void setFacilitiesCategoryId(Integer facilitiesCategoryId) {
        this.facilitiesCategoryId = facilitiesCategoryId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFileDocUrl() {
        return fileDocUrl;
    }

    public void setFileDocUrl(String fileDocUrl) {
        this.fileDocUrl = fileDocUrl;
    }

    public String getFileDocName() {
        return fileDocName;
    }

    public void setFileDocName(String fileDocName) {
        this.fileDocName = fileDocName;
    }

    public String getRemakes() {
        return remakes;
    }

    public void setRemakes(String remakes) {
        this.remakes = remakes;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public FacilitiesManage() {
    }

    public FacilitiesManage(Integer id, String code, String name, String address, Integer facilitiesCategoryId, Integer status, String fileDocUrl, String fileDocName, String remakes, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.address = address;
        this.facilitiesCategoryId = facilitiesCategoryId;
        this.status = status;
        this.fileDocUrl = fileDocUrl;
        this.fileDocName = fileDocName;
        this.remakes = remakes;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.isDelete = isDelete;
    }
}
