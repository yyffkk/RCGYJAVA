package com.api.systemDataBigScreen.dao;

import com.api.model.systemDataBigScreen.DailyActivitySearch;
import com.api.model.systemDataBigScreen.DispatchListSearch;
import com.api.vo.systemDataBigScreen.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface SystemDataDao {
    /**
     * 查询当日新增报修单数量
     * @param dispatchListSearch 报修单搜索条件
     * @return 当日新增报修单数量
     */
    List<SDDispatchNumListVo> findNowAddNum(DispatchListSearch dispatchListSearch);

    /**
     * 查询当日解决报修单数量
     * @param dispatchListSearch 报修单搜索条件
     * @return 当日解决报修单数量
     */
    List<SDDispatchNumListVo> findNowSolveNum(DispatchListSearch dispatchListSearch);

    /**
     * 查询待分配报修单数量,1.待分配
     * @return 待分配报修单数量
     */
    int findNoDistributionNum();

    /**
     * 查询处理中报修单数量，3.处理中
     * @return 处理中报修单数量
     */
    int findProcessingNum();

    /**
     * 查询访客记录信息集合
     * @return 系统数据 访客记录Vo list 回显
     */
    List<SDUserVisitorsVo> userVisitorsList();

    /**
     * 查询投诉表扬信息集合
     * @return 投诉表扬信息集合
     */
    List<SDSysAdviceVo> sysAdviceList();

    /**
     * 查询公共资讯信息集合
     * @return 公共资讯信息集合
     */
    List<SDSysAnnouncementVo> sysAnnouncementList();

    /**
     * 查询楼栋数
     * @return 楼栋数
     */
    int findBuildingNum();

    /**
     * 查询房屋总数
     * @return 房屋总数
     */
    int findEstateNum();

    /**
     * 查询已入住房屋数
     * @return 已入住房屋数
     */
    int findCheckInEstateNum();

    /**
     * 查询车位总数
     * @return 车位总数
     */
    int findParkingNum();

    /**
     * 查询已售车位数,1.已售
     * @return 已售车位数,1.已售
     */
    int findSoldParkingParkingNum();

    /**
     * 查询已租车位数,2.已出租
     * @return 已租车位数,2.已出租
     */
    int findRentedParkingNum();

    /**
     * 查询登记车辆总数
     * @return 登记车辆总数
     */
    int findUserCar();

    /**
     * 查询业主数量
     * @return 业主数量
     */
    int findResidentNum();

    /**
     * 查询租户数量
     * @return 租户数量
     */
    int findTenantNum();

    /**
     * 查询今年应缴物业费总户数
     * @param date 当前时间
     * @return 今年应缴物业费总户数
     */
    int findThisYearPayableNum(Date date);

    /**
     * 查询今年应缴物业费总金额
     * @param date 当前时间
     * @return 今年应缴物业费总金额
     */
    BigDecimal findThisYearPayablePrice(Date date);

    /**
     * 查询已缴物业费总户数
     * @return 已交物业费总户数
     */
    int findPaidNum();

    /**
     * 查询已缴物业费总金额
     * @return 已交物业费总金额
     */
    BigDecimal findPaidPrice();

    /**
     * 查询未缴物业费总户数
     * @return 未交物业费总户数
     */
    int findUnPaidNum();

    /**
     * 查询未缴物业费总金额
     * @return 未交物业费总金额
     */
    BigDecimal findUnPaidPrice();

    /**
     * 查询日活跃量
     * @param dailyActivitySearch 日活跃搜索条件
     * @return 日活跃量
     */
    List<SDDailyActivityVo> findDailyActivity(DailyActivitySearch dailyActivitySearch);

    /**
     * 查询所有的巡更人员
     * @return 系统数据 巡更人员信息
     */
    List<SDInspectionSysUserVo> findAllInspector();

    /**
     * 查询今日巡更执行计划
     * @param date 当前时间
     * @return 系统数据 巡更执行计划 Vo list 回显
     */
    List<SDInspectionExecuteListVo> findTodayExecute(Date date);

    /**
     * 查询今日巡更执行计划
     * @param date 当前时间
     * @return 系统数据 巡更执行计划 Vo list 回显
     */
    List<SDInspectionExecuteVo> findNowExecute(Date date);

    /**
     * 根据巡检执行计划主键id查询执行计划的巡检点（开始巡检后的巡检点信息）
     * @param executeId 巡检执行计划主键id
     * @return 开始巡检后的巡检点信息
     */
    List<SDInspectionExecutePointVo> findExecutePointByExecuteId(Integer executeId);

    /**
     * 根据巡检执行计划主键id查询计划的巡检点（开始巡检前的巡检点信息）
     * @param executeId 巡检执行计划主键id
     * @return 开始巡检前的巡检点信息
     */
    List<SDInspectionExecutePointVo> findPlanPointByExecuteId(Integer executeId);

    /**
     * 查询所有的地点信息
     * @param executeId 巡检执行计划主键id
     * @return 系统数据 巡更执行路线 Vo 回显
     */
    List<SDInspectionExecuteMapVo> findAllLocation(Integer executeId);

    /**
     * 查询所有的巡更记录
     * @return 系统数据 巡更记录回显
     */
    List<SDInspectionRecordVo> findAllInspectionRecord();

    /**
     * 查询所有的报修工单信息
     * @return 报修工单信息
     */
    List<SDReportDispatchVo> findReportDispatch();

    /**
     * 查询已处理数量
     * @return 已处理数量
     */
    int findHandledNum();

    /**
     * 查询未处理数量
     * @return 未处理数量
     */
    int findPendingNum();

    /**
     * 查询公区报修数量
     * @return 有偿类型数量
     */
    int findPublicTypeNum();

    /**
     * 查询家庭报修数量
     * @return 无偿类型数量
     */
    int findFamilyTypeNum();

    /**
     * 查询所有的物品数量
     * @return 空置的物品数量
     */
    int findAllArticle();

    /**
     * 查询已借出的物品数量
     * @return 已借出的物品数量
     */
    int findBorrowArticle();

    /**
     * 查询已损坏的物品数量
     * @return 已损坏的物品数量
     */
    int findBreakDownArticle();

    /**
     * 查询已丢失的物品数量
     * @return 已丢失的物品数量
     */
    int findLoseArticle();

    /**
     * 查询社区活动信息
     * @return 社区活动信息
     */
    List<SDSysActivityVo> findActivity();

    /**
     * 查询每月访客数量
     * @return 每月访客数量
     */
    List<SDVisitorInfoVo> findVisitorInfo();
}
