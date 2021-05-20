package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.KeyBorrow;
import com.api.model.operationManagement.SearchKeyBorrow;
import com.api.vo.operationManagement.VoKeyBorrow;

import java.util.List;
import java.util.Map;

public interface SysKeyBorrowService {
    List<VoKeyBorrow> list(SearchKeyBorrow searchKeyBorrow);

    Map<String, Object> examine(KeyBorrow keyBorrow);
}
