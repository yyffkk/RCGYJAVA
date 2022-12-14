package com.api.manage.service.basicArchives.impl;

import com.api.manage.dao.basicArchives.CpmParkingSpaceDao;
import com.api.model.basicArchives.CpmParkingSpace;
import com.api.model.businessManagement.SysUser;
import com.api.model.basicArchives.SearchCpmParkingSpace;
import com.api.manage.service.basicArchives.CpmParkingSpaceService;
import com.api.vo.basicArchives.VoParkingSpace;
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
public class CpmParkingSpaceServiceImpl implements CpmParkingSpaceService {
    private static Map<String,Object> map = null;
    @Resource
    CpmParkingSpaceDao cpmParkingSpaceDao;

    @Override
    public List<VoParkingSpace> list(SearchCpmParkingSpace searchCpmParkingSpace) {
        return cpmParkingSpaceDao.list(searchCpmParkingSpace);
    }

    @Override
    public Map<String, Object> insert(CpmParkingSpace cpmParkingSpace) {
        map = new HashMap<>();
//        //是否有业主信息填入
//        CpmParkingSpace cpmParkingSpace = parkingSpaceAndResident.getCpmParkingSpace();

        //校验查重
        //根据车位编号查询是否存在车位信息
        CpmParkingSpace cpmParkingSpace1 = cpmParkingSpaceDao.findByCode(cpmParkingSpace.getCode());
        if (cpmParkingSpace1 != null){
            map.put("message","车位编号已存在");
            map.put("status",false);
            return map;
        }

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        cpmParkingSpace.setCreateId(sysUser.getId());
        cpmParkingSpace.setCreateDate(new Date());
        //添加车位坐标
        cpmParkingSpace.setCoordinate("0,0");
        if (cpmParkingSpace.getUserId() == null){
            cpmParkingSpace.setUserId(cpmParkingSpace.getResidentId());
        }

        int insert = cpmParkingSpaceDao.insert(cpmParkingSpace);
        if (insert >0){
            map.put("message","添加车位信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加车位信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        CpmParkingSpace byId = cpmParkingSpaceDao.findById(id);

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",byId);
        return map;
    }

    @Override
    public Map<String, Object> update(CpmParkingSpace cpmParkingSpace) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        cpmParkingSpace.setModifyId(sysUser.getId());
        cpmParkingSpace.setModifyDate(new Date());
        int update = cpmParkingSpaceDao.update(cpmParkingSpace);
        if (update >0){
            map.put("message","修改车位信息成功");
            map.put("status",true);
        }else {
            map.put("message","修改车位信息失败");
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
                //先查询是否有关联业主信息
                CpmParkingSpace byId = cpmParkingSpaceDao.findById(id);
                if (byId.getResidentId() != null && byId.getResidentId()>0){
                    throw new RuntimeException("批量删除失败，请先解除关联业主信息");
                }
                //再删除车位信息
                int delete = cpmParkingSpaceDao.delete(id);
                if (delete<=0){
                    throw new RuntimeException("批量删除车位信息失败");
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
        map.put("message","批量删除车位信息成功");
        map.put("status",true);
        return map;
    }
}
