package com.api.alipay.dao;

import com.api.model.alipay.*;

import java.math.BigDecimal;

public interface AlipayDao {

    /**
     * 创建商户支付宝订单
     * @param aliPaymentOrder 支付宝订单
     */
    void createAlipayMentOrder(AliPaymentOrder aliPaymentOrder);

    /**
     * 根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
     * @param outTradeNo out_trade_no【商户系统的唯一订单号】
     * @return 支付宝订单信息
     */
    AliPaymentOrder selectByOutTradeNo(String outTradeNo);

    /**
     * 根据主键修改 数据库支付宝信息
     * @param aliPaymentOrder 支付宝订单
     * @return 影响行数
     */
    int updateByPrimaryKey(AliPaymentOrder aliPaymentOrder);

    /**
     * 添加生活缴费-预充值支付订单信息
     * @param sysAdvancePaymentOrder app 生活缴费-预充值支付订单model
     * @return 影响行数
     */
    int insertAdvancePaymentOrder(SysAdvancePaymentOrder sysAdvancePaymentOrder);

    /**
     * 根据out_trade_no【商户系统的唯一订单号】查询信息 pay_price【订单金额】
     * @param outTradeNo out_trade_no【商户系统的唯一订单号】
     * @return app 生活缴费-预充值支付订单model
     */
    SysAdvancePaymentOrder findSysAdvancePaymentOrderByCode(String outTradeNo);

    /**
     * 根据预充值支付单号更新表的状态
     * @param sysAdvancePaymentOrder app 生活缴费-预充值支付订单model
     * @return 影响行数
     */
    int updateAdvancePaymentOrderStatusByCode(SysAdvancePaymentOrder sysAdvancePaymentOrder);

    /**
     * 根据充值房产主键id查询预付款充值金额
     * @param estateId 充值房产主键id
     * @return 预付款充值金额
     */
    BigDecimal findAPPByEstateId(Integer estateId);

    /**
     * 根据充值房产主键id修改预付款充值金额
     * @param estateIdAndAPPrice 房产id 和 预付款充值金额
     * @return 影响行数
     */
    int updateAdvancePaymentPriceByEstateId(EstateIdAndAdvancePaymentPrice estateIdAndAPPrice);

    /**
     * 添加家政服务-服务费用支付订单信息
     * @param sysHousekeepingServiceOrder app 家政服务-服务费用支付订单model
     * @return 影响行数
     */
    int insertHousekeepingServiceOrder(SysHousekeepingServiceOrder sysHousekeepingServiceOrder);

    /**
     * 根据out_trade_no【商户系统的唯一订单号】查询信息 pay_price【订单金额】
     * @param outTradeNo 商户系统的唯一订单号
     * @return app 家政服务-服务费用支付订单model
     */
    SysHousekeepingServiceOrder findSysHousekeepingServiceOrderByCode(String outTradeNo);

    /**
     * 根据家政服务-服务费用支付单号更新表的状态
     * @param sysHousekeepingServiceOrder app 家政服务-服务费用支付订单model
     * @return 影响行数
     */
    int updateHousekeepingServiceOrderStatusByCode(SysHousekeepingServiceOrder sysHousekeepingServiceOrder);

    /**
     * 添加抄表记录管理-抄表分摊详情费用支付订单信息
     * @param shareDetailsOrder 抄表分摊详情订单
     * @return 影响行数
     */
    int insertShareDetailsOrder(SysMeterReadingShareDetailsOrder shareDetailsOrder);

    /**
     * 根据out_trade_no【商户系统的唯一订单号】查询信息 pay_price【订单金额】
     * @param outTradeNo 商户系统的唯一订单号
     * @return app 抄表记录管理-抄表分摊详情费用支付订单model
     */
    SysMeterReadingShareDetailsOrder findShareDetailsOrderOrderByCode(String outTradeNo);

    /**
     * 根据抄表记录管理-抄表分摊详情费用支付单号更新表的状态
     * @param shareDetailsOrder app 抄表分摊详情订单model
     * @return 影响行数
     */
    int updateShareDetailsOrderStatusByCode(SysMeterReadingShareDetailsOrder shareDetailsOrder);
}
