package com.api.vo.butlerService;

/**
 * 投票候选人详情信息
 */
public class VoFindDetailByIdVoteCandidate {
    /**
     * 投票候选人主键id
     */
    private Integer id;
    /**
     * 投票管理主键id
     */
    private Integer voteId;
    /**
     * 选项名称
     */
    private String name;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 票数
     */
    private Integer total;

    @Override
    public String toString() {
        return "VoFindDetailByIdVoteCandidate{" +
                "id=" + id +
                ", voteId=" + voteId +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", total=" + total +
                '}';
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public VoFindDetailByIdVoteCandidate() {
    }

    public VoFindDetailByIdVoteCandidate(Integer id, Integer voteId, String name, String tel, Integer total) {
        this.id = id;
        this.voteId = voteId;
        this.name = name;
        this.tel = tel;
        this.total = total;
    }
}
