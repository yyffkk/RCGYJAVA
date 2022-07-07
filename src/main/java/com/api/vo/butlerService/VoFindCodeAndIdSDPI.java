package com.api.vo.butlerService;

/**
 * 费用单号（工单号）和工单主键id信息
 */
public class VoFindCodeAndIdSDPI {
    /**
     * 工单主键id
     */
    private Integer id;
    /**
     * 工单号
     */
    private String code;

    @Override
    public String toString() {
        return "VoFindCodeAndIdSDPI{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public VoFindCodeAndIdSDPI() {
    }

    public VoFindCodeAndIdSDPI(Integer id, String code) {
        this.id = id;
        this.code = code;
    }
}
