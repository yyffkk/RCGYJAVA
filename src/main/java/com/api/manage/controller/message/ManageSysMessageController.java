package com.api.manage.controller.message;

import com.api.manage.service.message.ManageSysMessageService;
import com.api.model.message.ManageSysMessage;
import com.api.model.message.SearchManageSysMessage;
import com.api.vo.chargeManagement.VoChargesTemplateDetail;
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
 * 后台消息列表
 */
@RestController
@RequestMapping("manage/manageSysMessage")
public class ManageSysMessageController {
    @Resource
    ManageSysMessageService manageSysMessageService;


    /**
     * 查询所有的消息列表信息（包含条件搜索）
     * @param searchManageSysMessage 后台消息列表 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchManageSysMessage searchManageSysMessage){
        PageHelper.startPage(searchManageSysMessage.getPageNum(),searchManageSysMessage.getSize());
        List<ManageSysMessage> manageSysMessageList = manageSysMessageService.list(searchManageSysMessage);
        PageInfo<ManageSysMessage> pageInfo = new PageInfo<>(manageSysMessageList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

}
