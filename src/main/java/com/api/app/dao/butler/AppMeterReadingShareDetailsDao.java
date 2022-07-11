package com.api.app.dao.butler;

import com.api.model.alipay.SysMeterReadingShareDetailsOrder;
import com.api.model.alipay.SysMeterReadingShareDetailsOrderList;
import com.api.model.app.EstateIdAndShareBillId;
import com.api.model.chargeManagement.SysMeterReadingShareBillDetails;
import com.api.vo.app.AppMeterShareDetailsVo;
import com.api.vo.app.AppMeterShareOrderVo;
import com.api.vo.app.AppMeterShareVo;

import java.util.List;

public interface AppMeterReadingShareDetailsDao {
    /**
     * 根据公摊账单详情主键id查询公摊账单详情
     * @param shareDetailsId 公摊账单详情主键id
     * @return 公摊账单详情
     */
    SysMeterReadingShareBillDetails findShareDetailsById(Integer shareDetailsId);

    /**
     * 根据主键id修改状态
     * @param shareBillDetails 抄表公摊账单详情
     * @return 影响函数
     */
    int updateStatusById(SysMeterReadingShareBillDetails shareBillDetails);

    /**
     * 查询所有未缴纳的公摊缴费
     * @param estateId 房产主键id
     * @return 所有未缴纳的公摊缴费
     */
    List<AppMeterShareVo> findAllUnPayList(Integer estateId);

    /**
     * 根据公摊账单详情主键id查询未缴纳的公摊账单详情
     * @param estateIdAndShareBillId 房产主键id和抄表公摊账单主键id
     * @return 未缴纳的公摊账单详情
     */
    List<AppMeterShareDetailsVo> findUnPayShareDetailsById(EstateIdAndShareBillId estateIdAndShareBillId);

    /**
     * 根据手机号查询所有的抄表公摊缴费订单
     * @param tel 手机号
     * @return 所有的抄表公摊缴费订单
     */
    List<AppMeterShareOrderVo> findAllMeterShareOrderByTel(String tel);

    /**
     * 添加抄表分摊订单清单
     * @param orderList 抄表分摊详情订单清单信息
     * @return 影响行数
     */
    int insertOrderList(SysMeterReadingShareDetailsOrderList orderList);

    /**
     * 根据抄表分摊订单支付单号查询抄表分摊详情信息
     * @param outTradeNo 订单支付单号
     * @return 抄表分摊详情信息
     */
    List<SysMeterReadingShareBillDetails> findShareBillDetailsByOrderCode(String outTradeNo);

    /**
     * 根据抄表分摊详情主键id查询抄表分摊详情
     * @param shareDetailsOrder 抄表分摊详情订单
     * @return 询抄表分摊详情
     */
    List<SysMeterReadingShareBillDetails> findShareDetailsByIds(SysMeterReadingShareDetailsOrder shareDetailsOrder);
}
