package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 管家app 处理情况Vo findById 回显
 */
public class ButlerHandlingSituationVo {
    /**
     * 处理情况主键id
     */
    private Integer id;
    /**
     * 处理完成情况
     */
    private String detail;
    /**
     * 更换材料清单（含辅材）
     */
    private String materialList;
    /**
     * 上传照片资源
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "ButlerHandlingSituationVo{" +
                "id=" + id +
                ", detail='" + detail + '\'' +
                ", materialList='" + materialList + '\'' +
                ", imgUrls=" + imgUrls +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMaterialList() {
        return materialList;
    }

    public void setMaterialList(String materialList) {
        this.materialList = materialList;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public ButlerHandlingSituationVo() {
    }

    public ButlerHandlingSituationVo(Integer id, String detail, String materialList, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.detail = detail;
        this.materialList = materialList;
        this.imgUrls = imgUrls;
    }
}
