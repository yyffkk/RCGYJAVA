package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerGreenSearch;
import com.api.vo.butlerApp.ButlerGreenVo;

import java.util.List;

public interface ButlerGreenService {
    List<ButlerGreenVo> list(ButlerGreenSearch butlerGreenSearch);
}
