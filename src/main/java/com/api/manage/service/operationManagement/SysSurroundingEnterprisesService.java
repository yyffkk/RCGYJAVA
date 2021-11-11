package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SurroundingEnterprisesSearch;
import com.api.vo.operationManagement.SysSurroundingEnterprisesVo;

import java.util.List;

public interface SysSurroundingEnterprisesService {
    List<SysSurroundingEnterprisesVo> list(SurroundingEnterprisesSearch surroundingEnterprisesSearch);
}
