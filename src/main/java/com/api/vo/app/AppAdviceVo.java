package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * app 咨询建议/投诉表扬 信息
 */
public class AppAdviceVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 类型(1.咨询，2.建议，3.投诉，4.表扬)
     */
    private Integer type;
    /**
     * 状态（1.未反馈，2.反馈中，3.已反馈）
     */
    private Integer status;
    /**
     * 咨询建议内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "AppAdviceVo{" +
                "id=" + id +
                ", type=" + type +
                ", status=" + status +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", imgUrls=" + imgUrls +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public AppAdviceVo() {
    }

    public AppAdviceVo(Integer id, Integer type, Integer status, String content, Date createDate, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.content = content;
        this.createDate = createDate;
        this.imgUrls = imgUrls;
    }
}
