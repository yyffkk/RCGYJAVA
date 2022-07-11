package com.api.vo.systemDataBigScreen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 资讯分类（触摸屏）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SDTSNewsCategoryVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 分类名称
     */
    private String name;
}
