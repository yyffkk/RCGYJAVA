package com.api.vo.systemDataBigScreen;

import java.util.Date;

/**
 * 报修单数量Vo list回显
 */
public class SDDispatchNumListVo {
    /**
     * 当前日期
     */
    private Date oneDay;
    /**
     * 报修单数量
     */
    private Integer num;

    @Override
    public String toString() {
        return "SDDispatchNumListVo{" +
                "oneDay=" + oneDay +
                ", num=" + num +
                '}';
    }

    public Date getOneDay() {
        return oneDay;
    }

    public void setOneDay(Date oneDay) {
        this.oneDay = oneDay;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public SDDispatchNumListVo() {
    }

    public SDDispatchNumListVo(Date oneDay, Integer num) {
        this.oneDay = oneDay;
        this.num = num;
    }
}
