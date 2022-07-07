package com.api.model.butlerService;

/**
 * 门禁二维码 搜索条件
 */
public class SearchDoorQRCode {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 手机号
     */
    private String tel;

    @Override
    public String toString() {
        return "SearchDoorQRCode{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", tel='" + tel + '\'' +
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public SearchDoorQRCode() {
    }

    public SearchDoorQRCode(int pageNum, int size, String tel) {
        this.pageNum = pageNum;
        this.size = size;
        this.tel = tel;
    }
}
