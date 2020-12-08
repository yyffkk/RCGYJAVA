package com.aku.dao.butlerService;

import com.aku.model.butlerService.*;
import com.aku.vo.butlerService.VoFindByIdChoice;
import com.aku.vo.butlerService.VoFindByIdQuestionnaire;
import com.aku.vo.butlerService.VoFindByIdTopic;
import com.aku.vo.butlerService.VoQuestionnaire;

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
}
