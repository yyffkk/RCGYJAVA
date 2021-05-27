package com.api.model.butlerService;

/**
 * 家政服务 搜索条件
 */
public class SearchHousekeeping {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 家政负责人手机号
     */
    private String leaderTel;
    /**
     * 创建人名称
     */
    private String createName;

    @Override
    public String toString() {
        return "SearchHousekeeping{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", leaderTel='" + leaderTel + '\'' +
                ", createName='" + createName + '\'' +
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

    public String getLeaderTel() {
        return leaderTel;
    }

    public void setLeaderTel(String leaderTel) {
        this.leaderTel = leaderTel;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public SearchHousekeeping() {
    }

    public SearchHousekeeping(int pageNum, int size, String leaderTel, String createName) {
        this.pageNum = pageNum;
        this.size = size;
        this.leaderTel = leaderTel;
        this.createName = createName;
    }
}
