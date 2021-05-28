package com.api.app.service.butler;

import com.api.model.app.AppUserDecorationNew;
import com.api.model.app.SearchAppUserDecorationNew;
import com.api.vo.butlerApp.ButlerUserDecorationNewVo;

import java.util.List;
import java.util.Map;

public interface AppUserDecorationNewService {
    List<ButlerUserDecorationNewVo> list(SearchAppUserDecorationNew searchAppUserDecorationNew);

    Map<String, Object> insert(AppUserDecorationNew appUserDecorationNew, Integer id);
}
