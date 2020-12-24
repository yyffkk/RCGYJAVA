package com.api.service.chargeManagement;

import com.api.model.chargeManagement.SearchDepositManagement;
import com.api.vo.chargeManagement.VoDepositManagement;

import java.util.List;

public interface SysDepositManagementService {
    List<VoDepositManagement> list(SearchDepositManagement searchDepositManagement);
}
