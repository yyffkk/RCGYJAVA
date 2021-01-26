package com.api.app.service.butler;

import com.api.model.app.AppVotePersonnel;
import com.api.vo.app.AppEventVotingVo;

import java.util.List;
import java.util.Map;

public interface AppEventVotingService {
    List<AppEventVotingVo> list(Integer id, Integer type);

    Map<String, Object> voteDetail(Integer voteId, Integer id);

    Map<String, Object> vote(AppVotePersonnel appVotePersonnel);
}
