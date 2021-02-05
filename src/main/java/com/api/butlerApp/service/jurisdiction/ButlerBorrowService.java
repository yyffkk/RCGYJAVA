package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerBorrowSearch;
import com.api.model.butlerApp.ButlerSubmitCheck;
import com.api.vo.butlerApp.ButlerTypeAndBorrowListVo;

import java.util.Map;


public interface ButlerBorrowService {
    ButlerTypeAndBorrowListVo list(ButlerBorrowSearch butlerBorrowSearch);

    Map<String, Object> checkItems(Integer articleBorrowId, String roleId);

    Map<String, Object> submitCheck(ButlerSubmitCheck butlerSubmitCheck, String roleId);
}
