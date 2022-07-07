package com.api.model.butlerService;

/**
 * 巡检执行情况 搜索条件
 */
public class SearchInspectionExecute {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 巡检编号
     */
    private String code;
    /**
     * 巡检人手机号
     */
    private String inspectorTel;
    /**
     * 巡检状态（1.待巡检，2.已巡检,3.巡检中,4.未巡检）
     */
    private Integer inspectionStatus;

    @Override
    public String toString() {
        return "SearchInspectionExecute{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", inspectorTel='" + inspectorTel + '\'' +
                ", inspectionStatus=" + inspectionStatus +
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

    public String getInspectorTel() {
        return inspectorTel;
    }

    public void setInspectorTel(String inspectorTel) {
        this.inspectorTel = inspectorTel;
    }

    public Integer getInspectionStatus() {
        return inspectionStatus;
    }

    public void setInspectionStatus(Integer inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }

    public SearchInspectionExecute() {
    }

    public SearchInspectionExecute(int pageNum, int size, String code, String inspectorTel, Integer inspectionStatus) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.inspectorTel = inspectorTel;
        this.inspectionStatus = inspectionStatus;
    }
}
