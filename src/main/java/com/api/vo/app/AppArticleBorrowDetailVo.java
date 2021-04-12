package com.api.vo.app;

/**
 * 借还物品明细信息
 */
public class AppArticleBorrowDetailVo {
    /**
     * 物品明细主键id
     */
    private Integer id;
    /**
     * 物品名称
     */
    private String name;
    /**
     * 物品单号
     */
    private String code;
    /**
     * 物品状态（1.正常，2.破损，3.丢失）
     */
    private Integer status;

    @Override
    public String toString() {
        return "AppArticleBorrowDetailVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public AppArticleBorrowDetailVo() {
    }

    public AppArticleBorrowDetailVo(Integer id, String name, String code, Integer status) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.status = status;
    }
}
