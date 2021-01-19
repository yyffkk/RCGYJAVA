package com.api.manage.service.butlerService;

import com.api.model.butlerService.ReportRepair;
import com.api.model.butlerService.SearchReportRepair;
import com.api.vo.butlerService.VoFindByIdRepair;
import com.api.vo.butlerService.VoRepair;
import com.api.vo.butlerService.VoReportRepair;

import java.util.List;
import java.util.Map;

public interface SysReportRepairService {
    List<VoReportRepair> list(SearchReportRepair searchReportRepair);

    VoRepair findRepairDetail(Integer id);

    Map<String, Object> insert(ReportRepair reportRepair);

    VoFindByIdRepair findById(Integer id);

    Map<String, Object> update(ReportRepair reportRepair);
}
