package com.api.model.butlerService;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;
/**
 * 话题管理信息
 */
public class SysGambit {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 话题标题
     */
    private String title;
    /**
     * 摘要
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
     * 用户类型（系统自动获取）（1.住户，2.装修人员，3.物业）
     */
    private Integer userType;
    /**
     * 发布人（根据用户类型判断使用对应表数据）
     */
    private Integer createId;
    /**
     * 发布时间
     */
    private Date createDate;
    /**
     * 修改人（sys_user）
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 上传文件路径数组
     */
    private String[] fileUrls;
    /**
     * 是否删除默认否（1.非删，0.删除）
     */
    private Integer isDelete;

    @Override
    public String toString() {
        return "SysGambit{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", isPublic=" + isPublic +
                ", isRating=" + isRating +
                ", content='" + content + '\'' +
                ", userType=" + userType +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", fileUrls=" + Arrays.toString(fileUrls) +
                ", isDelete=" + isDelete +
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

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
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

    public String[] getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(String[] fileUrls) {
        this.fileUrls = fileUrls;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public SysGambit() {
    }

    public SysGambit(Integer id, String title, String summary, Date beginDate, Date endDate, Integer status, Integer isPublic, Integer isRating, String content, Integer userType, Integer createId, Date createDate, Integer modifyId, Date modifyDate, String[] fileUrls, Integer isDelete) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.status = status;
        this.isPublic = isPublic;
        this.isRating = isRating;
        this.content = content;
        this.userType = userType;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.fileUrls = fileUrls;
        this.isDelete = isDelete;
    }
}
