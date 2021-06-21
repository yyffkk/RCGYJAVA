package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchLeaseContract;
import com.api.model.butlerService.SysLeaseContract;
import com.api.vo.butlerService.VoLeaseContract;

import java.util.List;
import java.util.Map;

public interface LeaseContractService {
    List<VoLeaseContract> list(SearchLeaseContract searchLeaseContract);

    Map<String, Object> insert(SysLeaseContract sysLeaseContract);

    Map<String, Object> enable(Integer id);

    Map<String, Object> delete(int[] ids);
}
