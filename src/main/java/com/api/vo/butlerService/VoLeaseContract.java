package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 租赁合同 Vo 回显
 */
public class VoLeaseContract {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 模版名称
     */
    private String name;
    /**
     * 启用状态：1.启用，2.停用
     */
    private Integer status;
    /**
     * 上传文件路径集合
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 创建时间
     */
    private String createDate;

    @Override
    public String toString() {
        return "VoLeaseContract{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", imgUrls=" + imgUrls +
                ", createName='" + createName + '\'' +
                ", createDate='" + createDate + '\'' +
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

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
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

    public VoLeaseContract() {
    }

    public VoLeaseContract(Integer id, String name, Integer status, List<VoResourcesImg> imgUrls, String createName, String createDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.imgUrls = imgUrls;
        this.createName = createName;
        this.createDate = createDate;
    }
}
