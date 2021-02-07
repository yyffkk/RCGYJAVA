package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 管家app 物品明细信息Vo list 回显
 */
public class ButlerArticleDetailVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 物品明细名称
     */
    private String name;
    /**
     * 物品单号（物品编号用于生成二维码）
     */
    private String code;
    /**
     * 出借状态（1.未出借，2.已出借）
     */
    private Integer borrowStatus;
    /**
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "ButlerArticleDetailVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", borrowStatus=" + borrowStatus +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(Integer borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public ButlerArticleDetailVo() {
    }

    public ButlerArticleDetailVo(Integer id, String name, String code, Integer borrowStatus, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.borrowStatus = borrowStatus;
        this.imgUrls = imgUrls;
    }
}
