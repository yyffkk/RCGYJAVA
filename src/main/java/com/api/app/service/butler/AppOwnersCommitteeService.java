package com.api.app.service.butler;

import com.api.vo.butlerService.VoOwnersCommittee;

import java.util.List;
import java.util.Map;

public interface AppOwnersCommitteeService {
    List<VoOwnersCommittee> findAll();

    Map<String, Object> findOwnersTel();
}
