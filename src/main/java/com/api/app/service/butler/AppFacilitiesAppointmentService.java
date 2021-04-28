package com.api.app.service.butler;

import com.api.model.app.SearchAppFacilitiesAppointment;
import com.api.model.butlerService.FacilitiesAppointment;
import com.api.vo.app.AppFacilitiesAppointmentVo;

import java.util.List;
import java.util.Map;

public interface AppFacilitiesAppointmentService {
    List<AppFacilitiesAppointmentVo> list(SearchAppFacilitiesAppointment appFacilitiesAppointment);

    Map<String, Object> insert(FacilitiesAppointment facilitiesAppointment);
}
