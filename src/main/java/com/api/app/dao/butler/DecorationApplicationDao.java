package com.api.app.dao.butler;

import com.api.model.app.*;
import com.api.vo.app.*;

import java.util.List;

public interface DecorationApplicationDao {
    /**
     * 查询装修列表
     * @param searchAppDecoration app装修管理搜索条件
     * @return app装修管理Vo list 回显集合
     */
    List<AppDecorationVo> list(SearchAppDecoration searchAppDecoration);

    /**
     * 查询装修押金,费用类型为：3.装修押金
     * @return app装修费用信息Vo list 回显
     */
    AppDecorationCostVo findDecorationDeposit();

    /**
     * 查询装修附加费用
     * @param id 装修押金费用主键id
     * @return app装修额外费用Vo list 回显 集合
     */
    List<AppDecorationAdditionalCostVo> findDecorationAdditionalCost(Integer id);

    /**
     * 查询装修须知doc路径
     * @return 装修须知doc路径
     */
    String findDecorationDocUrl();

    /**
     * 根据用户id和房产id查询该用户有无该房产的使用权
     * @param userIdAndEstateId 用户id和房产id
     * @return 关联数量
     */
    int applicationDecoration(UserIdAndEstateId userIdAndEstateId);

    /**
     * 根据用户id查询用户类型
     * @param id 用户id
     * @return 用户类型
     */
    int findUserTypeByUserId(Integer id);

    /**
     * 添加装修申请信息
     * @param userDecoration 装修信息表 model
     * @return 影响行数
     */
    int insertDecorationApplication(AppUserDecoration userDecoration);

    /**
     * 修改或完善装修申请
     * @param userDecoration 装修信息表 model
     * @return 影响行数
     */
    int update(AppUserDecoration userDecoration);

    /**
     * 查询申请装修信息
     * @param id 装修主键id
     * @return 申请装修信息Vo 回显
     */
    AppDecorationApplicationVo findApplicationDecoration(Integer id);

    /**
     * 添加押金管理信息
     * @param appDepositManagement app押金管理model
     * @return 影响行数
     */
    int insertDepositManagement(AppDepositManagement appDepositManagement);

    /**
     * 添加押金附加费用
     * @param additionalCost app押金额外费用
     * @return 影响行数
     */
    int insertDepositAdditionalCost(AppDepositAdditionalCost additionalCost);

    /**
     * 根据装修主键id查询装修单号
     * @param decorationId 装修主键id
     * @return 装修单号
     */
    String findDecorationCodeById(Integer decorationId);

    /**
     * 根据装修单号查询装修主键id
     * @param code 装修单号
     * @return 装修主键id
     */
    int findDecorationIdByCode(String code);

    /**
     * 添加装修人员信息
     * @param decorationPerson 装修人员信息
     * @return 影响行数
     */
    int insertDecorationPerson(AppUserDecorationPerson decorationPerson);

    /**
     * 先删除装修人员信息
     * @param decorationId 装修主键id
     * @return 影响行数
     */
    int delete(int decorationId);

    /**
     * 根据装修主键id修改装修状态
     * @param appUserDecoration 装修信息表 model
     * @return 影响行数
     */
    int updateStatus(AppUserDecoration appUserDecoration);

    /**
     * 根据装修主键id查询装修信息
     * @param decorationId 装修主键id
     * @return 装修信息
     */
    AppDecorationFBIVo findDecorationById(Integer decorationId);

    /**
     * 根据装修主键id查询装修押金信息
     * @param decorationId 装修主键id
     * @return 装修押金信息
     */
    AppDepositVo findDepositById(Integer decorationId);

    /**
     * 根据押金管理主键id查询押金信息
     * @param id 押金管理主键id
     * @return 押金信息集合
     */
    List<AppDepositAdditionalCostVo> findDACostByDId(Integer id);

    /**
     * 查询根据装修主键id装修公司人员信息是否填写
     * @param decorationId 装修主键id
     * @return 填写的装修人员人数
     */
    int findPersonByDecorationId(Integer decorationId);

    /**
     * 查看全部详情信息
     * @param decorationId 装修主键id
     * @return app装修管理 查询全部详情信息 回显
     */
    AppDecorationFindAllDetailVo findAllDetail(Integer decorationId);

    /**
     * 查询跟踪检查记录
     * @param decorationId 装修主键id
     * @return app装修跟踪记录Vo list 回显
     */
    List<AppTrackRecordVo> findTrackRecord(Integer decorationId);

    /**
     * 查询跟踪检查记录明细
     * @param id 装修主键id
     * @return app装修跟踪记录明细Vo 回显
     */
    List<AppTrackRecordDetailVo> findTrackRecordDetail(Integer id);

    /**
     * 延长装修时间
     * @param appExtendDecoration app延长装修信息
     * @return 影响行数
     */
    int extendDecorationTime(AppExtendDecoration appExtendDecoration);

    /**
     * 申请退款
     * @param appUserDecoration 装修信息表 model
     * @return 影响行数
     */
    int applicationRefund(AppUserDecoration appUserDecoration);

    /**
     * 根据装修主键id查询退款单信息
     * @param decorationId 装修主键id
     * @return 退款单信息
     */
    AppDepositRefundOrderVo findRefundByDecorationId(Integer decorationId);

    /**
     * 开始装修
     * @param appUserDecoration 装修信息表 model
     * @return 影响行数
     */
    int startDecoration(AppUserDecoration appUserDecoration);

    /**
     * 根据装修主键id查询装修状态
     * @param id 装修主键id
     * @return 装修状态
     */
    int findStatusById(Integer id);

    /**
     * 添加审核结果信息
     * @param appUserDecoration 装修信息表 model
     * @return 影响行数
     */
    int applicationReview(AppUserDecoration appUserDecoration);
}
