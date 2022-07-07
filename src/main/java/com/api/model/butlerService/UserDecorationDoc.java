package com.api.model.butlerService;

import java.util.Date;

/**
 * 装修须知Doc文件
 */
public class UserDecorationDoc {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 上传doc文件名称
     */
    private String name;
    /**
     * 上传doc文件路径
     */
    private String url;
    /**
     * 上传人
     */
    private Integer createId;
    /**
     * 上传时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "UserDecorationDoc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public UserDecorationDoc() {
    }

    public UserDecorationDoc(Integer id, String name, String url, Integer createId, Date createDate) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.createId = createId;
        this.createDate = createDate;
    }
}
