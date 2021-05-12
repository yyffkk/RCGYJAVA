package com.api.model.app;

/**
 * app 包裹代收搜索条件
 */
public class SearchAppPackageCollection {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 状态 1.未领取,2.已领取
     */
    private Integer packageCollectionStatus;
    /**
     * 用户手机号
     */
    private String tel;

    @Override
    public String toString() {
        return "SearchAppPackageCollection{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", packageCollectionStatus=" + packageCollectionStatus +
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

    public Integer getPackageCollectionStatus() {
        return packageCollectionStatus;
    }

    public void setPackageCollectionStatus(Integer packageCollectionStatus) {
        this.packageCollectionStatus = packageCollectionStatus;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public SearchAppPackageCollection() {
    }

    public SearchAppPackageCollection(int pageNum, int size, Integer packageCollectionStatus, String tel) {
        this.pageNum = pageNum;
        this.size = size;
        this.packageCollectionStatus = packageCollectionStatus;
        this.tel = tel;
    }
}
