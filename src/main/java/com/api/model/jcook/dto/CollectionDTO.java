package com.api.model.jcook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 加入收藏DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollectionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户主键id
     */
    private Integer id;
    /**
     * jcook商品主键id
     */
    private Integer jcookGoodsId;
}
