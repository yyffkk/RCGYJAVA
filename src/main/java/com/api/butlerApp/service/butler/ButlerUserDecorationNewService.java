package com.api.butlerApp.service.butler;

import com.api.model.butlerApp.ButlerUserDecorationNewSearch;
import com.api.vo.butlerApp.ButlerUserDecorationNewVo;

import java.util.List;

public interface ButlerUserDecorationNewService {
    List<ButlerUserDecorationNewVo> list(ButlerUserDecorationNewSearch butlerUserDecorationNewSearch);
}
