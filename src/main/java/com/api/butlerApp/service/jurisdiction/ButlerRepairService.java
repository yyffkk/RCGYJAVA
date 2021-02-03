package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerApplyDelayed;
import com.api.model.butlerApp.ButlerHandleCompleteDetail;
import com.api.model.butlerApp.ButlerRepairSearch;
import com.api.model.butlerService.SysDispatchListDetail;
import com.api.vo.butlerApp.ButlerRepairVo;

import java.util.List;
import java.util.Map;

public interface ButlerRepairService {
    List<ButlerRepairVo> list(ButlerRepairSearch butlerRepairSearch);

    Map<String, Object> findById(Integer repairId, Integer id, String roleId);

    Map<String, Object> findWorkOrderTimeLimit();

    Map<String, Object> findWorkOrderTypeDetail(Integer workOrderTypeId);

    Map<String, Object> findRepairOrganization(int repairOrganizationId);

    Map<String, Object> dispatch(SysDispatchListDetail sysDispatchListDetail, String roleId);

    Map<String, Object> reassignment(Integer dispatchListId, Integer operator, String roleId, Integer id);

    Map<String, Object> receivingOrders(Integer dispatchId, Integer id, String roleId);

    Map<String, Object> applyDelayed(ButlerApplyDelayed butlerApplyDelayed, Integer id);

    Map<String, Object> handleResult(ButlerHandleCompleteDetail handleCompleteDetail, Integer id);
}
