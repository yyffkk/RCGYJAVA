package com.api.vo.operationManagement;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 电子商务信息Vo findById 回显
 */
public class VoFBIElectronicCommerce {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 电子商务编号
     */
    private String code;
    /**
     * 电子商务标题
     */
    private String title;
    /**
     * 电子商务内容
     */
    private String content;
    /**
     * 电子商务分类名称
     */
    private String electronicCommerceCategoryName;
    /**
     * 电子商务分类主键id
     */
    private Integer electronicCommerceCategoryId;
    /**
     * 电子商务照片资源信息集合
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "VoFBIElectronicCommerce{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", electronicCommerceCategoryName='" + electronicCommerceCategoryName + '\'' +
                ", electronicCommerceCategoryId=" + electronicCommerceCategoryId +
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getElectronicCommerceCategoryName() {
        return electronicCommerceCategoryName;
    }

    public void setElectronicCommerceCategoryName(String electronicCommerceCategoryName) {
        this.electronicCommerceCategoryName = electronicCommerceCategoryName;
    }

    public Integer getElectronicCommerceCategoryId() {
        return electronicCommerceCategoryId;
    }

    public void setElectronicCommerceCategoryId(Integer electronicCommerceCategoryId) {
        this.electronicCommerceCategoryId = electronicCommerceCategoryId;
    }

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public VoFBIElectronicCommerce() {
    }

    public VoFBIElectronicCommerce(Integer id, String code, String title, String content, String electronicCommerceCategoryName, Integer electronicCommerceCategoryId, List<VoResourcesImg> imgList) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.content = content;
        this.electronicCommerceCategoryName = electronicCommerceCategoryName;
        this.electronicCommerceCategoryId = electronicCommerceCategoryId;
        this.imgList = imgList;
    }
}
