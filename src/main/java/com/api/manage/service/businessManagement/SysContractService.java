package com.api.manage.service.businessManagement;

import com.api.model.businessManagement.SearchContract;
import com.api.model.businessManagement.SysContract;
import com.api.vo.businessManagement.VoContract;

import java.util.List;
import java.util.Map;

public interface SysContractService {
    List<VoContract> list(SearchContract searchContract);

    Map<String, Object> insert(SysContract sysContract);

    Map<String, Object> delete(int[] ids);
}
