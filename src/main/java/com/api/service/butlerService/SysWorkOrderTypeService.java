package com.api.service.butlerService;

import com.api.model.butlerService.SysWorkOrderType;
import com.api.vo.butlerService.VoWorkOrderType;

import java.util.List;
import java.util.Map;

public interface SysWorkOrderTypeService {
    List<VoWorkOrderType> list();

    Map<String, Object> insert(SysWorkOrderType sysWorkOrderType);

    VoWorkOrderType findById(Integer id);

    Map<String, Object> update(SysWorkOrderType sysWorkOrderType);

    Map<String, Object> delete(Integer id);
}
