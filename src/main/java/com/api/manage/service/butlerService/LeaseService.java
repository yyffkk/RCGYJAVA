package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchLease;
import com.api.model.butlerService.SysLease;
import com.api.model.butlerService.SysLeaseRenew;
import com.api.vo.butlerService.VoLease;

import java.util.List;
import java.util.Map;

public interface LeaseService {
    List<VoLease> list(SearchLease searchLease);

    Map<String, Object> insert(SysLease sysLease);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(SysLease sysLease);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> reviewer(SysLease sysLease);

    Map<String, Object> reviewTerminationApplication(SysLease sysLease);

    Map<String, Object> reviewDepositRefundApplication(SysLease sysLease);

    Map<String, Object> renew(SysLeaseRenew sysLeaseRenew);

    Map<String, Object> findPaymentRecordsById(Integer id);
}
