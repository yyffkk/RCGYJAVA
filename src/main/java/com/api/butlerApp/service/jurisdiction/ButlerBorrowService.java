package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerBorrowSearch;
import com.api.vo.butlerApp.ButlerBorrowVo;
import com.api.vo.butlerApp.ButlerTypeAndBorrowListVo;

import java.util.List;

public interface ButlerBorrowService {
    ButlerTypeAndBorrowListVo list(ButlerBorrowSearch butlerBorrowSearch);
}
