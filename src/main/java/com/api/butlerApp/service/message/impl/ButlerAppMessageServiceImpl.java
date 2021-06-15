package com.api.butlerApp.service.message.impl;

import com.api.butlerApp.dao.message.ButlerAppMessageDao;
import com.api.butlerApp.service.message.ButlerAppMessageService;
import com.api.model.butlerApp.ButlerGreenTaskMesVo;
import com.api.model.butlerApp.ButlerHygieneTaskMesVo;
import com.api.vo.butlerApp.ButlerCommentMessageVo;
import com.api.vo.butlerApp.ButlerRepairCommentMesVo;
import com.api.vo.butlerApp.ButlerRepairMessageVo;
import com.api.vo.butlerApp.ButlerSysMessageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
        //根据用户id 查询系统通知最新的第一个发送时间
        Date sysDate = butlerAppMessageDao.findFirstSysDateById(id);
        //查询评论消息
        //根据用户id 查询评论消息未读数量
        int commentCount = butlerAppMessageDao.findCommentNoReadNumById(id);
        //根据用户id 查询评论消息最新的第一个发送时间
        Date commentDate = butlerAppMessageDao.findFirstCommentDateById(id);
        map.put("sysCount",count);
        map.put("sysType",type);
        map.put("sysDate",sysDate);

        map.put("commentCount",commentCount);
        map.put("commentDate",commentDate);
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
    public Map<String, Object> findGreenTaskByGreenId(Integer greenTaskId) {
        map = new HashMap<>();
        ButlerGreenTaskMesVo butlerGreenTaskMesVo = butlerAppMessageDao.findGreenTaskByGreenId(greenTaskId);
        map.put("data",butlerGreenTaskMesVo);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findHygieneTaskByHygieneId(Integer hygieneTaskId) {
        map = new HashMap<>();
        ButlerHygieneTaskMesVo butlerHygieneTaskMesVo = butlerAppMessageDao.findHygieneTaskByHygieneId(hygieneTaskId);
        map.put("data",butlerHygieneTaskMesVo);
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

    @Override
    public Map<String, Object> allReadSys(Integer id) {
        map = new HashMap<>();
        //修改全部系统通知为已读
        int update2 = butlerAppMessageDao.allReadSys(id);
        if (update2 >0){
            map.put("message","操作成功");
            map.put("status",true);
        }else {
            map.put("message","操作失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> allReadComment(Integer id) {
        map = new HashMap<>();
        //修改全部评论通知为已读
        int update2 = butlerAppMessageDao.allReadComment(id);
        if (update2 >0){
            map.put("message","操作成功");
            map.put("status",true);
        }else {
            map.put("message","操作失败");
            map.put("status",false);
        }
        return map;
    }

}
