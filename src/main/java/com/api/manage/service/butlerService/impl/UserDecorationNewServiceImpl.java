package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.UserDecorationNewDao;
import com.api.manage.service.butlerService.UserDecorationNewService;
import com.api.model.app.AppUserDecorationNew;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.UserDecorationNewSearch;
import com.api.vo.butlerApp.ButlerUserDecorationNewVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserDecorationNewServiceImpl implements UserDecorationNewService {
    private static Map<String,Object> map = null;
    @Resource
    UserDecorationNewDao userDecorationNewDao;

    @Override
    public List<ButlerUserDecorationNewVo> list(UserDecorationNewSearch userDecorationNewSearch) {
        return userDecorationNewDao.list(userDecorationNewSearch);
    }

    @Override
    public Map<String, Object> examine(AppUserDecorationNew appUserDecorationNew) {
        map = new HashMap<>();

        //根据新版装修主键id查询新版装修状态
        int status = userDecorationNewDao.findStatusById(appUserDecorationNew.getId());
        if (status != 1){
            map.put("message","当前状态不可审核");
            map.put("status",false);
            return map;
        }

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        appUserDecorationNew.setReviewer(sysUser.getId());
        appUserDecorationNew.setAuditDate(new Date());

        int update = userDecorationNewDao.examine(appUserDecorationNew);
        if (update <= 0){
            map.put("message","操作失败");
            map.put("status",false);
        }else {
            map.put("message","操作成功");
            map.put("status",true);
        }

        return map;
    }
}
