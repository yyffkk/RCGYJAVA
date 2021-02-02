package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerRepairSearch;
import com.api.vo.butlerApp.ButlerRepairVo;

import java.util.List;

public interface ButlerRepairService {
    List<ButlerRepairVo> list(ButlerRepairSearch butlerRepairSearch);
}
