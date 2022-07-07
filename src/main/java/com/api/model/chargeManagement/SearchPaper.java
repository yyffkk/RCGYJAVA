package com.api.model.chargeManagement;

/**
 * 发票管理 搜索条件
 */
public class SearchPaper {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 开票编号
     */
    private String code;
    /**
     * 开票类型：1.增值税专用发票，2.增值税普通发票，3.国税通用机打发票，4.地税通用机打发票，5.收据
     */
    private Integer type;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 抬头类型：1.企业单位，2.个人
     */
    private Integer invoiceTitleType;
    /**
     * 抬头名称
     */
    private String invoiceTitleName;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 领用情况：1.未领用，2.已领用
     */
    private Integer status;
    /**
     * 领用人姓名
     */
    private String recipient;

    @Override
    public String toString() {
        return "SearchPaper{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", invoiceTitleType=" + invoiceTitleType +
                ", invoiceTitleName='" + invoiceTitleName + '\'' +
                ", tel='" + tel + '\'' +
                ", status=" + status +
                ", recipient='" + recipient + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInvoiceTitleType() {
        return invoiceTitleType;
    }

    public void setInvoiceTitleType(Integer invoiceTitleType) {
        this.invoiceTitleType = invoiceTitleType;
    }

    public String getInvoiceTitleName() {
        return invoiceTitleName;
    }

    public void setInvoiceTitleName(String invoiceTitleName) {
        this.invoiceTitleName = invoiceTitleName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public SearchPaper() {
    }

    public SearchPaper(int pageNum, int size, String code, Integer type, String name, Integer invoiceTitleType, String invoiceTitleName, String tel, Integer status, String recipient) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.type = type;
        this.name = name;
        this.invoiceTitleType = invoiceTitleType;
        this.invoiceTitleName = invoiceTitleName;
        this.tel = tel;
        this.status = status;
        this.recipient = recipient;
    }
}
