package com.api.manage.service.basicArchives.impl;

import com.api.manage.dao.basicArchives.AuditManagementDao;
import com.api.manage.service.basicArchives.AuditManagementService;
import com.api.model.basicArchives.AuditManagementSearch;
import com.api.vo.basicArchives.VoAuditManagement;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuditManagementServiceImpl implements AuditManagementService {
    @Resource
    AuditManagementDao auditManagementDao;

    @Override
    public List<VoAuditManagement> list(AuditManagementSearch auditManagementSearch) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (auditManagementSearch.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = auditManagementSearch.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                auditManagementSearch.setBuildingNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                auditManagementSearch.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                auditManagementSearch.setRoomNumber(split[2]);
            }
        }

        return auditManagementDao.list(auditManagementSearch);
    }
}
