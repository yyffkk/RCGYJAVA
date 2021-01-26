package com.api.app.dao.butler;

import com.api.model.app.AppQuestionnairePersonnel;
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
}
