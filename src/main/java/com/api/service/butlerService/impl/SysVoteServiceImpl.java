package com.api.service.butlerService.impl;

import com.api.dao.butlerService.SysVoteDao;
import com.api.dao.resources.ResourcesImgDao;
import com.api.model.butlerService.SearchVote;
import com.api.model.butlerService.SysVote;
import com.api.model.butlerService.SysVoteCandidate;
import com.api.model.resources.ResourcesImg;
import com.api.model.system.SysUser;
import com.api.service.butlerService.SysVoteService;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.VoFindByIdVote;
import com.api.vo.butlerService.VoFindByIdVoteCandidate;
import com.api.vo.butlerService.VoVote;
import com.api.vo.resources.VoResourcesImg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysVoteServiceImpl implements SysVoteService {
    private static Map<String,Object> map = null;
    @Value("${prop.upload-vote-title}")
    private String UPLOAD_VOTE_TITLE;
    @Value("${prop.upload-vote-candidate}")
    private String UPLOAD_VOTE_CANDIDATE;
    @Resource
    SysVoteDao sysVoteDao;
    @Resource
    ResourcesImgDao resourcesImgDao;

    @Override
    public List<VoVote> list(SearchVote searchVote) {
        List<VoVote> list = sysVoteDao.list(searchVote);
        if (list!=null){
            for (VoVote voVote : list) {
                //更新（修正）投票状态(初始是未进行状态)
                //如果状态为已结束，就不需要更新
                if (voVote.getStatus() != 3){
                    if (new Date().getTime() < voVote.getBeginDate().getTime()){
                        //小于开始时间，不更新，因为初始为未开始->进行中->已结束
                    } else if (new Date().getTime() > voVote.getEndDate().getTime() ){
                        //超过结束时间，更新到3.已结束
                        voVote.setStatus(3);
                        sysVoteDao.updateStatus(voVote);
                    }else {
                        //大于开始时间，小于结束时间时,如果状态为1.未开始，则更新到2.进行中
                        if (voVote.getStatus() == 1){
                            //更新到2.进行中
                            voVote.setStatus(2);
                            sysVoteDao.updateStatus(voVote);
                        }
                    }
                }


                //根据投票主键id查询候选人数量
                int count = sysVoteDao.countVoteCandidate(voVote.getId());
                //传入候选人数量
                voVote.setVotePersonnelNum(count);
                //判断投票状态是否为3.已结束（其他状态，投票结果都为null）
                if (voVote.getStatus() == 3){
                    //根据投票主键id查询出最高投票数的候选人信息
                    SysVoteCandidate sysVoteCandidate = sysVoteDao.maxVoteCandidate(voVote.getId());
                    //传入投票结果
                    if (sysVoteCandidate != null){
                        voVote.setVoteResult(sysVoteCandidate.getName()+"："+sysVoteCandidate.getTotal()+"票");
                    }else {
                        voVote.setVoteResult("无人投票");
                    }
                }
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        //根据投票主键id查询投票信息
        VoFindByIdVote voFindByIdVote = sysVoteDao.findById(id);
        if (voFindByIdVote != null){
            //查询照片信息集合
            ResourcesImg resourcesImg = new ResourcesImg();
            //填入表名称 sysVote
            resourcesImg.setTableName("sysVote");
            //填入数据所属id
            resourcesImg.setDateId(id);
            //填入类型名称 咨询建议照片：VoteImg
            resourcesImg.setTypeName("VoteImg");
            //根据条件查询照片信息集合
            List<VoResourcesImg> imgByDate = resourcesImgDao.findImgByDate(resourcesImg);
            //传入 照片信息集合
            voFindByIdVote.setImgUrls(imgByDate);
            //根据投票主键id查询候选人信息集合
            List<VoFindByIdVoteCandidate> voFindByIdVoteCandidateList = sysVoteDao.findCandidateByVoteId(id);
            if (voFindByIdVoteCandidateList != null){
                for (VoFindByIdVoteCandidate voteCandidate : voFindByIdVoteCandidateList) {
                    //查询照片信息集合
                    ResourcesImg resourcesImg2 = new ResourcesImg();
                    //填入表名称 sysVote
                    resourcesImg2.setTableName("sysVoteCandidate");
                    //填入数据所属id
                    resourcesImg2.setDateId(voteCandidate.getId());
                    //填入类型名称 咨询建议照片：VoteImg
                    resourcesImg2.setTypeName("VoteCandidateImg");
                    //根据条件查询照片信息集合
                    List<VoResourcesImg> imgByDate2 = resourcesImgDao.findImgByDate(resourcesImg2);
                    voteCandidate.setImgUrls(imgByDate2);
                }
                //传入 候选人信息集合
                voFindByIdVote.setVoFindByIdVoteCandidateList(voFindByIdVoteCandidateList);
            }
        }
        map.put("voFindByIdVote",voFindByIdVote);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysVote sysVote) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        //添加投票信息
        try {
            //填入创建人id
            sysVote.setCreateId(sysUser.getId());
            //填入创建时间
            sysVote.setCreateDate(new Date());
            //填入是否删除（默认为1.非删）
            sysVote.setIsDelete(1);
            //填入是否发布（默认0.未发布）
            if (sysVote.getIsRelease() == null){
                sysVote.setIsRelease(0);
            }
            //判断开始时间和结束时间
            if (sysVote.getBeginDate().getTime() > sysVote.getEndDate().getTime()){
                throw new RuntimeException("开始时间不得大于结束时间");
            }
            //填入投票状态（以开始时间和结束时间为准）
            if (new Date().getTime() < sysVote.getBeginDate().getTime()){
                //未开始
                sysVote.setStatus(1);
            } else if (new Date().getTime() > sysVote.getEndDate().getTime()){
                //已结束
                sysVote.setStatus(3);
            } else {
                //进行中
                sysVote.setStatus(2);
            }
            //添加投票信息并返回主键id
            int insert = sysVoteDao.insert(sysVote);
            if (insert <= 0){
                throw new RuntimeException("添加投票信息失败");
            }
            //上传投票信息照片
            MultipartFile file = sysVote.getFile();
            //如果文件file不为空，则上传该文件到 ../static/img/vote/title目录下,并录入数据库
            if (file != null){
                UploadUtil uploadUtil = new UploadUtil();
                uploadUtil.upload(file,UPLOAD_VOTE_TITLE,"sysVote",sysVote.getId(),"voteImg","600",30,20);
            }

            //添加候选人信息集合
            List<SysVoteCandidate> sysVoteCandidateList = sysVote.getSysVoteCandidateList();
            if (sysVoteCandidateList != null){
                for (SysVoteCandidate sysVoteCandidate : sysVoteCandidateList) {
                    //填入创建人
                    sysVoteCandidate.setCreateId(sysUser.getId());
                    //填入创建时间
                    sysVoteCandidate.setCreateDate(new Date());
                    //填入投票id
                    sysVoteCandidate.setVoteId(sysVote.getId());
                    //投票总数，初始为0
                    sysVoteCandidate.setTotal(0);
                    //填入是否删除，默认1.非删
                    sysVoteCandidate.setIsDelete(1);
                    //添加投票候选人信息,并返回主键id
                    sysVoteDao.insertCandidate(sysVoteCandidate);
                    //上传投票候选人照片
                    MultipartFile file1 = sysVoteCandidate.getFile();
                    //如果文件file不为空，则上传该文件到 ../static/img/vote/candidate目录下,并录入数据库
                    if (file1 != null){
                        UploadUtil uploadUtil = new UploadUtil();
                        uploadUtil.upload(file1,UPLOAD_VOTE_CANDIDATE,"sysVoteCandidate",sysVoteCandidate.getId(),"voteCandidateImg","600",30,20);
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
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","新增投票信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(SysVote sysVote) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        //添加投票信息
        try {
            //填入修改人id
            sysVote.setModifyId(sysUser.getId());
            //填入修改时间
            sysVote.setModifyDate(new Date());
            //填入是否发布（默认0.未发布）
            if (sysVote.getIsRelease() == null){
                sysVote.setIsRelease(0);
            }
            //判断开始时间和结束时间
            if (sysVote.getBeginDate().getTime() > sysVote.getEndDate().getTime()){
                throw new RuntimeException("开始时间不得大于结束时间");
            }
            //填入投票状态（以开始时间和结束时间为准）
            if (new Date().getTime() < sysVote.getBeginDate().getTime()){
                //未开始
                sysVote.setStatus(1);
            } else if (new Date().getTime() > sysVote.getEndDate().getTime()){
                //已结束
                sysVote.setStatus(3);
            } else {
                //进行中
                sysVote.setStatus(2);
            }
            //修改投票信息
            int update = sysVoteDao.update(sysVote);
            if (update <= 0){
                throw new RuntimeException("修改投票信息失败");
            }
            //先删除文件信息
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.delete("sysVote",sysVote.getId(),"voteImg");

            //再上传投票信息照片
            MultipartFile file = sysVote.getFile();
            //如果文件file不为空，则上传该文件到 ../static/img/vote/title目录下,并录入数据库
            if (file != null){
                uploadUtil.upload(file,UPLOAD_VOTE_TITLE,"sysVote",sysVote.getId(),"voteImg","600",30,20);
            }

            //添加候选人信息集合
            List<SysVoteCandidate> sysVoteCandidateList = sysVote.getSysVoteCandidateList();
            if (sysVoteCandidateList != null && sysVoteCandidateList.size()>0){
                for (SysVoteCandidate sysVoteCandidate : sysVoteCandidateList) {
                    //删除再添加？？？？
                    //填入修改人
                    sysVoteCandidate.setModifyId(sysUser.getId());
                    //填入修改时间
                    sysVoteCandidate.setModifyDate(new Date());
                    //修改投票候选人信息
                    int update2 = sysVoteDao.updateCandidate(sysVoteCandidate);
                    if (update2 <= 0){
                        throw new RuntimeException("修改投票候选人信息失败");
                    }

                    //先删除文件和数据库的资源文件数据
                    List<SysVoteCandidate> sysVoteCandidateList1 = sysVote.getSysVoteCandidateList();
                    if (sysVoteCandidateList1 != null && sysVoteCandidateList1.size()>0){
                        for (SysVoteCandidate voteCandidate : sysVoteCandidateList1) {
                            uploadUtil.delete("sysVoteCandidate",voteCandidate.getId(),"voteCandidateImg");
                        }
                    }

                    //再上传投票候选人照片
                    MultipartFile file1 = sysVoteCandidate.getFile();
                    //如果文件file不为空，则上传该文件到 ../static/img/vote/candidate目录下,并录入数据库
                    if (file1 != null){
                        uploadUtil.upload(file1,UPLOAD_VOTE_CANDIDATE,"sysVoteCandidate",sysVoteCandidate.getId(),"voteCandidateImg","600",30,20);
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
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","修改投票信息成功");
        map.put("status",true);
        return map;
    }
}
