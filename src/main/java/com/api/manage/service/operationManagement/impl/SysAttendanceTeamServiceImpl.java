package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysAttendanceTeamDao;
import com.api.manage.service.operationManagement.SysAttendanceTeamService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchAttendanceTeam;
import com.api.model.operationManagement.SysAttendanceTeam;
import com.api.vo.operationManagement.VoAttendanceTeam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysAttendanceTeamServiceImpl implements SysAttendanceTeamService {
    private static Map<String,Object> map = null;
    @Resource
    SysAttendanceTeamDao sysAttendanceTeamDao;

    @Override
    public List<VoAttendanceTeam> list(SearchAttendanceTeam searchAttendanceTeam) {
        return sysAttendanceTeamDao.list(searchAttendanceTeam);
    }

    @Override
    public Map<String, Object> insert(SysAttendanceTeam sysAttendanceTeam) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysAttendanceTeam.setCreateId(sysUser.getId());
        sysAttendanceTeam.setCreateDate(new Date());

        int insert = sysAttendanceTeamDao.insert(sysAttendanceTeam);
        if (insert >0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }

        return map;
    }
}
