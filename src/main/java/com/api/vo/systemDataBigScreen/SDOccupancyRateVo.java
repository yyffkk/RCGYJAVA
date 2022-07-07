package com.api.vo.systemDataBigScreen;

/**
 * 各楼栋入住数信息
 */
public class SDOccupancyRateVo {
    /**
     * 楼栋名称
     */
    private String name;
    /**
     * 该楼栋房屋总数
     */
    private Integer total;
    /**
     * 入住数
     */
    private Integer occupancyNum;
    /**
     * 入住率
     */
    private Integer occupancyRate;

    @Override
    public String toString() {
        return "SDOccupancyRateVo{" +
                "name='" + name + '\'' +
                ", total=" + total +
                ", occupancyNum=" + occupancyNum +
                ", occupancyRate=" + occupancyRate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getOccupancyNum() {
        return occupancyNum;
    }

    public void setOccupancyNum(Integer occupancyNum) {
        this.occupancyNum = occupancyNum;
    }

    public Integer getOccupancyRate() {
        return occupancyRate;
    }

    public void setOccupancyRate(Integer occupancyRate) {
        this.occupancyRate = occupancyRate;
    }

    public SDOccupancyRateVo() {
    }

    public SDOccupancyRateVo(String name, Integer total, Integer occupancyNum, Integer occupancyRate) {
        this.name = name;
        this.total = total;
        this.occupancyNum = occupancyNum;
        this.occupancyRate = occupancyRate;
    }
}
