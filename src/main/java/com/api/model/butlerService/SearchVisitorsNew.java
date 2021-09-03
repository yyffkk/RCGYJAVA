package com.api.model.butlerService;

/**
 * 新版访客信息搜索条件
 */
public class SearchVisitorsNew {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 访客姓名
     */
    private String name;
    /**
     * 访客手机号
     */
    private String tel;
    /**
     * 年份
     */
    private Integer years;
    /**
     * 月份
     */
    private Integer months;

    @Override
    public String toString() {
        return "SearchVisitorsNew{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", years=" + years +
                ", months=" + months +
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

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public SearchVisitorsNew() {
    }

    public SearchVisitorsNew(int pageNum, int size, String name, String tel, Integer years, Integer months) {
        this.pageNum = pageNum;
        this.size = size;
        this.name = name;
        this.tel = tel;
        this.years = years;
        this.months = months;
    }
}
