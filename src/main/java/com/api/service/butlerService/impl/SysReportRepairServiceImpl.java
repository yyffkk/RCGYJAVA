package com.api.service.butlerService.impl;

import com.api.dao.butlerService.SysReportRepairDao;
import com.api.model.butlerService.SearchReportRepair;
import com.api.service.butlerService.SysReportRepairService;
import com.api.vo.butlerService.VoReportRepair;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysReportRepairServiceImpl implements SysReportRepairService {
    private static Map<String,Object> map = null;
    @Resource
    SysReportRepairDao sysReportRepairDao;

    @Override
    public List<VoReportRepair> list(SearchReportRepair searchReportRepair) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchReportRepair.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = searchReportRepair.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchReportRepair.setEstateNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchReportRepair.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchReportRepair.setRoomNumber(split[2]);
            }
        }
        List<VoReportRepair> list = sysReportRepairDao.list(searchReportRepair);
        return list;
    }

}
