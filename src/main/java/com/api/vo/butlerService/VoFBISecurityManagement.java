package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 安全管理 Vo findById 回显
 */
public class VoFBISecurityManagement {
    /**
     * 安全管理主键id
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
     * 发生时间
     */
    private Date happenDate;
    /**
     * 事件详情
     */
    private String details;
    /**
     * 上传文件资源集合
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "VoFBISecurityManagement{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", happenDate=" + happenDate +
                ", details='" + details + '\'' +
                ", imgList=" + imgList +
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

    public Date getHappenDate() {
        return happenDate;
    }

    public void setHappenDate(Date happenDate) {
        this.happenDate = happenDate;
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

    public VoFBISecurityManagement() {
    }

    public VoFBISecurityManagement(Integer id, String code, String name, Integer type, Date happenDate, String details, List<VoResourcesImg> imgList) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.happenDate = happenDate;
        this.details = details;
        this.imgList = imgList;
    }
}
