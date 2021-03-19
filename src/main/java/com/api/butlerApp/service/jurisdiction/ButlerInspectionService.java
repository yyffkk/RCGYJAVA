package com.api.butlerApp.service.jurisdiction;

import com.api.vo.butlerApp.ButlerInspectionVo;

import java.util.List;

public interface ButlerInspectionService {
    List<ButlerInspectionVo> list(int status);
}
