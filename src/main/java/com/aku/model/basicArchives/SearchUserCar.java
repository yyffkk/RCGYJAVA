package com.aku.model.basicArchives;

/**
 * 车辆搜索条件
 */
public class SearchUserCar {
    /**
     * 车牌号
     */
    private String code;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 车位编号
     */
    private String parkingSpaceCode;
    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer size;

    @Override
    public String toString() {
        return "UserCarSearch{" +
                "code='" + code + '\'' +
                ", tel='" + tel + '\'' +
                ", parkingSpaceCode='" + parkingSpaceCode + '\'' +
                ", pageNum=" + pageNum +
                ", size=" + size +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getParkingSpaceCode() {
        return parkingSpaceCode;
    }

    public void setParkingSpaceCode(String parkingSpaceCode) {
        this.parkingSpaceCode = parkingSpaceCode;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public SearchUserCar() {
    }

    public SearchUserCar(String code, String tel, String parkingSpaceCode, Integer pageNum, Integer size) {
        this.code = code;
        this.tel = tel;
        this.parkingSpaceCode = parkingSpaceCode;
        this.pageNum = pageNum;
        this.size = size;
    }
}
