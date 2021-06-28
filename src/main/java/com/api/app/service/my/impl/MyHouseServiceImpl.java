package com.api.app.service.my.impl;

import com.api.app.dao.login.AppLoginDao;
import com.api.app.dao.my.MyHouseDao;
import com.api.app.service.my.MyHouseService;
import com.api.manage.dao.resources.ResourcesImgDao;
import com.api.model.app.AppLeaseSubmitAudit;
import com.api.model.app.AppLeaseValidContract;
import com.api.model.app.AppUserIdAndExamineId;
import com.api.model.basicArchives.ResidentIdAndEstateId;
import com.api.model.basicArchives.UserResident;
import com.api.model.butlerService.SysLease;
import com.api.model.butlerService.SysLeaseContract;
import com.api.model.my.MyHouse;
import com.api.model.resources.ResourcesImg;
import com.api.util.ConvertUpMoney;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.util.pdf.PdfReplaceMap;
import com.api.util.pdf.PdfUtils;
import com.api.vo.app.AppLeaseInfoVo;
import com.api.vo.app.AppLeaseVo;
import com.api.vo.butlerService.VoLease;
import com.api.vo.my.*;
import com.api.vo.resources.VoResourcesImg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class MyHouseServiceImpl implements MyHouseService {
    private static Map<String,Object> map = null;
    @Value("${prop.upload-lease-contract-preview-pdf}")
    private String UPLOAD_LEASE_CONTRACT_PREVIEW_PDF;
    @Value("${prop.upload-lease-contract-signed-pdf}")
    private String UPLOAD_LEASE_CONTRACT_SIGNED_PDF;
    @Value("${prop.upload-lease-contract-valid-pdf}")
    private String UPLOAD_LEASE_CONTRACT_VALID_PDF;
    @Resource
    MyHouseDao myHouseDao;
    @Resource
    AppLoginDao appLoginDao;
    @Resource
    ResourcesImgDao resourcesImgDao;



    @Override
    public Map<String, Object> houseList(Integer id) {
        map = new HashMap<>();
        List<MyHouseListVo> myHouseListVos = myHouseDao.houseList(id);
        map.put("data",myHouseListVos);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> examineList(Integer id) {
        map = new HashMap<>();
        List<MyHouseExamineVo> list = myHouseDao.examineList(id);
        map.put("data",list);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> authentication(MyHouse myHouse, Integer type) {
        map =  new HashMap<>();
        try {
            // TODO 去除该判断，使得用户可以同时拥有两种身份
            //当既不是游客，用户类型又不相等时，抛出错误；是游客继续执行，类型相等继续执行
            if (type != 4 && myHouse.getType() != type){
                throw new RuntimeException("身份信息不对，请联系管理员");
            }

            //判断该用户是否已有审核中记录存在
            int count = myHouseDao.countNotReviewed(myHouse.getResidentId());
            if (count >0){
                throw new RuntimeException("已有审核中记录，请等待完成");
            }

            //判断是否已有审核成功的房产id
            List<Integer> ids2 = myHouseDao.countSuccessReviewed(myHouse.getResidentId());
            if (ids2.contains(myHouse.getEstateId())){
                throw new RuntimeException("已有该房产的审核成功并且没有删除的记录");
            }

            //当数据库存在该房屋信息时，直接审核成功
            //根据用户主键id查询数据库存在的关联的房房产id集合
            List<Integer> ids = myHouseDao.findDBEstaIdByResidentId(myHouse.getResidentId());
            // TODO 根据房产主键id查询住户信息，以此判断用户是否 需要判断住户类型
            //根据用户主键id查询数据库住户信息
            MyHouseResidentInfoVo residentInfoVo = myHouseDao.findSBResidentInfoByResidentId(myHouse.getResidentId());
            //判断填入数据与数据库已知数据是否相同
            // （1）用户类型不为2.审核亲属，（2）该用户拥有该房产的拥有权，（3）用户证件号码与数据库一致，（4）用户姓名与数据库一致，（5）用户证件类型与数据库一致
            // TODO 缺少判断用户类型，业主还是租户
            if (myHouse.getType() != 2 && ids.contains(myHouse.getEstateId()) && residentInfoVo.getIdNumber().equals(myHouse.getIdNumber())
                    && residentInfoVo.getName().equals(myHouse.getName()) && residentInfoVo.getIdType().equals(myHouse.getIdType())){
                //系统自动审核成功
                //根据用户主键id和房产id查询房产信息
                ResidentIdAndEstateId residentIdAndEstateId = new ResidentIdAndEstateId();
                residentIdAndEstateId.setResidentId(myHouse.getResidentId());
                residentIdAndEstateId.setEstateId(myHouse.getEstateId());
                MyHouseEstateInfoVo estateInfoVo = myHouseDao.findEstateInfoByResidentId(residentIdAndEstateId);
                //添加有效时间开始（只限租客）
                myHouse.setEffectiveTimeStart(estateInfoVo.getEffectiveTimeStart());
                //添加有效时间结束（只限租客）
                myHouse.setEffectiveTimeEnd(estateInfoVo.getEffectiveTimeEnd());
                //添加审核状态（1.未审核，3.审核失败，4.审核成功）
                myHouse.setStatus(4);
                //填写审核人id（系统自动审核成功为-1）
                myHouse.setReviewer(-1);
                //填写审核时间（系统自动审核成功为当前时间）
                myHouse.setReviewerDate(new Date());
                //填入是否删除，1.非删 0.删除 默认为1.非删
                myHouse.setIsDelete(1);
                //填入创建时间
                myHouse.setCreateDate(new Date());
                //添加住户房产审核信息
                int insert2 = appLoginDao.insertResidentEstateExamine(myHouse);
                if (insert2 <= 0){
                    throw new RuntimeException("添加住户房产审核信息失败");
                }
            }else {
                //系统自动审核失败
                //添加审核状态（1.未审核，3.审核失败，4.审核成功）
                myHouse.setStatus(1);
                //填写审核人id（系统自动审核失败为null）
                myHouse.setReviewer(null);
                //填写审核时间(系统自动审核失败为null)
                myHouse.setReviewerDate(null);
                //填入是否删除，1.非删 0.删除 默认为1.非删
                myHouse.setIsDelete(1);
                //填入创建时间
                myHouse.setCreateDate(new Date());
                //添加住户房产审核信息
                int insert2 = appLoginDao.insertResidentEstateExamine(myHouse);
                if (insert2 <= 0){
                    throw new RuntimeException("添加住户房产审核信息失败");
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
        map.put("message","提交成功,请等待审核");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> falseDelete(int[] ids,Integer residentId) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int residentIdById = myHouseDao.findResidentIdById(id);
                //判断用户是否是该审核用户
                if (residentIdById != residentId){
                    throw new RuntimeException("登录用户错误");
                }
                //判断是否是审核中状态
                int status = myHouseDao.findStatusById(id);
                if (status == 1){ //审核中
                    throw new RuntimeException("审核中，无法删除");
                }

                if (status == 4) { //审核成功
                    //根据房产审核表主键id查询审核房产id
                    Integer estateId = myHouseDao.findEstateIdById(id);
                    //根据住户id查询app当前选中的房产id
                    Integer nowEstateId = myHouseDao.findNowEstateIdByResidentId(residentId);
                    //判断该用户的当前选择的房产id是否是该审核成功的房产id
                    if (estateId.equals(nowEstateId)){
                        throw new RuntimeException("该房屋已选中，不可删除");
                    }
                }

                int update = myHouseDao.falseDelete(id);
                if (update <= 0){
                    throw new RuntimeException("删除失败");
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
        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findById(Integer estateExamineId) {
        map = new HashMap<>();
        //根据房产审核表主键id查询再次认证回显信息
        MyHouseFBIVo myHouseFBIVo = myHouseDao.findById(estateExamineId);
        map.put("data",myHouseFBIVo);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> changeSelectExamineId(Integer examineId, Integer id) {
        map = new HashMap<>();
        AppUserIdAndExamineId appUserIdAndExamineId = new AppUserIdAndExamineId();
        appUserIdAndExamineId.setExamineId(examineId);
        appUserIdAndExamineId.setUserId(id);
        int update = myHouseDao.updateEstateExamineId(appUserIdAndExamineId);
        if (update <= 0){
            map.put("message","更改失败");
            map.put("status",false);
        }
        map.put("message","更改成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> leaseCertification(UserResident userResident) {
        map = new HashMap<>();
        List<SysLease> sysLeaseList = myHouseDao.findLeaseByTel(userResident.getTel());
        if (sysLeaseList == null || sysLeaseList.size()<=0){
            map.put("message","用户并未具备相关的资格");
            map.put("status",false);
            return map;
        }
        SysLease sysLease = sysLeaseList.get(0);

        if (sysLease.getTel().equals(userResident.getTel())
                && sysLease.getName().equals(userResident.getName())
                && sysLease.getSex() == userResident.getSex()
                && sysLease.getIdCard().equals(userResident.getIdNumber())){
            //认证通过
            //更新用户信息
            userResident.setIdType(1);//默认1.身份证
            int update = myHouseDao.updateUserResidentInfo(userResident);
            if (update >0){
                map.put("message","认证成功");
                map.put("status",true);
            }else {
                map.put("message","信息更新失败,认证失败");
                map.put("status",false);
            }
        }else {
            //认证失败
            map.put("message","认证失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> leaseEcho(String tel) {
        map = new HashMap<>();

        //根据手机号查询认证回显信息
        AppLeaseInfoVo appLeaseInfoVo = myHouseDao.findLeaseInfoByTel(tel);
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",appLeaseInfoVo);

        return map;
    }

    @Override
    public List<AppLeaseVo> leaseList(String tel) {
        return myHouseDao.leaseList(tel);
    }

    @Override
    public Map<String, Object> leaseFindById(Integer leaseId) {
        map = new HashMap<>();

        VoLease voLease = myHouseDao.leaseFindById(leaseId);
        if (voLease != null){
            UploadUtil uploadUtil = new UploadUtil();
            //查询身份证照正面
            List<VoResourcesImg> idCardFront = uploadUtil.findImgByDate("sysLease", voLease.getId(), "idCardFront");
            voLease.setIdCardFrontFiles(idCardFront);
            //查询身份证照背面
            List<VoResourcesImg> idCardBack = uploadUtil.findImgByDate("sysLease", voLease.getId(), "idCardBack");
            voLease.setIdCardBackFiles(idCardBack);
        }
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voLease);

        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> submitPersonalLeaseInfo(SysLease sysLease) {
        map = new HashMap<>();
        long descUrl = new IdWorker(1, 1, 1).nextId();


        try {
            int update = myHouseDao.submitPersonalLeaseInfo(sysLease);
            if (update <=0){
                throw new RuntimeException("修改数据库失败");
            }

            //查询当前开启的合同模版
            SysLeaseContract sysLeaseContract = myHouseDao.findEnableLeaseContract();
            if (sysLeaseContract == null){
                throw new RuntimeException("当前无启用合同模版");
            }
            UploadUtil uploadUtil = new UploadUtil();

            //保存身份证照正面照
            uploadUtil.saveUrlToDB(sysLease.getIdCardFrontImgUrl(),"sysLease", sysLease.getId(), "idCardFront","600",30,20);
            //保存身份证照背面照
            uploadUtil.saveUrlToDB(sysLease.getIdCardBackImgUrl(),"sysLease", sysLease.getId(), "idCardBack","600",30,20);

            try {
                // 获取项目同级目录，传入static中
                String realPath = new File(ResourceUtils.getURL("classpath:").getPath()).getParentFile().getParentFile().getParent()+"/static";
                String descRootPath = realPath + "/temp"+ UPLOAD_LEASE_CONTRACT_PREVIEW_PDF;
                //生成预览合同
                //查询可用的合同模版
                List<VoResourcesImg> sysLeaseContractImgData = uploadUtil.findImgByDate("sysLeaseContract", sysLeaseContract.getId(), "leaseContractPdf");
                if (sysLeaseContractImgData == null || sysLeaseContractImgData.size() <= 0){
                    throw new RuntimeException("无可用合同模版");
                }
                String src = realPath + sysLeaseContractImgData.get(0).getUrl();
                String dest = descRootPath + descUrl+".pdf";
                log.info("查询到可用的合同模版,路径为："+src);
                log.info("预览合同预生成路径："+dest);

//                String src = "/Users/AKU001/pdf/模版2.pdf";
//                String dest = "/Users/AKU001/pdf/"+descUrl+".pdf";
                ArrayList<PdfReplaceMap> pdfReplaceMaps = new ArrayList<>();

                //查询租赁信息
                VoLease voLease = myHouseDao.leaseFindById(sysLease.getId());

                //填写需要替换的信息
                pdfReplaceMaps.add(new PdfReplaceMap("${合同编号}",voLease.getCode()));
                pdfReplaceMaps.add(new PdfReplaceMap("${承租人}",voLease.getName()));
                pdfReplaceMaps.add(new PdfReplaceMap("${承租人身份证号}",voLease.getIdCard()));
                pdfReplaceMaps.add(new PdfReplaceMap("${手机号}",voLease.getTel()));
                pdfReplaceMaps.add(new PdfReplaceMap("${房屋户型}",voLease.getEstateType()));
                pdfReplaceMaps.add(new PdfReplaceMap("${房屋结构}",voLease.getEstateStructure()));
                pdfReplaceMaps.add(new PdfReplaceMap("${建筑面积}",voLease.getConstructionArea().toString()));
                pdfReplaceMaps.add(new PdfReplaceMap("${使用面积}",voLease.getIndoorArea().toString()));
                pdfReplaceMaps.add(new PdfReplaceMap("${保证金大写}", ConvertUpMoney.toChinese(voLease.getMargin().toString())));
                pdfReplaceMaps.add(new PdfReplaceMap("${保证金数字}",voLease.getMargin().toString()));
                DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
                pdfReplaceMaps.add(new PdfReplaceMap("${租赁开始时间}",format.format(voLease.getLeaseDateStart())));
                pdfReplaceMaps.add(new PdfReplaceMap("${租赁结束时间}",format.format(voLease.getLeaseDateEnd())));
                pdfReplaceMaps.add(new PdfReplaceMap("${办理人}",voLease.getCreateName()));
                pdfReplaceMaps.add(new PdfReplaceMap("${紧急联系人}",voLease.getEmergencyContact()));
                pdfReplaceMaps.add(new PdfReplaceMap("${紧急联系人电话}",voLease.getEmergencyContactNumber()));
                pdfReplaceMaps.add(new PdfReplaceMap("${通讯地址}",voLease.getCorrespondenceAddress()));
                pdfReplaceMaps.add(new PdfReplaceMap("${工作单位}",voLease.getWorkUnits()));
                pdfReplaceMaps.add(new PdfReplaceMap("${代缴银行账户名}",voLease.getBankAccountName()));
                pdfReplaceMaps.add(new PdfReplaceMap("${代缴银行账户}",voLease.getBankAccount()));

                //插入图片
                if (voLease.getType() == 1){
                    pdfReplaceMaps.add(new PdfReplaceMap("\uF0A3一类人才","正方形"));
                }else if (voLease.getType() == 2){
                    pdfReplaceMaps.add(new PdfReplaceMap("\uF0A3二类人才","正方形"));
                }else if (voLease.getType() == 3){
                    pdfReplaceMaps.add(new PdfReplaceMap("\uF0A3三类人才","正方形"));
                }
                log.info("信息已填写");
                PdfUtils.pdfReplace(src,descRootPath,dest,pdfReplaceMaps);
            } catch (Exception e) {
                throw new RuntimeException("生成预览合同异常");
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
        map.put("message","填写成功");
        map.put("status",true);
        map.put("data","/temp"+UPLOAD_LEASE_CONTRACT_PREVIEW_PDF+descUrl+".pdf");
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> generateValidContract(AppLeaseValidContract appLeaseValidContract) {
        map = new HashMap<>();
        long descUrl = new IdWorker(1, 1, 1).nextId();

        try {
            try {
                // 获取项目同级目录，传入static中
                String realPath = new File(ResourceUtils.getURL("classpath:").getPath()).getParentFile().getParentFile().getParent()+"/static";
                //预览合同作为底板来绘画签名
                String src = realPath + appLeaseValidContract.getContractPreviewImgUrl();
                String destRootPath = realPath +UPLOAD_LEASE_CONTRACT_SIGNED_PDF;
                String dest = realPath +UPLOAD_LEASE_CONTRACT_SIGNED_PDF+ descUrl+".pdf";

//                //预览合同作为底板来绘画签名
//                String src = "/Users/AKU001/pdf/163458752756977664.pdf";
//                String dest = "/Users/AKU001/pdf/"+descUrl+".pdf";

                ArrayList<PdfReplaceMap> pdfReplaceMaps = new ArrayList<>();
                pdfReplaceMaps.add(new PdfReplaceMap("【$签字区】",appLeaseValidContract.getContractSignatureImgUrl()));
//                pdfReplaceMaps.add(new PdfReplaceMap("【$签字区】","/Users/AKU001/pdf/黑色.jpeg"));
                PdfUtils.pdfReplace(src,destRootPath,dest,pdfReplaceMaps);
            } catch (Exception e) {
                throw new RuntimeException("生成合同异常");
            }
            //手动将文件路径存入数据库
            ResourcesImg resourcesImg = new ResourcesImg();
            //填入表名称
            resourcesImg.setTableName("sysLease");
            //填入数据所属id
            resourcesImg.setDateId(appLeaseValidContract.getId());
            //填入类型名称
            resourcesImg.setTypeName("leaseContractSignedPdf");
            //填入图片路径
            resourcesImg.setUrl(UPLOAD_LEASE_CONTRACT_SIGNED_PDF+ descUrl+".pdf");
            //填入图片大小
            resourcesImg.setSize("600");
            //填入长（像素）
            resourcesImg.setLongs(30);
            //填入宽（像素）
            resourcesImg.setParagraph(20);
            //查询该表，该类型名称的照片数量
            int count = resourcesImgDao.countByData(resourcesImg);
            if (count > 0){
                resourcesImg.setSort(count+1);
            }else {
                resourcesImg.setSort(1);
            }
            //添加该照片数据到数据库中
            int insert2 = resourcesImgDao.insert(resourcesImg);
            if (insert2 <= 0){
                throw new RuntimeException("添加照片数据失败");
            }

            //修改租赁状态
            //办理状态，1.待签署，2.待提交，3.审核中，4.已驳回，5.待支付，6.已完成
            SysLease sysLease = new SysLease();
            sysLease.setId(appLeaseValidContract.getId());//填入租赁主键id
            sysLease.setStatus(2);//填入状态2.待提交
            int update = myHouseDao.updateStatusById(sysLease);
            if (update <=0){
                throw new RuntimeException("签名失败，状态修改失败");
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
        map.put("message","签名成功");
        map.put("status",true);
        map.put("data",UPLOAD_LEASE_CONTRACT_SIGNED_PDF+ descUrl+".pdf");

        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> submitAudit(AppLeaseSubmitAudit appLeaseSubmitAudit) {
        map = new HashMap<>();

        try {
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(appLeaseSubmitAudit.getLeaseContractValidPdfUrl(),"sysLease",appLeaseSubmitAudit.getId(),"leaseContractValidPdf","600",30,20);
            //办理状态，1.待签署，2.待提交，3.审核中，4.已驳回，5.待支付，6.已完成
            SysLease sysLease = new SysLease();
            sysLease.setId(appLeaseSubmitAudit.getId());//填入租赁主键id
            sysLease.setStatus(3);//填入状态3.审核中
            int update = myHouseDao.updateStatusById(sysLease);
            if (update <=0){
                throw new RuntimeException("提交失败，状态修改失败");
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
        map.put("message","提交成功");
        map.put("status",true);
        return map;
    }

}
