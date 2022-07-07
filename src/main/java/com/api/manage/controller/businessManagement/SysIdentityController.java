package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysIdentityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 身份(职业)管理
 */
@RequestMapping("manage/identity")
@RestController
public class SysIdentityController {
    @Resource
    SysIdentityService sysIdentityService;

    /**
     * 查询所有的身份（职业）信息
     * @return map
     */
    @GetMapping("/listAll")
    public Map<String,Object> listAll(){
        return sysIdentityService.listAll();
    }
}
