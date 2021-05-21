package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerGreenSearch;
import com.api.model.operationManagement.SysGreenTask;
import com.api.vo.butlerApp.ButlerGreenVo;

import java.util.List;
import java.util.Map;

public interface ButlerGreenService {
    List<ButlerGreenVo> list(ButlerGreenSearch butlerGreenSearch);

    Map<String, Object> complete(SysGreenTask sysGreenTask);

}
