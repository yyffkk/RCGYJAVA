package com.api.app.dao.butler;

import com.api.model.app.AppointmentStopUseFactor;
import com.api.model.app.SearchAppFacilitiesAppointment;
import com.api.vo.app.AppFacilitiesAppointmentVo;
import com.api.vo.app.AppFacilitiesCategoryVo;
import com.api.vo.app.IdAndName;

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
}
