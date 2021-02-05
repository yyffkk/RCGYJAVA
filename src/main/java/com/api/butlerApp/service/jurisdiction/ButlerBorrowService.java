package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerBorrowSearch;
import com.api.vo.butlerApp.ButlerTypeAndBorrowListVo;


public interface ButlerBorrowService {
    ButlerTypeAndBorrowListVo list(ButlerBorrowSearch butlerBorrowSearch);
}
