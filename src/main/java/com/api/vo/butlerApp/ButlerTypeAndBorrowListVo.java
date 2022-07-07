package com.api.vo.butlerApp;

import java.util.List;

public class ButlerTypeAndBorrowListVo {
    /**
     * 当前角色的类型（1.可操作角色，2.其他角色）
     */
    private Integer type;
    /**
     * 管家app 借还管理Vo list 回显
     */
    private List<ButlerBorrowVo> butlerBorrowVos;

    @Override
    public String toString() {
        return "ButlerTypeAndBorrowListVo{" +
                "type=" + type +
                ", butlerBorrowVos=" + butlerBorrowVos +
                '}';
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<ButlerBorrowVo> getButlerBorrowVos() {
        return butlerBorrowVos;
    }

    public void setButlerBorrowVos(List<ButlerBorrowVo> butlerBorrowVos) {
        this.butlerBorrowVos = butlerBorrowVos;
    }

    public ButlerTypeAndBorrowListVo() {
    }

    public ButlerTypeAndBorrowListVo(Integer type, List<ButlerBorrowVo> butlerBorrowVos) {
        this.type = type;
        this.butlerBorrowVos = butlerBorrowVos;
    }
}
