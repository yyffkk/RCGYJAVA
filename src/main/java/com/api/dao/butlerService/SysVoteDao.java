package com.api.dao.butlerService;

import com.api.model.butlerService.SearchVote;
import com.api.model.butlerService.SysVote;
import com.api.model.butlerService.SysVoteCandidate;
import com.api.vo.butlerService.VoFindByIdVote;
import com.api.vo.butlerService.VoFindByIdVoteCandidate;
import com.api.vo.butlerService.VoVote;

import java.util.List;

public interface SysVoteDao {
    /**
     * 查询所有投票信息（包含条件搜索）
     * @param searchVote 搜索条件
     * @return 投票信息集合
     */
    List<VoVote> list(SearchVote searchVote);

    /**
     * 根据投票主键id查询候选人数量
     * @param id 投票主键id
     * @return 候选人数量
     */
    int countVoteCandidate(Integer id);

    /**
     * 根据投票主键id查询出最高投票数的候选人信息
     * @param id 投票主键id
     * @return 最高投票数的候选人信息
     */
    SysVoteCandidate maxVoteCandidate(Integer id);

    /**
     * 更新投票状态
     * @param voVote 更新信息
     * @return 影响行数
     */
    int updateStatus(VoVote voVote);

    /**
     * 投票主键id查询投票信息
     * @param id  投票主键id
     * @return 投票信息
     */
    VoFindByIdVote findById(Integer id);

    /**
     * 根据投票主键id查询候选人信息集合
     * @param id 投票主键id
     * @return 候选人信息集合
     */
    List<VoFindByIdVoteCandidate> findCandidateByVoteId(Integer id);

    /**
     * 添加投票信息并返回主键id
     * @param sysVote 投票信息
     * @return 影响行数
     */
    int insert(SysVote sysVote);

    /**
     * 添加投票候选人信息
     * @param sysVoteCandidate 投票候选人信息
     * @return 影响行数
     */
    int insertCandidate(SysVoteCandidate sysVoteCandidate);

    /**
     * 修改投票信息
     * @param sysVote 新投票信息
     * @return 影响行数
     */
    int update(SysVote sysVote);

    /**
     * 修改投票候选人信息
     * @param sysVoteCandidate 新投票候选人信息
     * @return 影响行数
     */
    int updateCandidate(SysVoteCandidate sysVoteCandidate);
}
