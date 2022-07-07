package com.api.model.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * app 电子商务Vo list 回显
 */
public class AppElectronicCommerceVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 电子商务标题
     */
    private String title;
    /**
     * 电子商务创建时间
     */
    private Date createDate;
    /**
     * 电子商务照片资源信息集合
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "AppElectronicCommerceVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createDate=" + createDate +
                ", imgList=" + imgList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public AppElectronicCommerceVo() {
    }

    public AppElectronicCommerceVo(Integer id, String title, Date createDate, List<VoResourcesImg> imgList) {
        this.id = id;
        this.title = title;
        this.createDate = createDate;
        this.imgList = imgList;
    }
}
