package com.api.app.dao.butler;

import com.api.model.app.SearchAppAdvice;
import com.api.model.app.UserIdAndAdviceId;
import com.api.model.butlerService.SysAdvice;
import com.api.model.butlerService.SysAdviceDetail;
import com.api.vo.app.AppAdviceContentVo;
import com.api.vo.app.AppAdviceVo;

import java.util.List;

public interface AppAdviceDao {
    /**
     * 查询所有的app建议咨询信息（包含条件搜索 type 【类型(1.咨询，2.建议，3.投诉，4.表扬)】）
     * @param searchAppAdvice 建议咨询/投诉表扬 搜索条件
     * @return app建议咨询信息集合
     */
    List<AppAdviceVo> list(SearchAppAdvice searchAppAdvice);

    /**
     * 添加建议咨询/投诉表扬 信息
     * @param sysAdvice 咨询建议表信息
     * @return 影响行数
     */
    int insert(SysAdvice sysAdvice);

    /**
     * 根据 用户id 和 咨询建议主键id 查询 咨询建议反馈文本详情
     * @param adviceId 咨询建议主键id
     * @return app咨询建议反馈文本内容集合
     */
    List<AppAdviceContentVo> findAdviceDetailByAdviceId(Integer adviceId);

    /**
     * 根据 咨询建议主键id 查询 咨询建议 信息
     * @param adviceId 咨询建议主键id
     * @return 咨询建议 信息
     */
    AppAdviceVo findAdviceByAdviceId(Integer adviceId);

    /***
     * 继续提问
     * @param sysAdviceDetail 建议反馈表信息
     * @return 影响行数
     */
    int reQuestion(SysAdviceDetail sysAdviceDetail);

    /**
     * 添加打分信息
     * @param sysAdvice 咨询建议表信息
     * @return 影响行数
     */
    int evaluate(SysAdvice sysAdvice);

    /**
     * app批量删除咨询建议信息
     * @param userIdAndAdviceId 用户id 和 咨询建议主键id
     * @return 影响行数
     */
    int falseDelete(UserIdAndAdviceId userIdAndAdviceId);
}
