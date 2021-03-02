package com.api.app.service.butler.impl;

import com.api.app.dao.butler.DecorationApplicationDao;
import com.api.app.service.butler.DecorationApplicationService;
import com.api.model.app.*;
import com.api.vo.app.AppDecorationAdditionalCostVo;
import com.api.vo.app.AppDecorationApplicationVo;
import com.api.vo.app.AppDecorationCostVo;
import com.api.vo.app.AppDecorationVo;
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
    public Map<String, Object> decorationCostDetail() {
        map = new HashMap<>();
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
                userDecoration.setStatus(-3);
            }else{
                map.put("message","申请成功，请等待业主同意");
                map.put("status",false);
                userDecoration.setStatus(-1);
            }
            //添加装修信息
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
    public Map<String, Object> insertDecorationPerson(AppUserDecorationSubmit decorationSubmit) {
        return null;
    }
}
