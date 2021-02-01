package com.api.model.butlerService;

/**
 * 投票人搜索条件
 */
public class SearchVotePersonnel {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 候选人主键ID
     */
    private Integer id;
    /**
     * 投票管理主键id
     */
    private Integer voteId;

    @Override
    public String toString() {
        return "SearchVotePersonnel{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", id=" + id +
                ", voteId=" + voteId +
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public SearchVotePersonnel() {
    }

    public SearchVotePersonnel(int pageNum, int size, Integer id, Integer voteId) {
        this.pageNum = pageNum;
        this.size = size;
        this.id = id;
        this.voteId = voteId;
    }
}
