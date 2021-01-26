package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppQuestionnaireDao;
import com.api.app.service.butler.AppQuestionnaireService;
import com.api.model.app.AppQuestionnairePersonnel;
import com.api.util.UploadUtil;
import com.api.vo.app.AppQuestionnaireVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
}
