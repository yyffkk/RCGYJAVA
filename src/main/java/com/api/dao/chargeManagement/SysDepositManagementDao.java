package com.api.dao.chargeManagement;

import com.api.model.chargeManagement.SearchDepositManagement;
import com.api.vo.chargeManagement.VoDepositManagement;

import java.util.List;

public interface SysDepositManagementDao {
    List<VoDepositManagement> list(SearchDepositManagement searchDepositManagement);
}
