package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 管家app 物品Vo list 回显
 */
public class ButlerArticleVo {
    /**
     * 物品主键id
     */
    private Integer id;
    /**
     * 物品名称
     */
    private String name;
    /**
     * 借出数量
     */
    private Integer borrowNum;
    /**
     * 剩余数量
     */
    private Integer remainingNum;
    /**
     * 总数量
     */
    private Integer quantity;
    /**
     * 照片资源信息
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "ButlerArticleVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", borrowNum=" + borrowNum +
                ", remainingNum=" + remainingNum +
                ", quantity=" + quantity +
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

    public Integer getBorrowNum() {
        return borrowNum;
    }

    public void setBorrowNum(Integer borrowNum) {
        this.borrowNum = borrowNum;
    }

    public Integer getRemainingNum() {
        return remainingNum;
    }

    public void setRemainingNum(Integer remainingNum) {
        this.remainingNum = remainingNum;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public ButlerArticleVo() {
    }

    public ButlerArticleVo(Integer id, String name, Integer borrowNum, Integer remainingNum, Integer quantity, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.name = name;
        this.borrowNum = borrowNum;
        this.remainingNum = remainingNum;
        this.quantity = quantity;
        this.imgUrls = imgUrls;
    }
}
