package com.api.model.butlerService;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 投票候选人 model信息
 */
public class SysVoteCandidate {
    /**
     * 投票候选人主键id
     */
    private Integer id;
    /**
     * 投票管理主键id
     */
    private Integer voteId;
    /**
     * 选项名称
     */
    private String name;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 上传文件（照片）
     */
    private MultipartFile file;
    /**
     * 投票总数（默认为0，数量取sys_vote_personnel）
     */
    private Integer total;
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
     * 是否删除
     */
    private Integer isDelete;

    @Override
    public String toString() {
        return "SysVoteCandidate{" +
                "id=" + id +
                ", voteId=" + voteId +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", file=" + file +
                ", total=" + total +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public SysVoteCandidate() {
    }

    public SysVoteCandidate(Integer id, Integer voteId, String name, String tel, MultipartFile file, Integer total, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete) {
        this.id = id;
        this.voteId = voteId;
        this.name = name;
        this.tel = tel;
        this.file = file;
        this.total = total;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.isDelete = isDelete;
    }
}
