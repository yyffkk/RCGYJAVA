package com.api.vo.butlerApp;

/**
 * 管家app 工单类型 Vo findById 回显
 */
public class ButlerDispatchTypeVo {
    /**
     * 派工类型（1.无偿服务，2.有偿服务）
     */
    private Integer dispatchType;
    /**
     * 工单时限名称
     */
    private String workOrderLimitName;
    /**
     * 工单子类名称
     */
    private String workOrderSubclassName;

    @Override
    public String toString() {
        return "ButlerDispatchTypeVo{" +
                "dispatchType=" + dispatchType +
                ", workOrderLimitName='" + workOrderLimitName + '\'' +
                ", workOrderSubclassName='" + workOrderSubclassName + '\'' +
                '}';
    }

    public Integer getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(Integer dispatchType) {
        this.dispatchType = dispatchType;
    }

    public String getWorkOrderLimitName() {
        return workOrderLimitName;
    }

    public void setWorkOrderLimitName(String workOrderLimitName) {
        this.workOrderLimitName = workOrderLimitName;
    }

    public String getWorkOrderSubclassName() {
        return workOrderSubclassName;
    }

    public void setWorkOrderSubclassName(String workOrderSubclassName) {
        this.workOrderSubclassName = workOrderSubclassName;
    }

    public ButlerDispatchTypeVo() {
    }

    public ButlerDispatchTypeVo(Integer dispatchType, String workOrderLimitName, String workOrderSubclassName) {
        this.dispatchType = dispatchType;
        this.workOrderLimitName = workOrderLimitName;
        this.workOrderSubclassName = workOrderSubclassName;
    }
}
