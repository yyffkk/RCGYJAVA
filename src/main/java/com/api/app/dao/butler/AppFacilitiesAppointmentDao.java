package com.api.app.dao.butler;

import com.api.model.app.SearchAppFacilitiesAppointment;
import com.api.vo.app.AppFacilitiesAppointmentVo;

import java.util.List;

public interface AppFacilitiesAppointmentDao {
    List<AppFacilitiesAppointmentVo> list(SearchAppFacilitiesAppointment appFacilitiesAppointment);
}
