package com.api.vo.app;

/**
 * app 我的借还物品信息
 */
public class AppMyArticleBorrowVo {
    /**
     * 物品借还主键id
     */
    private Integer id;
    /**
     * 物品名称
     */
    private String name;
    /**
     * 借取数量
     */
    private Integer quantity;
    /**
     * 借取状态（1.出借中，2.已还）
     */
    private Integer borrowStatus;
    /**
     * 借用时长
     */
    private Integer dayNum;
}
