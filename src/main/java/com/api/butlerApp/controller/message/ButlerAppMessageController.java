package com.api.butlerApp.controller.message;

import com.api.butlerApp.service.message.ButlerAppMessageService;
import com.api.vo.app.AppCommentMessageVo;
import com.api.vo.butlerApp.ButlerCommentMessageVo;
import com.api.vo.butlerApp.ButlerSysMessageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管家app消息中心
 */
@RestController
@RequestMapping("butlerApp/user/message")
public class ButlerAppMessageController {
    @Resource
    ButlerAppMessageService butlerAppMessageService;

    /**
     * 消息中心
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/messageCenter")
    public Map<String,Object> messageCenter(Integer id){
        return butlerAppMessageService.messageCenter(id);
    }

    /**
     * 查询所有的系统通知
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/sysMessageList")
    public Map<String,Object> sysMessageList(int pageNum,int size,Integer id){
        PageHelper.startPage(pageNum,size);
        List<ButlerSysMessageVo> sysMessageVos =butlerAppMessageService.sysMessageList(id);
        PageInfo<ButlerSysMessageVo> pageInfo = new PageInfo<>(sysMessageVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询所有的评论通知
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/sysCommentMessageList")
    public Map<String,Object> sysCommentMessageList(int pageNum,int size,Integer id){
        PageHelper.startPage(pageNum,size);
        List<ButlerCommentMessageVo> commentMessageVos =butlerAppMessageService.sysCommentMessageList(id);
        PageInfo<ButlerCommentMessageVo> pageInfo = new PageInfo<>(commentMessageVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据报事报修主键id 同步查询报事报修消息信息（同步）
     * @param repairId 报事报修主键id
     * @return map
     */
    @GetMapping("/findRepairByRepairId")
    public Map<String,Object> findRepairByRepairId(Integer repairId){
        return butlerAppMessageService.findRepairByRepairId(repairId);
    }

    /**
     * 根据绿化任务主键id 同步查询绿化任务消息信息（同步）
     * @param greenTaskId 绿化任务主键id
     * @return map
     */
    @GetMapping("/findGreenTaskByGreenId")
    public Map<String,Object> findGreenTaskByGreenId(Integer greenTaskId){
        return butlerAppMessageService.findGreenTaskByGreenId(greenTaskId);
    }

    /**
     * 根据卫生任务主键id 同步查询卫生任务消息信息（同步）
     * @param hygieneTaskId 卫生任务主键id
     * @return map
     */
    @GetMapping("/findHygieneTaskByGreenId")
    public Map<String,Object> findHygieneTaskByGreenId(Integer hygieneTaskId){
        return butlerAppMessageService.findHygieneTaskByHygieneId(hygieneTaskId);
    }

    /**
     * 根据工单主键id同步查询报事报修评论（同步）
     * @param dispatchId 工单主键id
     * @return map
     */
    @GetMapping("/findCommentByDispatchId")
    public Map<String,Object> findCommentByDispatchId(Integer dispatchId){
        return butlerAppMessageService.findCommentByDispatchId(dispatchId);
    }

    /**
     * 系统消息全部已读(进入系统消息列表后调用)
     * @param id 用户id
     * @return map
     */
    @GetMapping("/allReadSys")
    public Map<String,Object> allReadSys(Integer id){
        return butlerAppMessageService.allReadSys(id);
    }

    /**
     * 评论消息全部已读(进入评论消息列表后调用)
     * @param id 用户id
     * @return map
     */
    @GetMapping("/allReadComment")
    public Map<String,Object> allReadComment(Integer id){
        return butlerAppMessageService.allReadComment(id);
    }
}
