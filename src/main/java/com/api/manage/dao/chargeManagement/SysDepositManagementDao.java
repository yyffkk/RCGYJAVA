package com.api.manage.dao.chargeManagement;

import com.api.model.chargeManagement.SearchDepositManagement;
import com.api.model.chargeManagement.SysDepositManagement;
import com.api.model.chargeManagement.SysDepositManagementOrder;
import com.api.vo.chargeManagement.VoDepositManagement;
import com.api.vo.chargeManagement.VoFindByIdDepositManagement;
import com.api.vo.chargeManagement.VoRefundDecorationDetail;

import java.util.List;

public interface SysDepositManagementDao {
    /**
     * 查询所有的押金信息 （包含条件搜索）
     * @param searchDepositManagement 搜索条件
     * @return 押金信息集合
     */
    List<VoDepositManagement> list(SearchDepositManagement searchDepositManagement);

    /**
     * 根据押金管理主键id查询押金退款单号
     * @param id 押金管理主键id
     * @return 押金退款单号
     */
    String findOrderCodeByDMI(Integer id);

    /**
     * 添加押金管理信息
     * @param sysDepositManagement 押金管理信息
     * @return 影响行数
     */
    int insert(SysDepositManagement sysDepositManagement);

    /**
     * 根据装修id查询是否已有该房押金信息
     * @param userDecorationId
     * @return
     */
    int countByUDId(Integer userDecorationId);

    /**
     * 根据押金主键id查询押金信息
     * @param id 押金主键id
     * @return 押金信息
     */
    VoFindByIdDepositManagement findById(Integer id);

    /**
     * 修改押金管理
     * @param sysDepositManagement 押金管理信息
     * @return 影响行数
     */
    int update(SysDepositManagement sysDepositManagement);

    /**
     * 根据押金管理主键id删除押金管理信息
     * @param id 押金管理主键id
     * @return 影响行数
     */
    int falseDelete(int id);

    /**
     * 根据押金管理主键id查询押金退款装修情况（点击退款按钮触发的请求）
     * @param id 押金管理主键id
     * @return 押金退款装修情况Vo
     */
    VoRefundDecorationDetail refundDecorationDetail(Integer id);

    /**
     * 添加押金退款单
     * @param sysDepositManagementOrder 押金退款单信息
     * @return 影响行数
     */
    int refund(SysDepositManagementOrder sysDepositManagementOrder);

    /**
     * 根据押金管理主键id修改押金管理信息的状态 1.未退 --> 2.已退
     * @param depositManagementId 押金管理主键id
     * @return 影响行数
     */
    int updateStatusById(Integer depositManagementId);

    /**
     * 根据押金管理主键id查询该押金管理是否已有退款信息
     * @param depositManagementId 押金管理主键id
     * @return 押金管理信息数量
     */
    int countOrderByDMI(Integer depositManagementId);
}
