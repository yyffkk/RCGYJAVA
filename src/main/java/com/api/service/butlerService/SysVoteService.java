package com.api.service.butlerService;

import com.api.model.butlerService.SearchVote;
import com.api.model.butlerService.SysVote;
import com.api.vo.butlerService.VoVote;

import java.util.List;
import java.util.Map;

public interface SysVoteService {

    List<VoVote> list(SearchVote searchVote);

    Map<String, Object> findById(Integer id);

    Map<String, Object> insert(SysVote sysVote);

    Map<String, Object> update(SysVote sysVote);
}
