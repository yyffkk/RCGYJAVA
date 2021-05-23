package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerFacilitiesCheckSearch;
import com.api.vo.butlerApp.ButlerFacilitiesCheckVo;

import java.util.List;

public interface ButlerFacilitiesCheckService {
    List<ButlerFacilitiesCheckVo> list(ButlerFacilitiesCheckSearch butlerFacilitiesCheckSearch);
}
