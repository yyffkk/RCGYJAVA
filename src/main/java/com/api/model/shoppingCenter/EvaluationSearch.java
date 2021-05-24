package com.api.model.shoppingCenter;

/**
 * 评价搜索条件
 */
public class EvaluationSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 评价数（1.差评【1-4】，2.中评【5-6】，3.好评【7-10】）
     */
    private Integer score;
    /**
     * 用户手机号
     */
    private String tel;

    @Override
    public String toString() {
        return "EvaluationSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", score=" + score +
                ", tel='" + tel + '\'' +
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public EvaluationSearch() {
    }

    public EvaluationSearch(int pageNum, int size, Integer score, String tel) {
        this.pageNum = pageNum;
        this.size = size;
        this.score = score;
        this.tel = tel;
    }
}
