package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppEventVotingDao;
import com.api.app.service.butler.AppEventVotingService;
import com.api.model.app.AppVotePersonnel;
import com.api.model.butlerService.SysVote;
import com.api.util.UploadUtil;
import com.api.vo.app.AppEventVotingVo;
import com.api.vo.app.AppVoteCandidateVo;
import com.api.vo.app.AppVoteDetailVo;
import com.api.vo.app.AppVotePersonnelVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AppEventVotingServiceImpl implements AppEventVotingService {
    @Resource
    AppEventVotingDao appEventVotingDao;
    private static Map<String,Object> map = null;

    @Override
    public List<AppEventVotingVo> list(Integer id) {
        List<AppEventVotingVo> list = appEventVotingDao.list();
        if (list != null && list.size()>0){
            for (AppEventVotingVo appEventVotingVo : list) {
                AppVotePersonnel appVotePersonnel = new AppVotePersonnel();
                appVotePersonnel.setVoteId(appEventVotingVo.getId());
                appVotePersonnel.setVoterId(id);
                //查询是否投过票
                List<AppVotePersonnelVo> appVotePersonnelVo = appEventVotingDao.findPersonnelByIds(appVotePersonnel);
                if (appVotePersonnelVo != null && appVotePersonnelVo.size()>0){
                    //状态为4.已投票
                    appEventVotingVo.setStatus(4);
                }else {
                    //查询时间是否处于投票时间
                    Date date = new Date();
                    if (date.getTime() < appEventVotingVo.getBeginDate().getTime()){
                        //状态为1.未开始
                        appEventVotingVo.setStatus(1);
                    }else if (date.getTime() > appEventVotingVo.getEndDate().getTime()){
                        //状态为3.已结束
                        appEventVotingVo.setStatus(3);
                    }else {
                        //状态为2.进行中
                        appEventVotingVo.setStatus(2);
                    }
                }


                UploadUtil uploadUtil = new UploadUtil();
                //查询投票照片信息
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysVote", appEventVotingVo.getId(), "voteImg");
                appEventVotingVo.setImgUrls(imgByDate);
                //根据投票信息id查询相关投票人信息
                List<Integer> ids = appEventVotingDao.findVoterIdById(appEventVotingVo.getId());
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
                    appEventVotingVo.setHeadImgURls(imgList);
                }
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> voteDetail(Integer voteId, Integer id) {
        map = new HashMap<>();
        UploadUtil uploadUtil = new UploadUtil();
        AppVoteDetailVo appVoteDetailVo = appEventVotingDao.voteDetail(voteId);

        if (appVoteDetailVo != null){
            //查询所有候选人投票总数
            int sumTotal = appEventVotingDao.sumTotalByVoteId(voteId);
            appVoteDetailVo.setTotals(sumTotal);

            AppVotePersonnel appVotePersonnel = new AppVotePersonnel();
            appVotePersonnel.setVoteId(voteId);
            appVotePersonnel.setVoterId(id);
            //查询是否投过票
            List<AppVotePersonnelVo> appVotePersonnelVo = appEventVotingDao.findPersonnelByIds(appVotePersonnel);
            if (appVotePersonnelVo != null && appVotePersonnelVo.size()>0){
                //状态为4.已投票
                appVoteDetailVo.setStatus(4);
            }else {
                //查询时间是否处于投票时间
                SysVote sysVote = appEventVotingDao.findVoteById(voteId);
                Date date = new Date();
                if (date.getTime() < sysVote.getBeginDate().getTime()){
                    //状态为1.未开始
                    appVoteDetailVo.setStatus(1);
                }else if (date.getTime() > sysVote.getEndDate().getTime()){
                    //状态为3.已结束
                    appVoteDetailVo.setStatus(3);
                }else {
                    //状态为2.进行中
                    appVoteDetailVo.setStatus(2);
                }
            }

            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysVote", appVoteDetailVo.getId(), "voteImg");
            appVoteDetailVo.setImgUrls(imgByDate);
        }
        //查询投票候选人信息
        List<AppVoteCandidateVo> appVoteCandidateVos = appEventVotingDao.findCandidateByVoteId(voteId);
        if (appVoteCandidateVos != null && appVoteCandidateVos.size()>0){
            for (AppVoteCandidateVo candidateVo : appVoteCandidateVos) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysVoteCandidate", candidateVo.getId(), "voteCandidateImg");
                candidateVo.setImgUrls(imgByDate);
            }
        }
        appVoteDetailVo.setAppVoteCandidateVos(appVoteCandidateVos);
        map.put("message","请求成功");
        map.put("data",appVoteDetailVo);
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> vote(AppVotePersonnel appVotePersonnel) {
        map = new HashMap<>();
        try {
            //查询时间是否处于投票时间
            SysVote sysVote = appEventVotingDao.findVoteById(appVotePersonnel.getVoteId());
            Date date = new Date();
            if (date.getTime() < sysVote.getBeginDate().getTime()){
                throw new RuntimeException("投票还未开始");
            }else if (date.getTime() > sysVote.getEndDate().getTime()){
                throw new RuntimeException("投票已结束");
            }
            //查询用户是否投票过
            List<AppVotePersonnelVo> appVotePersonnelVo = appEventVotingDao.findPersonnelByIds(appVotePersonnel);
            if (appVotePersonnelVo != null && appVotePersonnelVo.size()>0){
                throw new RuntimeException("用户已投票");
            }
            //用户投票
            appVotePersonnel.setVoterDate(date);
            int insert = appEventVotingDao.insertVotePersonnel(appVotePersonnel);
            if (insert <= 0){
                throw new RuntimeException("投票失败");
            }
            //当前投票候选人，投票总数加一
            int update = appEventVotingDao.voteCandidateAdd(appVotePersonnel);
            if (update <= 0){
                throw new RuntimeException("投票失败");
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
        map.put("message","投票成功");
        map.put("status",true);
        return map;
    }
}
