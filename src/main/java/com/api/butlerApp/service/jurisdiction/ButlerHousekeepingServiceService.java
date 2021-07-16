package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerHousekeepingServiceSearch;
import com.api.vo.app.AppHousekeepingServiceVo;

import java.util.List;

public interface ButlerHousekeepingServiceService {
    List<AppHousekeepingServiceVo> list(ButlerHousekeepingServiceSearch butlerHousekeepingServiceSearch);
}
