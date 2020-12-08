package com.aku.service.butlerService.impl;

import com.aku.dao.butlerService.SysQuestionnaireDao;
import com.aku.dao.resources.ResourcesImgDao;
import com.aku.model.butlerService.*;
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
    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;
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

            //上传文件
            MultipartFile file = sysQuestionnaire.getFile();
            //如果文件file不为空，则上传该文件到 ../static/img/advice目录下
            if (file != null){
                if (file.getSize() > 1024 * 1024 * 10) {
                    throw new RuntimeException("文件大小不能大于10M");
                }
                //获取文件后缀
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length());
                if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
                    throw new RuntimeException("请选择jpg,jpeg,gif,png格式的图片");
                }
                //获取保持路径
                String savePath = UPLOAD_FOLDER;
                File savePathFile = new File(savePath);
                if (!savePathFile.exists()) {
                    //若不存在该目录，则创建目录
                    savePathFile.mkdir();
                }
                //通过UUID生成唯一文件名
                String filename = UUID.randomUUID().toString().replaceAll("-","") + "." + suffix;
                try {
                    //将文件保存指定目录
                    file.transferTo(new File(savePath + filename));
                    //保存后，将文件路径存入数据库
                    ResourcesImg resourcesImg = new ResourcesImg();
                    //填入表名称 sysQuestionnaire
                    resourcesImg.setTableName("sysQuestionnaire");
                    //填入数据所属id
                    resourcesImg.setDateId(sysQuestionnaire.getId());
                    //填入类型名称 问卷调查照片：questionnaireImg
                    resourcesImg.setTypeName("questionnaireImg");
                    //填入图片路径
                    resourcesImg.setUrl(savePath + filename);
                    resourcesImg.setSize("600");
                    resourcesImg.setLongs(30);
                    resourcesImg.setParagraph(20);
                    //查询该表，该类型名称的照片数量
                    int count = resourcesImgDao.countByData(resourcesImg);
                    if (count > 0){
                        resourcesImg.setSort(count+1);
                    }else {
                        resourcesImg.setSort(1);
                    }

                    int insert2 = resourcesImgDao.insert(resourcesImg);
                    if (insert2 <= 0){
                        throw new RuntimeException("添加照片数据失败");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("保存文件异常");
                }
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
        if (voFindByIdQuestionnaire != null){
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
        }
        map.put("sysQuestionnaire",voFindByIdQuestionnaire);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(SysQuestionnaire sysQuestionnaire) {
        map = new HashMap<>();
        try {
            //先删除照片文件
            ResourcesImg resourcesImg2 = new ResourcesImg();
            //填入表名称 sysQuestionnaire
            resourcesImg2.setTableName("sysQuestionnaire");
            //填入数据所属id
            resourcesImg2.setDateId(sysQuestionnaire.getId());
            //填入类型名称 问卷调查照片：questionnaireImg
            resourcesImg2.setTypeName("questionnaireImg");

            //根据条件查询照片信息查询
            List<VoResourcesImg> imgByDate = resourcesImgDao.findImgByDate(resourcesImg2);
            if (imgByDate!=null){
                for (VoResourcesImg voResourcesImg : imgByDate) {
                    File file = new File(voResourcesImg.getUrl());
                    file.delete();
                    System.out.println("照片删除成功");
                }
            }
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

            //上传文件
            MultipartFile file = sysQuestionnaire.getFile();
            //如果文件file不为空，则上传该文件到 ../static/img/advice目录下
            if (file != null){
                if (file.getSize() > 1024 * 1024 * 10) {
                    throw new RuntimeException("文件大小不能大于10M");
                }
                //获取文件后缀
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length());
                if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
                    throw new RuntimeException("请选择jpg,jpeg,gif,png格式的图片");
                }
                //获取保持路径
                String savePath = UPLOAD_FOLDER;
                File savePathFile = new File(savePath);
                if (!savePathFile.exists()) {
                    //若不存在该目录，则创建目录
                    savePathFile.mkdir();
                }
                //通过UUID生成唯一文件名
                String filename = UUID.randomUUID().toString().replaceAll("-","") + "." + suffix;
                try {
                    //将文件保存指定目录
                    file.transferTo(new File(savePath + filename));
                    //保存后，将文件路径存入数据库
                    ResourcesImg resourcesImg = new ResourcesImg();
                    //填入表名称 sysQuestionnaire
                    resourcesImg.setTableName("sysQuestionnaire");
                    //填入数据所属id
                    resourcesImg.setDateId(sysQuestionnaire.getId());
                    //填入类型名称 问卷调查照片：questionnaireImg
                    resourcesImg.setTypeName("questionnaireImg");
                    //填入图片路径
                    resourcesImg.setUrl(savePath + filename);
                    resourcesImg.setSize("600");
                    resourcesImg.setLongs(30);
                    resourcesImg.setParagraph(20);
                    //查询该表，该类型名称的照片数量
                    int count = resourcesImgDao.countByData(resourcesImg);
                    if (count > 0){
                        resourcesImg.setSort(count+1);
                    }else {
                        resourcesImg.setSort(1);
                    }

                    int insert2 = resourcesImgDao.insert(resourcesImg);
                    if (insert2 <= 0){
                        throw new RuntimeException("添加照片数据失败");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("保存文件异常");
                }
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
                //先删除照片文件
                ResourcesImg resourcesImg = new ResourcesImg();
                //填入表名称 sysQuestionnaire
                resourcesImg.setTableName("sysQuestionnaire");
                //填入数据所属id
                resourcesImg.setDateId(id);
                //填入类型名称 问卷调查照片：questionnaireImg
                resourcesImg.setTypeName("questionnaireImg");

                List<VoResourcesImg> imgByDate = resourcesImgDao.findImgByDate(resourcesImg);
                if (imgByDate!=null){
                    for (VoResourcesImg voResourcesImg : imgByDate) {
                        File file = new File(voResourcesImg.getUrl());
                        file.delete();
                        System.out.println("照片删除成功");
                    }
                }
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
            //查询出所有题目-答案信息,然后遍历存储
            List<SysQuestionnaireAnswerSubmit> sysQuestionnaireTopicSubmitList = sysQuestionnaireSubmit.getSysQuestionnaireTopicSubmitList();
            if (sysQuestionnaireTopicSubmitList != null){
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
}
