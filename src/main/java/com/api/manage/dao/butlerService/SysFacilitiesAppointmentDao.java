package com.api.manage.dao.butlerService;

import com.api.model.butlerService.FacilitiesAppointment;
import com.api.model.butlerService.SearchFacilitiesAppointment;
import com.api.vo.butlerService.VoFacilitiesAppointment;

import java.util.Date;
import java.util.List;

public interface SysFacilitiesAppointmentDao {
    /**
     * 查询所有的设施预约信息
     * @param searchFacilitiesAppointment 设施预约管理 搜索条件
     * @return 设施预约信息集合
     */
    List<VoFacilitiesAppointment> list(SearchFacilitiesAppointment searchFacilitiesAppointment);

    /**
     * 添加设施预约信息
     * @param facilitiesAppointment 设施预约管理model
     * @return 影响行数
     */
    int insert(FacilitiesAppointment facilitiesAppointment);

    /**
     * 作废设施预约信息
     * @param facilitiesAppointment 设施预约管理model
     * @return 影响行数
     */
    int nullify(FacilitiesAppointment facilitiesAppointment);

    /**
     * 查询今日新增预约数量
     * @param date 当前时间
     * @return 影响行数
     */
    int countAppointmentNow(Date date);

    /**
     * 先查询是否处于预约时段
     * @param facilitiesAppointment 设施预约管理model
     * @return 处于预约时段中的行数
     */
    int findIsBeInAppointmentDate(FacilitiesAppointment facilitiesAppointment);

    /**
     * 修改设施预约信息
     * @param facilitiesAppointment 设施预约管理model
     * @return 影响行数
     */
    int update(FacilitiesAppointment facilitiesAppointment);
}
