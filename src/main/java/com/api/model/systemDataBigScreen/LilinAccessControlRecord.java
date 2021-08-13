package com.api.model.systemDataBigScreen;

/**
 * 立林门禁记录model
 */
public class LilinAccessControlRecord {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 小区号12位，由立林线下提供
     */
    private String neighNo;
    /**
     * 卡类型（ 1 IC卡 2身份证 3二维码 4指纹 5蓝牙 6CPU卡 7人脸识别 8动态密码 9远程开门 10APP远程开门 11住户密码 12开门按钮）
     */
    private Integer cardType;
    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 应用类型 1表示住户卡，2表示物业卡，3表示巡更卡，4表示访客卡，5表示管理卡;10：失效卡（己注册，但被注销或过期）、11：非法卡（该卡号不存在）、12：异常卡（有开启防复制情况下，但不满足加密要求)
     */
    private String useType;
    /**
     * 设备号码
     */
    private String deviceNo;
    /**
     * 读头编号
     */
    private Integer headNo;
    /**
     * 是否开锁（1：未开(进)，:2：已开(进)，:3：未开（出），4：已开（出）5：未开闸门（进），6：开闸门(进)，:7：未开闸门（出），:8：开闸门（出））
     */
    private Integer isUnlock;
    /**
     * 刷卡时间，精确到毫秒数的时间戳
     */
    private Long eventTime;
    /**
     * 事务ID
     */
    private String eventId;
    /**
     * 第三方账号
     */
    private Long accountId;

    @Override
    public String toString() {
        return "LilinAccessControlRecord{" +
                "id=" + id +
                ", neighNo='" + neighNo + '\'' +
                ", cardType=" + cardType +
                ", cardNo='" + cardNo + '\'' +
                ", useType='" + useType + '\'' +
                ", deviceNo='" + deviceNo + '\'' +
                ", headNo=" + headNo +
                ", isUnlock=" + isUnlock +
                ", eventTime=" + eventTime +
                ", eventId='" + eventId + '\'' +
                ", accountId=" + accountId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNeighNo() {
        return neighNo;
    }

    public void setNeighNo(String neighNo) {
        this.neighNo = neighNo;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public Integer getHeadNo() {
        return headNo;
    }

    public void setHeadNo(Integer headNo) {
        this.headNo = headNo;
    }

    public Integer getIsUnlock() {
        return isUnlock;
    }

    public void setIsUnlock(Integer isUnlock) {
        this.isUnlock = isUnlock;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public LilinAccessControlRecord() {
    }

    public LilinAccessControlRecord(Integer id, String neighNo, Integer cardType, String cardNo, String useType, String deviceNo, Integer headNo, Integer isUnlock, Long eventTime, String eventId, Long accountId) {
        this.id = id;
        this.neighNo = neighNo;
        this.cardType = cardType;
        this.cardNo = cardNo;
        this.useType = useType;
        this.deviceNo = deviceNo;
        this.headNo = headNo;
        this.isUnlock = isUnlock;
        this.eventTime = eventTime;
        this.eventId = eventId;
        this.accountId = accountId;
    }
}
