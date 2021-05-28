package com.api.model.butlerService;

/**
 * 新版装修管理 搜索条件
 */
public class UserDecorationNewSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 装修状态（1.装修申请中，2.装修通过，3.装修驳回，4.装修中，5.申请完工检查，6.检查通过，7.检查不通过）
     */
    private Integer status;
    /**
     * 装修公司名称
     */
    private String constructionUnit;
    /**
     * 装修负责人联系方式
     */
    private String directorTel;

    @Override
    public String toString() {
        return "UserDecorationNewSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", status=" + status +
                ", constructionUnit='" + constructionUnit + '\'' +
                ", directorTel='" + directorTel + '\'' +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public String getDirectorTel() {
        return directorTel;
    }

    public void setDirectorTel(String directorTel) {
        this.directorTel = directorTel;
    }

    public UserDecorationNewSearch() {
    }

    public UserDecorationNewSearch(int pageNum, int size, Integer status, String constructionUnit, String directorTel) {
        this.pageNum = pageNum;
        this.size = size;
        this.status = status;
        this.constructionUnit = constructionUnit;
        this.directorTel = directorTel;
    }
}
