package com.api.model.systemDataBigScreen;

/**
 * 立林门禁记录请求类型
 */
public class LilinAccessControlRecordType {
    /**
     * 上报数据类型 1001：门禁记录，1002：对讲记录，1007：方案二获取对讲参数，1008：方案三获取呼叫账号列表
     */
    private Integer bizType;
    /**
     * 上报数据类型不同数据不同，详情请参考下方。
     */
    private LilinAccessControlRecord param;

    @Override
    public String toString() {
        return "LilinAccessControlRecordType{" +
                "bizType=" + bizType +
                ", param=" + param +
                '}';
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public LilinAccessControlRecord getParam() {
        return param;
    }

    public void setParam(LilinAccessControlRecord param) {
        this.param = param;
    }

    public LilinAccessControlRecordType() {
    }

    public LilinAccessControlRecordType(Integer bizType, LilinAccessControlRecord param) {
        this.bizType = bizType;
        this.param = param;
    }
}
