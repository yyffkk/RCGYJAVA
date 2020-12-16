package com.api.service.butlerService;

import com.api.model.butlerService.SysWorkOrderTypeDetail;
import com.api.vo.butlerService.VoWorkOrderTypeDetail;

import java.util.List;
import java.util.Map;

public interface SysWorkOrderTypeDetailService {
    List<VoWorkOrderTypeDetail> list(Integer id);

    Map<String, Object> insert(SysWorkOrderTypeDetail sysWorkOrderTypeDetail);

    VoWorkOrderTypeDetail findById(Integer id);

    Map<String, Object> update(SysWorkOrderTypeDetail sysWorkOrderTypeDetail);

    Map<String, Object> delete(int[] ids);
}
