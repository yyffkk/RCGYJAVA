package com.api.vo.jcook.appGoods;

import com.api.vo.resources.VoResourcesImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * jcook轮播图信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JcookRotationInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 商品主键id
     */
    private Integer jcookGoodsId;
    /**
     * sku编码
     */
    private BigInteger skuId;
    /**
     * 轮播图照片集合
     */
    private List<VoResourcesImg> imgList;
}
