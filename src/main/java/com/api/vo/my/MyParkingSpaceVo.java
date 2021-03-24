package com.api.vo.my;

/**
 * 我的车位Vo list  回显
 */
public class MyParkingSpaceVo {
    /**
     * 车位编号
     */
    private String code;
    /**
     * 审核状态（1.审核中，3.审核失败，4.审核成功）
     */
    private Integer status;

    @Override
    public String toString() {
        return "MyParkingSpaceVo{" +
                "code='" + code + '\'' +
                ", status=" + status +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public MyParkingSpaceVo() {
    }

    public MyParkingSpaceVo(String code, Integer status) {
        this.code = code;
        this.status = status;
    }
}
