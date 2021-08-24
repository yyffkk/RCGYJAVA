package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysIdentityService;
import com.api.model.system.SysIdentity;
import com.api.vo.basicArchives.VoIds;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 身份(职业,岗位)管理
 */
@RequestMapping("manage/identity")
@RestController
public class SysIdentityController {
    @Resource
    SysIdentityService sysIdentityService;

    /**
     * 查询所有的身份（职业,岗位）信息
     * @return map
     */
    @GetMapping("/listAll")
    public Map<String,Object> listAll(){
        return sysIdentityService.listAll();
    }

    /**
     * 添加身份（职业,岗位信息）
     * @param sysIdentity 身份（职业,岗位）
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysIdentity sysIdentity){
        return sysIdentityService.insert(sysIdentity);
    }

    /**
     * 根据身份主键id查询身份信息
     * @param id 身份主键id
     * @return 身份信息
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysIdentityService.findById(id);
    }

    /**
     * 修改身份信息
     * @param sysIdentity 身份信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysIdentity sysIdentity){
        return  sysIdentityService.update(sysIdentity);
    }

    /**
     * 批量删除身份信息
     * @param ids 身份信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysIdentityService.delete(ids.getIds());
    }

}
