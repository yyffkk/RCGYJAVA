package com.api.app.service.butler;

import com.api.model.app.AppointmentCodeAndUserId;
import com.api.model.app.AppointmentStopUseFactor;
import com.api.model.app.SearchAppFacilitiesAppointment;
import com.api.model.butlerService.FacilitiesAppointment;
import com.api.vo.app.AppFacilitiesAppointmentVo;
import com.api.vo.app.AppFacilitiesCategoryVo;

import java.util.List;
import java.util.Map;

public interface AppFacilitiesAppointmentService {
    List<AppFacilitiesAppointmentVo> list(SearchAppFacilitiesAppointment appFacilitiesAppointment);

    Map<String, Object> insert(FacilitiesAppointment facilitiesAppointment);

    List<AppFacilitiesCategoryVo> findCategoryList();

    Map<String, Object> findFacilitiesByCategoryId(Integer categoryId);

    Map<String, Object> useStop(AppointmentStopUseFactor appointmentStopUseFactor);

    Map<String, Object> cancel(AppointmentStopUseFactor appointmentStopUseFactor);

    Map<String, Object> signId(AppointmentCodeAndUserId appointmentCodeAndUserId);
}
