package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * 设施分类详情 Vo findDetail 回显
 */
public class VoFacilitiesCategoryDetail {
    /**
     * 主键id
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
     * 设施数量
     */
    private Integer num;
    /**
     * 开放开始时间
     */
    private Time openStartDate;
    /**
     * 开放结束时间
     */
    private Time openEndDate;
    /**
     * 添加人
     */
    private String createName;
    /**
     * 添加时间
     */
    private Date createDate;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 分类照片信息
     */
    private List<VoResourcesImg> files;

    @Override
    public String toString() {
        return "VoFacilitiesCategoryDetail{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", openStartDate=" + openStartDate +
                ", openEndDate=" + openEndDate +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                ", tel='" + tel + '\'' +
                ", files=" + files +
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Time getOpenStartDate() {
        return openStartDate;
    }

    public void setOpenStartDate(Time openStartDate) {
        this.openStartDate = openStartDate;
    }

    public Time getOpenEndDate() {
        return openEndDate;
    }

    public void setOpenEndDate(Time openEndDate) {
        this.openEndDate = openEndDate;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<VoResourcesImg> getFiles() {
        return files;
    }

    public void setFiles(List<VoResourcesImg> files) {
        this.files = files;
    }

    public VoFacilitiesCategoryDetail() {
    }

    public VoFacilitiesCategoryDetail(Integer id, String code, String name, Integer num, Time openStartDate, Time openEndDate, String createName, Date createDate, String tel, List<VoResourcesImg> files) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.num = num;
        this.openStartDate = openStartDate;
        this.openEndDate = openEndDate;
        this.createName = createName;
        this.createDate = createDate;
        this.tel = tel;
        this.files = files;
    }
}
