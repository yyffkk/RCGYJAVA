package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppQuestionnaireDao;
import com.api.app.service.butler.AppQuestionnaireService;
import com.api.model.app.*;
import com.api.model.butlerService.*;
import com.api.vo.app.AppQuestionnaireChoiceVo;
import com.api.vo.app.AppQuestionnaireDetailVo;
import com.api.util.UploadUtil;
import com.api.vo.app.AppQuestionnaireTopicVo;
import com.api.vo.app.AppQuestionnaireVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AppQuestionnaireServiceImpl implements AppQuestionnaireService {
    @Resource
    AppQuestionnaireDao appQuestionnaireDao;
    private static Map<String,Object> map = null;

    @Override
    public List<AppQuestionnaireVo> list(Integer id, Integer type) {
        if (type == 1){
            //因为业主表 1是业主，问卷表 2是业主
            type = 2;
        }else if (type == 2){
            //因为业主表 2是亲属，投票表 1是全部，亲属只能看类型为全部的投票信息
            type = 1;
        }
        List<AppQuestionnaireVo> list = appQuestionnaireDao.list(type);
        if (list != null && list.size()>0){
            for (AppQuestionnaireVo questionnaireVo : list) {
                AppQuestionnairePersonnel personnel = new AppQuestionnairePersonnel();
                personnel.setQuestionnaireId(questionnaireVo.getId());
                personnel.setAnswerId(id);
                //查询是否答过卷
                List<AppQuestionnairePersonnel> personnelList = appQuestionnaireDao.findPersonnelByIds(personnel);
                if (personnelList != null && personnelList.size()>0){
                    //状态为4.已投票
                    questionnaireVo.setStatus(4);
                }else {
                    //查询时间是否处于投票时间
                    Date date = new Date();
                    if (date.getTime() < questionnaireVo.getBeginDate().getTime()){
                        //状态为1.未开始
                        questionnaireVo.setStatus(1);
                    }else if (date.getTime() > questionnaireVo.getEndDate().getTime()){
                        //状态为3.已结束
                        questionnaireVo.setStatus(3);
                    }else {
                        //状态为2.进行中
                        questionnaireVo.setStatus(2);
                    }
                }

                UploadUtil uploadUtil = new UploadUtil();
                //查询问卷照片信息
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysQuestionnaire", questionnaireVo.getId(), "questionnaireImg");
                questionnaireVo.setImgUrls(imgByDate);

                //根据问卷信息id查询相关答卷人信息
                List<Integer> ids = appQuestionnaireDao.findAnswerIdById(questionnaireVo.getId());
                if (ids != null && ids.size()>0){
                    List<VoResourcesImg> imgList = new ArrayList<>();
                    //最多只取3个头像
                    int i = 3;
                    for (Integer id2 : ids) {
                        i = i-1;
                        List<VoResourcesImg> imgByDate1 = uploadUtil.findImgByDate("userResident", id2, "headSculpture");
                        if (imgByDate1 != null && imgByDate1.size()>0){
                            imgList.add(imgByDate1.get(0));
                        }
                        if (i == 0){
                            break;
                        }
                    }
                    questionnaireVo.setHeadImgURls(imgList);
                }
            }
        }

        return list;
    }

    @Override
    public Map<String, Object> findById(Integer questionnaireId) {
        map = new HashMap<>();
        //根据问卷调查主键ID查询问卷调查信息
        AppQuestionnaireDetailVo questionnaireDetailVo = appQuestionnaireDao.findQuestionnaireById(questionnaireId);
        if (questionnaireDetailVo != null){
            //根据问卷调查主键ID查询题目信息集合
            List<AppQuestionnaireTopicVo> questionnaireTopicVoList = appQuestionnaireDao.findTopicById(questionnaireId);
            if (questionnaireTopicVoList != null && questionnaireTopicVoList.size()>0){
                for (AppQuestionnaireTopicVo topicVo : questionnaireTopicVoList) {
                    //判断是否是选择题
                    if (topicVo.getType() == 1|| topicVo.getType() == 2||topicVo.getType() == 3) {
                        //根据题目主键id查询选择项信息集合
                        List<AppQuestionnaireChoiceVo> questionnaireChoiceVoList = appQuestionnaireDao.findChoiceByTopicId(topicVo.getId());
                        //传入选择项信息集合
                        topicVo.setQuestionnaireChoiceVoList(questionnaireChoiceVoList);
                    }
                }
            }
            //传入题目信息集合
            questionnaireDetailVo.setQuestionnaireTopicVoList(questionnaireTopicVoList);
            //传入照片资源
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysQuestionnaire", questionnaireId, "questionnaireImg");
            questionnaireDetailVo.setVoResourcesImgList(imgByDate);
        }

        map.put("message","请求成功");
        map.put("data",questionnaireDetailVo);
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> submit(AppQuestionnaireSubmit appQuestionnaireSubmit, Integer id) {
        map = new HashMap<>();
        try {
            //查询该用户是否答题过
            AppQuestionnairePersonnel appQuestionnairePersonnel = new AppQuestionnairePersonnel();
            appQuestionnairePersonnel.setQuestionnaireId(appQuestionnaireSubmit.getId());
            appQuestionnairePersonnel.setAnswerId(id);
            List<AppQuestionnairePersonnel> personnelList = appQuestionnaireDao.findPersonnelByIds(appQuestionnairePersonnel);
            if (personnelList != null && personnelList.size()>0){
                //已投票
                throw new RuntimeException("已投过票");
            }else {
                //查询时间是否处于投票时间
                Date date = new Date();
                AppQuestionnaireDetailVo questionnaireVo = appQuestionnaireDao.findQuestionnaireById(appQuestionnaireSubmit.getId());
                if (date.getTime() < questionnaireVo.getBeginDate().getTime()){
                    //未开始
                    throw new RuntimeException("投票未开始");
                }else if (date.getTime() > questionnaireVo.getEndDate().getTime()){
                    //已结束
                    throw new RuntimeException("投票已结束");
                }
            }

            //对该问卷的答题人数量加一
            int update = appQuestionnaireDao.accumulationAnswerNum(appQuestionnaireSubmit.getId());
            if (update <= 0){
                throw new RuntimeException("累加答题人数失败");
            }
            //添加答题人信息表
            appQuestionnairePersonnel.setAnswerDate(new Date());
            int insert = appQuestionnaireDao.insertPersonnel(appQuestionnairePersonnel);
            if (insert <= 0){
                throw new RuntimeException("添加答题人信息失败");
            }

            //查询出所有题目-答案信息,然后遍历存储
            List<AppQuestionnaireAnswerSubmit> appQuestionnaireAnswerSubmits = appQuestionnaireSubmit.getAppQuestionnaireAnswerSubmits();
            if (appQuestionnaireAnswerSubmits != null && appQuestionnaireAnswerSubmits.size()>0){
                for (AppQuestionnaireAnswerSubmit answerSubmit : appQuestionnaireAnswerSubmits) {
                    //根据题目id查询题目信息
                    AppQuestionnaireTopicVo appQuestionnaireTopicVo = appQuestionnaireDao.findTopicByTopicId(answerSubmit.getTopicId());
                    switch (appQuestionnaireTopicVo.getType()){
                        case 1:
                            //单选
                        case 2:
                            //多选
                        case 3:
                            //单选下拉
                            List<Integer> choiceAnswer = answerSubmit.getChoiceAnswer();
                            if (choiceAnswer != null && choiceAnswer.size()>0){
                                for (Integer integer : choiceAnswer) {
                                    AppQuestionnaireChoiceAnswer questionnaireChoiceAnswer = new AppQuestionnaireChoiceAnswer();
                                    questionnaireChoiceAnswer.setQuestionnaireId(appQuestionnaireSubmit.getId());
                                    questionnaireChoiceAnswer.setQuestionnaireTopicId(answerSubmit.getTopicId());
                                    questionnaireChoiceAnswer.setQuestionnaireMultipleChoiceId(integer);
                                    questionnaireChoiceAnswer.setCreateId(id);
                                    questionnaireChoiceAnswer.setCreateDate(new Date());
                                    appQuestionnaireDao.insertChoiceAnswer(questionnaireChoiceAnswer);
                                }
                            }else {
                                throw new RuntimeException("选择题不能为空");
                            }
                            break;
                        case 4:
                            //判断题
                            List<Integer> choiceAnswer2 = answerSubmit.getChoiceAnswer();
                            if (choiceAnswer2 != null && choiceAnswer2.size()>0){
                                for (Integer integer : choiceAnswer2) {
                                    AppQuestionJudgmentAnswer appQuestionJudgmentAnswer = new AppQuestionJudgmentAnswer();
                                    appQuestionJudgmentAnswer.setQuestionnaireId(appQuestionnaireSubmit.getId());
                                    appQuestionJudgmentAnswer.setQuestionnaireTopicId(answerSubmit.getTopicId());
                                    appQuestionJudgmentAnswer.setAnswer(integer);
                                    appQuestionJudgmentAnswer.setCreateId(id);
                                    appQuestionJudgmentAnswer.setCreateDate(new Date());
                                    appQuestionnaireDao.insertJudgmentAnswer(appQuestionJudgmentAnswer);
                                }
                            }else {
                                throw new RuntimeException("判断题不能为空");
                            }
                            break;
                        case 5:
                            //开放题
                            AppQuestionnaireShortAnswer appQuestionnaireShortAnswer = new AppQuestionnaireShortAnswer();
                            appQuestionnaireShortAnswer.setQuestionnaireId(appQuestionnaireSubmit.getId());
                            appQuestionnaireShortAnswer.setQuestionnaireTopicId(answerSubmit.getTopicId());
                            appQuestionnaireShortAnswer.setAnswer(answerSubmit.getShortAnswer());
                            appQuestionnaireShortAnswer.setCreateId(id);
                            appQuestionnaireShortAnswer.setCreateDate(new Date());
                            appQuestionnaireDao.insertShortAnswer(appQuestionnaireShortAnswer);
                            break;
                        default:
                            throw new RuntimeException("答题类型有误");
                    }
                }
            }
        } catch (Exception e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","问卷调查提交成功");
        map.put("status",true);
        return map;
    }
}
