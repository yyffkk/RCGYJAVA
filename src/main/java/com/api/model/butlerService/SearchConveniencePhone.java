package com.api.model.butlerService;

/**
 * 便民电话 搜索条件
 */
public class SearchConveniencePhone {
    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer size;
    /**
     * 联系名称
     */
    private String name;
    /**
     * 联系电话
     */
    private String tel;

    @Override
    public String toString() {
        return "SearchConveniencePhone{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
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

    public SearchConveniencePhone() {
    }

    public SearchConveniencePhone(Integer pageNum, Integer size, String name, String tel) {
        this.pageNum = pageNum;
        this.size = size;
        this.name = name;
        this.tel = tel;
    }
}
