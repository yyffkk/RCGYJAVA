package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysMaterialInventoryDao;
import com.api.manage.service.operationManagement.SysMaterialInventoryService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchMaterialInventory;
import com.api.model.operationManagement.SysMaterialInventory;
import com.api.model.operationManagement.SysMaterialInventoryDetail;
import com.api.vo.operationManagement.VoMaterialInventory;
import com.api.vo.operationManagement.VoMaterialInventoryDetail;
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
public class SysMaterialInventoryServiceImpl implements SysMaterialInventoryService {
    private static Map<String,Object> map = null;
    @Resource
    SysMaterialInventoryDao sysMaterialInventoryDao;

    @Override
    public List<VoMaterialInventory> list(SearchMaterialInventory searchMaterialInventory) {
        List<VoMaterialInventory> list = sysMaterialInventoryDao.list(searchMaterialInventory);
        if (list != null && list.size()>0){
            for (VoMaterialInventory voMaterialInventory : list) {
                int count = sysMaterialInventoryDao.countSMIDBySMIId(voMaterialInventory.getId());
                voMaterialInventory.setSpeciesNum(count);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysMaterialInventory sysMaterialInventory) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysMaterialInventory.setCreateId(sysUser.getId());
        sysMaterialInventory.setCreateDate(new Date());

        try {
            //添加物资盘点信息
            int insert = sysMaterialInventoryDao.insert(sysMaterialInventory);
            if (insert <=0){
                throw new RuntimeException("添加失败");
            }
            List<SysMaterialInventoryDetail> inventoryDetailList = sysMaterialInventory.getMaterialInventoryDetailList();
            if (inventoryDetailList != null && inventoryDetailList.size()>0 && inventoryDetailList.get(0).getId() != null){
                for (SysMaterialInventoryDetail sysMaterialInventoryDetail : inventoryDetailList) {
                    sysMaterialInventoryDetail.setMaterialInventoryId(sysMaterialInventory.getId());
                    //添加物资盘点详情信息
                    int insert2 = sysMaterialInventoryDao.insertDetail(sysMaterialInventoryDetail);
                    if (insert2 <=0){
                        throw new RuntimeException("添加失败");
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
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();

        VoMaterialInventory voMaterialInventory = sysMaterialInventoryDao.findById(id);
        if (voMaterialInventory != null){
            List<VoMaterialInventoryDetail> materialInventoryDetailList = sysMaterialInventoryDao.findDetailBySMIDId(voMaterialInventory.getId());
            voMaterialInventory.setVoMaterialInventoryDetailList(materialInventoryDetailList);

            //填入盘点种类数量
            int count = sysMaterialInventoryDao.countSMIDBySMIId(voMaterialInventory.getId());
            voMaterialInventory.setSpeciesNum(count);
        }
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voMaterialInventory);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(SysMaterialInventory sysMaterialInventory) {
        map = new HashMap<>();

        try {
            //修改物资盘点
            int update = sysMaterialInventoryDao.update(sysMaterialInventory);
            if (update <= 0){
                throw new RuntimeException("修改失败");
            }

            //先删除该物资盘点的所有详情
            sysMaterialInventoryDao.deleteDetailByMIId(sysMaterialInventory.getId());
            List<SysMaterialInventoryDetail> materialInventoryDetailList = sysMaterialInventory.getMaterialInventoryDetailList();
            if (materialInventoryDetailList != null && materialInventoryDetailList.size()>0){
                for (SysMaterialInventoryDetail sysMaterialInventoryDetail : materialInventoryDetailList) {
                    sysMaterialInventoryDetail.setMaterialInventoryId(sysMaterialInventory.getId());
                    //再添加该物资盘点的所有详情
                    int insert = sysMaterialInventoryDao.insertDetail(sysMaterialInventoryDetail);
                    if (insert <=0){
                        throw new RuntimeException("添加新详情失败");
                    }
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
        map.put("message","修改成功");
        map.put("status",true);
        return map;
    }
}
