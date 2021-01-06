package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.basicArchives.CpmBuildingDao;
import com.api.manage.dao.basicArchives.CpmBuildingUnitDao;
import com.api.manage.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.api.manage.dao.butlerService.SysVoteDao;
import com.api.manage.dao.resources.ResourcesImgDao;
import com.api.model.basicArchives.CpmBuilding;
import com.api.model.basicArchives.CpmBuildingUnit;
import com.api.model.basicArchives.CpmBuildingUnitEstate;
import com.api.model.butlerService.SearchVote;
import com.api.model.butlerService.SearchVotePersonnel;
import com.api.model.butlerService.SysVote;
import com.api.model.butlerService.SysVoteCandidate;
import com.api.model.resources.ResourcesImg;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.butlerService.SysVoteService;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.*;
import com.api.vo.resources.VoResourcesImg;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysVoteServiceImpl implements SysVoteService {
    private static Map<String,Object> map = null;
    @Resource
    SysVoteDao sysVoteDao;
    @Resource
    ResourcesImgDao resourcesImgDao;
    @Resource
    CpmBuildingDao cpmBuildingDao;
    @Resource
    CpmBuildingUnitDao cpmBuildingUnitDao;
    @Resource
    CpmBuildingUnitEstateDao cpmBuildingUnitEstateDao;

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
    public Map<String, Object> findDetailById(Integer id) {
        map = new HashMap<>();
        //根据投票主键id查询投票信息
        VoFindDetailByIdVote voFindDetailByIdVote = sysVoteDao.findDetailById(id);
        if (voFindDetailByIdVote != null) {
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
            voFindDetailByIdVote.setImgUrls(imgByDate);
        }
        map.put("voFindDetailByIdVote",voFindDetailByIdVote);
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
            //上传投票信息照片到数据库
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(sysVote.getFileUrls(),"sysVote",sysVote.getId(),"voteImg","600",30,20);


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
                    //上传投票候选人照片到数据库
                    uploadUtil.saveUrlToDB(sysVoteCandidate.getFileUrls(),"sysVoteCandidate",sysVoteCandidate.getId(),"voteCandidateImg","600",30,20);
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
            //判断投票是否开始
            VoFindByIdVote byId = sysVoteDao.findById(sysVote.getId());
            if (new Date().getTime() >= byId.getBeginDate().getTime()){
                throw new RuntimeException("投票已开始，无法修改投票信息");
            }

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

            //再上传投票信息照片到数据库
            uploadUtil.saveUrlToDB(sysVote.getFileUrls(),"sysVote",sysVote.getId(),"voteImg","600",30,20);


            //先删除候选人信息
            sysVoteDao.deleteCandidate(sysVote.getId());
            //根据投票主键id查询投票候选人信息
            List<VoFindByIdVoteCandidate> candidateByVoteId = sysVoteDao.findCandidateByVoteId(sysVote.getId());
            //删除数据库对应的投票候选人信息
            if (candidateByVoteId != null && candidateByVoteId.size()>0){
                for (VoFindByIdVoteCandidate byIdVoteCandidate : candidateByVoteId) {
                    //删除文件和数据库的资源文件数据
                    uploadUtil.delete("sysVoteCandidate",byIdVoteCandidate.getId(),"voteCandidateImg");
                }
            }

            //再添加候选人信息集合
            List<SysVoteCandidate> sysVoteCandidateList = sysVote.getSysVoteCandidateList();
            if (sysVoteCandidateList != null && sysVoteCandidateList.size()>0){
                //遍历候选人信息集合
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

                    //上传投票候选人照片到数据库
                    uploadUtil.saveUrlToDB(sysVoteCandidate.getFileUrls(),"sysVoteCandidate",sysVoteCandidate.getId(),"voteCandidateImg","600",30,20);

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

    @Override
    @Transactional
    public Map<String, Object> falseDelete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //更新投票信息假删除状态
                int update = sysVoteDao.falseDelete(id);
                if (update <= 0){
                    throw new RuntimeException("投票信息删除失败");
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
        map.put("message","投票信息删除成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> release(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //更新投票信息发布状态
                int update = sysVoteDao.release(id);
                if (update <= 0){
                    throw new RuntimeException("投票信息发布失败");
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
        map.put("message","投票信息发布成功");
        map.put("status",true);
        return map;
    }

    @Override
    public List<VoFindDetailByIdVoteCandidate> listDetailCandidate(int id) {
        return sysVoteDao.listDetailCandidate(id);
    }

    @Override
    public List<VoVotePersonnel> listVotePersonnel(SearchVotePersonnel searchVotePersonnel) {
        //查询候选人投票详情信息
        List<VoVotePersonnel> voVotePersonnelList = sysVoteDao.listVotePersonnel(searchVotePersonnel);
        //遍历候选人投票详情信息
        if (voVotePersonnelList != null && voVotePersonnelList.size()>0){
            for (VoVotePersonnel voVotePersonnel : voVotePersonnelList) {
                //根据投票人id查询房产信息
                List<CpmBuildingUnitEstate> byResidentId = cpmBuildingUnitEstateDao.findByResidentId(voVotePersonnel.getVoterId());
                String roomName = "";
                if (byResidentId != null && byResidentId.size()>0){
                    //创建一个list
                    ArrayList<String> strings = new ArrayList<>(byResidentId.size());
                    //遍历房产信息集合
                    for (CpmBuildingUnitEstate cpmBuildingUnitEstate : byResidentId) {
                        //根据单元id查询单元信息
                        CpmBuildingUnit byId = cpmBuildingUnitDao.findById(cpmBuildingUnitEstate.getBuildingUnitId());
                        //根据楼栋id查询楼栋信息
                        CpmBuilding byId1 = cpmBuildingDao.findById(byId.getBuildingId());
                        //将单个房产信息传入list中
                        strings.add(byId1.getNo()+"-"+byId.getNo()+"-"+cpmBuildingUnitEstate.getRoomNumber());
                    }
                    //将list转成字符串形式
                    roomName = StringUtils.join(strings,",");
                }
                //传入住户房号
                voVotePersonnel.setRoomName(roomName);
            }
        }
        return voVotePersonnelList;
    }

    @Override
    public Map<String, Object> countVoteExpectedStart() {
        map = new HashMap<>();
        //查询设置的预期开始时间间隔
        VoVoteExpectedTime voVoteExpectedTime = sysVoteDao.listVoteExpectedTime();
        //获取预期最晚开始时间
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        if (voVoteExpectedTime.getType() == 1){
            //分
            c.add(Calendar.MINUTE,voVoteExpectedTime.getLongs());
        }else if (voVoteExpectedTime.getType() == 2){
            //时
            c.add(Calendar.HOUR,voVoteExpectedTime.getLongs());
        }else if (voVoteExpectedTime.getType() == 3){
            //天
            c.add(Calendar.DATE,voVoteExpectedTime.getLongs());
        }
        //传出预期最晚开始时间
        Date date = c.getTime();
        //查询即将开始的投票数，投票开始时间要大于当前时间，小于预期最晚开始时间
        int count = sysVoteDao.countVoteExpectedStart(date);
        map.put("count",count);
        return map;
    }
}
