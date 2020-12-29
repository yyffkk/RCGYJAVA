package com.api.service.operationManagement;

import com.api.model.operationManagement.SearchSponsorManagement;
import com.api.model.operationManagement.SponsorManagement;
import com.api.vo.operationManagement.VoSponsorManagement;

import java.util.List;
import java.util.Map;

public interface SysSponsorManagementService {
    List<VoSponsorManagement> list(SearchSponsorManagement searchSponsorManagement);

    Map<String, Object> insert(SponsorManagement sponsorManagement);
}
