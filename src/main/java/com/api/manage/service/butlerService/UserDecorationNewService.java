package com.api.manage.service.butlerService;

import com.api.model.app.AppUserDecorationNew;
import com.api.model.butlerService.UserDecorationNewSearch;
import com.api.vo.butlerApp.ButlerUserDecorationNewVo;

import java.util.List;
import java.util.Map;

public interface UserDecorationNewService {
    List<ButlerUserDecorationNewVo> list(UserDecorationNewSearch userDecorationNewSearch);

    Map<String, Object> examine(AppUserDecorationNew appUserDecorationNew);

    Map<String, Object> assign(AppUserDecorationNew appUserDecorationNew);
}
