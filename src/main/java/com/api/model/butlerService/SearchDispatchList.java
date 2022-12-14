package com.api.model.butlerService;

import java.util.Date;

/**
 * 派工单搜索条件
 */
public class SearchDispatchList {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 派工单号
     */
    private String code;
    /**
     * 工单类型
     */
    private Integer type;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 工单时限
     */
    private Integer workOrderTimeId;
    /**
     * 提交人姓名（报修人）
     */
    private String createName;
    /**
     * 分配人
     */
    private String distributorName;
    /**
     * 操作人（维修人）
     */
    private String operatorName;
    /**
     * 开始处理时间开始
     */
    private Date beginDateStart;
    /**
     * 开始处理时间结束
     */
    private Date beginDateEnd;
    /**
     * 派工时间开始
     */
    private Date dispatchTimeStart;
    /**
     * 派工时间结束
     */
    private Date dispatchTimeEnd;
    /**
     * 状态（1.待分配，2.已分配未接单，3.已分配处理中，4.已处理，5.已确认已完成，6.已关闭，7.已作废，8.已取消）
     */
    private Integer status;
    /**
     * 房间号
     */
    private String roomNumber;
    /**
     * 单元号
     */
    private Integer unitNo;
    /**
     * 楼栋编号
     */
    private Integer estateNo;

    @Override
    public String toString() {
        return "SearchDispatchList{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", roomName='" + roomName + '\'' +
                ", workOrderTimeId=" + workOrderTimeId +
                ", createName='" + createName + '\'' +
                ", distributorName='" + distributorName + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", beginDateStart=" + beginDateStart +
                ", beginDateEnd=" + beginDateEnd +
                ", dispatchTimeStart=" + dispatchTimeStart +
                ", dispatchTimeEnd=" + dispatchTimeEnd +
                ", status=" + status +
                ", roomNumber='" + roomNumber + '\'' +
                ", unitNo=" + unitNo +
                ", estateNo=" + estateNo +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getWorkOrderTimeId() {
        return workOrderTimeId;
    }

    public void setWorkOrderTimeId(Integer workOrderTimeId) {
        this.workOrderTimeId = workOrderTimeId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Date getBeginDateStart() {
        return beginDateStart;
    }

    public void setBeginDateStart(Date beginDateStart) {
        this.beginDateStart = beginDateStart;
    }

    public Date getBeginDateEnd() {
        return beginDateEnd;
    }

    public void setBeginDateEnd(Date beginDateEnd) {
        this.beginDateEnd = beginDateEnd;
    }

    public Date getDispatchTimeStart() {
        return dispatchTimeStart;
    }

    public void setDispatchTimeStart(Date dispatchTimeStart) {
        this.dispatchTimeStart = dispatchTimeStart;
    }

    public Date getDispatchTimeEnd() {
        return dispatchTimeEnd;
    }

    public void setDispatchTimeEnd(Date dispatchTimeEnd) {
        this.dispatchTimeEnd = dispatchTimeEnd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(Integer unitNo) {
        this.unitNo = unitNo;
    }

    public Integer getEstateNo() {
        return estateNo;
    }

    public void setEstateNo(Integer estateNo) {
        this.estateNo = estateNo;
    }

    public SearchDispatchList() {
    }

    public SearchDispatchList(int pageNum, int size, String code, Integer type, String roomName, Integer workOrderTimeId, String createName, String distributorName, String operatorName, Date beginDateStart, Date beginDateEnd, Date dispatchTimeStart, Date dispatchTimeEnd, Integer status, String roomNumber, Integer unitNo, Integer estateNo) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.type = type;
        this.roomName = roomName;
        this.workOrderTimeId = workOrderTimeId;
        this.createName = createName;
        this.distributorName = distributorName;
        this.operatorName = operatorName;
        this.beginDateStart = beginDateStart;
        this.beginDateEnd = beginDateEnd;
        this.dispatchTimeStart = dispatchTimeStart;
        this.dispatchTimeEnd = dispatchTimeEnd;
        this.status = status;
        this.roomNumber = roomNumber;
        this.unitNo = unitNo;
        this.estateNo = estateNo;
    }
}
