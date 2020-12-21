package com.api.dao.butlerService;

import com.api.model.butlerService.SearchReportRepair;
import com.api.vo.butlerService.VoReportRepair;

import java.util.List;

public interface SysReportRepairDao {
    List<VoReportRepair> list(SearchReportRepair searchReportRepair);
}
