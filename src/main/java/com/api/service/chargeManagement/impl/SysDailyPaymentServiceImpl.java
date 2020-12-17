package com.api.service.chargeManagement.impl;

import com.api.dao.chargeManagement.SysDailyPaymentDao;
import com.api.model.chargeManagement.SearchDailyPayment;
import com.api.service.chargeManagement.SysDailyPaymentService;
import com.api.vo.basicArchives.VoDecoration;
import com.api.vo.chargeManagement.VoDailyPayment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysDailyPaymentServiceImpl implements SysDailyPaymentService {
    @Resource
    SysDailyPaymentDao sysDailyPaymentDao;

    @Override
    public List<VoDailyPayment> list(SearchDailyPayment searchDailyPayment) {
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
        List<VoDailyPayment> list = sysDailyPaymentDao.list(searchDailyPayment);
        if (list != null && list.size()>0){
            //处理显示的roomName信息
            for (VoDailyPayment voDailyPayment : list) {
                voDailyPayment.setRoomName(voDailyPayment.getEstateNo()+"-"+voDailyPayment.getUnitNo()+"-"+voDailyPayment.getRoomNumber());
            }
        }
        return list;
    }
}
