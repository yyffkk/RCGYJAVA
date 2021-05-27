package com.api.vo.systemDataBigScreen;

import java.util.Date;

/**
 * 系统数据 借还时间超出一周的用户及相关信息
 */
public class SDBorrowExceedWeek {
    /**
     * 房屋名称
     */
    private String roomName;
    /**
     * 楼栋号
     */
    private Integer buildingNo;
    /**
     * 单元号
     */
    private Integer unitNo;
    /**
     * 房间名称
     */
    private String estateName;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 借出时间
     */
    private Date beginDate;
    /**
     * 借还时间
     */
    private long borrowTime;
    /**
     * 借取物品名称
     */
    private String articleName;

    @Override
    public String toString() {
        return "SDBorrowExceedWeek{" +
                "roomName='" + roomName + '\'' +
                ", buildingNo=" + buildingNo +
                ", unitNo=" + unitNo +
                ", estateName='" + estateName + '\'' +
                ", userName='" + userName + '\'' +
                ", beginDate=" + beginDate +
                ", borrowTime=" + borrowTime +
                ", articleName='" + articleName + '\'' +
                '}';
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(Integer buildingNo) {
        this.buildingNo = buildingNo;
    }

    public Integer getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(Integer unitNo) {
        this.unitNo = unitNo;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public long getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(long borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public SDBorrowExceedWeek() {
    }

    public SDBorrowExceedWeek(String roomName, Integer buildingNo, Integer unitNo, String estateName, String userName, Date beginDate, long borrowTime, String articleName) {
        this.roomName = roomName;
        this.buildingNo = buildingNo;
        this.unitNo = unitNo;
        this.estateName = estateName;
        this.userName = userName;
        this.beginDate = beginDate;
        this.borrowTime = borrowTime;
        this.articleName = articleName;
    }
}
