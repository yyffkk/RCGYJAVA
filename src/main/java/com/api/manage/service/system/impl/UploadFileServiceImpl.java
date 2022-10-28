package com.api.manage.service.system.impl;

import com.api.manage.dao.system.UploadFileDao;
import com.api.manage.service.system.UploadFileService;
import com.api.model.basicArchives.CpmBuilding;
import com.api.model.basicArchives.CpmBuildingUnit;
import com.api.model.basicArchives.CpmBuildingUnitEstate;
import com.api.model.businessManagement.SysUser;
import com.api.model.chargeManagement.DailyPayment;
import com.api.model.operationManagement.SysGreenArea;
import com.api.model.operationManagement.SysKeyManagement;
import com.api.model.operationManagement.SysServiceBrowsing;
import com.api.util.ExcelReadUtils;
import com.api.util.IdWorker;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UploadFileServiceImpl implements UploadFileService {
    private static Map<String,Object> map = null;
    @Resource
    UploadFileDao uploadFileDao;

    @Override
    @Transactional
    public Map<String, Object> UploadBuildingFile(MultipartFile file) {
        map = new HashMap<>();

        try {
            //创建处理EXCEL的类
            ExcelReadUtils readExcel = new ExcelReadUtils();
            //解析excel，获取上传的事件单
            List<Map<String, Object>> userList = readExcel.getExcelInfo(file);

            if(userList == null || userList.isEmpty()){
                throw new RuntimeException("导入失败");
            }

            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
            for(Map<String, Object> user:userList){
                CpmBuilding cpmBuilding = new CpmBuilding();

                cpmBuilding.setNo(Integer.valueOf(user.get("楼栋编号").toString()));
                cpmBuilding.setName(user.get("房间号").toString());


                //获取登录用户信息
                Subject subject = SecurityUtils.getSubject();
                SysUser sysUser = (SysUser) subject.getPrincipal();

                cpmBuilding.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16));
                cpmBuilding.setCreateId(sysUser.getId());
                cpmBuilding.setCreateDate(new Date());


                //添加楼栋信息
                int ret = uploadFileDao.insertBuilding(cpmBuilding);
                if(ret == 0){
                    throw new RuntimeException("插入数据库失败");
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
        map.put("message","导入成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> UploadBuildingUnitFile(MultipartFile file) {
        map = new HashMap<>();

        try {
            //创建处理EXCEL的类
            ExcelReadUtils readExcel = new ExcelReadUtils();
            //解析excel，获取上传的事件单
            List<Map<String, Object>> userList = readExcel.getExcelInfo(file);

            if(userList == null || userList.isEmpty()){
                throw new RuntimeException("导入失败");
            }

            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
            for(Map<String, Object> user:userList){
                CpmBuildingUnit cpmBuildingUnit = new CpmBuildingUnit();

                cpmBuildingUnit.setBuildingId(Integer.valueOf(user.get("楼栋导入编号").toString()));
                cpmBuildingUnit.setNo(Integer.valueOf(user.get("单元号").toString()));
                cpmBuildingUnit.setTotalFloor(Integer.valueOf(user.get("总层数").toString()));
                cpmBuildingUnit.setIsElevator(Integer.valueOf(user.get("是否有电梯(1.有，0.无)").toString()));

                if (cpmBuildingUnit.getIsElevator() != 1 && cpmBuildingUnit.getIsElevator() != 0){
                    throw new RuntimeException("数据有误，是否有电梯（1.有，0.无）");
                }

                //获取登录用户信息
                Subject subject = SecurityUtils.getSubject();
                SysUser sysUser = (SysUser) subject.getPrincipal();

                cpmBuildingUnit.setCreateId(sysUser.getId());
                cpmBuildingUnit.setCreateDate(new Date());

                //查询是否存在该楼栋导入编号
                CpmBuilding building = uploadFileDao.findByBuildingId(cpmBuildingUnit.getBuildingId());
                if (building == null){
                    throw new RuntimeException("该楼栋不存在");
                }


                //添加楼栋单元信息
                int ret = uploadFileDao.insertBuildingUnit(cpmBuildingUnit);
                if(ret == 0){
                    throw new RuntimeException("插入数据库失败");
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
        map.put("message","导入成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String,Object> UploadEstateFile(MultipartFile file) {
        map = new HashMap<>();

        try {
            //创建处理EXCEL的类
            ExcelReadUtils readExcel = new ExcelReadUtils();
            //解析excel，获取上传的事件单
            List<Map<String, Object>> userList = readExcel.getExcelInfo(file);

            if(userList == null || userList.isEmpty()){
                throw new RuntimeException("导入失败");
            }

            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
            for(Map<String, Object> user:userList){
                CpmBuildingUnitEstate cpmBuildingUnitEstate = new CpmBuildingUnitEstate();

//                cpmBuildingUnitEstate.setBuildingUnitId(Integer.valueOf(user.get("楼宇单元导入编号").toString()));
//                cpmBuildingUnitEstate.setBuildingId(Integer.valueOf(user.get("楼栋号").toString()));
//                cpmBuildingUnitEstate.setBuildingUnitId(Integer.valueOf(user.get("单元号").toString()));

               if(Integer.parseInt(user.get("楼栋号").toString())==1 && Integer.parseInt(user.get("单元号").toString())==1){
                   cpmBuildingUnitEstate.setBuildingUnitId(24);
               }else if(Integer.parseInt(user.get("楼栋号").toString())==1 && Integer.parseInt(user.get("单元号").toString())==2){
                   cpmBuildingUnitEstate.setBuildingUnitId(25);
               }else if(Integer.parseInt(user.get("楼栋号").toString())==2 && Integer.parseInt(user.get("单元号").toString())==1) {
                   cpmBuildingUnitEstate.setBuildingUnitId(26);
               }else if(Integer.parseInt(user.get("楼栋号").toString())==3 && Integer.parseInt(user.get("单元号").toString())==1) {
                   cpmBuildingUnitEstate.setBuildingUnitId(27);
               }else if(Integer.parseInt(user.get("楼栋号").toString())==3 && Integer.parseInt(user.get("单元号").toString())==2) {
                   cpmBuildingUnitEstate.setBuildingUnitId(28);
               }else if(Integer.parseInt(user.get("楼栋号").toString())==5 && Integer.parseInt(user.get("单元号").toString())==1) {
                   cpmBuildingUnitEstate.setBuildingUnitId(29);
               }else if(Integer.parseInt(user.get("楼栋号").toString())==5 && Integer.parseInt(user.get("单元号").toString())==2) {
                   cpmBuildingUnitEstate.setBuildingUnitId(30);
               }else if(Integer.parseInt(user.get("楼栋号").toString())==6 && Integer.parseInt(user.get("单元号").toString())==1) {
                   cpmBuildingUnitEstate.setBuildingUnitId(31);
               }else if(Integer.parseInt(user.get("楼栋号").toString())==6 && Integer.parseInt(user.get("单元号").toString())==2) {
                   cpmBuildingUnitEstate.setBuildingUnitId(32);
               }else if(Integer.parseInt(user.get("楼栋号").toString())==7 && Integer.parseInt(user.get("单元号").toString())==1) {
                   cpmBuildingUnitEstate.setBuildingUnitId(33);
               }else if(Integer.parseInt(user.get("楼栋号").toString())==7 && Integer.parseInt(user.get("单元号").toString())==2) {
                   cpmBuildingUnitEstate.setBuildingUnitId(34);
               }else if(Integer.parseInt(user.get("楼栋号").toString())==8 && Integer.parseInt(user.get("单元号").toString())==1) {
                   cpmBuildingUnitEstate.setBuildingUnitId(35);
               }else if(Integer.parseInt(user.get("楼栋号").toString())==8 && Integer.parseInt(user.get("单元号").toString())==2) {
                   cpmBuildingUnitEstate.setBuildingUnitId(36);
               }else if(Integer.parseInt(user.get("楼栋号").toString())==9 && Integer.parseInt(user.get("单元号").toString())==1) {
                   cpmBuildingUnitEstate.setBuildingUnitId(37);
               }else if(Integer.parseInt(user.get("楼栋号").toString())==9 && Integer.parseInt(user.get("单元号").toString())==2) {
                   cpmBuildingUnitEstate.setBuildingUnitId(38);
               }else if(Integer.parseInt(user.get("楼栋号").toString())==10 && Integer.parseInt(user.get("单元号").toString())==1) {
                   cpmBuildingUnitEstate.setBuildingUnitId(39);
               }else if(Integer.parseInt(user.get("楼栋号").toString())==10 && Integer.parseInt(user.get("单元号").toString())==2) {
                   cpmBuildingUnitEstate.setBuildingUnitId(40);
               }






                cpmBuildingUnitEstate.setRoomNumber(user.get("房间号").toString());
                cpmBuildingUnitEstate.setStatus(Integer.valueOf(user.get("房间状态").toString()));
                cpmBuildingUnitEstate.setType(Integer.valueOf(user.get("房间类型").toString()));
                cpmBuildingUnitEstate.setConstructionArea(new BigDecimal(user.get("建筑面积").toString()));
                cpmBuildingUnitEstate.setIndoorArea(new BigDecimal(user.get("室内面积").toString()));
                cpmBuildingUnitEstate.setDeviceNumber(user.get("对讲机设备号").toString());
                cpmBuildingUnitEstate.setIsDelete(1);//默认1.非删


                //获取登录用户信息
                Subject subject = SecurityUtils.getSubject();
                SysUser sysUser = (SysUser) subject.getPrincipal();

                cpmBuildingUnitEstate.setCreateId(sysUser.getId());
                cpmBuildingUnitEstate.setCreateDate(new Date());

                //查询是否存在该单元导入编号
                CpmBuildingUnit unit = uploadFileDao.findByUnitId(cpmBuildingUnitEstate.getBuildingUnitId());
                if (unit == null){
                    throw new RuntimeException("该单元不存在");
                }


                //添加楼栋信息
                int ret = uploadFileDao.insertEstate(cpmBuildingUnitEstate);
                if(ret == 0){
                    throw new RuntimeException("插入数据库失败");
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
        map.put("message","导入成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> UploadServiceBrowsingFile(MultipartFile file) {
        map = new HashMap<>();

        try {
            //创建处理EXCEL的类
            ExcelReadUtils readExcel = new ExcelReadUtils();
            //解析excel，获取上传的事件单
            List<Map<String, Object>> userList = readExcel.getExcelInfo(file);

            if(userList == null || userList.isEmpty()){
                throw new RuntimeException("导入失败");
            }

            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
            for(Map<String, Object> user:userList){
                SysServiceBrowsing sysServiceBrowsing = new SysServiceBrowsing();

                sysServiceBrowsing.setName(user.get("服务名称").toString());
                sysServiceBrowsing.setContent(user.get("服务介绍").toString());

                //获取登录用户信息
                Subject subject = SecurityUtils.getSubject();
                SysUser sysUser = (SysUser) subject.getPrincipal();

                sysServiceBrowsing.setCreateId(sysUser.getId());
                sysServiceBrowsing.setCreateDate(new Date());



                //添加服务浏览信息
                int ret = uploadFileDao.insertServiceBrowsing(sysServiceBrowsing);
                if(ret == 0){
                    throw new RuntimeException("插入数据库失败");
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
        map.put("message","导入成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> UploadKeyFile(MultipartFile file) {
        map = new HashMap<>();

        try {
            //创建处理EXCEL的类
            ExcelReadUtils readExcel = new ExcelReadUtils();
            //解析excel，获取上传的事件单
            List<Map<String, Object>> userList = readExcel.getExcelInfo(file);

            if(userList == null || userList.isEmpty()){
                throw new RuntimeException("导入失败");
            }

            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
            for(Map<String, Object> user:userList){
                SysKeyManagement sysKeyManagement = new SysKeyManagement();

                sysKeyManagement.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));
                sysKeyManagement.setFacilityName(user.get("设备名称").toString());
                sysKeyManagement.setNum(Integer.valueOf(user.get("钥匙数量").toString()));
                sysKeyManagement.setCorrespondingPosition(user.get("对应位置").toString());
                sysKeyManagement.setStorageLocation(user.get("存放位置").toString());
                sysKeyManagement.setAdministrator(user.get("管理员名称").toString());
                sysKeyManagement.setTel(user.get("管理员联系方式").toString());

                //获取登录用户信息
                Subject subject = SecurityUtils.getSubject();
                SysUser sysUser = (SysUser) subject.getPrincipal();

                sysKeyManagement.setCreateId(sysUser.getId());
                sysKeyManagement.setCreateDate(new Date());



                //添加钥匙信息
                int ret = uploadFileDao.insertKey(sysKeyManagement);
                if(ret == 0){
                    throw new RuntimeException("插入数据库失败");
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
        map.put("message","导入成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> UploadGreenAreaFile(MultipartFile file) {
        map = new HashMap<>();

        try {
            //创建处理EXCEL的类
            ExcelReadUtils readExcel = new ExcelReadUtils();
            //解析excel，获取上传的事件单
            List<Map<String, Object>> userList = readExcel.getExcelInfo(file);

            if(userList == null || userList.isEmpty()){
                throw new RuntimeException("导入失败");
            }

            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
            for(Map<String, Object> user:userList){
                SysGreenArea sysGreenArea = new SysGreenArea();

                sysGreenArea.setName(user.get("绿化区域").toString());
                sysGreenArea.setContent(user.get("工作内容").toString());
                sysGreenArea.setDepartment(user.get("部门").toString());
                sysGreenArea.setCharge(user.get("负责人员").toString());
                sysGreenArea.setEndDate(user.get("截止时间").toString());
                //获取登录用户信息
                Subject subject = SecurityUtils.getSubject();
                SysUser sysUser = (SysUser) subject.getPrincipal();

                sysGreenArea.setCreateId(sysUser.getId());
                sysGreenArea.setCreateDate(new Date());



                //添加绿化区域信息
                int ret = uploadFileDao.insertGreenArea(sysGreenArea);
                if(ret == 0){
                    throw new RuntimeException("插入数据库失败");
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
        map.put("message","导入成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> UploadDailyPaymentFile(MultipartFile file) {
        map = new HashMap<>();

        try {
            //创建处理EXCEL的类
            ExcelReadUtils readExcel = new ExcelReadUtils();
            //解析excel，获取上传的事件单
            List<Map<String, Object>> userList = readExcel.getExcelInfo(file);

            if(userList == null || userList.isEmpty()){
                throw new RuntimeException("导入失败");
            }

            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
            for(Map<String, Object> user:userList){
                DailyPayment dailyPayment = new DailyPayment();

                dailyPayment.setBuildingUnitEstateId(Integer.valueOf(user.get("楼宇单元房产导入编号").toString()));
                dailyPayment.setChargesTemplateDetailId(Integer.valueOf(user.get("费用名称类型导入编号").toString()));

                //获得SimpleDateFormat类，我们转换为yyyy-MM-dd的时间格式
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    //使用SimpleDateFormat的parse()方法生成Date
                    Date beginDate = sf.parse(user.get("计费开始时间（yyyy-MM-dd）").toString());
                    dailyPayment.setBeginDate(beginDate);
                    Date endDate = sf.parse(user.get("计费结束时间（yyyy-MM-dd）").toString());
                    dailyPayment.setEndDate(endDate);
                    //填入缴费期限
                    Date paymentTerm = sf.parse(user.get("缴费期限").toString());
                    dailyPayment.setPaymentTerm(paymentTerm);
                } catch (ParseException e) {
                    e.printStackTrace();
                    throw new RuntimeException("时间格式有误，请遵循yyyy-MM-dd格式，例如：'2016-12-31'");
                }

                dailyPayment.setUnitPrice(new BigDecimal(user.get("计费单价").toString()));
                dailyPayment.setType(Integer.valueOf(user.get("计费单位（1.元/月 平方米，2.元/ 立方米，3.元/ 次）").toString()));
                dailyPayment.setNum(Integer.valueOf(user.get("面积/用量/数量").toString()));
                //填入费率（先默认为0），将excel费率
                dailyPayment.setRate(Integer.valueOf(user.get("费率").toString()));
                //填入已缴金额
                dailyPayment.setPaidPrice(BigDecimal.ZERO);
                //填入费用金额(单价*用量)
                dailyPayment.setCostPrice(dailyPayment.getUnitPrice().multiply(BigDecimal.valueOf(dailyPayment.getNum())));
                //填入应收总计(费用金额)
                dailyPayment.setTotalPrice(dailyPayment.getCostPrice());
                //填入待缴金额
                dailyPayment.setPaymentPrice(dailyPayment.getCostPrice());
                //填入状态(1.未缴纳)
                dailyPayment.setStatus(1);
                //填入是否删除，0.删除 1.非删
                dailyPayment.setIsDelete(1);

                //获取登录用户信息
                Subject subject = SecurityUtils.getSubject();
                SysUser sysUser = (SysUser) subject.getPrincipal();

                dailyPayment.setCreateId(sysUser.getId());
                dailyPayment.setCreateDate(new Date());

                //添加日常缴费信息
                int ret = uploadFileDao.insertDailyPayment(dailyPayment);
                if(ret == 0){
                    throw new RuntimeException("插入数据库失败");
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
        map.put("message","导入成功");
        map.put("status",true);
        return map;
    }
}
