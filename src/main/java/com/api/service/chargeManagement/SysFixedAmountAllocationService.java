package com.api.service.chargeManagement;

import com.api.model.chargeManagement.SearchFixedAmountAllocation;
import com.api.model.chargeManagement.SysFixedAmountAllocation;
import com.api.vo.chargeManagement.VoFindByIdFAA;
import com.api.vo.chargeManagement.VoFixedAmountAllocation;

import java.util.List;
import java.util.Map;

public interface SysFixedAmountAllocationService {
    List<VoFixedAmountAllocation> list(SearchFixedAmountAllocation searchFixedAmountAllocation);

    Map<String, Object> insert(SysFixedAmountAllocation sysFixedAmountAllocation);

    VoFindByIdFAA findById(Integer id);

    Map<String, Object> update(SysFixedAmountAllocation sysFixedAmountAllocation);

    Map<String, Object> falseDelete(int[] ids);
}
