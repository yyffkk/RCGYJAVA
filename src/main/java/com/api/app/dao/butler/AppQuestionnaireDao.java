package com.api.app.dao.butler;

import com.api.model.app.AppQuestionJudgmentAnswer;
import com.api.model.app.AppQuestionnaireChoiceAnswer;
import com.api.model.app.AppQuestionnaireShortAnswer;
import com.api.model.butlerService.SysQuestionnaireTopic;
import com.api.vo.app.AppQuestionnaireChoiceVo;
import com.api.vo.app.AppQuestionnaireDetailVo;
import com.api.model.app.AppQuestionnairePersonnel;
import com.api.vo.app.AppQuestionnaireTopicVo;
import com.api.vo.app.AppQuestionnaireVo;

import java.util.List;

public interface AppQuestionnaireDao {
    /**
     * app查询所有的问卷调查list
     * @param type 用户类型
     * @return 所有的问卷调查list
     */
    List<AppQuestionnaireVo> list(Integer type);

    /**
     * 查询是否答过卷
     * @param personnel 问卷人表信息条件
     * @return 问卷人表信息
     */
    List<AppQuestionnairePersonnel> findPersonnelByIds(AppQuestionnairePersonnel personnel);

    /**
     * 根据问卷信息id查询相关答卷人信息
     * @param questionnaireId 问卷信息id
     * @return 相关答卷人信息
     */
    List<Integer> findAnswerIdById(Integer questionnaireId);

    /**
     * 根据问卷调查主键ID查询问卷调查信息
     * @param questionnaireId 问卷调查主键ID
     * @return 问卷调查信息
     */
    AppQuestionnaireDetailVo findQuestionnaireById(Integer questionnaireId);

    /**
     * 根据问卷调查主键ID查询题目信息集合
     * @param questionnaireId 问卷调查主键ID
     * @return 题目信息集合
     */
    List<AppQuestionnaireTopicVo> findTopicById(Integer questionnaireId);

    /**
     * 根据题目主键id查询选择项信息集合
     * @param topicId 题目主键id
     * @return 选择项信息集合
     */
    List<AppQuestionnaireChoiceVo> findChoiceByTopicId(Integer topicId);

    /**
     * 根据问卷调查主键id对答题人员数量进行累加
     * @param id 问卷调查主键id
     * @return 影响行数
     */
    int accumulationAnswerNum(Integer id);

    /**
     * 根据题目id查询题目信息
     * @param topicId 题目id
     * @return 题目信息
     */
    AppQuestionnaireTopicVo findTopicByTopicId(Integer topicId);

    /**
     * 添加选择答案信息
     * @param questionnaireChoiceAnswer 选择答案信息
     * @return 影响行数
     */
    int insertChoiceAnswer(AppQuestionnaireChoiceAnswer questionnaireChoiceAnswer);

    /**
     * 添加判断答案信息
     * @param appQuestionJudgmentAnswer 判断答案信息
     * @return 影响行数
     */
    int insertJudgmentAnswer(AppQuestionJudgmentAnswer appQuestionJudgmentAnswer);


    /**
     * 添加开放题答案信息
     * @param appQuestionnaireShortAnswer 开放题答案信息
     * @return 影响行数
     */
    int insertShortAnswer(AppQuestionnaireShortAnswer appQuestionnaireShortAnswer);

    /**
     * 添加答题人信息表
     * @param appQuestionnairePersonnel 问卷人表信息
     * @return 影响行数
     */
    int insertPersonnel(AppQuestionnairePersonnel appQuestionnairePersonnel);
}
