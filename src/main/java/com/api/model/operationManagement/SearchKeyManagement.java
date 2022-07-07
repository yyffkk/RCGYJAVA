package com.api.model.operationManagement;

import java.util.Date;

/**
 * 钥匙管理 搜索条件
 */
public class SearchKeyManagement {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 钥匙编号
     */
    private String code;
    /**
     * 设备名称
     */
    private String facilityName;
    /**
     * 管理人名称
     */
    private String administrator;
    /**
     * 管理人联系方式
     */
    private String tel;
    /**
     * 发布时间开始
     */
    private Date createDateStart;
    /**
     * 发布时间结束
     */
    private Date createDateEnd;

    @Override
    public String toString() {
        return "SearchKeyManagement{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", facilityName='" + facilityName + '\'' +
                ", administrator='" + administrator + '\'' +
                ", tel='" + tel + '\'' +
                ", createDateStart=" + createDateStart +
                ", createDateEnd=" + createDateEnd +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getCreateDateStart() {
        return createDateStart;
    }

    public void setCreateDateStart(Date createDateStart) {
        this.createDateStart = createDateStart;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public SearchKeyManagement() {
    }

    public SearchKeyManagement(int pageNum, int size, String code, String facilityName, String administrator, String tel, Date createDateStart, Date createDateEnd) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.facilityName = facilityName;
        this.administrator = administrator;
        this.tel = tel;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
    }
}
