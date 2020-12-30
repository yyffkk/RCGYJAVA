package com.api.service.operationManagement;

import com.api.model.operationManagement.SearchSponsorManagement;
import com.api.model.operationManagement.SponsorManagement;
import com.api.vo.operationManagement.VoFindByIdSponsorManagement;
import com.api.vo.operationManagement.VoSponsorActivityDetail;
import com.api.vo.operationManagement.VoSponsorManagement;

import java.util.List;
import java.util.Map;

public interface SysSponsorManagementService {
    List<VoSponsorManagement> list(SearchSponsorManagement searchSponsorManagement);

    Map<String, Object> insert(SponsorManagement sponsorManagement);

    VoFindByIdSponsorManagement findById(Integer id);

    Map<String, Object> update(SponsorManagement sponsorManagement);

    Map<String, Object> falseDelete(int[] ids);

    List<VoSponsorActivityDetail> sponsorActivityDetail(Integer id);
}
