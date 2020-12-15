package com.api.service.butlerService;

import com.api.model.butlerService.SearchBorrow;
import com.api.model.butlerService.SysMessage;
import com.api.vo.butlerService.VoBorrow;

import java.util.List;
import java.util.Map;

public interface BorrowService {
    List<VoBorrow> list(SearchBorrow searchBorrow);

    Map<String, Object> remind(SysMessage sysMessage);
}
