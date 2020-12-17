package com.api.service.butlerService;

import com.api.model.butlerService.SearchDispatchList;
import com.api.vo.butlerService.VoDispatchList;

import java.util.List;

public interface SysDispatchListService {
    List<VoDispatchList> list(SearchDispatchList searchDispatchList);
}
