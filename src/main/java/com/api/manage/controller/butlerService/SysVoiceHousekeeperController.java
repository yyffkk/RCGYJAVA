package com.api.manage.controller.butlerService;

import com.api.model.butlerService.SearchVoiceHousekeeper;
import com.api.model.butlerService.VoiceHousekeeperRemake;
import com.api.manage.service.butlerService.SysVoiceHousekeeperService;
import com.api.vo.butlerService.VoVoiceHousekeeper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 语音管家
 */
@RestController
@RequestMapping("/voiceHousekeeper")
public class SysVoiceHousekeeperController {
    @Resource
    SysVoiceHousekeeperService sysVoiceHousekeeperService;

    /**
     * 查询所有的语音管家信息 （包含条件搜索）
     * @param searchVoiceHousekeeper 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchVoiceHousekeeper searchVoiceHousekeeper){
        PageHelper.startPage(searchVoiceHousekeeper.getPageNum(),searchVoiceHousekeeper.getSize());
        List<VoVoiceHousekeeper> voVoiceHousekeeperList = sysVoiceHousekeeperService.list(searchVoiceHousekeeper);
        PageInfo<VoVoiceHousekeeper> pageInfo = new PageInfo<>(voVoiceHousekeeperList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 添加备注
     * @param voiceHousekeeperRemake 备注信息
     * @return map
     */
    @PostMapping("/insertRemake")
    public Map<String,Object> insertRemake(@RequestBody VoiceHousekeeperRemake voiceHousekeeperRemake){
        return sysVoiceHousekeeperService.insertRemake(voiceHousekeeperRemake);
    }

}
