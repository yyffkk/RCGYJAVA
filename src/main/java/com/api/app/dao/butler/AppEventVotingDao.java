package com.api.app.dao.butler;

import com.api.model.app.AppVotePersonnel;
import com.api.model.butlerService.SysVote;
import com.api.vo.app.AppEventVotingVo;
import com.api.vo.app.AppVoteCandidateVo;
import com.api.vo.app.AppVoteDetailVo;
import com.api.vo.app.AppVotePersonnelVo;

import java.util.List;

public interface AppEventVotingDao {
    /**
     * app查询所有活动投票信息
     * @param type 用户类型
     * @return 活动投票信息集合
     */
    List<AppEventVotingVo> list(Integer type);

    /**
     * 根据投票信息id查询相关投票人信息
     * @param id 投票信息主键id
     * @return 投票人信息集合
     */
    List<Integer> findVoterIdById(Integer id);

    /**
     * 根据投票信息主键id投票详情
     * @param voteId 投票信息主键id
     * @return 投票详情Vo
     */
    AppVoteDetailVo voteDetail(Integer voteId);

    /**
     * 根据投票信息主键id查询候选人信息
     * @param voteId 投票信息主键id
     * @return 候选人信息集合
     */
    List<AppVoteCandidateVo> findCandidateByVoteId(Integer voteId);

    /**
     * 根据投票信息id和投票人 查询投票人投票信息
     * @param appVotePersonnel 投票人投票信息查询条件
     * @return 投票人投票信息
     */
    List<AppVotePersonnelVo> findPersonnelByIds(AppVotePersonnel appVotePersonnel);

    /**
     * 根据活动投票主键id 查询活动投票信息
     * @param voteId 活动投票主键id
     * @return 活动投票信息
     */
    SysVote findVoteById(Integer voteId);

    /**
     * 用户投票
     * @param appVotePersonnel 投票人投票信息
     * @return 影响行数
     */
    int insertVotePersonnel(AppVotePersonnel appVotePersonnel);

    /**
     * 当前活动投票，投票总数加一
     * @param appVotePersonnel 投票人投票信息
     * @return 影响行数
     */
    int voteCandidateAdd(AppVotePersonnel appVotePersonnel);

    /**
     * 查询所有候选人投票总数
     * @param voteId 投票信息主键id
     * @return 所有候选人投票总数
     */
    int sumTotalByVoteId(Integer voteId);
}
