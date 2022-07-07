package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchVote;
import com.api.model.butlerService.SearchVotePersonnel;
import com.api.model.butlerService.SysVote;
import com.api.model.butlerService.SysVoteCandidate;
import com.api.vo.butlerService.*;

import java.util.Date;
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
     * 根据投票主键Id删除投票候选人信息
     * @param id 投票主键id
     * @return 影响行数
     */
    int deleteCandidate(Integer id);

    /**
     * 根据投票管理主键id批量删除投票信息(假删除)
     * @param id 投票管理主键id
     * @return 影响行数
     */
    int falseDelete(Integer id);

    /**
     * 根据投票管理主键id批量发布投票信息
     * @param id 投票管理主键id
     * @return 影响行数
     */
    int release(int id);

    /**
     * 根据投票管理主键id查询投票详情信息
     * @param id 投票管理主键ID
     * @return 投票详情信息
     */
    VoFindDetailByIdVote findDetailById(Integer id);

    /**
     * 根据投票管理主键id查询所有投票候选人信息（详情页面）
     * @param id 投票管理主键id
     * @return 投票候选人信息集合
     */
    List<VoFindDetailByIdVoteCandidate> listDetailCandidate(int id);

    /**
     * 根据投票管理主键id和候选人主键ID查询候选人投票详情信息
     * @param searchVotePersonnel 投票人搜索条件
     * @return 候选人投票详情信息
     */
    List<VoVotePersonnel> listVotePersonnel(SearchVotePersonnel searchVotePersonnel);

    /**
     * 查询预期时间间隔信息
     * @return 时间间隔信息
     */
    VoVoteExpectedTime listVoteExpectedTime();

    /**
     * 查询即将开始的投票数，投票开始时间要大于当前时间，小于预期最晚开始时间
     * @param date 预期最晚开始时间
     * @return 即将开始的投票数
     */
    int countVoteExpectedStart(Date date);


//    /**
//     * 修改投票候选人信息
//     * @param sysVoteCandidate 新投票候选人信息
//     * @return 影响行数
//     */
//    int updateCandidate(SysVoteCandidate sysVoteCandidate);
}
