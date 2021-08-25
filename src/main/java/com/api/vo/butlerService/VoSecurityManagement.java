package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 安全管理 Vo list 回显
 */
public class VoSecurityManagement {
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
     * 上传文件照片集合
     */
    private List<VoResourcesImg> imgList;
    /**
     * 发生时间
     */
    private Date happenDate;
    /**
     * 登记人名称
     */
    private String createName;

    @Override
    public String toString() {
        return "VoSecurityManagement{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", details='" + details + '\'' +
                ", imgList=" + imgList +
                ", happenDate=" + happenDate +
                ", createName='" + createName + '\'' +
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

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public Date getHappenDate() {
        return happenDate;
    }

    public void setHappenDate(Date happenDate) {
        this.happenDate = happenDate;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public VoSecurityManagement() {
    }

    public VoSecurityManagement(Integer id, String code, String name, Integer type, String details, List<VoResourcesImg> imgList, Date happenDate, String createName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.details = details;
        this.imgList = imgList;
        this.happenDate = happenDate;
        this.createName = createName;
    }
}
