package com.api.manage.service.businessManagement;

import com.api.model.businessManagement.Remind;
import com.api.model.businessManagement.SearchRemind;
import com.api.vo.businessManagement.VoRemind;

import java.util.List;
import java.util.Map;

public interface SysRemindService {
    List<VoRemind> list(SearchRemind searchRemind);

    Map<String, Object> insert(Remind remind);
}
