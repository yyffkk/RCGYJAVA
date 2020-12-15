package com.api.service.butlerService.impl;

import com.api.dao.butlerService.SysChargesTemplateDetailDao;
import com.api.model.butlerService.SearchChargesTemplateDetail;
import com.api.model.butlerService.SysChargesTemplateDetail;
import com.api.model.system.SysUser;
import com.api.service.butlerService.SysChargesTemplateDetailService;
import com.api.vo.butlerService.VoChargesTemplateDetail;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysChargesTemplateDetailServiceImpl implements SysChargesTemplateDetailService {
    private static Map<String,Object> map = null;
    @Resource
    SysChargesTemplateDetailDao sysChargesTemplateDetailDao;

    @Override
    public List<VoChargesTemplateDetail> list(SearchChargesTemplateDetail searchChargesTemplateDetail) {
        return sysChargesTemplateDetailDao.list(searchChargesTemplateDetail);
    }

    @Override
    public Map<String, Object> insert(SysChargesTemplateDetail sysChargesTemplateDetail) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入创建人
        sysChargesTemplateDetail.setCreateId(sysUser.getId());
        //填入创建时间
        sysChargesTemplateDetail.setCreateDate(new Date());
        //添加物业收费标准明细信息
        int insert = sysChargesTemplateDetailDao.insert(sysChargesTemplateDetail);
        if (insert >0) {
            map.put("message","添加物业收费标准明细信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加物业收费标准明细信息失败");
            map.put("status",false);
        }
        return map;
    }
}
