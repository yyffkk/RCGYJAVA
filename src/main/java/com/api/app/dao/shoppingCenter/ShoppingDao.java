package com.api.app.dao.shoppingCenter;

import com.api.model.app.AppGoodsAppointment;
import com.api.model.app.AppGoodsIdAndAppointmentNum;
import com.api.model.app.AppGoodsIdAndUserId;
import com.api.model.shoppingCenter.Order;
import com.api.vo.app.AppCategoryVo;
import com.api.vo.app.AppGoodsDetailVo;
import com.api.vo.app.AppGoodsVo;
import com.api.vo.app.AppMyOrderVo;

import java.util.List;

public interface ShoppingDao {
    /**
     * 查询所有的分类
     * @param parentId 父类id，如果为一级则为0
     * @return 所有的分类
     */
    List<AppCategoryVo> list(Integer parentId);

    /**
     * 查询订阅量最高的4件商品
     * @return 商品
     */
    List<AppGoodsVo> findTopGoods();

    /**
     * 根据分类主键id查询商品信息列表
     * @param categoryId 分类主键id
     * @return 商品信息列表
     */
    List<AppGoodsVo> findGoodsByCategoryId(Integer categoryId);

    /**
     * 根据商品主键id查询商品详情
     * @param goodsId 商品主键id
     * @return 商品详情
     */
    AppGoodsDetailVo findDetailByGoodsId(Integer goodsId);

    /**
     * 根据商品主键id 和 用户主键id 查询是否预约
     * @param goodsIdAndUserId 商品主键id 和 用户主键id
     * @return 预约数
     */
    int countAppointmentByGIdAndUId(AppGoodsIdAndUserId goodsIdAndUserId);

    /**
     * 根据供应商主键id 查询预约量最高的4个商品信息(其他【4个】)
     * @param supplierId 供应商主键id
     * @return 预约量最高的4个商品信息
     */
    List<AppGoodsVo> findTopGoodsBySupplierId(Integer supplierId);

    /**
     * 商品预约
     * @param appGoodsAppointment app 商品预约信息
     * @return 影响行数
     */
    int goodsAppointment(AppGoodsAppointment appGoodsAppointment);

    /**
     * 商品搜索
     * @param searchName 搜索内容
     * @return 商品信息
     */
    List<AppGoodsVo> goodsSearch(String searchName);

    /**
     * 累加商品预约量
     * @param appGoodsIdAndAppointmentNum 预约商品主键id 和 预约数量
     * @return 影响行数
     */
    int incGoodsAppointmentNum(AppGoodsIdAndAppointmentNum appGoodsIdAndAppointmentNum);

    /**
     * 我的订单
     * @param order 商品预约model（订单）
     * @return 订单信息
     */
    List<AppMyOrderVo> myOrder(Order order);

    /**
     * 取消预约
     * @param order 商品预约model（订单）
     * @return 影响行数
     */
    int cancel(Order order);

    /**
     * 申请退换
     * @param order 商品预约model（订单）
     * @return 影响行数
     */
    int applicationRefund(Order order);

    /**
     * 确认收货
     * @param order 商品预约model（订单）
     * @return 影响行数
     */
    int confirmReceipt(Order order);
}
