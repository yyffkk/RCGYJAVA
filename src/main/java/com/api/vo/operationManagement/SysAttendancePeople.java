package com.api.vo.operationManagement;

/**
 * 考勤人员Vo list  回显
 */
public class SysAttendancePeople {
    /**
     * 人员主键id
     */
    private Integer id;
    /**
     * 人员名称
     */
    private String Name;
    /**
     * 职位名称
     */
    private String identityName;
    /**
     * 联系方式
     */
    private String tel;

    @Override
    public String toString() {
        return "SysAttendancePeople{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", identityName='" + identityName + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIdentityName() {
        return identityName;
    }

    public void setIdentityName(String identityName) {
        this.identityName = identityName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public SysAttendancePeople() {
    }

    public SysAttendancePeople(Integer id, String name, String identityName, String tel) {
        this.id = id;
        Name = name;
        this.identityName = identityName;
        this.tel = tel;
    }
}
