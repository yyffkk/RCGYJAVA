package com.api.service.butlerService;

import com.api.model.butlerService.SearchReportRepair;
import com.api.vo.butlerService.VoReportRepair;

import java.util.List;
import java.util.Map;

public interface SysReportRepairService {
    List<VoReportRepair> list(SearchReportRepair searchReportRepair);
}
