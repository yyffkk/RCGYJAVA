package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppVisitorAccessDao;
import com.api.app.service.butler.AppVisitorAccessService;
import com.api.model.app.SearchVisitorAccess;
import com.api.model.butlerService.UserVisitors;
import com.api.util.IdWorker;
import com.api.vo.app.VisitorAccessFindByIdVo;
import com.api.vo.app.VisitorAccessVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppVisitorAccessServiceImpl implements AppVisitorAccessService {
    @Resource
    AppVisitorAccessDao visitorAccessDao;
    private static Map<String,Object> map = null;

    @Override
    public Map<String, Object> insertVisitorInfo(UserVisitors userVisitors) {
        map = new HashMap<>();
        IdWorker idWorker = new IdWorker(1, 1, 1);
        long l = idWorker.nextId();
        userVisitors.setAccessCode(l);
        //添加访客信息
        int insert = visitorAccessDao.insertVisitorInfo(userVisitors);
        if (insert >0){
            map.put("accessCode",l);
            map.put("message","添加访客信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加访客信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> findVisitorByAC(Long accessCode) {
        map = new HashMap<>();
        //根据访客信息通行证认证码 查询访客信息
        VisitorAccessFindByIdVo accessFindByIdVo = visitorAccessDao.findVisitorByAC(accessCode);
        if (accessFindByIdVo != null){
            map.put("data",accessFindByIdVo);
            map.put("message","请求成功");
            map.put("status",true);
        }else {
            map.put("message","数据不存在");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public List<VisitorAccessVo> list(SearchVisitorAccess searchVisitorAccess) {
        List<VisitorAccessVo> visitorAccessVos = visitorAccessDao.list(searchVisitorAccess);
        //判断未到是否有已过期
        if (visitorAccessVos != null && visitorAccessVos.size()>0){
            for (VisitorAccessVo visitorAccessVo : visitorAccessVos) {
                //如果状态为1.未到，并且当前时间大于有效时间，则显示3.已过期
                if (visitorAccessVo.getVisitorStatus() == 1&&(new Date().getTime()>visitorAccessVo.getEffectiveTime().getTime())){
                    visitorAccessVo.setVisitorStatus(3);
                }
            }
        }
        return visitorAccessVos;
    }
}
