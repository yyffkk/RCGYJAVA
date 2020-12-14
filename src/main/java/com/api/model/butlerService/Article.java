package com.api.model.butlerService;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * 物品管理表
 */
public class Article {
    /**
     * 物品管理主键id
     */
    private Integer id;
    /**
     * 物品名称
     */
    private String name;
    /**
     * 上传文件（照片）
     */
    private MultipartFile file;
    /**
     * 数量
     */
    private Integer quantity;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 物品明细集合
     */
    private List<ArticleDetail> articleDetailList;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", file=" + file +
                ", quantity=" + quantity +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", articleDetailList=" + articleDetailList +
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public List<ArticleDetail> getArticleDetailList() {
        return articleDetailList;
    }

    public void setArticleDetailList(List<ArticleDetail> articleDetailList) {
        this.articleDetailList = articleDetailList;
    }

    public Article() {
    }

    public Article(Integer id, String name, MultipartFile file, Integer quantity, Integer createId, Date createDate, Integer modifyId, Date modifyDate, List<ArticleDetail> articleDetailList) {
        this.id = id;
        this.name = name;
        this.file = file;
        this.quantity = quantity;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.articleDetailList = articleDetailList;
    }
}
