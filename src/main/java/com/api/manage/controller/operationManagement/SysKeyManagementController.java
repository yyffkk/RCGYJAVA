package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysKeyManagementService;
import com.api.model.operationManagement.SearchKeyManagement;
import com.api.model.operationManagement.SysKeyManagement;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoKeyManagement;
import com.api.vo.operationManagement.VoNewsManagement;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 钥匙管理
 */
@RestController
@RequestMapping("manage/keyManagement")
public class SysKeyManagementController {
    @Resource
    SysKeyManagementService sysKeyManagementService;

    /**
     * 查询所有的钥匙信息
     * @param searchKeyManagement 钥匙管理 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchKeyManagement searchKeyManagement){
        PageHelper.startPage(searchKeyManagement.getPageNum(),searchKeyManagement.getSize());
        List<VoKeyManagement> voKeyManagementList = sysKeyManagementService.list(searchKeyManagement);
        PageInfo<VoKeyManagement> pageInfo = new PageInfo<>(voKeyManagementList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 添加钥匙信息
     * @param sysKeyManagement 钥匙model信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysKeyManagement sysKeyManagement){
        return sysKeyManagementService.insert(sysKeyManagement);
    }

    /**
     * 根据钥匙主键id查询钥匙信息
     * @param id 钥匙主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysKeyManagementService.findById(id);
    }

    /**
     * 修改钥匙信息
     * @param sysKeyManagement 钥匙管理model信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysKeyManagement sysKeyManagement){
        return sysKeyManagementService.update(sysKeyManagement);
    }

    /**
     * 批量删除钥匙信息
     * @param ids 钥匙主键Id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysKeyManagementService.delete(ids.getIds());
    }
}
