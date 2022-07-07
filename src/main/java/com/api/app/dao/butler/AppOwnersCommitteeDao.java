package com.api.app.dao.butler;

import com.api.vo.butlerService.VoOwnersCommittee;

import java.util.List;

public interface AppOwnersCommitteeDao {
    List<VoOwnersCommittee> findAll();
}
