package com.api.manage.service.basicArchives.impl;

import com.api.manage.dao.basicArchives.CpmBuildingUnitDao;
import com.api.model.basicArchives.CpmBuildingUnit;
import com.api.model.businessManagement.SysUser;
import com.api.vo.basicArchives.VoCpmBuildingUnit;
import com.api.manage.service.basicArchives.CpmBuildingUnitService;
import com.api.vo.basicArchives.VoFindAll;
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
public class CpmBuildingUnitServiceImpl implements CpmBuildingUnitService {
    private final Map<String,Object> map = new HashMap<>();

    @Resource
    CpmBuildingUnitDao cpmBuildingUnitDao;

    @Override
    public List<VoCpmBuildingUnit> list(VoCpmBuildingUnit voCpmBuildingUnit) {
        return cpmBuildingUnitDao.list(voCpmBuildingUnit);
    }

    @Override
    public Map<String, Object> insert(CpmBuildingUnit cpmBuildingUnit) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        //校验重复
        //根据楼栋单元号查询是否已有单元信息
        CpmBuildingUnit cpmBuildingUnit1 = cpmBuildingUnitDao.findByNo(cpmBuildingUnit.getNo());
        if (cpmBuildingUnit1 != null){
            map.put("message","楼栋单元号信息已存在");
            map.put("status",false);
            return map;
        }

        cpmBuildingUnit.setCreateId(sysUser.getId());
        cpmBuildingUnit.setCreateDate(new Date());
        int insert = cpmBuildingUnitDao.insert(cpmBuildingUnit);
        if (insert>0){
            map.put("message","添加楼栋单元信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加楼栋单元信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public CpmBuildingUnit findById(Integer id) {
        return cpmBuildingUnitDao.findById(id);
    }

    @Override
    public Map<String, Object> update(CpmBuildingUnit cpmBuildingUnit) {
        //校验重复
        //根据楼栋单元号查询是否已有单元信息
        CpmBuildingUnit cpmBuildingUnit1 = cpmBuildingUnitDao.findByNo(cpmBuildingUnit.getNo());
        if (cpmBuildingUnit1 != null){
            //如果输入id与查询到的id不一致，则修改了单元号信息，并且单元号重复
            if (!cpmBuildingUnit1.getId().equals(cpmBuildingUnit.getId())){
                map.put("message","楼栋单元号信息已存在");
                map.put("status",false);
                return map;
            }
        }


        int update = cpmBuildingUnitDao.update(cpmBuildingUnit);
        if (update>0){
            map.put("message","修改楼栋单元信息成功");
            map.put("status",true);
        }else {
            map.put("message","修改楼栋单元信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        try {
            for (int id : ids) {
                int delete = cpmBuildingUnitDao.delete(id);
                if (delete<=0){
                    throw new RuntimeException("批量删除楼栋单元信息失败");
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
        map.put("message","批量删除楼栋单元信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public List<VoFindAll> findAll() {
        return cpmBuildingUnitDao.findAll();
    }

    @Override
    public List<VoFindAll> findByBuildingId(Integer id) {
        return cpmBuildingUnitDao.findByBuildingId(id);
    }
}
