package com.api.manage.dao.butlerService;

import com.api.model.alipay.SysLeaseOrder;
import com.api.model.alipay.SysLeaseRentBillOrder;
import com.api.model.alipay.SysLeaseRentOrder;
import com.api.model.app.AppLeaseRent;
import com.api.model.butlerService.SearchLease;
import com.api.model.butlerService.SysLease;
import com.api.vo.butlerService.VoFBILease;
import com.api.vo.butlerService.VoLease;

import java.math.BigDecimal;
import java.util.List;

public interface LeaseDao {
    /**
     * 查询所有的租赁管理信息
     * @param searchLease 租赁管理 搜索条件
     * @return 租赁管理信息
     */
    List<VoLease> list(SearchLease searchLease);

    /**
     * 添加租赁信息
     * @param sysLease 租赁管理model
     * @return 影响行数
     */
    int insert(SysLease sysLease);

    /**
     * 根据租赁管理主键id查询租赁信息
     * @param id 租赁管理主键id
     * @return 租赁信息
     */
    VoFBILease findById(Integer id);

    /**
     * 根据租赁管理主键id修改租赁信息
     * @param sysLease 租赁管理model
     * @return 影响行数
     */
    int update(SysLease sysLease);

    /**
     * 根据租赁管理主键id删除租赁信息
     * @param id 租赁管理主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 审核签署合同内容
     * @param sysLease 租赁管理model
     * @return 影响行数
     */
    int reviewer(SysLease sysLease);

    /**
     * 添加房屋租赁保证金订单信息
     * @param sysLeaseOrder app 房屋租赁订单model
     * @return 影响行数
     */
    int insertOrder(SysLeaseOrder sysLeaseOrder);

    /**
     * 根据订单编号查询保证金订单信息
     * @param outTradeNo 订单编号
     * @return app 房屋租赁订单model
     */
    SysLeaseOrder findSysLeaseOrderByCode(String outTradeNo);

    /**
     * 根据房屋租赁保证金订单编号更新订单状态
     * @param sysLeaseOrder app 房屋租赁订单model
     * @return 影响行数
     */
    int updateLeaseOrderStatusByCode(SysLeaseOrder sysLeaseOrder);

    /**
     * 根据主键id修改租赁状态
     * @param sysLease 租赁管理model
     * @return 影响行数
     */
    int updateStatusById(SysLease sysLease);

    /**
     * 添加房屋租赁租金订单信息
     * @param sysLeaseRentOrder app 房屋租赁租金订单model
     * @return 影响行数
     */
    int insertRentOrder(SysLeaseRentOrder sysLeaseRentOrder);

    /**
     * 根据房屋租赁租金订单编号查询租金订单信息
     * @param outTradeNo 租金订单编号
     * @return 租金订单信息
     */
    SysLeaseRentOrder findSysLeaseRentOrderByCode(String outTradeNo);

    /**
     * 根据房屋租赁租金订单编号更新订单状态
     * @param sysLeaseRentOrder app 房屋租赁租金订单model
     * @return 影响行数
     */
    int updateLeaseRentOrderStatusByCode(SysLeaseRentOrder sysLeaseRentOrder);

    /**
     * 审核合同终止申请(修改租赁状态及合同终止信息)
     * @param sysLease 租赁管理model
     * @return 影响行数
     */
    int reviewTerminationApplication(SysLease sysLease);

    /**
     * 审核保证金退还申请
     * @param sysLease 租赁管理model
     * @return 影响行数
     */
    int reviewDepositRefundApplication(SysLease sysLease);

    /**
     * 根据租赁主键id查询唯一已支付的保证金订单信息
     * @param id 租赁主键id
     * @return 保证金订单信息
     */
    SysLeaseOrder findPaySysLeaseOrderById(Integer id);

    /**
     * 查询未缴纳的保证金订单信息
     * @return 未缴纳的保证金订单信息
     */
    List<SysLeaseOrder> findUnPaymentLeaseOrder();

