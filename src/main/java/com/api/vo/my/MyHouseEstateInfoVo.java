package com.api.vo.my;

import java.util.Date;

/**
 * 我的房屋 数据库存在的房屋回显信息
 */
public class MyHouseEstateInfoVo {
    /**
     * id
     */
    private Integer id;
    /**
     * 有效时间开始（只限租客）
     */
    private Date effectiveTimeStart;
    /**
     * 有效时间结束（只限租客）
     */
    private Date effectiveTimeEnd;

    @Override
    public String toString() {
        return "MyHouseEstateInfoVo{" +
                "id=" + id +
                ", effectiveTimeStart=" + effectiveTimeStart +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEffectiveTimeStart() {
        return effectiveTimeStart;
    }

    public void setEffectiveTimeStart(Date effectiveTimeStart) {
        this.effectiveTimeStart = effectiveTimeStart;
    }

    public Date getEffectiveTimeEnd() {
        return effectiveTimeEnd;
    }

    public void setEffectiveTimeEnd(Date effectiveTimeEnd) {
        this.effectiveTimeEnd = effectiveTimeEnd;
    }

    public MyHouseEstateInfoVo() {
    }

    public MyHouseEstateInfoVo(Integer id, Date effectiveTimeStart, Date effectiveTimeEnd) {
        this.id = id;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
}
