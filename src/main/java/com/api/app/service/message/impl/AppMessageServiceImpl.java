package com.api.app.service.message.impl;

import com.api.app.dao.message.AppMessageDao;
import com.api.app.service.message.AppMessageService;
import com.api.model.app.UserIdAndSysMessageId;
import com.api.vo.app.AppSysMessageDetail;
import com.api.vo.app.AppSysMessageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppMessageServiceImpl implements AppMessageService {
    @Resource
    AppMessageDao appMessageDao;
    private static Map<String,Object> map = null;

    @Override
    public Map<String, Object> messageCenter(Integer id) {
        map = new HashMap<>();
        //查询系统通知
        //根据用户id 查询系统通知未读数量
        int sysCount = appMessageDao.findSysNoReadNumById(id);
        //根据用户id 查询系统通知最新的第一个消息标题
        String sysTitle = appMessageDao.findNewTitleById(id);

        map.put("sysCount",sysCount);
        map.put("sysTitle",sysTitle);
        return map;
    }

    @Override
    public List<AppSysMessageVo> sysMessageList(Integer id) {
        return appMessageDao.sysMessageList(id);
    }

    @Override
    public Map<String, Object> sysMessageDetail(Integer sysMessageId, Integer id) {
        map = new HashMap<>();
        UserIdAndSysMessageId userIdAndSysMessageId = new UserIdAndSysMessageId();
        userIdAndSysMessageId.setId(id);
        userIdAndSysMessageId.setSysMessageId(sysMessageId);
        AppSysMessageDetail appSysMessageDetail = appMessageDao.sysMessageDetail(userIdAndSysMessageId);
        map.put("data",appSysMessageDetail);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> readMessage(Integer sysMessageId, Integer id) {
        map = new HashMap<>();
        UserIdAndSysMessageId userIdAndSysMessageId = new UserIdAndSysMessageId();
        userIdAndSysMessageId.setId(id);
        userIdAndSysMessageId.setSysMessageId(sysMessageId);
        int update = appMessageDao.readMessage(userIdAndSysMessageId);
        if (update >0){
            map.put("message","阅读成功");
            map.put("status",true);
        }else {
            map.put("message","阅读失败");
            map.put("status",false);
        }
        return map;
    }
}
