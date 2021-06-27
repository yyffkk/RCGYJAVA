package com.api.manage.dao.butlerService;

import com.api.model.alipay.SysLeaseOrder;
import com.api.model.butlerService.SearchLease;
import com.api.model.butlerService.SysLease;
import com.api.vo.butlerService.VoFBILease;
import com.api.vo.butlerService.VoLease;

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
     * 添加缴费订单信息
     * @param sysLeaseOrder app 房屋租赁订单model
     * @return 影响行数
     */
    int insertOrder(SysLeaseOrder sysLeaseOrder);

    /**
     * 根据订单编号查询订单信息
     * @param outTradeNo 订单编号
     * @return app 房屋租赁订单model
     */
    SysLeaseOrder findSysLeaseOrderByCode(String outTradeNo);

    /**
     * 根据订单编号更新订单状态
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
}