    /**
     * 根据code【保证金支付单号】修改保证金订单状态
     * @param sysLeaseOrder1 app 房屋租赁保证金订单model
     * @return 影响行数
     */
    int updateSLOStatusByCode(SysLeaseOrder sysLeaseOrder1);

    /**
     * 根据主键id修改租赁保证金缴纳时间
     * @param sysLease 租赁管理model
     * @return 影响行数
     */
    int updateMarginPayDateById(SysLease sysLease);

    /**
     * 查询正在生效的租赁信息 //TODO 此接口还需改，等合同续签和合同变更功能
     * @return 正在生效的租赁信息
     */
    List<VoLease> findAllEffectLease();

    /**
     * 添加租金账单
     * @param appLeaseRent 租赁租金账单表
     * @return 影响行数
     */
    int insertRent(AppLeaseRent appLeaseRent);

    /**
     * 查询租赁剩余需结清房租（元）
     * @param leaseId 租赁主键id
     * @return 租赁剩余需结清房租（元）
     */
    BigDecimal findLeaseRemainingRental(Integer leaseId);

    /**
     * 根据租赁账单管理主键id查询租赁账单信息
     * @param sysLeaseRentId 租赁账单管理主键id
     * @return 租赁账单信息
     */
    AppLeaseRent findLeaseRentById(Integer sysLeaseRentId);

    /**
     * 添加租赁租金账单订单信息
     * @param sysLeaseRentBillOrder app 房屋租赁租金账单订单model
     * @return 影响行数
     */
    int insertRentBillOrder(SysLeaseRentBillOrder sysLeaseRentBillOrder);

    /**
     * 根据订单编号查询租赁租金账单订单信息
     * @param outTradeNo 订单编号
     * @return 租赁租金账单订单信息
     */
    SysLeaseRentBillOrder findSysLeaseRentBillOrderByCode(String outTradeNo);

    /**
     * 根据房屋租赁租金账单订单编号更新订单状态
     * @param sysLeaseRentBillOrder app 房屋租赁租金账单订单model
     * @return 影响行数
     */
    int updateLeaseRentBillOrderStatusByCode(SysLeaseRentBillOrder sysLeaseRentBillOrder);

    /**
     * 根据租赁账单主键id更新租赁账单信息状态
     * @param appLeaseRent 租赁租金账单表
     * @return 影响行数
     */
    int updateLeaseRentStatusById(AppLeaseRent appLeaseRent);

    /**
     * 将当前租赁租金账单所有的未缴纳的租金改为已结算状态
     * @param sysLeaseId  租赁主键id
     * @return 影响行数
     */
    int updateSLRStatusUnPayToSettledBySLId(Integer sysLeaseId);

    /**
     * 查询未缴纳的租赁剩余需结清租金订单信息
     * @return 未缴纳的租赁剩余需结清租金订单信息
     */
    List<SysLeaseRentOrder> findUnPaymentLeaseRentOrder();

    /**
     * 根据code【租赁剩余需结清租金支付单号】修改租赁剩余需结清租金订单状态
     * @param sysLeaseRentOrder1 app 房屋租赁剩余需结清租金订单model
     * @return 影响行数
     */
    int updateSLROStatusByCode(SysLeaseRentOrder sysLeaseRentOrder1);

    /**
     * 查询未缴纳的租赁租金账单订单信息
     * @return 未缴纳的租赁租金账单订单信息
     */
    List<SysLeaseRentBillOrder> findUnPaymentLeaseRentBillOrder();

    /**
     * 根据code【租赁租金账单支付单号】修改租赁租金账单订单状态
     * @param sysLeaseRentBillOrder1 app 房屋租赁租金账单订单model
     * @return 影响行数
     */
    int updateSLRBOStatusByCode(SysLeaseRentBillOrder sysLeaseRentBillOrder1);
}
