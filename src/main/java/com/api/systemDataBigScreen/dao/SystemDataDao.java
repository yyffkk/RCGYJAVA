package com.api.systemDataBigScreen.dao;

import com.api.model.systemDataBigScreen.*;
import com.api.vo.operationManagement.VoGreenTask;
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
    int findPaidNum(Date date);

    /**
     * 查询已缴物业费总金额
     * @return 已交物业费总金额
     */
    BigDecimal findPaidPrice(Date date);

    /**
     * 查询未缴物业费总户数
     * @return 未交物业费总户数
     */
    int findUnPaidNum(Date date);

    /**
     * 查询未缴物业费总金额
     * @return 未交物业费总金额
     */
    BigDecimal findUnPaidPrice(Date date);

    /**
     * 查询日常缴费未缴费住户数量（最近6个月，每月信息数量）
     * @return 最近6个月，每月未缴费住户数量
     */
    List<SDCountAndDate> findSixMonthUnPaidNum();

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
     * 查询all执行计划的巡检点（开始巡检后的巡检点信息）
     * @return 开始巡检后的巡检点信息
     */
    List<SDInspectionExecutePointVo> findExecutePointAll();

    /**
     * 根据巡检执行计划主键id查询计划的巡检点（开始巡检前的巡检点信息）
     * @param executeId 巡检执行计划主键id
     * @return 开始巡检前的巡检点信息
     */
    List<SDInspectionExecutePointVo> findPlanPointByExecuteId(Integer executeId);

    /**
     * 查询所有的巡检路线
     * @return 巡检路线
     */
    List<SDInspectionRouteVo> findAllInspectionRoute();

    /**
     * 根据巡检路线主键id查询巡检执行计划信息
     * @param routeId 巡检路线主键id
     * @return 巡检执行计划信息
     */
    List<SDInspectionExecutePlanVo> findExecuteByRoute(Integer routeId);


    /**
     * 根据执行计划主键id查询执行计划信息
     * @param executeId 行计划主键id
     * @return 执行计划信息
     */
    SDInspectionExecuteListVo findExecuteByExecuteId(Integer executeId);


    /**
     * 根据执行计划主键id查询巡检后的巡检点信息(巡检后的巡检点)
     * @param executeId 执行计划主键id
     * @return 巡检点信息
     */
    List<SDInspectionExecutePointVo> findPointByExecuteIdAfter(Integer executeId);


    /**
     * 根据执行计划主键id查询巡检前的巡检点信息(巡检前的巡检点)
     * @param executeId 执行计划主键id
     * @return 巡检点信息
     */
    List<SDInspectionExecutePointVo> findPointByExecuteIdBefore(Integer executeId);


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

    /**
     * 查询未缴总费用
     * @return 未缴总费用
     */
    int findAllUnpaidFees();


    /**
     * 查询app注册数
     * @return app注册数
     */
    int findRegCount();


    /**
     * 查询所有的绿化管理情况
     * @return 绿化管理情况
     */
    List<VoGreenTask> findGreenTaskList();

    /**
     * 查询访客信息(12个月内的数据，不包含本月)
     * @return 访客信息
     */
    List<SDVisitorInfoMonthVo> findVisitorInfoMonth();

    /**
     * 查询待出户的数量
     * @return 待出户的数量
     */
    int findWaitOutNum();

    /**
     * 查询已出户的数量
     * @return 已出户的数量
     */
    int findGoOutNum();

    /**
     * 查询已驳回的数量
     * @return 已驳回的数量
     */
    int findRejectNum();

    /**
     * 查询所有的投票信息
     * @return 投票信息
     */
    List<SDVoteInfoVo> findVoteInfo();

    /**
     * 查询商场各分类下报名统计
     * @return 商场各分类下报名统计
     */
    List<SDShopAppointmentNumVo> findShopAppointmentNum();

    /**
     * 查询各楼栋入住数信息
     * @return 各楼栋入住数信息
     */
    List<SDOccupancyRateVo> findOccupancyRate();

    /**
     * 添加记录进数据库
     * @param firePushAlert 火灾推送通知内容
     * @return 影响行数
     */
    int insertPushAlert(FirePushAlert firePushAlert);

    /**
     * 添加预案推送通知
     * @param planPushAlert 预案推送通知内容
     * @return 影响行数
     */
    int insertPlanAlarm(PlanPushAlert planPushAlert);

    /**
     * 查询工单超量的用户(报事报修)
     * @param threshold 阀值
     * @return 用户名称集合
     */
    List<String> findExcessiveWorkOrderUserName(Integer threshold);

    /**
     * 查询工单超量的用户(绿化任务)
     * @param threshold 阀值
     * @return 用户名称集合
     */
    List<String> findExcessiveGreenTaskUserName(Integer threshold);

    /**
     * 查询借还物品时间超出一周的用户及相关信息
     * @return 用户及相关信息
     * @param date
     */
    List<SDBorrowExceedWeek> findBorrowExceedWeek(Date date);

    /**
     * 查询未缴费用户房屋信息
     * @return 未缴费用户房屋信息
     */
    List<SDUnpaidUserInfoVo> findUnpaidUserInfo();

    /**
     * 查询所有的巡检点信息
     * @return 巡检点信息
     */
    List<SDInspectionExecutePointAllVo> findPointByExecuteIdAll();

    /**
     * 巡检点检查项
     * @return 巡检点检查项集合
     */
    List<SDSysInspectionCheckItemsVo> sysInspectionCheckItems();

    /**
     * 巡检执行情况（巡检计划周期的记录）
     * @return 巡检执行情况集合
     */
    List<SDSysInspectionExecuteVo> sysInspectionExecute();

    /**
     * 巡检执行点检查项
     * @return 巡检执行点检查项集合
     */
    List<SDSysInspectionExecuteCheckItemsVo> sysInspectionExecuteCheckItems();

    /**
     * 巡检执行路线地图经纬度
     * @return 巡检执行路线地图经纬度集合
     */
    List<SDSysInspectionExecuteMapVo> sysInspectionExecuteMap();

    /**
     * 巡检执行点（有经纬度）
     * @return 巡检执行点集合
     */
    List<SDSysInspectionExecutePointVo> sysInspectionExecutePoint();

    /**
     * 巡检计划
     * @return 巡检计划集合
     */
    List<SDSysInspectionPlanVo> sysInspectionPlan();

    /**
     * 巡检点管理（有经纬度）
     * @return 巡检点管理集合
     */
    List<SDSysInspectionPointVo> sysInspectionPoint();

    /**
     * 巡检路线-点关联表
     * @return 巡检路线-点关联表集合
     */
    List<SDSysInspectionPointRouteVo> sysInspectionPointRoute();

    /**
     * 巡检路线
     * @return 巡检路线集合
     */
    List<SDSysInspectionRouteVo> sysInspectionRoute();

    /**
     * 新版访客管理
     * @return 新版访客管理集合
     */
    List<SDUserVisitorsNewVo> userVisitorsNew();

    /**
     * 抄表记录表
     * @return 抄表记录表集合
     */
    List<SDSysMeterReadingRecordVo> sysMeterReadingRecord();

    /**
     * 抄表公摊表
     * @return 抄表公摊表集合
     */
    List<SDSysMeterReadingShareVo> sysMeterReadingShare();

    /**
     * 抄表公摊详情表
     * @return 抄表公摊详情表集合
     */
    List<SDSysMeterReadingShareDetailsVo> sysMeterReadingShareDetails();

    /**
     * 查询社区活动信息（触摸屏）
     * @return 社区活动信息
     */
    List<SDTSActivityVo> findActivityTouchScreen();

    /**
     * 查询公告信息集合（发布时间、标题、内容）（触摸屏）
     * @return 公告信息集合
     */
    List<SDTSAnnouncementVo> sysAnnouncementTouchScreen();

    /**
     * 查询资讯分类（触摸屏）
     * @return 资讯分类
     */
    List<SDTSNewsCategoryVo> sysNewCategoryTouchScreen();

    /**
     * 查询资讯信息（触摸屏）
     * @param newCategoryId 资讯分类主键id
     * @return 资讯信息
     */
    List<SDTSNewVo> sysNewTouchScreen(Integer newCategoryId);

    /**
     * 查询最近发布的资讯信息
     * @param num 资讯数量
     * @return 资讯信息
     */
    List<SDTSNewVo> sysNewLatestReleaseTouchScreen(Integer num);

    /**
     * 活动信息搜索（触摸屏）
     * @param searchTouchScreenSearch 触摸屏信息搜索 搜索条件
     * @return 返回内容
     */
    List<SDTSActivityVo> searchActivity(SearchTouchScreenSearch searchTouchScreenSearch);

    /**
     * 公告信息搜索
     * @param searchTouchScreenSearch 触摸屏信息搜索 搜索条件
     * @return 返回内容
     */
    List<SDTSAnnouncementVo> searchAnnouncement(SearchTouchScreenSearch searchTouchScreenSearch);

    /**
     * 资讯信息搜索
     * @param searchTouchScreenSearch 触摸屏信息搜索 搜索条件
     * @return 返回内容
     */
    List<SDTSNewVo> searchNews(SearchTouchScreenSearch searchTouchScreenSearch);
}
