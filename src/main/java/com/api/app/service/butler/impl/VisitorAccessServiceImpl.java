package com.api.app.service.butler.impl;

import com.api.app.dao.butler.VisitorAccessDao;
import com.api.app.service.butler.VisitorAccessService;
import com.api.model.butlerService.UserVisitors;
import com.api.util.IdWorker;
import com.api.vo.app.VisitorAccessFindByIdVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class VisitorAccessServiceImpl implements VisitorAccessService {
    @Resource
    VisitorAccessDao visitorAccessDao;
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
}
