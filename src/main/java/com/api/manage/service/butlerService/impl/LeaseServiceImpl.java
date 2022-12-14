package com.api.manage.service.butlerService.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.api.manage.dao.butlerService.LeaseDao;
import com.api.manage.dao.resources.ResourcesImgDao;
import com.api.manage.service.butlerService.LeaseService;
import com.api.model.alipay.SysLeaseOrder;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.SearchLease;
import com.api.model.butlerService.SysLease;
import com.api.model.butlerService.SysLeasePaymentRecords;
import com.api.model.butlerService.SysLeaseRenew;
import com.api.model.resources.ResourcesImg;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.VoFBILease;
import com.api.vo.butlerService.VoLease;
import com.api.vo.resources.VoResourcesImg;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class LeaseServiceImpl implements LeaseService {
    private static Map<String,Object> map = null;
    @Resource
    LeaseDao leaseDao;
    @Resource
    ResourcesImgDao resourcesImgDao;

    @Value("${alipay.aliPayAppId}")
    private String ALIPAY_APP_ID;
    @Value("${alipay.rsaPrivatKey}")
    private String RSA_PRIVAT_KEY;
    @Value("${alipay.rsaAlipayPublicKey}")
    private String RSA_ALIPAY_PUBLIC_KEY;
    @Value("${alipay.aliPayGateway}")
    private String ALIPAY_GATEWAY;
    @Value("${alipay.signType}")
    private String SIGN_TYPE;
    @Value("${alipay.alipayFormat}")
    private String ALIPAY_FORMAT;
    @Value("${alipay.alipayCharset}")
    private String ALIPAY_CHARSET;

    @Override
    public List<VoLease> list(SearchLease searchLease) {
        List<VoLease> list = leaseDao.list(searchLease);
        if (list != null && list.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (VoLease voLease : list) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysLease", voLease.getId(), "leaseContractValidPdf");
                voLease.setImgUrls(imgByDate);

                //保存身份证照正面照
                List<VoResourcesImg> imgByDate1 = uploadUtil.findImgByDate("sysLease", voLease.getId(), "idCardFront");
                voLease.setIdCardFrontFiles(imgByDate1);

                //保存身份证照背面照
                List<VoResourcesImg> imgByDate2 = uploadUtil.findImgByDate("sysLease", voLease.getId(), "idCardBack");
                voLease.setIdCardBackFiles(imgByDate2);

                //查询租赁剩余需结清房租（元）
                BigDecimal requiredRent = leaseDao.findLeaseRemainingRental(voLease.getId());
                if (voLease.getTakeDate() != null){
                    //获取收房日期是几号
                    int day= Integer.parseInt(String.format("%td",voLease.getTakeDate()));

                    Date date = voLease.getTakeDate();
                    if (day > 15){
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(date);
                        cal.set(Calendar.DAY_OF_MONTH, 1);
                        cal.add(Calendar.MONTH, 1);
                        cal.add(Calendar.DATE, -1);
                        Date time = cal.getTime();
                        log.info("主键id为"+voLease.getId()+"的不再计租时间为："+new SimpleDateFormat("yyyy-MM-dd").format(time));
                        voLease.setNotMeterRentDate(time);
                        //当大于15号时，租金算整月，剩余需结清房租不减任何租金
                        requiredRent = requiredRent.subtract(BigDecimal.ZERO);
                    }else {
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(date);
                        cal.set(Calendar.DAY_OF_MONTH, 1);
                        Date time = cal.getTime();
                        voLease.setNotMeterRentDate(time);
                        //当小于15号及15号时，租金算半月，剩余需结清房租需要减去半个月租金
                        requiredRent = requiredRent.subtract(voLease.getRentStandard().multiply(new BigDecimal(0.5)));
                    }
                }

                //填入剩余需结清房租
                voLease.setRequiredRent(requiredRent);
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> insert(SysLease sysLease) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysLease.setCreateId(sysUser.getId());
        sysLease.setCreateDate(new Date());
        sysLease.setStatus(1);//1.待签署

        int insert = leaseDao.insert(sysLease);
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
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();

        VoFBILease voFBILease = leaseDao.findById(id);

        UploadUtil uploadUtil = new UploadUtil();

        List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysLease", voFBILease.getId(), "leaseContractValidPdf");
        voFBILease.setImgUrls(imgByDate);

        //保存身份证照正面照
        List<VoResourcesImg> imgByDate1 = uploadUtil.findImgByDate("sysLease", voFBILease.getId(), "idCardFront");
        voFBILease.setIdCardFrontFiles(imgByDate1);

        //保存身份证照背面照
        List<VoResourcesImg> imgByDate2 = uploadUtil.findImgByDate("sysLease", voFBILease.getId(), "idCardBack");
        voFBILease.setIdCardBackFiles(imgByDate2);

        //查询租赁剩余需结清房租（元）
        BigDecimal requiredRent = leaseDao.findLeaseRemainingRental(voFBILease.getId());
        if (voFBILease.getTakeDate() != null){
            //获取收房日期是几号
            int day= Integer.parseInt(String.format("%td",voFBILease.getTakeDate()));

            Date date = voFBILease.getTakeDate();
            if (day > 15){
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                cal.add(Calendar.MONTH, 1);
                cal.add(Calendar.DATE, -1);
                Date time = cal.getTime();
                log.info("主键id为"+voFBILease.getId()+"的不再计租时间为："+new SimpleDateFormat("yyyy-MM-dd").format(time));
                voFBILease.setNotMeterRentDate(time);
                //当大于15号时，租金算整月，剩余需结清房租不减任何租金
                requiredRent = requiredRent.subtract(BigDecimal.ZERO);
            }else {
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                Date time = cal.getTime();
                voFBILease.setNotMeterRentDate(time);
                //当小于15号及15号时，租金算半月，剩余需结清房租需要减去半个月租金
                requiredRent = requiredRent.subtract(voFBILease.getRentStandard().multiply(new BigDecimal(0.5)));
            }
        }

        //填入剩余需结清房租
        voFBILease.setRequiredRent(requiredRent);

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voFBILease);
        return map;
    }

    @Override
    public Map<String, Object> update(SysLease sysLease) {
        map = new HashMap<>();

        VoFBILease byId = leaseDao.findById(sysLease.getId());
        if (byId.getStatus() != 1){
            map.put("message","该状态不允许修改信息");
            map.put("status",false);
            return map;
        }

        int update = leaseDao.update(sysLease);
        if (update >0){
            map.put("message","修改成功");
            map.put("status",true);
        }else {
            map.put("message","修改失败");
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
                VoFBILease byId = leaseDao.findById(id);
                if (byId.getStatus() != 1){
                    throw new RuntimeException("该状态不可删除");
                }

                int delete = leaseDao.delete(id);
                if (delete <= 0){
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
    public Map<String, Object> reviewer(SysLease sysLease) {
        map = new HashMap<>();
        VoFBILease byId = leaseDao.findById(sysLease.getId());
        if (byId.getStatus() != 1 && byId.getStatus() != 3){//3.审核中
            map.put("message","该状态不可审核");
            map.put("status",false);
            return map;
        }
        if(byId.getStatus()==1 ){
            if(sysLease.getStatus()==5) {
                sysLease.setStatus(3);
            }else{
                sysLease.setStatus(4);
            }
        }
        if(byId.getStatus()==3){
            if(sysLease.getStatus()==5) {
                sysLease.setStatus(5);
            }else{
                sysLease.setStatus(4);
            }
        }
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysLease.setReviewer(sysUser.getId());
        sysLease.setAuditDate(new Date());

        int update = leaseDao.reviewer(sysLease);
        if (update >0 ){
            map.put("message","审核成功");
            map.put("status",true);
        }else {
            map.put("message","审核失败");
            map.put("status",false);
        }

        return map;
    }

    @Override
    public Map<String, Object> reviewTerminationApplication(SysLease sysLease) {
        map = new HashMap<>();
        VoFBILease byId = leaseDao.findById(sysLease.getId());
        if (byId == null){
            map.put("message","该记录不存在");
            map.put("status",false);
            return map;
        }
        if (byId.getStatus() != 11){//11.申请终止合同
            map.put("message","该状态不可审核");
            map.put("status",false);
            return map;
        }

        //审核合同终止申请(修改租赁状态及合同终止信息)[确定不再计租时间和剩余需结清房租]
        int update = leaseDao.reviewTerminationApplication(sysLease);
        if (update > 0){
            map.put("message","审核成功");
            map.put("status",true);
        }else {
            map.put("message","审核失败");
            map.put("status",false);
        }

        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> reviewDepositRefundApplication(SysLease sysLease) {
        map = new HashMap<>();
        try {
            VoFBILease byId = leaseDao.findById(sysLease.getId());
            if (byId.getStatus() != 15){//15申请退还保证金
                throw new RuntimeException("该状态不可审核");
            }

            //审核合同终止申请(修改租赁状态及合同终止信息)
            int update = leaseDao.reviewDepositRefundApplication(sysLease);
            if (update <= 0){
                throw new RuntimeException("审核失败");
            }

            if (sysLease.getStatus() == 16){//16.申请退还保证金驳回
                //该状态不处理任何数据
            }else if (sysLease.getStatus() == 17){//17.申请退还保证金成功（需要内部调用支付宝退款接口）
                //根据租赁主键id查询唯一已支付的保证金订单信息
                SysLeaseOrder sysLeaseOrder = leaseDao.findPaySysLeaseOrderById(sysLease.getId());
                if (sysLeaseOrder == null){
                    throw new RuntimeException("不存在未退款的保证金");
                }

                //调用支付宝退款接口
                String out_request_no= String.valueOf(new IdWorker(1,1,1).nextId());//随机数  不是全额退款，部分退款必须使用该参数

                AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
                AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
                request.setBizContent("{" +
                        "\"out_trade_no\":\"" + sysLeaseOrder.getCode() + "\"," +
                        "\"trade_no\":" + null + "," +
                        "\"refund_amount\":\"" + sysLeaseOrder.getPayPrice() + "\"," +

                        "\"out_request_no\":\"" + out_request_no+ "\"," +
                        "\"refund_reason\":\"正常退款\"" +
                        " }");
                AlipayTradeRefundResponse response;
                response = alipayClient.execute(request);
                if (response.isSuccess()) {
                    log.info("支付宝退款成功");
                } else {
                    throw new RuntimeException(response.getSubMsg());//失败会返回错误信息
                }
            }else {
                throw new RuntimeException("状态数据异常");
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
        map.put("message","审核成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> renew(SysLeaseRenew sysLeaseRenew) {
        map = new HashMap<>();

        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            sysLeaseRenew.setCreateId(sysUser.getId());
            sysLeaseRenew.setCreateDate(new Date());
            sysLeaseRenew.setStatus(1);//1.待签署


            int insert = leaseDao.renew(sysLeaseRenew);
            if (insert <= 0){
                throw new RuntimeException("添加失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            //保持身份证正面照片
            if (sysLeaseRenew.getIdCardFrontImgNewUrl() != null && sysLeaseRenew.getIdCardFrontImgNewUrl().length >0){
                //保持新上传的身份证正面照片进数据库
                uploadUtil.saveUrlToDB(sysLeaseRenew.getIdCardFrontImgNewUrl(),"sysLease",sysLeaseRenew.getId(),"idCardFront","600",30,20);
            }else {
                //保持原身份证正面照片进数据库
                String[] imgOldUrls = sysLeaseRenew.getIdCardFrontImgOldUrl();
                for (String imgOldUrl : imgOldUrls) {
                    //保存后，将文件路径存入数据库
                    ResourcesImg resourcesImg = new ResourcesImg();
                    //填入表名称
                    resourcesImg.setTableName("sysLease");
                    //填入数据所属id
                    resourcesImg.setDateId(sysLeaseRenew.getId());
                    //填入类型名称
                    resourcesImg.setTypeName("idCardFront");
                    //填入图片路径
                    resourcesImg.setUrl(imgOldUrl);
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
                        throw new RuntimeException("添加身份证照正面照片路径失败");
                    }
                }

            }


            //保持身份证背面照片
            if (sysLeaseRenew.getIdCardBackImgNewUrl() != null && sysLeaseRenew.getIdCardFrontImgNewUrl().length >0){
                //保持新上传的身份证背面照片进数据库
                uploadUtil.saveUrlToDB(sysLeaseRenew.getIdCardBackImgNewUrl(),"sysLease",sysLeaseRenew.getId(),"idCardBack","600",30,20);
            }else {
                String[] imgOldUrls = sysLeaseRenew.getIdCardBackImgOldUrl();
                for (String imgOldUrl : imgOldUrls) {
                    //保持原身份证背面照片进数据库
                    //保存后，将文件路径存入数据库
                    ResourcesImg resourcesImg2 = new ResourcesImg();
                    //填入表名称
                    resourcesImg2.setTableName("sysLease");
                    //填入数据所属id
                    resourcesImg2.setDateId(sysLeaseRenew.getId());
                    //填入类型名称
                    resourcesImg2.setTypeName("idCardBack");
                    //填入图片路径
                    resourcesImg2.setUrl(imgOldUrl);
                    //填入图片大小
                    resourcesImg2.setSize("600");
                    //填入长（像素）
                    resourcesImg2.setLongs(30);
                    //填入宽（像素）
                    resourcesImg2.setParagraph(20);
                    //查询该表，该类型名称的照片数量
                    int count2 = resourcesImgDao.countByData(resourcesImg2);
                    if (count2 > 0){
                        resourcesImg2.setSort(count2+1);
                    }else {
                        resourcesImg2.setSort(1);
                    }
                    //添加该照片数据到数据库中
                    int insert3 = resourcesImgDao.insert(resourcesImg2);
                    if (insert3 <= 0){
                        throw new RuntimeException("添加身份证照背面照片路径失败");
                    }
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
        map.put("message","添加成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findPaymentRecordsById(Integer id) {
        map = new HashMap<>();

        List<SysLeasePaymentRecords> paymentRecordsList = leaseDao.findPaymentRecordsById(id);
        map.put("message","请求成功");
        map.put("data",paymentRecordsList);
        map.put("status",true);

        return map;
    }
}
