package com.api.model.systemDataBigScreen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 触摸屏信息搜索 搜索条件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchTouchScreenSearch implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 搜索关键字
     */
    private String content;
    /**
     * 每栏的搜索数据数量
     */
    private Integer num;
}
