package com.aku.service.butlerService.impl;

import com.aku.dao.butlerService.SysQuestionnaireDao;
import com.aku.dao.resources.ResourcesImgDao;
import com.aku.model.butlerService.SearchQuestionnaire;
import com.aku.model.butlerService.SysQuestionnaire;
import com.aku.model.butlerService.SysQuestionnaireChoice;
import com.aku.model.butlerService.SysQuestionnaireTopic;
import com.aku.model.resources.ResourcesImg;
import com.aku.model.system.SysUser;
import com.aku.service.butlerService.SysQuestionnaireService;
import com.aku.vo.butlerService.VoFindByIdChoice;
import com.aku.vo.butlerService.VoFindByIdQuestionnaire;
import com.aku.vo.butlerService.VoFindByIdTopic;
import com.aku.vo.butlerService.VoQuestionnaire;
import com.aku.vo.resources.VoResourcesImg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysQuestionnaireServiceImpl implements SysQuestionnaireService {
    private static Map<String,Object> map = null;
    @Resource
    SysQuestionnaireDao sysQuestionnaireDao;
    @Resource
    ResourcesImgDao resourcesImgDao;

    @Override
    public List<VoQuestionnaire> list(SearchQuestionnaire searchQuestionnaire) {
        //查询所有调查问卷信息 （包含条件搜索）
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
            sysQuestionnaire.setIsRelease(0);
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
        //根据问卷调查主键ID查询题目信息集合
        List<VoFindByIdTopic> voFindByIdTopicList = sysQuestionnaireDao.findTopicByQuestionnaireId(id);
        if (voFindByIdTopicList != null){
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

        ResourcesImg resourcesImg = new ResourcesImg();
        //填入表名称 sysQuestionnaire
        resourcesImg.setTableName("sysQuestionnaire");
        //填入数据所属id
        resourcesImg.setDateId(id);
        //填入类型名称 问卷调查照片：questionnaireImg
        resourcesImg.setTypeName("questionnaireImg");
        //查询照片信息集合
        List<VoResourcesImg> imgByDate = resourcesImgDao.findImgByDate(resourcesImg);
        voFindByIdQuestionnaire.setVoResourcesImgList(imgByDate);
        map.put("sysQuestionnaire",voFindByIdQuestionnaire);
        return map;
    }
}
