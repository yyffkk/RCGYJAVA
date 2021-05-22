package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysContractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 合同管理
 */
@RestController
@RequestMapping("manage/contract")
public class SysContractController {
    @Resource
    SysContractService sysContractService;

    public Map<String,Object> list(){
        return null;
    }


}
