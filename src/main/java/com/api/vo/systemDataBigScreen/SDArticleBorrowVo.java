package com.api.vo.systemDataBigScreen;

/**
 * 系统数据 物品借还Vo 回显
 */
public class SDArticleBorrowVo {
    /**
     * 空置的物品数量
     */
    private int vacantArticle;
    /**
     * 借出的物品数量
     */
    private int borrowArticle;
    /**
     * 已损坏的物品数量
     */
    private int breakDownArticle;
    /**
     * 已丢失的物品数量
     */
    private int loseArticle;

    @Override
    public String toString() {
        return "SDArticleBorrowVo{" +
                "vacantArticle=" + vacantArticle +
                ", borrowArticle=" + borrowArticle +
                ", breakDownArticle=" + breakDownArticle +
                ", loseArticle=" + loseArticle +
                '}';
    }

    public int getVacantArticle() {
        return vacantArticle;
    }

    public void setVacantArticle(int vacantArticle) {
        this.vacantArticle = vacantArticle;
    }

    public int getBorrowArticle() {
        return borrowArticle;
    }

    public void setBorrowArticle(int borrowArticle) {
        this.borrowArticle = borrowArticle;
    }

    public int getBreakDownArticle() {
        return breakDownArticle;
    }

    public void setBreakDownArticle(int breakDownArticle) {
        this.breakDownArticle = breakDownArticle;
    }

    public int getLoseArticle() {
        return loseArticle;
    }

    public void setLoseArticle(int loseArticle) {
        this.loseArticle = loseArticle;
    }

    public SDArticleBorrowVo() {
    }

    public SDArticleBorrowVo(int vacantArticle, int borrowArticle, int breakDownArticle, int loseArticle) {
        this.vacantArticle = vacantArticle;
        this.borrowArticle = borrowArticle;
        this.breakDownArticle = breakDownArticle;
        this.loseArticle = loseArticle;
    }
}
