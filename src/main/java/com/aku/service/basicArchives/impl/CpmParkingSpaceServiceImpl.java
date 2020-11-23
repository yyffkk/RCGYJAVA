package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.CpmParkingSpaceDao;
import com.aku.model.basicArchives.CpmParkingSpace;
import com.aku.model.system.SysUser;
import com.aku.vo.basicArchives.VoCpmParkingSpace;
import com.aku.service.basicArchives.CpmParkingSpaceService;
import com.aku.vo.basicArchives.VoParkingSpace;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CpmParkingSpaceServiceImpl implements CpmParkingSpaceService {
    private final Map<String,Object> map = new HashMap<>();
    @Resource
    CpmParkingSpaceDao cpmParkingSpaceDao;

    @Override
    public List<VoParkingSpace> list(VoCpmParkingSpace voCpmParkingSpace) {
        return cpmParkingSpaceDao.list(voCpmParkingSpace);
    }

    @Override
    public Map<String, Object> insert(CpmParkingSpace cpmParkingSpace) {
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
    public CpmParkingSpace findById(Integer id) {
        return cpmParkingSpaceDao.findById(id);
    }

    @Override
    public Map<String, Object> update(CpmParkingSpace cpmParkingSpace) {
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
    public Map<String, Object> delete(Integer id) {
        int delete = cpmParkingSpaceDao.delete(id);
        if (delete >0){
            map.put("message","删除车位信息成功");
            map.put("status",true);
        }else {
            map.put("message","删除车位信息失败");
            map.put("status",false);
        }
        return map;
    }
}
