package com.api.butlerApp.service.butler;

import com.api.model.butlerApp.ButlerVisitorSearch;
import com.api.vo.butlerApp.ButlerVisitorVo;

import java.util.List;

public interface ButlerVisitorService {
    List<ButlerVisitorVo> list(ButlerVisitorSearch butlerVisitorSearch);
}
