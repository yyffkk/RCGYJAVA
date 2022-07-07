package com.api.vo.butlerService;

import com.api.model.resources.ResourcesImg;
import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 话题详情 findById 回显
 */
public class VoFindByIdGambit {
    /**
     * 话题主键id
     */
    private Integer id;
    /**
     * 话题标题
     */
    private String title;
    /**
     * 话题摘要
     */
    private String summary;
    /**
     * 开始时间
     */
    private Date beginDate;
    /**
     * 结束时间
     */
    private Date endDate;
    /**
     * 状态（1.启用中，2.禁用中）
     */
    private Integer status;
    /**
     * 是否公开（1.是，0否）
     */
    private Integer isPublic;
    /**
     * 是否可以评论（1.是，0否）
     */
    private Integer isRating;
    /**
     * 内容
     */
    private String content;
    /**
     * 照片信息集合
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "VoFindByIdGambit{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", isPublic=" + isPublic +
                ", isRating=" + isRating +
                ", content='" + content + '\'' +
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getIsRating() {
        return isRating;
    }

    public void setIsRating(Integer isRating) {
        this.isRating = isRating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public VoFindByIdGambit() {
    }

    public VoFindByIdGambit(Integer id, String title, String summary, Date beginDate, Date endDate, Integer status, Integer isPublic, Integer isRating, String content, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.status = status;
        this.isPublic = isPublic;
        this.isRating = isRating;
        this.content = content;
        this.imgUrls = imgUrls;
    }
}
