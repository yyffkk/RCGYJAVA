package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.sql.Time;
import java.util.List;

/**
 * app 设施分类Vo list 回显
 */
public class AppFacilitiesCategoryVo {
    /**
     * 设施分类主键id
     */
    private Integer id;
    /**
     * 设施分类名称
     */
    private String name;
    /**
     * 开放开始时间
     */
    private Time openStartDate;
    /**
     * 开放结束时间
     */
    private Time openEndDate;
    /**
     * 设施数量
     */
    private Integer num;
    /**
     * 设施分类照片路径
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "AppFacilitiesCategoryVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", openStartDate=" + openStartDate +
                ", openEndDate=" + openEndDate +
                ", num=" + num +
                ", imgUrls=" + imgUrls +
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public AppFacilitiesCategoryVo() {
    }

    public AppFacilitiesCategoryVo(Integer id, String name, Time openStartDate, Time openEndDate, Integer num, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.name = name;
        this.openStartDate = openStartDate;
        this.openEndDate = openEndDate;
        this.num = num;
        this.imgUrls = imgUrls;
    }
}
