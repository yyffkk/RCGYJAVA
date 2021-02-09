package com.api.app.controller.message;

import com.api.app.service.message.AppMessageService;
import com.api.vo.app.AppGambitThemeVo;
import com.api.vo.app.AppSysMessageVo;
import com.api.vo.basicArchives.VoIds;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * app消息中心
 */
@RestController
@RequestMapping("app/user/message")
public class AppMessageController {
    @Resource
    AppMessageService appMessageService;

    /**
     * 消息中心
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/messageCenter")
    public Map<String,Object> messageCenter(Integer id){
        return appMessageService.messageCenter(id);
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
        List<AppSysMessageVo> appSysMessageVos =appMessageService.sysMessageList(id);
        PageInfo<AppSysMessageVo> pageInfo = new PageInfo<>(appSysMessageVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据消息列表主键id和用户主键id查询系统通知消息详情
     * @param sysMessageId 消息列表主键id
     * @param id 用户id
     * @return map
     */
    @GetMapping("sysMessageDetail")
    public Map<String,Object> sysMessageDetail(Integer sysMessageId,Integer id){
        return appMessageService.sysMessageDetail(sysMessageId,id);
    }

    /**
     * 阅读消息（未读 -> 已读）
     * @param sysMessageId 消息列表主键id
     * @param id 用户id
     * @return map
     */
    @GetMapping("/readMessage")
    public Map<String,Object> readMessage(Integer sysMessageId,Integer id){
        return appMessageService.readMessage(sysMessageId,id);
    }

    /**
     * 全部已读
     * @param id 用户id
     * @return map
     */
    @GetMapping("/allRead")
    public Map<String,Object> allRead(Integer id){
        return appMessageService.allRead(id);
    }

    /**
     * 删除app消息列表???需要改 消息列表 表，添加字段 user_delete 用户端删除
     * @param ids 消息列表主键id数组
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/falseDelete")
    public Map<String,Object> falseDelete(@RequestBody VoIds ids, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        return appMessageService.falseDelete(ids.getIds(),id);
    }
}
