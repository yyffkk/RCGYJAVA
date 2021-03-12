package com.api.systemDataBigScreen.dao;

import com.api.model.systemDataBigScreen.DailyActivity;
import com.api.model.systemDataBigScreen.DailyActivitySearch;
import com.api.vo.systemDataBigScreen.SDDailyActivityVo;
import com.api.vo.systemDataBigScreen.SDSysAdviceVo;
import com.api.vo.systemDataBigScreen.SDSysAnnouncementVo;
import com.api.vo.systemDataBigScreen.SDUserVisitorsVo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface SystemDataDao {
    /**
     * 查询当日新增报修单数量
     * @param date 当天时间
     * @return 当日新增报修单数量
     */
    int findNowAddNum(Date date);

    /**
     * 查询当日解决报修单数量
     * @param date 当天时间
     * @return 当日解决报修单数量
     */
    int findNowSolveNum(Date date);

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
     * 查询本日 日活跃量
     * @param date 本日
     * @return 日活跃量
     */
    int findTodayDailyActivity(Date date);

    /**
     * 将日活跃量 添加进数据库
     * @param dailyActivity 日活跃量
     * @return 影响行数
     */
    int insertDailyActivity(DailyActivity dailyActivity);
}
