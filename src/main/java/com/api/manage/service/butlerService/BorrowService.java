package com.api.manage.service.butlerService;

import com.api.model.butlerService.BorrowRemind;
import com.api.model.butlerService.SearchBorrow;
import com.api.vo.butlerService.VoBorrow;

import java.util.List;
import java.util.Map;

public interface BorrowService {
    List<VoBorrow> list(SearchBorrow searchBorrow);

    Map<String, Object> remind(BorrowRemind borrowRemind);
}
