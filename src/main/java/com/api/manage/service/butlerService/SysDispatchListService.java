package com.api.manage.service.butlerService;

import com.api.model.butlerService.CancelWorkOrder;
import com.api.model.butlerService.RevisitWorkOrder;
import com.api.model.butlerService.SearchDispatchList;
import com.api.model.butlerService.SysDispatchListDetail;
import com.api.vo.butlerService.VoDispatchList;

import java.util.List;
import java.util.Map;

public interface SysDispatchListService {
    List<VoDispatchList> list(SearchDispatchList searchDispatchList);

    Map<String, Object> falseDelete(int[] ids);

    Map<String, Object> cancel(CancelWorkOrder cancelWorkOrder);

    Map<String, Object> revisit(RevisitWorkOrder revisitWorkOrder);

    Map<String, Object> rollback(Integer id);

    Map<String, Object> dispatch(SysDispatchListDetail sysDispatchListDetail);

    Map<String, Object> repairWorkOrderDetail(Integer id);
}
