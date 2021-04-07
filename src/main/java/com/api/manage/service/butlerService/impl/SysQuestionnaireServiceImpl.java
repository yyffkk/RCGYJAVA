package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysQuestionnaireDao;
import com.api.manage.dao.resources.ResourcesImgDao;
import com.api.model.butlerService.*;
import com.api.model.resources.ResourcesImg;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.butlerService.SysQuestionnaireService;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.*;
import com.api.vo.resources.VoResourcesImg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

@Service
public class SysQuestionnaireServiceImpl implements SysQuestionnaireService {
    private static Map<String,Object> map = null;
    @Value("${prop.upload-advice}")
    private String UPLOAD_ADVICE;
    @Resource
    SysQuestionnaireDao sysQuestionnaireDao;
    @Resource
    ResourcesImgDao resourcesImgDao;

    @Override
    public List<VoQuestionnaire> list(SearchQuestionnaire searchQuestionnaire) {
        //查询所有调查问卷信息 （包含条件搜索）
        searchQuestionnaire.setNowDate(new Date());
        List<VoQuestionnaire> list = sysQuestionnaireDao.list(searchQuestionnaire);
        if (list != null){
            for (VoQuestionnaire voQuestionnaire : list) {
                //遍历判断对应状态(1.未开始，2.正在进行，3.已结束)
                if (new Date().getTime() < voQuestionnaire.getBeginDate().getTime()){
                    voQuestionnaire.setStatus(1);
                }else if (new Date().getTime() > voQuestionnaire.getEndDate().getTime()){
                    voQuestionnaire.setStatus(3);
                }else {
                    voQuestionnaire.setStatus(2);
                }
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysQuestionnaire sysQuestionnaire) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        try {
            //填入创建人
            sysQuestionnaire.setCreateId(sysUser.getId());
            //填入创建时间
            sysQuestionnaire.setCreateDate(new Date());
            //填入是否删除 1.非删，0.删除
            sysQuestionnaire.setIsDelete(1);
            //填入是否发布（默认未发布）
            if (sysQuestionnaire.getIsRelease() == null){
                sysQuestionnaire.setIsRelease(0);
            }
            //填入答题人数（初始为0）
            sysQuestionnaire.setAnswerNum(0);

            //添加问卷调查信息，返回主键id
            int insert1 = sysQuestionnaireDao.insertQuestionnaire(sysQuestionnaire);
            if (insert1 <= 0){
                throw new RuntimeException("添加问卷调查信息失败");
            }
            List<SysQuestionnaireTopic> sysQuestionnaireTopicList = sysQuestionnaire.getSysQuestionnaireTopicList();
            if (sysQuestionnaireTopicList != null){
                for (SysQuestionnaireTopic sysQuestionnaireTopic : sysQuestionnaireTopicList) {
                    //填入问卷id
                    sysQuestionnaireTopic.setQuestionnaireId(sysQuestionnaire.getId());
                    //填入创建人
                    sysQuestionnaireTopic.setCreateId(sysUser.getId());
                    //填入创建时间
                    sysQuestionnaireTopic.setCreateDate(new Date());
                    //添加题目信息，返回主键id
                    int insert2 = sysQuestionnaireDao.insertQuestionnaireTopic(sysQuestionnaireTopic);
                    if (insert2 <= 0){
                        throw new RuntimeException("添加题目信息失败");
                    }

                    //判断是否是选择题（1.单选，2.多选,3.下拉单选）
                    if (sysQuestionnaireTopic.getType() == 1||sysQuestionnaireTopic.getType() == 2||sysQuestionnaireTopic.getType() == 3){
                        //查询所有选择题选项
                        List<SysQuestionnaireChoice> sysQuestionnaireChoiceList = sysQuestionnaireTopic.getSysQuestionnaireChoiceList();
                        if (sysQuestionnaireChoiceList != null){
                            for (SysQuestionnaireChoice sysQuestionnaireChoice : sysQuestionnaireChoiceList) {
                                //填入问卷id
                                sysQuestionnaireChoice.setQuestionnaireId(sysQuestionnaire.getId());
                                //填入题目id
                                sysQuestionnaireChoice.setQuestionnaireTopicId(sysQuestionnaireTopic.getId());
                                //填入创建人
                                sysQuestionnaireChoice.setCreateId(sysUser.getId());
                                //填入创建时间
                                sysQuestionnaireChoice.setCreateDate(new Date());
                                //添加选择题选项
                                int insert3 = sysQuestionnaireDao.insertQuestionnaireChoice(sysQuestionnaireChoice);
                                if (insert3 <= 0){
                                    throw new RuntimeException("添加选择题选项失败");
                                }
                            }
                        }
                    }
                }
            } else {
                throw new RuntimeException("该问卷没有题目信息");
            }

            //上传文件到数据库
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(sysQuestionnaire.getFiles(),"sysQuestionnaire",sysQuestionnaire.getId(),"coverPhoto","600",30,20);
        } catch (RuntimeException e) {
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

        map.put("message","新增问卷调查成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();

        //根据问卷调查主键ID查询问卷调查信息
        VoFindByIdQuestionnaire voFindByIdQuestionnaire = sysQuestionnaireDao.findById(id);
        if (voFindByIdQuestionnaire != null){
            //根据问卷调查主键ID查询题目信息集合
            List<VoFindByIdTopic> voFindByIdTopicList = sysQuestionnaireDao.findTopicByQuestionnaireId(id);
            if (voFindByIdTopicList != null && voFindByIdTopicList.size()>0){
                for (VoFindByIdTopic voFindByIdTopic : voFindByIdTopicList) {
                    //判断是否是选择题
                    if (voFindByIdTopic.getType() == 1|| voFindByIdTopic.getType() == 2||voFindByIdTopic.getType() == 3){
                        //根据题目主键id查询选择项信息集合
                        List<VoFindByIdChoice> voFindByIdChoiceList = sysQuestionnaireDao.findChoiceByTopicId(voFindByIdTopic.getId());
                        //传入选择项信息集合
                        voFindByIdTopic.setVoFindByIdChoiceList(voFindByIdChoiceList);
                    }
                }
            }
            //传入题目信息集合
            voFindByIdQuestionnaire.setVoFindByIdTopicList(voFindByIdTopicList);

            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysQuestionnaire", id, "coverPhoto");
            voFindByIdQuestionnaire.setVoResourcesImgList(imgByDate);
        }
        map.put("sysQuestionnaire",voFindByIdQuestionnaire);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(SysQuestionnaire sysQuestionnaire) {
        map = new HashMap<>();
        try {
            UploadUtil uploadUtil = new UploadUtil();
            //先删除照片文件
            uploadUtil.delete("sysQuestionnaire",sysQuestionnaire.getId(),"coverPhoto");

            //再删除问卷调查
            //删除选择项
            sysQuestionnaireDao.deleteChoice(sysQuestionnaire.getId());
            //删除题目
            sysQuestionnaireDao.deleteTopic(sysQuestionnaire.getId());
            //删除问卷
            sysQuestionnaireDao.deleteQuestionnaire(sysQuestionnaire.getId());

            //再添加问卷调查和上传文件
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();
            //填入创建人
            sysQuestionnaire.setCreateId(sysUser.getId());
            //填入创建时间
            sysQuestionnaire.setCreateDate(new Date());
            //填入是否删除 1.非删，0.删除
            sysQuestionnaire.setIsDelete(1);
            //填入是否发布（默认未发布）
            if (sysQuestionnaire.getIsRelease() == null){
                sysQuestionnaire.setIsRelease(0);
            }
            //填入答题人数（初始为0）
            sysQuestionnaire.setAnswerNum(0);

            //添加问卷调查信息，返回主键id
            int insert1 = sysQuestionnaireDao.insertQuestionnaire(sysQuestionnaire);
            if (insert1 <= 0){
                throw new RuntimeException("添加问卷调查信息失败");
            }
            List<SysQuestionnaireTopic> sysQuestionnaireTopicList = sysQuestionnaire.getSysQuestionnaireTopicList();
            if (sysQuestionnaireTopicList != null){
                for (SysQuestionnaireTopic sysQuestionnaireTopic : sysQuestionnaireTopicList) {
                    //填入问卷id
                    sysQuestionnaireTopic.setQuestionnaireId(sysQuestionnaire.getId());
                    //填入创建人
                    sysQuestionnaireTopic.setCreateId(sysUser.getId());
                    //填入创建时间
                    sysQuestionnaireTopic.setCreateDate(new Date());
                    //添加题目信息，返回主键id
                    int insert2 = sysQuestionnaireDao.insertQuestionnaireTopic(sysQuestionnaireTopic);
                    if (insert2 <= 0){
                        throw new RuntimeException("添加题目信息失败");
                    }

                    //判断是否是选择题（1.单选，2.多选,3.下拉单选）
                    if (sysQuestionnaireTopic.getType() == 1||sysQuestionnaireTopic.getType() == 2||sysQuestionnaireTopic.getType() == 3){
                        //查询所有选择题选项
                        List<SysQuestionnaireChoice> sysQuestionnaireChoiceList = sysQuestionnaireTopic.getSysQuestionnaireChoiceList();
                        if (sysQuestionnaireChoiceList != null){
                            for (SysQuestionnaireChoice sysQuestionnaireChoice : sysQuestionnaireChoiceList) {
                                //填入问卷id
                                sysQuestionnaireChoice.setQuestionnaireId(sysQuestionnaire.getId());
                                //填入题目id
                                sysQuestionnaireChoice.setQuestionnaireTopicId(sysQuestionnaireTopic.getId());
                                //填入创建人
                                sysQuestionnaireChoice.setCreateId(sysUser.getId());
                                //填入创建时间
                                sysQuestionnaireChoice.setCreateDate(new Date());
                                //添加选择题选项
                                int insert3 = sysQuestionnaireDao.insertQuestionnaireChoice(sysQuestionnaireChoice);
                                if (insert3 <= 0){
                                    throw new RuntimeException("添加选择题选项失败");
                                }
                            }
                        }
                    }
                }
            } else {
                throw new RuntimeException("该问卷没有题目信息");
            }

            //上传文件到数据库
            uploadUtil.saveUrlToDB(sysQuestionnaire.getFiles(),"sysQuestionnaire",sysQuestionnaire.getId(),"coverPhoto","600",30,20);
        } catch (RuntimeException e) {
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

        map.put("message","修改问卷调查成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                UploadUtil uploadUtil = new UploadUtil();
                //先删除照片文件
                uploadUtil.delete("sysQuestionnaire",id,"coverPhoto");
                //再删除问卷调查
                //删除选择项
                sysQuestionnaireDao.deleteChoice(id);
                //删除题目
                sysQuestionnaireDao.deleteTopic(id);
                //删除问卷
                sysQuestionnaireDao.deleteQuestionnaire(id);
            }
        } catch (Exception e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message","批量删除问卷调查失败");
            map.put("status",false);
            return map;
        }
        map.put("message","批量删除问卷调查成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> falseDelete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //假删除问卷
                int update = sysQuestionnaireDao.falseDeleteQuestionnaire(id);
                if (update <= 0){
                    throw new RuntimeException("批量删除问卷调查失败");
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
        map.put("message","批量删除问卷调查成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> sysQuestionnaireSubmit(SysQuestionnaireSubmit sysQuestionnaireSubmit) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        try {
            //对该问卷的答题人数量加一
            int update = sysQuestionnaireDao.accumulationAnswerNum(sysQuestionnaireSubmit.getId());
            if (update <= 0){
                throw new RuntimeException("累加答题人数失败");
            }
            //查询出所有题目-答案信息,然后遍历存储
            List<SysQuestionnaireAnswerSubmit> sysQuestionnaireTopicSubmitList = sysQuestionnaireSubmit.getSysQuestionnaireTopicSubmitList();
            if (sysQuestionnaireTopicSubmitList != null && sysQuestionnaireTopicSubmitList.size()>0){
                for (SysQuestionnaireAnswerSubmit answerSubmit : sysQuestionnaireTopicSubmitList) {
                    //根据题目id查询题目信息
                    SysQuestionnaireTopic sysQuestionnaireTopic = sysQuestionnaireDao.findTopicByTopicId(answerSubmit.getTopicId());
                    switch (sysQuestionnaireTopic.getType()){
                        case 1:
                            //单选
                        case 2:
                            //多选
                        case 3:
                            //单选下拉
                            List<Integer> choiceAnswer = answerSubmit.getChoiceAnswer();
                            if (choiceAnswer != null){
                                for (Integer integer : choiceAnswer) {
                                    SysQuestionChoiceAnswer sysQuestionChoiceAnswer = new SysQuestionChoiceAnswer();
                                    sysQuestionChoiceAnswer.setQuestionnaireId(sysQuestionnaireSubmit.getId());
                                    sysQuestionChoiceAnswer.setQuestionnaireTopicId(answerSubmit.getTopicId());
                                    sysQuestionChoiceAnswer.setQuestionnaireMultipleChoiceId(integer);
                                    sysQuestionChoiceAnswer.setCreateId(sysUser.getId());
                                    sysQuestionChoiceAnswer.setCreateDate(new Date());
                                    sysQuestionnaireDao.insertChoiceAnswer(sysQuestionChoiceAnswer);
                                }
                            }else {
                                throw new RuntimeException("选择题不能为空");
                            }
                            break;
                        case 4:
                            //判断题
                            List<Integer> choiceAnswer2 = answerSubmit.getChoiceAnswer();
                            for (Integer integer : choiceAnswer2) {
                                SysQuestionJudgmentAnswer sysQuestionJudgmentAnswer = new SysQuestionJudgmentAnswer();
                                sysQuestionJudgmentAnswer.setQuestionnaireId(sysQuestionnaireSubmit.getId());
                                sysQuestionJudgmentAnswer.setQuestionnaireTopicId(answerSubmit.getTopicId());
                                sysQuestionJudgmentAnswer.setAnswer(integer);
                                sysQuestionJudgmentAnswer.setCreateId(sysUser.getId());
                                sysQuestionJudgmentAnswer.setCreateDate(new Date());
                                sysQuestionnaireDao.insertJudgmentAnswer(sysQuestionJudgmentAnswer);
                            }
                            break;
                        case 5:
                            //开放题
                            SysQuestionnaireShortAnswer sysQuestionnaireShortAnswer = new SysQuestionnaireShortAnswer();
                            sysQuestionnaireShortAnswer.setQuestionnaireId(sysQuestionnaireSubmit.getId());
                            sysQuestionnaireShortAnswer.setQuestionnaireTopicId(answerSubmit.getTopicId());
                            sysQuestionnaireShortAnswer.setAnswer(answerSubmit.getShortAnswer());
                            sysQuestionnaireShortAnswer.setCreateId(sysUser.getId());
                            sysQuestionnaireShortAnswer.setCreateDate(new Date());
                            sysQuestionnaireDao.insertShortAnswer(sysQuestionnaireShortAnswer);
                            break;
                        default:
                            throw new RuntimeException("答题类型有误");
                    }
                }
            }
        } catch (RuntimeException e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message","问卷调查提交失败");
            map.put("status",false);
            return map;
        }
        map.put("message","问卷调查提交成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> reportAnalysis(Integer id) {
        map = new HashMap<>();
        //根据问卷调查主键id查询问卷调查报表信息
        VoReportQuestionnaire reportQuestionnaire = sysQuestionnaireDao.findReportById(id);
        //根据问卷调查主键id查询问卷调查题目报表信息集合
        List<VoReportQuestionnaireTopic> voReportQuestionnaireTopicList = sysQuestionnaireDao.findReportTopicByQId(id);
        if (voReportQuestionnaireTopicList != null){
            //迭代器遍历题目报表，并删除开放题信息
            Iterator<VoReportQuestionnaireTopic> iterator = voReportQuestionnaireTopicList.iterator();
            while (iterator.hasNext()){
                VoReportQuestionnaireTopic topic = iterator.next();
                //查询该题目的各个选择项人数
                switch (topic.getType()){
                    case 1:
                        //单选
                    case 2:
                        //多选
                    case 3:
                        //单选下拉
                        //根据题目报表主键id查询选择项报表信息
                        List<VoReportQuestionnaireChoice> voReportQuestionnaireChoiceList = sysQuestionnaireDao.findReportChoiceByTopicId(topic.getId());
                        if (voReportQuestionnaireChoiceList != null){
                            //遍历选择项信息
                            for (VoReportQuestionnaireChoice choice : voReportQuestionnaireChoiceList) {
                                //根据选择题选项主键id查询该选择题的人数数量(需要去重)
                                int count = sysQuestionnaireDao.countChoice(choice.getId());
                                //传入该选择项的人数信息
                                choice.setAnswerNum(count);
                            }
                        }
                        //传入选择项信息集合
                        topic.setReportQuestionnaireChoiceList(voReportQuestionnaireChoiceList);
                        //根据题目主键报表id查询该题目的人数数量(需要去重)
                        int count2 = sysQuestionnaireDao.countTopic(topic.getId());
                        //传入该题目的选择人数
                        topic.setAnswerNum(count2);
                        break;
                    case 4:
                        //判断题
                        //根据题目主键报表id查询选【对】的数量
                        int count3 = sysQuestionnaireDao.countJudgmentTrueByTId(topic.getId());
                        //根据题目主键报表id查询选【错】的数量
                        int count4 = sysQuestionnaireDao.countJudgmentFalseByTId(topic.getId());
                        //传入选【对】的数量
                        topic.setTrueNum(count3);
                        //传入选【错】的数量
                        topic.setFalseNum(count4);
                        //传入该题目的选择人数
                        topic.setAnswerNum(count3+count4);
                        break;
                    case 5:
                        //开放题
//                        iterator.remove();
                        //查询开放题的答题人数,开放题只需查答题人数，内容，另外页面查
                        int count5 = sysQuestionnaireDao.countShort(topic.getId());
                        topic.setAnswerNum(count5);
                        break;
                    default:
                        System.out.println("数据有误");
                        break;
                }
            }
        }
        //传入问卷调查题目报表信息集合
        reportQuestionnaire.setReportQuestionnaireTopicList(voReportQuestionnaireTopicList);
        map.put("reportQuestionnaire",reportQuestionnaire);
        return map;
    }

    @Override
    public List<VoReportQuestionnaireShort> listShortAnswer(SearchShortAnswer searchShortAnswer) {
        return sysQuestionnaireDao.listShortAnswer(searchShortAnswer);
    }
}
