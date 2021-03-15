package com.api.vo.butlerApp;

/**
 * 待办事项Vo list 回显
 */
public class ButlerBacklogVo {
    /**
     * 数据
     */
    private Object data;
    /**
     * 返回数据类型，1.报事报修，2.物品出门
     */
    private Integer type;

    @Override
    public String toString() {
        return "ButlerBacklogVo{" +
                "data=" + data +
                ", type=" + type +
                '}';
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public ButlerBacklogVo() {
    }

    public ButlerBacklogVo(Object data, Integer type) {
        this.data = data;
        this.type = type;
    }
}
