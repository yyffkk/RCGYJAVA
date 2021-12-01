package com.api.model.jcook.appDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 修改分类照片DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryImgDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品分类主键id
     */
    private Integer categoryId;
    /**
     * 照片路径数组
     */
    private String[] imgList;
}
