package com.api.app.service.butler.impl;

import com.api.app.dao.butler.DecorationApplicationDao;
import com.api.app.service.butler.DecorationApplicationService;
import com.api.model.app.*;
import com.api.util.UploadUtil;
import com.api.vo.app.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class DecorationApplicationServiceImpl implements DecorationApplicationService {
    @Resource
    DecorationApplicationDao decorationApplicationDao;
    private static Map<String,Object> map = null;

    @Override
    public Map<String, Object> list(SearchAppDecoration searchAppDecoration) {
        map = new HashMap<>();
        List<AppDecorationVo> decorationVoList = decorationApplicationDao.list(searchAppDecoration);
        map.put("decorationVoList",decorationVoList);
        return map;
    }

    @Override
    public Map<String, Object> decorationCostDetail(Integer decorationId) {
        map = new HashMap<>();
        //根据装修主键id查询装修单号
        String code = decorationApplicationDao.findDecorationCodeById(decorationId);
        //查询装修押金,费用类型为：3.装修押金
        AppDecorationCostVo decorationCostVo = decorationApplicationDao.findDecorationDeposit();
        if (decorationCostVo != null){
            //根据 装修押金费用主键id 查询装修附加费用
            List<AppDecorationAdditionalCostVo> additionalCostVos = decorationApplicationDao.findDecorationAdditionalCost(decorationCostVo.getId());
            decorationCostVo.setAdditionalCostVos(additionalCostVos);
            //查询装修须知doc路径
            String url = decorationApplicationDao.findDecorationDocUrl();
            decorationCostVo.setDocUrl(url);
        }
        map.put("decorationCostVo",decorationCostVo);
        map.put("code",code);
        return map;
    }

    @Override
    public Map<String, Object> applicationDecoration(UserIdAndEstateId userIdAndEstateId) {
        map = new HashMap<>();
        //查询该用户是否有该房产的使用权
        int count = decorationApplicationDao.applicationDecoration(userIdAndEstateId);
        if (count >0){
            //根据用户id查询用户类型
            int type = decorationApplicationDao.findUserTypeByUserId(userIdAndEstateId.getId());
            AppUserDecoration userDecoration = new AppUserDecoration();
            if (type == 1){
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
            //添加装修信息
            userDecoration.setCode(UUID.randomUUID().toString().replace("-","").trim());
            userDecoration.setBuildingUnitEstateId(userIdAndEstateId.getEstateId());
            userDecoration.setResidentId(userIdAndEstateId.getId());
            userDecoration.setResidentType(type);
            userDecoration.setApplicationDate(new Date());
            //添加装修申请信息
            int insert = decorationApplicationDao.insertDecorationApplication(userDecoration);
            if (insert <= 0){
                map.put("message","申请失败");
                map.put("status",false);
            }
            map.put("keyId",userDecoration.getId());
        }else {
            map.put("message","您不能对该房产进行操作");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> update(AppUserDecoration userDecoration) {
        map = new HashMap<>();
        int update = decorationApplicationDao.update(userDecoration);
        if (update >0){
            map.put("message","信息完善成功");
            map.put("status",true);
        }else {
            map.put("message","信息完善失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> findApplicationDecoration(Integer id) {
        map = new HashMap<>();
        AppDecorationApplicationVo applicationVo = decorationApplicationDao.findApplicationDecoration(id);
        map.put("message","请求成功");
        map.put("data",applicationVo);
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> applicationPay(AppDepositManagement appDepositManagement) {
        map = new HashMap<>();
        try {
            //调用支付宝接口,返回订单号，当前为UUid自动生成订单号
            String uuid = UUID.randomUUID().toString().replace("-", "");

            //填入订单号
            appDepositManagement.setOrderCode(uuid);
            //填入缴费时间
            appDepositManagement.setPayDate(new Date());
            //填入来源：1.app,2.线下
            appDepositManagement.setFroms(2);
            //填入创建时间
            appDepositManagement.setCreateDate(new Date());
            //填入是否删除，默认为1.非删
            appDepositManagement.setIsDelete(1);
            //填入状态，默认为1.未退
            appDepositManagement.setStatus(1);

            //添加押金管理信息
            int insert = decorationApplicationDao.insertDepositManagement(appDepositManagement);
            if (insert <= 0){
                throw new RuntimeException("添加订单失败");
            }
            //添加押金附加费用
            List<AppDepositAdditionalCost> depositAdditionalCostList = appDepositManagement.getDepositAdditionalCostList();
            if (depositAdditionalCostList != null && depositAdditionalCostList.size() >0){
                for (AppDepositAdditionalCost additionalCost : depositAdditionalCostList) {
                    additionalCost.setSysDepositManagementId(appDepositManagement.getId());
                    int insert2 = decorationApplicationDao.insertDepositAdditionalCost(additionalCost);
                    if (insert2 <= 0){
                        throw new RuntimeException("添加附加费用失败");
                    }
                }
            }
            AppUserDecoration appUserDecoration = new AppUserDecoration();
            //填入装修id
            appUserDecoration.setId(appDepositManagement.getUserDecorationId());
            //填入状态，1.未开始（已付押金）
            appUserDecoration.setStatus(1);
            //更改装修状态
            int update = decorationApplicationDao.updateStatus(appUserDecoration);
            if (update <= 0){
                throw new RuntimeException("修改装修状态失败");
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
        map.put("message","付款成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> insertDecorationPerson(AppUserDecorationSubmit decorationSubmit) {
        map = new HashMap<>();
        try {
            //根据装修单号查询装修主键id
            int decorationId = decorationApplicationDao.findDecorationIdByCode(decorationSubmit.getCode());
            if (decorationId <= 0){
                throw new RuntimeException("查无此单");
            }
            //先删除装修人员信息
            decorationApplicationDao.delete(decorationId);

            //再添加装修人员信息
            AppUserDecoration appUserDecoration = new AppUserDecoration();
            //填入装修单号
            appUserDecoration.setId(decorationId);
            //填入装修公司
            appUserDecoration.setConstructionUnit(decorationSubmit.getConstructionUnit());
            //填入装修负责人
            appUserDecoration.setDirector(decorationSubmit.getDecorationPersonList().get(0).getName());
            //填入装修负责人联系电话
            appUserDecoration.setDirectorTel(decorationSubmit.getDecorationPersonList().get(0).getTel());
            int update = decorationApplicationDao.update(appUserDecoration);
            if (update <= 0){
                throw new RuntimeException("更新装修信息失败");
            }
            List<AppUserDecorationPerson> decorationPersonList = decorationSubmit.getDecorationPersonList();
            if (decorationPersonList != null && decorationPersonList.size()>0){
                for (AppUserDecorationPerson decorationPerson : decorationPersonList) {
                    decorationPerson.setDecorationId(decorationId);
                    //添加装修人员信息
                    int insert = decorationApplicationDao.insertDecorationPerson(decorationPerson);
                    if (insert <= 0){
                        throw new RuntimeException("添加装修人员信息失败");
                    }
                }
            }
            UploadUtil uploadUtil = new UploadUtil();
            //先删除数据库的照片信息
            //删除营业执照
            uploadUtil.delete("userDecoration",decorationId,"businessLicense");
            //删除资质证书
            uploadUtil.delete("userDecoration",decorationId,"qualificationCertificate");
            //删除装修图纸
            uploadUtil.delete("userDecoration",decorationId,"decorationDrawings");
            //删除装修申请表
            uploadUtil.delete("userDecoration",decorationId,"decorationApplicationForm");
            //删除装修承诺书
            uploadUtil.delete("userDecoration",decorationId,"decorationCommitment");


            //再添加上传文件到数据库
            //添加营业执照
            uploadUtil.saveUrlToDB(decorationSubmit.getBusinessLicenseUrl(),"userDecoration",decorationId,"businessLicense","600",30,20);
            //添加资质证书
            uploadUtil.saveUrlToDB(decorationSubmit.getQualificationCertificate(),"userDecoration",decorationId,"qualificationCertificate","600",30,20);
            //添加装修图纸
            uploadUtil.saveUrlToDB(decorationSubmit.getDecorationDrawings(),"userDecoration",decorationId,"decorationDrawings","600",30,20);
            //添加装修申请表
            uploadUtil.saveUrlToDB(decorationSubmit.getDecorationApplicationForm(),"userDecoration",decorationId,"decorationApplicationForm","600",30,20);
            //添加装修承诺书
            uploadUtil.saveUrlToDB(decorationSubmit.getDecorationCommitment(),"userDecoration",decorationId,"decorationCommitment","600",30,20);

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
        map.put("message","信息完善成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findDetailById(Integer decorationId) {
        map = new HashMap<>();
        //根据装修主键id查询装修信息
        AppDecorationFBIVo appDecorationFBIVo = decorationApplicationDao.findDecorationById(decorationId);
        //根据装修主键id查询装修押金信息
        AppDepositVo appDepositVo = decorationApplicationDao.findDepositById(decorationId);
        if (appDepositVo != null){
            //根据押金管理主键id查询押金信息
            List<AppDepositAdditionalCostVo> additionalCostVos = decorationApplicationDao.findDACostByDId(appDepositVo.getId());
            appDepositVo.setAdditionalCostVos(additionalCostVos);
        }
        //查询根据装修主键id装修公司人员信息是否完善
        int count = decorationApplicationDao.findPersonByDecorationId(decorationId);
        if (count >0){
            map.put("isPerfect",true);
        }else {
            map.put("isPerfect",false);
        }
        map.put("appDecorationFBIVo",appDecorationFBIVo);
        map.put("appDepositVo",appDepositVo);
        return map;
    }

    @Override
    public Map<String, Object> startDecoration(Integer decorationId, Integer id) {
        map = new HashMap<>();
        //根据装修主键id查询装修信息
        AppDecorationFBIVo decorationById = decorationApplicationDao.findDecorationById(decorationId);
        if (decorationById.getResidentId() != id){
            map.put("message","不可操作他人的装修单");
            map.put("status",false);
            return map;
        }
        AppUserDecoration appUserDecoration = new AppUserDecoration();
        appUserDecoration.setId(decorationId);
        //填入状态，2.装修中
        appUserDecoration.setStatus(2);
        int updateStatus = decorationApplicationDao.updateStatus(appUserDecoration);
        if (updateStatus > 0){
            map.put("message","操作成功");
            map.put("status",true);
        }else {
            map.put("message","操作失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> findAllDetail(Integer decorationId) {
        map = new HashMap<>();
        AppDecorationFindAllDetailVo allDetailVo = decorationApplicationDao.findAllDetail(decorationId);
        map.put("data",allDetailVo);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findTrackRecord(Integer decorationId) {
        map = new HashMap<>();
        //查询跟踪检查记录
        List<AppTrackRecordVo> trackRecordVos = decorationApplicationDao.findTrackRecord(decorationId);
        if (trackRecordVos != null && trackRecordVos.size()>0){
            for (AppTrackRecordVo trackRecordVo : trackRecordVos) {
                //查询跟踪检查记录明细
                List<AppTrackRecordDetailVo> trackRecordDetailVos = decorationApplicationDao.findTrackRecordDetail(trackRecordVo.getId());
                trackRecordVo.setRecordDetailVoList(trackRecordDetailVos);
            }
        }
        //查询是否有延长过时间


        map.put("trackRecordVos",trackRecordVos);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> extendDecorationTime(AppExtendDecoration appExtendDecoration, Integer id) {
        map = new HashMap<>();
        //根据装修主键id查询装修信息
        AppDecorationFBIVo decorationById = decorationApplicationDao.findDecorationById(appExtendDecoration.getDecorationId());
        if (decorationById.getResidentId() != id){
            map.put("message","不可操作他人的装修单");
            map.put("status",false);
            return map;
        }
        if (decorationById.getExtendDate() != null){
            map.put("message","只可延长一次装修时间");
            map.put("status",false);
            return map;
        }

        GregorianCalendar calendar = new GregorianCalendar();
        //填入预计结束时间
        calendar.setTime(decorationById.getExpectedEnd());
        //预计结束时间向后延长？天
        calendar.add(calendar.DATE,appExtendDecoration.getExtendTime());
        //获取延长后的时间
        Date time = calendar.getTime();
        appExtendDecoration.setExtendDate(time);
        //添加延长时间记录
        int update = decorationApplicationDao.extendDecorationTime(appExtendDecoration);
        if (update >0){
            map.put("message","延长成功");
            map.put("status",true);
        }else {
            map.put("message","延长失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> finishDecoration(Integer decorationId, Integer id) {
        map = new HashMap<>();
        //根据装修主键id查询装修信息
        AppDecorationFBIVo decorationById = decorationApplicationDao.findDecorationById(decorationId);
        if (decorationById.getResidentId() != id){
            map.put("message","不可操作他人的装修单");
            map.put("status",false);
            return map;
        }

        AppUserDecoration appUserDecoration = new AppUserDecoration();
        appUserDecoration.setId(decorationId);
        //填入状态，3.完工检查申请中
        appUserDecoration.setStatus(3);
        int update = decorationApplicationDao.updateStatus(appUserDecoration);
        if (update >0){
            map.put("message","操作成功");
            map.put("status",true);
        }else {
            map.put("message","操作失败");
            map.put("status",false);
        }
        return map;
    }


}
