package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 投票详情信息 findById 回显
 */
public class VoFindDetailByIdVote {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 投票开始时间
     */
    private Date beginDate;
    /**
     * 投票结束时间
     */
    private Date endDate;
    /**
     * 投票人群（1.业主，2.租户，3.全部）
     */
    private Integer type;
    /**
     * 照片信息集合
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "VoFindDetailByIdVote{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", type=" + type +
                ", imgUrls=" + imgUrls +
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public VoFindDetailByIdVote() {
    }

    public VoFindDetailByIdVote(Integer id, String title, String content, Date beginDate, Date endDate, Integer type, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.type = type;
        this.imgUrls = imgUrls;
    }
}
