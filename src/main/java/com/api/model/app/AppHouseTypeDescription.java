package com.api.model.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * app户型说明 搜索条件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppHouseTypeDescription implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer size;

}
