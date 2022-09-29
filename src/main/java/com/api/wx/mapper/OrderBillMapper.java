package com.api.wx.mapper;



import com.api.wx.entity.OrderBill;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * <p>
 *
 * @author leone
 * @since 2019-04-23
 **/
@Mapper
public interface OrderBillMapper {

    @Insert("insert into t_order_bill() values()")
    int save(@Param("bill") OrderBill orderBill);

}