package com.api.vo.butlerApp;

import org.apache.poi.hssf.record.formula.functions.T;

import java.util.List;

/**
 * 待办事项Vo list 回显<泛型>
 */
public class ButlerBacklogVo<T> {
    /**
     * 数据集合
     */
    private List<T> dataList;
    /**
     * 返回数据类型，1.报事报修，2.物品出门
     */
    private Integer type;

    @Override
    public String toString() {
        return "ButlerBacklogVo{" +
                "dataList=" + dataList +
                ", type=" + type +
                '}';
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public ButlerBacklogVo() {
    }

    public ButlerBacklogVo(List<T> dataList, Integer type) {
        this.dataList = dataList;
        this.type = type;
    }
}
