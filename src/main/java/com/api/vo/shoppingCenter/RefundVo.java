package com.api.vo.shoppingCenter;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 退换货管理Vo list 回显
 */
public class RefundVo {
    /**
     * 商品预约主键id
     */
    private Integer id;
    /**
     * 商品预约编号
     */
    private String code;
    /**
     * 商品主键id
     */
    private Integer goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品照片
     */
    private List<VoResourcesImg> goodsImgList;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户手机号
     */
    private String userTel;
    /**
     * 客户期望：1.退货，2.换货
     */
    private Integer backType;
    /**
     * 状态：4.申请退换货，5.申请通过，6.申请驳回
     */
    private Integer status;
    /**
     * 退货申请时间
     */
    private Date backDate;
    /**
     * 退货货理由
     */
    private String backReason;

    @Override
    public String toString() {
        return "RefundVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsImgList=" + goodsImgList +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", backType=" + backType +
                ", status=" + status +
                ", backDate=" + backDate +
                ", backReason='" + backReason + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public List<VoResourcesImg> getGoodsImgList() {
        return goodsImgList;
    }

    public void setGoodsImgList(List<VoResourcesImg> goodsImgList) {
        this.goodsImgList = goodsImgList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Integer getBackType() {
        return backType;
    }

    public void setBackType(Integer backType) {
        this.backType = backType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }

    public String getBackReason() {
        return backReason;
    }

    public void setBackReason(String backReason) {
        this.backReason = backReason;
    }

    public RefundVo() {
    }

    public RefundVo(Integer id, String code, Integer goodsId, String goodsName, List<VoResourcesImg> goodsImgList, String userName, String userTel, Integer backType, Integer status, Date backDate, String backReason) {
        this.id = id;
        this.code = code;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsImgList = goodsImgList;
        this.userName = userName;
        this.userTel = userTel;
        this.backType = backType;
        this.status = status;
        this.backDate = backDate;
        this.backReason = backReason;
    }
}
