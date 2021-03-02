package com.api.app.dao.butler;

import com.api.model.app.*;
import com.api.vo.app.AppDecorationAdditionalCostVo;
import com.api.vo.app.AppDecorationApplicationVo;
import com.api.vo.app.AppDecorationCostVo;
import com.api.vo.app.AppDecorationVo;

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
}
