package com.api.manage.service.chargeManagement;

import com.api.model.chargeManagement.SearchPaper;
import com.api.model.chargeManagement.SysPaper;
import com.api.vo.chargeManagement.SysPaperVo;

import java.util.List;
import java.util.Map;

public interface SysPaperService {
    List<SysPaperVo> list(SearchPaper searchPaper);

    Map<String, Object> insert(SysPaper sysPaper);

    Map<String, Object> recipients(SysPaper sysPaper);

    Map<String, Object> delete(int[] ids);
}
