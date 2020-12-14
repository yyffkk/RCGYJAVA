package com.api.service.butlerService;

import com.api.model.butlerService.SearchBorrow;
import com.api.vo.butlerService.VoBorrow;

import java.util.List;

public interface BorrowService {
    List<VoBorrow> list(SearchBorrow searchBorrow);
}
