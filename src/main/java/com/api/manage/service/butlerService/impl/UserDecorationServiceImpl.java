package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.UserAccessCardDao;
import com.api.manage.dao.butlerService.UserDecorationDao;
import com.api.manage.dao.butlerService.UserDecorationPersonnelDao;
import com.api.model.butlerService.*;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.butlerService.UserDecorationService;
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
import java.math.BigDecimal;
import java.util.*;

@Service
public class UserDecorationServiceImpl implements UserDecorationService {
    private static Map<String,Object> map = null;

    @Resource
    UserDecorationDao userDecorationDao;
    @Resource
    UserAccessCardDao userAccessCardDao;
    @Resource
    UserDecorationPersonnelDao userDecorationPersonnelDao;

    @Override
    public List<VoUserDecoration> list(SearchUserDecoration searchUserDecoration) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchUserDecoration.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = searchUserDecoration.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchUserDecoration.setBuildingNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchUserDecoration.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchUserDecoration.setRoomNumber(split[2]);
            }
        }
        List<VoUserDecoration> list = userDecorationDao.list(searchUserDecoration);
        for (VoUserDecoration voUserDecoration : list) {
            //填入门禁卡数量
            int num = userAccessCardDao.countCardNum(voUserDecoration.getId());
            voUserDecoration.setUserAccessCardNum(num);
            //填入装修押金信息
            VoDepositPriceAndId voDepositPriceAndId = userDecorationDao.findDepositById(voUserDecoration.getId());
            if (voDepositPriceAndId != null){
                voUserDecoration.setDepositPrice(voDepositPriceAndId.getDepositPrice());
                //填入装修附加费用
                List<VoDepositAdditionalCost> voDepositAdditionalCosts = userDecorationDao.findDepositAdditionalCost(voDepositPriceAndId.getId());
                voUserDecoration.setVoDepositAdditionalCosts(voDepositAdditionalCosts);
            }
            //填入是否退还押金
            BigDecimal refundDeposit = userDecorationDao.findRefundDeposit(voUserDecoration.getId());
            if (refundDeposit != null){
                voUserDecoration.setRefundDeposit(refundDeposit);
            }
            //填入是否退还门禁卡(1.归还，0.未归还)
            //根据装修主键id查询未归还门禁卡数量
            int count = userDecorationDao.findNoReturnAccessCard(voUserDecoration.getId());
            if (count >0){
                //如果未归还门禁卡数量大于0，则填入0.未归还
                voUserDecoration.setIsReturnAccessCard(0);
            }else {
                //如果未null或未归还门禁卡数量等于0，则填入1.归还
                voUserDecoration.setIsReturnAccessCard(1);
            }
        }
        return list;
    }

    @Override
    public List<VoUserDecorationPersonnel> decorationPersonnelList(Integer id) {
        return userDecorationDao.decorationPersonnelList(id);
    }

    @Override
    public Map<String, Object> decorationData(Integer id) {
        map = new HashMap<>();
        UploadUtil uploadUtil = new UploadUtil();
        //查询营业执照
        List<VoResourcesImg> businessLicenseList = uploadUtil.findImgByDate("userDecoration", id, "businessLicense");
        //查询资质证书
        List<VoResourcesImg> qualificationCertificateList = uploadUtil.findImgByDate("userDecoration", id, "qualificationCertificate");
        //查询装修图纸
        List<VoResourcesImg> decorationDrawingsList = uploadUtil.findImgByDate("userDecoration", id, "decorationDrawings");
        //查询装修申请表
        List<VoResourcesImg> decorationApplicationFormList = uploadUtil.findImgByDate("userDecoration", id, "decorationApplicationForm");
        //查询装修承诺书
        List<VoResourcesImg> decorationCommitmentList = uploadUtil.findImgByDate("userDecoration", id, "decorationCommitment");
        map.put("businessLicenseList",businessLicenseList);
        map.put("qualificationCertificateList",qualificationCertificateList);
        map.put("decorationDrawingsList",decorationDrawingsList);
        map.put("decorationApplicationFormList",decorationApplicationFormList);
        map.put("decorationCommitmentList",decorationCommitmentList);
        return map;
    }

    @Override
    public List<VoUserAccessCard> userAccessCardList(Integer id) {
        List<VoUserAccessCard> voUserAccessCardList = userAccessCardDao.userAccessCardList(id);
        if (voUserAccessCardList != null){
            for (VoUserAccessCard voUserAccessCard : voUserAccessCardList) {
                //如果到期时间不为null,为1.临时类型；为null，则为2.永久类型
                if (voUserAccessCard.getExpireDate() != null){
                    voUserAccessCard.setType(1);
                }else {
                    voUserAccessCard.setType(2);
                }
            }
        }

        return voUserAccessCardList;
    }

    @Override
    public List<VoUserDecorationTrackRecord> decorationTrackRecordList(Integer id) {
        List<VoUserDecorationTrackRecord> voUserDecorationTrackRecordList = userDecorationDao.decorationTrackRecordList(id);
        if (voUserDecorationTrackRecordList != null){
            for (VoUserDecorationTrackRecord voUserDecorationTrackRecord : voUserDecorationTrackRecordList) {
                //遍历查询跟踪检查记录明细
                List<VoUserDecorationTrackRecordDetail> voUserDecorationTrackRecordDetailList = userDecorationDao.decorationTrackRecordDetailList(voUserDecorationTrackRecord.getId());
                voUserDecorationTrackRecord.setReview(voUserDecorationTrackRecordDetailList);
            }
        }
        return voUserDecorationTrackRecordList;
    }

    @Override
    public List<VoUserDecorationTrackRecord> decorationFinishRecordList(Integer id) {
        //查询所有完工检查记录
        List<VoUserDecorationTrackRecord> voUserDecorationTrackRecordList = userDecorationDao.decorationFinishRecordList(id);
        if (voUserDecorationTrackRecordList != null){
            for (VoUserDecorationTrackRecord voUserDecorationTrackRecord : voUserDecorationTrackRecordList) {
                //遍历查询完工检查记录明细
                List<VoUserDecorationTrackRecordDetail> voUserDecorationTrackRecordDetailList = userDecorationDao.decorationTrackRecordDetailList(voUserDecorationTrackRecord.getId());
                voUserDecorationTrackRecord.setReview(voUserDecorationTrackRecordDetailList);
            }
        }
        return voUserDecorationTrackRecordList;
    }

    @Override
    public Map<String, Object> insertDecorationPersonnel(UserDecorationPersonnel userDecorationPersonnel) {
        map = new HashMap<>();
        //添加装修人员信息
        int insert = userDecorationPersonnelDao.insertDecorationPersonnel(userDecorationPersonnel);

        if (insert>0){
            map.put("message","添加装修人员成功");
            map.put("status",true);
        }else {
            map.put("message","添加装修人员失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> deleteDecorationPersonnel(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int delete = userDecorationPersonnelDao.deleteDecorationPersonnel(id);
                if (delete<=0){
                    throw new RuntimeException("批量删除装修人员信息失败");
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
        map.put("message","批量删除装修人员信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findByIdDecorationPersonnel(Integer id) {
        map = new HashMap<>();
        VoUserDecorationPersonnel voUserDecorationPersonnel = userDecorationPersonnelDao.findByIdDecorationPersonnel(id);
        map.put("voUserDecorationPersonnel",voUserDecorationPersonnel);
        return map;
    }

    @Override
    public Map<String, Object> updateDecorationPersonnel(UserDecorationPersonnel userDecorationPersonnel) {
        map = new HashMap<>();
        //修改装修人员信息
        int update = userDecorationPersonnelDao.updateDecorationPersonnel(userDecorationPersonnel);
        if (update>0){
            map.put("message","修改装修人员成功");
            map.put("status",true);
        }else {
            map.put("message","修改装修人员失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //根据装修信息主键id查询装修门禁卡关联信息
                List<UserDecorationAccessCard> userDecorationAccessCardList = userDecorationDao.findUDACByDecorationId(id);
                //判断有无装修门禁卡关联信息
                if (userDecorationAccessCardList != null && userDecorationAccessCardList.size()>0){
                    for (UserDecorationAccessCard userDecorationAccessCard : userDecorationAccessCardList) {
                        //批量删除门禁卡信息
                        int delete5 = userDecorationDao.deleteAccessCard(userDecorationAccessCard.getAccessCardId());
                        if (delete5<=0){
                            throw new RuntimeException("批量删除门禁卡信息失败");
                        }
                    }

                    //根据装修信息主键id删除装修门禁卡关联信息
                    int delete1 = userDecorationDao.deleteDecorationAccessCard(id);
                    if (delete1<=0){
                        throw new RuntimeException("批量删除装修门禁卡关联信息失败");
                    }
                }



                //根据装修信息主键id查询装修人员信息
                List<UserDecorationPersonnel> userDecorationPersonnelList = userDecorationPersonnelDao.findByDecorationId(id);
                //判断有无装修人员信息
                if (userDecorationPersonnelList != null && userDecorationPersonnelList.size()>0){
                    //根据装修信息主键id删除装修人员信息
                    int delete2 = userDecorationPersonnelDao.deletePersonnelByDecorationId(id);
                    if (delete2<=0){
                        throw new RuntimeException("批量删除装修人员信息失败");
                    }
                }


                //根据装修信息主键id查询装修跟踪记录表
                List<VoUserDecorationTrackRecord> voUserDecorationTrackRecordList = userDecorationDao.findTrackRecordByDecorationId(id);
                //判断有无装修跟踪记录表
                if (voUserDecorationTrackRecordList != null && voUserDecorationTrackRecordList.size()>0){
                    for (VoUserDecorationTrackRecord voUserDecorationTrackRecord : voUserDecorationTrackRecordList) {
                        //根据装修跟踪记录表主键id查询装修跟踪记录明细表
                        List<UserDecorationTrackRecordDetail> userDecorationTrackRecordDetailList = userDecorationDao.findUDTRDByTrackRecordId(voUserDecorationTrackRecord.getId());
                        //判断有无装修跟踪记录明细表
                        if (userDecorationTrackRecordDetailList != null && userDecorationTrackRecordDetailList.size()>0) {
                            //根据装修跟踪记录表主键id删除装修跟踪记录明细表
                            int delete3 = userDecorationDao.deleteTrackRecordDetail(voUserDecorationTrackRecord.getId());
                            if (delete3<=0){
                                throw new RuntimeException("批量删除装修跟踪记录明细表信息失败");
                            }
                        }
                    }
                    //根据装修信息主键id删除装修跟踪记录表
                    int delete4 = userDecorationDao.deleteTrackRecord(id);
                    if (delete4<=0){
                        throw new RuntimeException("批量删除装修跟踪记录表信息失败");
                    }
                }

                //根据装修信息主键id删除装修信息
                int delete = userDecorationDao.delete(id);
                if (delete<=0){
                    throw new RuntimeException("批量删除装修信息失败");
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
        map.put("message","批量删除装修信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> invalid(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int update = userDecorationDao.invalid(id);
                if (update <= 0){
                    throw new RuntimeException("批量作废装修信息失败");
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
        map.put("message","批量作废装修信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> countDecorationNow() {
        map = new HashMap<>();
        Integer integer = userDecorationDao.countDecorationNow();
        map.put("countNow",integer);
        return map;
    }

    @Override
    public Map<String, Object> countPerformed() {
        map = new HashMap<>();
        Integer integer = userDecorationDao.countPerformed();
        map.put("countPerformed",integer);
        return map;
    }

    @Override
    public Map<String, Object> findAllChecksContent() {
        map = new HashMap<>();
        //查询所有的检查内容信息
        List<VoUserDecorationChecksContent> checksContentList = userDecorationDao.findAllChecksContent();
        map.put("checksContentList",checksContentList);
        //查询装修须知doc路径
        List<String> urls = userDecorationDao.findDocUrl();
        String url = "";
        if (urls != null && urls.size()>0){
            url = urls.get(0);
        }
        map.put("url",url);
        return map;
    }

    @Override
    public Map<String, Object> insertCheckContent(UserDecorationChecksContent checksContent) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        checksContent.setCreateId(sysUser.getId());
        checksContent.setCreateDate(new Date());
        int insert = userDecorationDao.insertCheckContent(checksContent);
        if (insert >0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> updateCheckContent(UserDecorationChecksContent checksContent) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        checksContent.setModifyId(sysUser.getId());
        checksContent.setModifyDate(new Date());
        int insert = userDecorationDao.updateCheckContent(checksContent);
        if (insert >0){
            map.put("message","修改成功");
            map.put("status",true);
        }else {
            map.put("message","修改失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> deleteCheckContent(Integer checkContentId) {
        map = new HashMap<>();

        int delete = userDecorationDao.deleteCheckContent(checkContentId);
        if (delete >0){
            map.put("message","删除成功");
            map.put("status",true);
        }else {
            map.put("message","删除失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> updateDecoration(UserDecoration userDecoration) {
        map = new HashMap<>();
        int update = userDecorationDao.update(userDecoration);
        if (update >0){
            map.put("message","更新成功");
            map.put("status",true);
        }else {
            map.put("message","更新失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> insertDecoration(UserDecoration userDecoration) {
        map = new HashMap<>();
        //填入装修单号
        userDecoration.setCode(UUID.randomUUID().toString().replace("-","").trim());
        //填入申请时间
        userDecoration.setApplicationDate(new Date());
        if (userDecoration.getResidentType() == 1){
            map.put("message","申请通过");
            map.put("status",true);
            //填入状态，-3.申请通过
            userDecoration.setStatus(-3);
        }else{
            map.put("message","申请成功，请等待业主同意");
            map.put("status",false);
            //填入状态，-1.申请中
            userDecoration.setStatus(-1);
        }

        int insert = userDecorationDao.insert(userDecoration);
        if (insert >0){
            map.put("message","操作成功");
            map.put("status",true);
            map.put("key",userDecoration.getId());
        }else {
            map.put("message","操作失败");
            map.put("status",false);
        }
        return map;
    }


}
