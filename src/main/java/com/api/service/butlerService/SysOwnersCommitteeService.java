package com.api.service.butlerService;

import com.api.model.butlerService.SearchOwnersCommittee;
import com.api.model.butlerService.SysOwnersCommittee;
import com.api.vo.butlerService.VoFindByIdOwnersCommittee;
import com.api.vo.butlerService.VoOwnersCommittee;

import java.util.List;
import java.util.Map;

public interface SysOwnersCommitteeService {
    List<VoOwnersCommittee> list(SearchOwnersCommittee searchOwnersCommittee);

    Map<String, Object> insert(SysOwnersCommittee sysOwnersCommittee);

    VoFindByIdOwnersCommittee findById(Integer id);

    Map<String, Object> update(SysOwnersCommittee sysOwnersCommittee);

    Map<String, Object> delete(int[] ids);
}
