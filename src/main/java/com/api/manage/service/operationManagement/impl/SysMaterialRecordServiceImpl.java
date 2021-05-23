package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysMaterialRecordDao;
import com.api.manage.service.operationManagement.SysMaterialRecordService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchMaterialRecord;
import com.api.model.operationManagement.SysMaterialRecord;
import com.api.vo.operationManagement.VoMaterialRecord;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysMaterialRecordServiceImpl implements SysMaterialRecordService {
    private static Map<String,Object> map = null;
    @Resource
    SysMaterialRecordDao sysMaterialRecordDao;

    @Override
    public List<VoMaterialRecord> list(SearchMaterialRecord searchMaterialRecord) {
        return sysMaterialRecordDao.list(searchMaterialRecord);
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysMaterialRecord sysMaterialRecord) {
        map = new HashMap<>();
        String msg = "";
        try {
            //修改物料库存
            if (sysMaterialRecord.getType() == 1){
                //1.出库
                int update = sysMaterialRecordDao.delivery(sysMaterialRecord);
                if (update <=0){
                    throw new RuntimeException("出库失败");
                }
                msg = "出库";
            }else if (sysMaterialRecord.getType() == 2){
                //2.入库
                int update = sysMaterialRecordDao.warehousing(sysMaterialRecord);
                if (update <=0){
                    throw new RuntimeException("入库失败");
                }
                msg = "入库";
            }else {
                throw new RuntimeException("出入库类型数据有误");
            }

            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            sysMaterialRecord.setCreateId(sysUser.getId());
            sysMaterialRecord.setCreateDate(new Date());

            int insert = sysMaterialRecordDao.insert(sysMaterialRecord);
            if (insert <= 0){
                throw new RuntimeException(msg+"失败");
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
        map.put("message",msg+"成功");
        map.put("status",true);
        return map;
    }
}