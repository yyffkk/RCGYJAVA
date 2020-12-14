package com.api.dao.butlerService;

import com.api.model.butlerService.SearchBorrow;
import com.api.vo.butlerService.VoBorrow;

import java.util.List;

public interface BorrowDao {
    List<VoBorrow> list(SearchBorrow searchBorrow);
}
