package com.api.manage.service.basicArchives.impl;

import com.api.manage.dao.basicArchives.AuditManagementDao;
import com.api.manage.service.basicArchives.AuditManagementService;
import com.api.model.basicArchives.*;
import com.api.util.UploadUtil;
import com.api.vo.basicArchives.VoAuditManagement;
import com.api.vo.basicArchives.VoCheckAuditById;
import com.api.vo.basicArchives.VoFBIAuditManagement;
import com.api.vo.resources.VoResourcesImg;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuditManagementServiceImpl implements AuditManagementService {
    @Resource
    AuditManagementDao auditManagementDao;
    private static Map<String,Object> map = null;

    @Override
    public List<VoAuditManagement> list(AuditManagementSearch auditManagementSearch) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (auditManagementSearch.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = auditManagementSearch.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                auditManagementSearch.setBuildingNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                auditManagementSearch.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                auditManagementSearch.setRoomNumber(split[2]);
            }
        }
        return auditManagementDao.list(auditManagementSearch);
    }

    @Override
    public Map<String, Object> findById(Integer estateExamineId) {
        map = new HashMap<>();
        VoFBIAuditManagement voFBIAuditManagement = auditManagementDao.findById(estateExamineId);
        map.put("data",voFBIAuditManagement);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> review(Review review) {
        map = new HashMap<>();
        try {
            VoFBIAuditManagement byId = auditManagementDao.findById(review.getId());
            if (byId == null){
                throw new RuntimeException("该审核信息不存在");
            }
            if (byId.getStatus() != 1){
                throw new RuntimeException("当前审核信息不处于审核中状态，无法审核操作");
            }
            //将审核相关照片上传至数据库
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(review.getReviewFiles(),"cpmResidentEstateExamine",review.getId(),"review","600",30,20);
            if (review.getStatus() == 1){//审核通过
                review.setStatus(4); //审核表：4.审核成功
                //审核成功判断是业主、租客还是亲属
                if (byId.getType() == 1 || byId.getType() == 3){ //1.审核业主，3.审核租客
                    //删除原本存在的住户房产关联记录
                    ResidentIdAndEstateId residentIdAndEstateId = new ResidentIdAndEstateId();
                    residentIdAndEstateId.setResidentId(byId.getApplicantId()); //填入住户id
                    residentIdAndEstateId.setEstateId(byId.getEstateId()); //填入房产id
                    auditManagementDao.deleteByRIDAndEID(residentIdAndEstateId);

                    //添加住户房产关联表
                    CpmResidentEstate cpmResidentEstate = new CpmResidentEstate();
                    cpmResidentEstate.setBuildingUnitEstateId(byId.getEstateId()); //填入房产id
                    cpmResidentEstate.setResidentId(byId.getApplicantId()); //填入住户id
                    cpmResidentEstate.setEffectiveTimeStart(byId.getEffectiveTimeStart()); //填入有效时间开始（只限租客）
                    cpmResidentEstate.setEffectiveTimeEnd(byId.getEffectiveTimeEnd()); //填入有效时间结束（只限租客）
                    int insert = auditManagementDao.insertResidentEstate(cpmResidentEstate);
                    if (insert <=0){
                        throw new RuntimeException("添加住户房产关联失败");
                    }
                }else if (byId.getType() == 2){ //2.审核亲属
                    String residentId = byId.getResidentId(); //获取业主id
                    String[] split = residentId.split(",");
                    for (String id : split) {
                        //删除原本存在的住户亲属关联表
                        ResidentIdAndRelativesId residentIdAndRelativesId = new ResidentIdAndRelativesId();
                        residentIdAndRelativesId.setRelativesId(byId.getApplicantId()); //添加亲属id
                        residentIdAndRelativesId.setResidentId(Integer.valueOf(id)); //添加业主id
                        auditManagementDao.deleteByRIDAndRID(residentIdAndRelativesId);

                        //添加住户亲属关联表
                        UserResidentRelatives userResidentRelatives = new UserResidentRelatives();
                        userResidentRelatives.setRelativesId(byId.getApplicantId()); //添加亲属id
                        userResidentRelatives.setResidentId(Integer.valueOf(id)); //添加业主id
                        userResidentRelatives.setIdentity(3);
                        int insert2 = auditManagementDao.insertResidentRelatives(userResidentRelatives);
                        if (insert2 <=0){
                            throw new RuntimeException("添加住户亲属关联失败");
                        }
                    }
                }else {
                    throw new RuntimeException("数据异常");
                }

                //修改住户资料信息
                UserResident userResident = new UserResident();
                userResident.setId(byId.getApplicantId()); //填入住户主键id
                userResident.setIdType(byId.getIdType()); //填入证件类型
                userResident.setIdNumber(byId.getIdNumber()); //填入证件号码
                userResident.setName(byId.getName()); //填入住户姓名
                userResident.setType(byId.getType()); //填入住户类型
                int update = auditManagementDao.updateResident(userResident);
                if (update <=0){
                    throw new RuntimeException("住户信息修改失败");
                }
            }else if (review.getStatus() == 2){//审核不通过
                review.setStatus(3); //审核表：3.审核失败
            }else {
                throw new RuntimeException("数据异常");
            }
            //修改审核状态和备注
            int update = auditManagementDao.review(review);
            if (update <= 0){
                throw new RuntimeException("审核状态和备注修改失败");
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
        map.put("message","操作成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int delete = auditManagementDao.delete(id);
                if (delete <=0){
                    throw new RuntimeException("删除失败");
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
        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> checkById(Integer estateExamineId) {
        map = new HashMap<>();
        map = new HashMap<>();
        VoCheckAuditById voCheckAuditById = auditManagementDao.checkById(estateExamineId);
        if (voCheckAuditById != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("cpmResidentEstateExamine", voCheckAuditById.getId(), "review");
            voCheckAuditById.setImgList(imgByDate);
        }
        map.put("data",voCheckAuditById);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }
}
