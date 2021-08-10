package com.api.model.butlerService;

/**
 * 报事报修工程维修 搜索条件
 */
public class SearchRepairEngineering {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 工程报修单号
     */
    private String code;
    /**
     * 状态（1.待派单（维修公司），2.待派单（维修人员），3.待接单，4.处理中（或开始整改），5.已处理（待验收），6.验收失败，7.验收成功，8.已作废，9.已取消）
     */
    private Integer status;
    /**
     * 报修区域
     */
    private String repairArea;

    @Override
    public String toString() {
        return "SearchRepairEngineering{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", repairArea='" + repairArea + '\'' +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRepairArea() {
        return repairArea;
    }

    public void setRepairArea(String repairArea) {
        this.repairArea = repairArea;
    }

    public SearchRepairEngineering() {
    }

    public SearchRepairEngineering(int pageNum, int size, String code, Integer status, String repairArea) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.status = status;
        this.repairArea = repairArea;
    }
}
