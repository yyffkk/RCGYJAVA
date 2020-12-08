package com.api.dao.butlerService;

import com.api.model.butlerService.*;
import com.api.vo.butlerService.*;

import java.util.List;

public interface SysQuestionnaireDao {
    /**
     * 查询所有问卷调查信息 （包含条件搜索）
     * @param searchQuestionnaire 搜索条件
     * @return 问卷调查信息集合
     */
    List<VoQuestionnaire> list(SearchQuestionnaire searchQuestionnaire);

    /**
     * 添加问卷调查信息，返回主键id
     * @param sysQuestionnaire 问卷调查信息
     * @return 影响行数
     */
    int insertQuestionnaire(SysQuestionnaire sysQuestionnaire);

    /**
     * 添加题目信息，返回主键id
     * @param sysQuestionnaireTopic 题目信息
     * @return 影响行数
     */
    int insertQuestionnaireTopic(SysQuestionnaireTopic sysQuestionnaireTopic);

    /**
     * 添加选择题选项
     * @param sysQuestionnaireChoice 选择题选项
     * @return 影响行数
     */
    int insertQuestionnaireChoice(SysQuestionnaireChoice sysQuestionnaireChoice);

    /**
     * 根据问卷调查主键ID查询问卷调查信息
     * @param id 问卷调查主键ID
     * @return 问卷调查信息
     */
    VoFindByIdQuestionnaire findById(Integer id);

    /**
     * 根据问卷调查主键ID查询题目信息集合
     * @param id 问卷调查主键ID
     * @return 题目信息集合
     */
    List<VoFindByIdTopic> findTopicByQuestionnaireId(Integer id);

    /**
     * 根据题目主键id查询选择项信息集合
     * @param id 题目主键id
     * @return 选择项信息集合
     */
    List<VoFindByIdChoice> findChoiceByTopicId(Integer id);

    /**
     * 根据问卷调查主键ID删除选择项信息
     * @param id 问卷调查主键ID
     * @return 影响行数
     */
    int deleteChoice(Integer id);
    /**
     * 根据问卷调查主键ID删除题目信息
     * @param id 问卷调查主键ID
     * @return 影响行数
     */
    int deleteTopic(Integer id);
    /**
     * 根据问卷调查主键ID真删除问卷调查信息
     * @param id 问卷调查主键ID
     * @return 影响行数
     */
    int deleteQuestionnaire(Integer id);
    /**
     * 根据问卷调查主键ID假删除问卷调查信息
     * @param id 问卷调查主键ID
     * @return 影响行数
     */
    int falseDeleteQuestionnaire(int id);

    /**
     * 添加选择答案信息
     * @param sysQuestionChoiceAnswer 选择答案信息
     * @return 影响行数
     */
    int insertChoiceAnswer(SysQuestionChoiceAnswer sysQuestionChoiceAnswer);
    /**
     * 添加判断答案信息
     * @param sysQuestionJudgmentAnswer 判断答案信息
     * @return 影响行数
     */
    int insertJudgmentAnswer(SysQuestionJudgmentAnswer sysQuestionJudgmentAnswer);
    /**
     * 添加开放题答案信息
     * @param sysQuestionnaireShortAnswer 开放题答案信息
     * @return 影响行数
     */
    int insertShortAnswer(SysQuestionnaireShortAnswer sysQuestionnaireShortAnswer);

    /**
     * 根据题目id查询题目信息
     * @param topicId 题目id
     * @return 题目信息
     */
    SysQuestionnaireTopic findTopicByTopicId(Integer topicId);

    /**
     * 根据问卷调查主键id对答题人员数量进行累加
     * @param id 问卷调查主键id
     * @return 影响行数
     */
    int accumulationAnswerNum(Integer id);

    /**
     * 根据答卷人id查询开发题信息
     * @param id 答卷人id
     * @return 开发题信息
     */
    SysQuestionnaireShortAnswer findShortAnswerByCreateId(Integer id);

    /**
     * 根据问卷调查主键id查询问卷调查报表信息
     * @param id 问卷调查主键id
     * @return 问卷调查报表信息
     */
    VoReportQuestionnaire findReportById(Integer id);

    /**
     * 根据问卷调查主键id查询问卷调查题目报表信息
     * @param id 问卷调查主键id
     * @return 问卷调查题目报表信息
     */
    List<VoReportQuestionnaireTopic> findReportTopicByQId(Integer id);

    /**
     * 根据题目报表主键id查询选择项报表信息
     * @param id 题目报表主键id
     * @return 选择项报表信息集合
     */
    List<VoReportQuestionnaireChoice> findReportChoiceByTopicId(Integer id);

    /**
     * 根据选择题选项主键id查询该选择题的人数数量(需要去重)
     * @param id 选择题选项主键id
     * @return 该选择题的人数数量
     */
    int countChoice(Integer id);

    /**
     * 根据题目主键id查询该题目的人数数量(需要去重)
     * @param id 题目主键id
     * @return 该题目的人数数量
     */
    int countTopic(Integer id);

    /**
     * 根据题目报表主键id查询选【对】的数量
     * @param id 题目主键id
     * @return 选【对】的数量
     */
    int countJudgmentTrueByTId(Integer id);

    /**
     * 根据题目报表主键id查询选【错】的数量
     * @param id 题目主键id
     * @return 选【错】的数量
     */
    int countJudgmentFalseByTId(Integer id);
}
