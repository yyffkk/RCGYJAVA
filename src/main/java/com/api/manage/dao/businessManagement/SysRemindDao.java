package com.api.manage.dao.businessManagement;

import com.api.model.businessManagement.SearchRemind;
import com.api.vo.businessManagement.VoRemind;

import java.util.List;

public interface SysRemindDao {
    /**
     * 查询所有的提醒通知记录
     * @param searchRemind 提醒通知搜索条件
     * @return 提醒通知记录
     */
    List<VoRemind> list(SearchRemind searchRemind);
}
