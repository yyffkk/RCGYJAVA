package com.api.manage.controller.system;

import com.api.manage.service.system.SysSettingsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 系统设置管理
 */
@RestController
@RequestMapping("manage/setting")
public class SysSettingsController {
    @Resource
    SysSettingsService sysSettingsService;

    /**
     * 查询系统设置开关信息
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(){
        return sysSettingsService.list();
    }

    /**
     * 是否开启/关闭
     * @param id 系统设置开关信息主键id
     * @return map
     */
    @GetMapping("/isEnable")
    public Map<String,Object> isEnable(Integer id){
        return sysSettingsService.isEnable(id);
    }
}
