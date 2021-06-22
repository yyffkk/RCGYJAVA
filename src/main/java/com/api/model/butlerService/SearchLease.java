package com.api.model.butlerService;

/**
 * 租赁管理 搜索条件
 */
public class SearchLease {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 租户姓名
     */
    private String name;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 可租房产id
     */
    private Integer estateId;
    /**
     * 人才类型：1.一类人才，2.二类人才，3.三类人才
     */
    private Integer type;
    /**
     * 办理状态，1.待签署，2.待提交，3.审核中，4.已驳回，5.待支付，6.已完成
     */
    private Integer status;

    @Override
    public String toString() {
        return "SearchLease{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", tel='" + tel + '\'' +
                ", estateId=" + estateId +
                ", type=" + type +
                ", status=" + status +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SearchLease() {
    }

    public SearchLease(int pageNum, int size, String name, String idCard, String tel, Integer estateId, Integer type, Integer status) {
        this.pageNum = pageNum;
        this.size = size;
        this.name = name;
        this.idCard = idCard;
        this.tel = tel;
        this.estateId = estateId;
        this.type = type;
        this.status = status;
    }
}
