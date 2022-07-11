package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysContractService;
import com.api.model.businessManagement.SearchContract;
import com.api.model.businessManagement.SysContract;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.businessManagement.VoContract;
import com.api.vo.businessManagement.VoTrain;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 合同管理
 */
@RestController
@RequestMapping("manage/contract")
public class SysContractController {
    @Resource
    SysContractService sysContractService;

    /**
     * 查询所有的合同管理信息
     * @param searchContract 合同管理搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0101"},logical = Logical.AND)
    public Map<String,Object> list(SearchContract searchContract){
        PageHelper.startPage(searchContract.getPageNum(),searchContract.getSize());
        List<VoContract> voContractList = sysContractService.list(searchContract);
        PageInfo<VoContract> pageInfo = new PageInfo<>(voContractList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加合同管理信息
     * @param sysContract 合同管理model
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0104"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysContract sysContract){
        return sysContractService.insert(sysContract);
    }

    /**
     * 批量删除合同管理信息
     * @param ids 合同管理主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysContractService.delete(ids.getIds());
    }
}
