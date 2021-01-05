package com.api.manage.service.chargeManagement;

import com.api.model.chargeManagement.FixedPayment;
import com.api.model.chargeManagement.SearchFixedAmountAllocation;
import com.api.model.chargeManagement.SearchFixedAmountAllocationResult;
import com.api.model.chargeManagement.SysFixedAmountAllocation;
import com.api.vo.chargeManagement.VoFindByIdFAA;
import com.api.vo.chargeManagement.VoFixedAmountAllocation;
import com.api.vo.chargeManagement.VoFixedAmountAllocationResult;

import java.util.List;
import java.util.Map;

public interface SysFixedAmountAllocationService {
    List<VoFixedAmountAllocation> list(SearchFixedAmountAllocation searchFixedAmountAllocation);

    Map<String, Object> insert(SysFixedAmountAllocation sysFixedAmountAllocation);

    VoFindByIdFAA findById(Integer id);

    Map<String, Object> update(SysFixedAmountAllocation sysFixedAmountAllocation);

    Map<String, Object> falseDelete(int[] ids);

    List<VoFixedAmountAllocationResult> listResult(SearchFixedAmountAllocationResult searchFixedAmountAllocationResult);

    Map<String, Object> share(Integer id);

    Map<String, Object> payment(FixedPayment fixedPayment);
}
