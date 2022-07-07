package com.api.model.butlerService;

/**
 * 家政服务搜索条件
 */
public class SearchHousekeepingService {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 服务类型(1.室内清洁，2.洗涤护理)
     */
    private Integer type;
    /**
     * 状态：1.待派单，2.已派单（待接单），3.处理中，4.待支付，5.待评价，6.已完成，9.已取消
     */
    private Integer status;

    @Override
    public String toString() {
        return "SearchHousekeepingService{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", estateId=" + estateId +
                ", type=" + type +
                ", status=" + status +
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

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SearchHousekeepingService() {
    }

    public SearchHousekeepingService(int pageNum, int size, Integer estateId, Integer type, Integer status) {
        this.pageNum = pageNum;
        this.size = size;
        this.estateId = estateId;
        this.type = type;
        this.status = status;
    }
}
