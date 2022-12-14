package com.api.model.basicArchives;

import java.util.Date;

/**
 * 住户信息表
 */
public class UserResident {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 业主名称
     */
    private String name;
    /**
     * 业主类型（1业主，2亲属，3租客）
     */
    private Integer type;
    /**
     * 性别：1.男，2.女
     */
    private Integer sex;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 证件类型
     */
    private Integer idType;
    /**
     * 证件号码
     */
    private String idNumber;
    /**
     * 密码Md5
     */
    private String pwd;
    /**
     * 混淆码自动生成且只生成一次
     */
    private String confuse;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 亲属身份（只限亲属）
     */
    private Integer identity;
    /**
     * 房屋状态（只限租客）
     */
    private Integer roomStatus;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * app审核界面当前选中的房产id
     */
    private Integer nowEstateExamineId;

    @Override
    public String toString() {
        return "UserResident{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", sex=" + sex +
                ", tel='" + tel + '\'' +
                ", idType=" + idType +
                ", idNumber='" + idNumber + '\'' +
                ", pwd='" + pwd + '\'' +
                ", confuse='" + confuse + '\'' +
                ", email='" + email + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", identity=" + identity +
                ", roomStatus=" + roomStatus +
                ", nickName='" + nickName + '\'' +
                ", nowEstateExamineId=" + nowEstateExamineId +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getConfuse() {
        return confuse;
    }

    public void setConfuse(String confuse) {
        this.confuse = confuse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getNowEstateExamineId() {
        return nowEstateExamineId;
    }

    public void setNowEstateExamineId(Integer nowEstateExamineId) {
        this.nowEstateExamineId = nowEstateExamineId;
    }

    public UserResident() {
    }

    public UserResident(Integer id, String name, Integer type, Integer sex, String tel, Integer idType, String idNumber, String pwd, String confuse, String email, Integer createId, Date createDate, Integer identity, Integer roomStatus, String nickName, Integer nowEstateExamineId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.sex = sex;
        this.tel = tel;
        this.idType = idType;
        this.idNumber = idNumber;
        this.pwd = pwd;
        this.confuse = confuse;
        this.email = email;
        this.createId = createId;
        this.createDate = createDate;
        this.identity = identity;
        this.roomStatus = roomStatus;
        this.nickName = nickName;
        this.nowEstateExamineId = nowEstateExamineId;
    }
}
