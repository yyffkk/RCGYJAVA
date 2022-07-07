package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 物品明细 Vo findById 回显
 */
public class ButlerArticleDetailFBIVo {
    /**
     * 物品明细主键id
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
     * 借取状态（1.未出借，2.已出借）
     */
    private Integer borrowStatus;
    /**
     * 物品状态(1.正常，2.破损，3.丢失)
     */
    private Integer status;
    /**
     * 照片资源信息
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "ButlerArticleDetailFBIVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", borrowStatus=" + borrowStatus +
                ", status=" + status +
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

    public ButlerArticleDetailFBIVo() {
    }

    public ButlerArticleDetailFBIVo(Integer id, String name, String code, Integer borrowStatus, Integer status, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.borrowStatus = borrowStatus;
        this.status = status;
        this.imgUrls = imgUrls;
    }
}
