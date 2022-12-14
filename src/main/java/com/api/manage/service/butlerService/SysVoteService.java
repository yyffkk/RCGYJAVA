package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchVote;
import com.api.model.butlerService.SearchVotePersonnel;
import com.api.model.butlerService.SysVote;
import com.api.vo.butlerService.VoFindDetailByIdVoteCandidate;
import com.api.vo.butlerService.VoVote;
import com.api.vo.butlerService.VoVotePersonnel;

import java.util.List;
import java.util.Map;

public interface SysVoteService {

    List<VoVote> list(SearchVote searchVote);

    Map<String, Object> findById(Integer id);

    Map<String, Object> findDetailById(Integer id);

    Map<String, Object> insert(SysVote sysVote);

    Map<String, Object> update(SysVote sysVote);

    Map<String, Object> falseDelete(int[] ids);

    Map<String, Object> release(int[] ids);

    List<VoFindDetailByIdVoteCandidate> listDetailCandidate(int id);

    List<VoVotePersonnel> listVotePersonnel(SearchVotePersonnel searchVotePersonnel);

    Map<String, Object> countVoteExpectedStart();
}
