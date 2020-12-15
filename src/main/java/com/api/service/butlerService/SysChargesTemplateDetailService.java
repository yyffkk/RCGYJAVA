package com.api.service.butlerService;

import com.api.model.butlerService.SearchChargesTemplateDetail;
import com.api.model.butlerService.SysChargesTemplateDetail;
import com.api.vo.butlerService.VoChargesTemplateDetail;

import java.util.List;
import java.util.Map;

public interface SysChargesTemplateDetailService {
    List<VoChargesTemplateDetail> list(SearchChargesTemplateDetail searchChargesTemplateDetail);

    Map<String, Object> insert(SysChargesTemplateDetail sysChargesTemplateDetail);
}
