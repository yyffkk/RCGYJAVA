package com.api.model.jcook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * jcook收藏表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JcookCollection implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * jcook商品主键id
     */
    private Integer jcookGoodsId;
    /**
     * 用户主键id
     */
    private Integer residentId;

}
