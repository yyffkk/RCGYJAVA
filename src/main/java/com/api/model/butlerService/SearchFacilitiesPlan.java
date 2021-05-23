package com.api.model.butlerService;

/**
 * 设施设备检查计划搜索条件
 */
public class SearchFacilitiesPlan {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 设施/设备名称
     */
    private String facilitiesName;
    /**
     * 检查人联系方式
     */
    private String tel;

    @Override
    public String toString() {
        return "SearchFacilitiesPlan{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", facilitiesName='" + facilitiesName + '\'' +
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

    public String getFacilitiesName() {
        return facilitiesName;
    }

    public void setFacilitiesName(String facilitiesName) {
        this.facilitiesName = facilitiesName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public SearchFacilitiesPlan() {
    }

    public SearchFacilitiesPlan(int pageNum, int size, String facilitiesName, String tel) {
        this.pageNum = pageNum;
        this.size = size;
        this.facilitiesName = facilitiesName;
        this.tel = tel;
    }
}
