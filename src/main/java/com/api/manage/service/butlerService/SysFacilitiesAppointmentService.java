package com.api.manage.service.butlerService;

import com.api.model.butlerService.FacilitiesAppointment;
import com.api.model.butlerService.SearchFacilitiesAppointment;
import com.api.vo.butlerService.VoFacilitiesAppointment;

import java.util.List;
import java.util.Map;

public interface SysFacilitiesAppointmentService {
    List<VoFacilitiesAppointment> list(SearchFacilitiesAppointment searchFacilitiesAppointment);

    Map<String, Object> insert(FacilitiesAppointment facilitiesAppointment);

    Map<String, Object> nullify(FacilitiesAppointment facilitiesAppointment);

    Map<String, Object> countAppointmentNow();

    Map<String, Object> update(FacilitiesAppointment facilitiesAppointment);

    Map<String, Object> delete(int[] ids);
}
