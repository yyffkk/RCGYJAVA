package com.api.butlerApp.service.butler;

import com.api.model.butlerApp.ButlerUserDecorationNewSearch;
import com.api.model.butlerApp.ButlerUserDecorationNewCheck;
import com.api.vo.butlerApp.ButlerUserDecorationNewVo;

import java.util.List;
import java.util.Map;

public interface ButlerUserDecorationNewService {
    List<ButlerUserDecorationNewVo> list(ButlerUserDecorationNewSearch butlerUserDecorationNewSearch);

    Map<String, Object> submitReport(ButlerUserDecorationNewCheck butlerUserDecorationNewCheck, Integer id);
}
