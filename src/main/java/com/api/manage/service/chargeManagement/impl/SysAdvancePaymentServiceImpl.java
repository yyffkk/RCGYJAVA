package com.api.manage.service.chargeManagement.impl;

import com.api.manage.dao.chargeManagement.SysAdvancePaymentDao;
import com.api.manage.service.chargeManagement.SysAdvancePaymentService;
import com.api.model.alipay.SysAdvancePaymentOrder;
import com.api.model.chargeManagement.SearchAdvancePayment;
import com.api.vo.chargeManagement.VoAdvancePayment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysAdvancePaymentServiceImpl implements SysAdvancePaymentService {
    @Resource
    SysAdvancePaymentDao sysAdvancePaymentDao;

    @Override
    public List<VoAdvancePayment> list(SearchAdvancePayment searchAdvancePayment) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchAdvancePayment.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = searchAdvancePayment.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchAdvancePayment.setBuildingNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchAdvancePayment.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchAdvancePayment.setRoomNumber(split[2]);
            }
        }

        List<VoAdvancePayment> list = sysAdvancePaymentDao.list(searchAdvancePayment);

        if (list != null && list.size()>0){
            for (VoAdvancePayment voAdvancePayment : list) {
                //填入最近充值时间
                //根据房产主键Id查询最近充值订单时间
                SysAdvancePaymentOrder sysAdvancePaymentOrder = sysAdvancePaymentDao.findNearDateByEstateId(voAdvancePayment.getId());
                if (sysAdvancePaymentOrder != null){
                    voAdvancePayment.setNearDate(sysAdvancePaymentOrder.getCreateDate());
                }
            }
        }
        return list;
    }
}
