package com.api.wx.mapper;


import com.api.wx.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p> 
 *
 * @author leone
 * @since 2019-04-23
 **/
@Mapper
public interface GoodsMapper {
    
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}