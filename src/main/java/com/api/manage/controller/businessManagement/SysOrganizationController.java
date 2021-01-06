package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysOrganizationService;
import com.api.model.businessManagement.SysOrganization;
import com.api.vo.businessManagement.VoFindByIdOrganization;
import com.api.vo.businessManagement.VoOrganization;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequestMapping("manage/sysOrganization")
@RestController
public class SysOrganizationController {
    @Resource
    SysOrganizationService sysOrganizationService;

    /**
     * 查询所有的组织架构信息
     * @return 组织架构Vo 回显 list
     */
    @GetMapping("/list")
    public List<VoOrganization> list(){
        return sysOrganizationService.list();
    }


    /**
     * 添加部门
     * @param sysOrganization 组织信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysOrganization sysOrganization){
        return sysOrganizationService.insert(sysOrganization);
    }

    /**
     * 根据组织ID查找组织信息
     * @param id 组织主键ID
     * @return 组织架构Vo findById 回显
     */
    @GetMapping("/findById")
    public VoFindByIdOrganization findById(Integer id){
        return sysOrganizationService.findById(id);
    }

    /**
     * 修改部门信息
     * @param sysOrganization 组织信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysOrganization sysOrganization){
        return sysOrganizationService.update(sysOrganization);
    }

    /**
     * 删除部门信息
     * @param id 组织主键id
     * @return map
     */
    @GetMapping("/delete")
    public Map<String,Object> delete(Integer id){
        return sysOrganizationService.delete(id);
    }

    /**
     * 停用部门
     * @param id 组织主键id
     * @return map
     */
    @GetMapping("/stop")
    public Map<String,Object> stop(Integer id){
        return sysOrganizationService.stop(id);
    }

    /**
     * 恢复部门
     * @param id 组织主键id
     * @return map
     */
    @GetMapping("/recovery")
    public Map<String,Object> recovery(Integer id){
        return sysOrganizationService.recovery(id);
    }

}
