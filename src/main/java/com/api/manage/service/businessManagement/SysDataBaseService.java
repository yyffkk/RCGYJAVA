package com.api.manage.service.businessManagement;

import com.api.model.businessManagement.SearchDataBase;
import com.api.model.businessManagement.SysDataBase;
import com.api.vo.businessManagement.VoDataBase;

import java.util.List;
import java.util.Map;

public interface SysDataBaseService {
    List<VoDataBase> list(SearchDataBase searchDataBase);

    Map<String, Object> insert(SysDataBase sysDataBase);

    Map<String, Object> delete(int[] ids);
}
