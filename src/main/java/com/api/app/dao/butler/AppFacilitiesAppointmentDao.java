package com.api.app.dao.butler;

import com.api.model.app.AppFacilitiesIdAndNowDate;
import com.api.model.app.AppointmentCodeAndUserId;
import com.api.model.app.AppointmentStopUseFactor;
import com.api.model.app.SearchAppFacilitiesAppointment;
import com.api.vo.app.AppAppointmentDateVo;
import com.api.vo.app.AppFacilitiesAppointmentVo;
import com.api.vo.app.AppFacilitiesCategoryVo;
import com.api.vo.app.IdAndName;

import java.util.Date;
import java.util.List;

public interface AppFacilitiesAppointmentDao {
    /**
     * 查询所有的设施预约 （包含搜索条件）
     * @param appFacilitiesAppointment app 设施预约 搜索条件
     * @return app 设施预约 Vo list 回显
     */
    List<AppFacilitiesAppointmentVo> list(SearchAppFacilitiesAppointment appFacilitiesAppointment);

    /**
     * 查询所有的设施分类信息
     * @return app 设施分类Vo list 回显
     */
    List<AppFacilitiesCategoryVo> findCategoryList();

    /**
     * 根据设施分类主键id查询设施信息
     * @param categoryId 设施分类主键id
     * @return 设施id和name
     */
    List<IdAndName> findFacilitiesByCategoryId(Integer categoryId);

    /**
     * 结束使用
     * @param appointmentStopUseFactor 设施预约结束使用条件
     * @return 影响行数
     */
    int useStop(AppointmentStopUseFactor appointmentStopUseFactor);

    /**
     * 根据设施预约主键id查询预约状态
     * @param facilitiesAppointmentId 设施预约主键id
     * @return 预约状态
     */
    Integer findStatusById(Integer facilitiesAppointmentId);

    /**
     * 根据设施预约主键id取消预约
     * @param appointmentStopUseFactor 设施取消预约 使用条件
     * @return 影响行数
     */
    int cancel(AppointmentStopUseFactor appointmentStopUseFactor);

    /**
     * 根据预约编号和预约人主键id 查询预约时间
     * @param appointmentCodeAndUserId 设施预约编号和用户主键id
     * @return 预约时间
     */
    Date findAppointmentStartDateByACAUI(AppointmentCodeAndUserId appointmentCodeAndUserId);

    /**
     * 根据设施预约编号和用户主键id 签到
     * @param appointmentCodeAndUserId 设施预约编号和用户主键id
     * @return 影响行数
     */
    int signId(AppointmentCodeAndUserId appointmentCodeAndUserId);

    /**
     * 查询当前设施当前时间之后的预约时段
     * @param appFacilitiesIdAndNowDate app 设施主键id 和 当前时间
     * @return app 设施预约时段Vo list 回显
     */
    List<AppAppointmentDateVo> findFacilitiesAppointmentDate(AppFacilitiesIdAndNowDate appFacilitiesIdAndNowDate);



}
