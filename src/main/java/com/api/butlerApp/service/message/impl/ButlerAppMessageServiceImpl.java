package com.api.butlerApp.service.message.impl;

import com.api.butlerApp.dao.message.ButlerAppMessageDao;
import com.api.butlerApp.service.message.ButlerAppMessageService;
import com.api.vo.butlerApp.ButlerCommentMessageVo;
import com.api.vo.butlerApp.ButlerRepairCommentMesVo;
import com.api.vo.butlerApp.ButlerRepairMessageVo;
import com.api.vo.butlerApp.ButlerSysMessageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerAppMessageServiceImpl implements ButlerAppMessageService {
    @Resource
    ButlerAppMessageDao butlerAppMessageDao;
    private static Map<String,Object> map = null;

    @Override
    public Map<String, Object> messageCenter(Integer id) {
        map = new HashMap<>();
        //查询系统通知
        //根据用户id 查询系统通知未读数量
        int count = butlerAppMessageDao.findSysNoReadNumById(id);
        //根据用户id 查询系统通知最新的第一个消息类型
        Integer type = butlerAppMessageDao.findFirstTypeById(id);

        //查询评论消息
        //根据用户id 查询评论消息未读数量
        int commentCount = butlerAppMessageDao.findCommentNoReadNumById(id);

        map.put("sysCount",count);
        map.put("sysType",type);

        map.put("commentCount",commentCount);
        return map;
    }

    @Override
    public List<ButlerSysMessageVo> sysMessageList(Integer id) {
        return butlerAppMessageDao.sysMessageList(id);
    }

    @Override
    public List<ButlerCommentMessageVo> sysCommentMessageList(Integer id) {
        return  butlerAppMessageDao.sysCommentMessageList(id);
    }

    @Override
    public Map<String, Object> findRepairByRepairId(Integer repairId) {
        map = new HashMap<>();
        ButlerRepairMessageVo butlerRepairMessageVo = butlerAppMessageDao.findRepairByRepairId(repairId);
        map.put("data",butlerRepairMessageVo);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findCommentByDispatchId(Integer dispatchId) {
        map = new HashMap<>();
        ButlerRepairCommentMesVo butlerRepairCommentMesVo = butlerAppMessageDao.findCommentByDispatchId(dispatchId);
        map.put("data",butlerRepairCommentMesVo);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }
}
