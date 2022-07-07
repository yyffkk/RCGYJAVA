package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchUserAdvice;
import com.api.model.butlerService.SysAdvice;
import com.api.model.butlerService.SysAdviceDetail;
import com.api.vo.butlerService.VoFindByIdAdvice;
import com.api.vo.butlerService.VoUserAdvice;
import com.api.vo.butlerService.VoUserAdviceDetail;

import java.util.List;

public interface UserAdviceDao {
    /**
     * 查询所有的咨询建议的条件搜索
     * @param searchUserAdvice 搜索条件
     * @return 咨询建议表 Vo list
     */
    List<VoUserAdvice> list(SearchUserAdvice searchUserAdvice);

    /**
     * 根据咨询建议表主键id 查询 建议反馈表信息数量
     * @param id 咨询建议表主键id
     * @return 建议反馈表信息数量
     */
    int countDetailByAdviceId(Integer id);

    /**
     * 回复咨询建议（添加反馈信息）
     * @param sysAdviceDetail 建议反馈表信息
     * @return 影响行数
     */
    int insertDetail(SysAdviceDetail sysAdviceDetail);

    /**
     * 新增咨询建议
     * @param sysAdvice 咨询建议表信息
     * @return 影响行数
     */
    int insertAdvice(SysAdvice sysAdvice);

    /**
     * 根据咨询建议主键id删除咨询建议信息
     * @param id 咨询建议主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 根据咨询建议主键id删除反馈信息
     * @param id 咨询建议主键id
     * @return 影响行数
     */
    int deleteDetail(int id);

    /**
     * 根据咨询建议主键id假删除咨询建议信息
     * @param id 咨询建议主键id
     * @return 影响行数
     */
    int falseDelete(int id);

    /**
     * 根据咨询建议主键id查询咨询建议信息
     * @param id 咨询建议主键id
     * @return 咨询建议信息
     */
    VoFindByIdAdvice findById(Integer id);

    /**
     * 根据咨询建议主键id查询反馈信息集合
     * @param id 咨询建议主键id
     * @return 反馈信息集合
     */
    List<VoUserAdviceDetail> findByAdviceIdDetail(Integer id);

    /**
     * 查询今日建议条数
     * @return 建议条数
     */
    Integer countAdviceNew();

    /**
     * 查询今日咨询条数
     * @return 咨询条数
     */
    Integer countConsultNew();

    /**
     * 更新反馈状态
     * @param sysAdvice 咨询建议表信息
     * @return 影响行数
     */
    int updateAdviceStatus(SysAdvice sysAdvice);
}
