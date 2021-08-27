package com.api.vo.businessManagement;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 人员管理 Vo findById 回显
 */
public class VoFindByIdUser {
    /**
     * 用户ID
     */
    private Integer id;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 真实姓名
     */
    private String actualName;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 组织ID
     */
    private Integer organizationId;
    /**
     * 职位ID
     */
    private Integer positionId;
    /**
     * 汇报对象
     */
    private Integer reportTo;
    /**
     * 入职日期
     */
    private Date entryDate;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 身份证（护照）
     */
    private String idCard;
    /**
     * 员工简历资源集合
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "VoFindByIdUser{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", actualName='" + actualName + '\'' +
                ", tel='" + tel + '\'' +
                ", sex=" + sex +
                ", organizationId=" + organizationId +
                ", positionId=" + positionId +
                ", reportTo=" + reportTo +
                ", entryDate=" + entryDate +
                ", userCode='" + userCode + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", idCard='" + idCard + '\'' +
                ", imgList=" + imgList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getActualName() {
        return actualName;
    }

    public void setActualName(String actualName) {
        this.actualName = actualName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getReportTo() {
        return reportTo;
    }

    public void setReportTo(Integer reportTo) {
        this.reportTo = reportTo;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public VoFindByIdUser() {
    }

    public VoFindByIdUser(Integer id, String nickName, String actualName, String tel, Integer sex, Integer organizationId, Integer positionId, Integer reportTo, Date entryDate, String userCode, Date birthday, String email, String idCard, List<VoResourcesImg> imgList) {
        this.id = id;
        this.nickName = nickName;
        this.actualName = actualName;
        this.tel = tel;
        this.sex = sex;
        this.organizationId = organizationId;
        this.positionId = positionId;
        this.reportTo = reportTo;
        this.entryDate = entryDate;
        this.userCode = userCode;
        this.birthday = birthday;
        this.email = email;
        this.idCard = idCard;
        this.imgList = imgList;
    }
}
