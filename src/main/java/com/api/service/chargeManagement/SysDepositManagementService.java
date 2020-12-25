package com.api.service.chargeManagement;

import com.api.model.chargeManagement.SearchDepositManagement;
import com.api.model.chargeManagement.SysDepositManagement;
import com.api.model.chargeManagement.SysDepositManagementOrder;
import com.api.vo.chargeManagement.VoDepositManagement;
import com.api.vo.chargeManagement.VoFindByIdDepositManagement;
import com.api.vo.chargeManagement.VoRefundDecorationDetail;

import java.util.List;
import java.util.Map;

public interface SysDepositManagementService {
    List<VoDepositManagement> list(SearchDepositManagement searchDepositManagement);

    Map<String, Object> insert(SysDepositManagement sysDepositManagement);

    VoFindByIdDepositManagement findById(Integer id);

    Map<String, Object> update(SysDepositManagement sysDepositManagement);

    Map<String, Object> falseDelete(int[] ids);

    VoRefundDecorationDetail refundDecorationDetail(Integer id);

    Map<String, Object> refund(SysDepositManagementOrder sysDepositManagementOrder);
}
