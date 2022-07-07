package com.api.manage.service.chargeManagement.impl;

import com.api.manage.dao.butlerService.SysDispatchListDao;
import com.api.manage.dao.chargeManagement.SysDailyPaymentDao;
import com.api.manage.dao.chargeManagement.SysWorkOrderCostDao;
import com.api.model.chargeManagement.SearchDailyPayment;
import com.api.manage.service.chargeManagement.SysWorkOrderCostService;
import com.api.vo.butlerService.VoFindCodeAndIdSDPI;
import com.api.vo.chargeManagement.VoWorkOrderCost;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysWorkOrderCostServiceImpl implements SysWorkOrderCostService {
    private static Map<String,Object> map = null;
    @Resource
    SysWorkOrderCostDao sysWorkOrderCostDao;
    @Resource
    SysDispatchListDao sysDispatchListDao;
    @Resource
    SysDailyPaymentDao sysDailyPaymentDao;

    @Override
    public List<VoWorkOrderCost> list(SearchDailyPayment searchDailyPayment) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchDailyPayment.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = searchDailyPayment.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchDailyPayment.setEstateNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchDailyPayment.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchDailyPayment.setRoomNumber(split[2]);
            }
        }
        List<VoWorkOrderCost> list = sysWorkOrderCostDao.list(searchDailyPayment);
        if (list != null && list.size()>0){
            for (VoWorkOrderCost voWorkOrderCost : list) {
                //根据缴费主键id查询费用单号（工单号）和工单主键id
                VoFindCodeAndIdSDPI voFindCodeAndIdSDPI = sysDispatchListDao.findCodeAndIdBySDPI(voWorkOrderCost.getId());
                //填入费用单号和工单主键id
                voWorkOrderCost.setDispatchListCode(voFindCodeAndIdSDPI.getCode());
                voWorkOrderCost.setDispatchListId(voFindCodeAndIdSDPI.getId());
                //根据缴费主键id查询缴费订单支付单号
                String code = sysDailyPaymentDao.findOrderCodeBySDPI(voWorkOrderCost.getId());
                //填入交易号
                voWorkOrderCost.setOrderCode(code);
            }
        }

        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> falseDelete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int update = sysWorkOrderCostDao.falseDelete(id);
                if (update <= 0){
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
}
