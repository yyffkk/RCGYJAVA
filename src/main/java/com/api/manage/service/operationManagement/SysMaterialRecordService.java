package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchMaterialRecord;
import com.api.model.operationManagement.SysMaterialRecord;
import com.api.vo.operationManagement.VoMaterialRecord;

import java.util.List;
import java.util.Map;

public interface SysMaterialRecordService {
    List<VoMaterialRecord> list(SearchMaterialRecord searchMaterialRecord);

    Map<String, Object> insert(SysMaterialRecord sysMaterialRecord);

}
