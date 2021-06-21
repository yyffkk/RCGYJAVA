package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.LeaseContractService;
import com.api.model.butlerService.SearchLeaseContract;
import com.api.model.butlerService.SysLeaseContract;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoLeaseContract;
import com.api.vo.butlerService.VoUserAdvice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 租赁合同管理
 */
@RestController
@RequestMapping("manage/leaseContract")
public class LeaseContractController {
    @Resource
    LeaseContractService leaseContractService;

    /**
     * 查询所有的租赁合同信息
     * @param searchLeaseContract 租赁合同管理 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchLeaseContract searchLeaseContract){
        PageHelper.startPage(searchLeaseContract.getPageNum(),searchLeaseContract.getSize());
        List<VoLeaseContract> voLeaseContractList = leaseContractService.list(searchLeaseContract);
        PageInfo<VoLeaseContract> pageInfo = new PageInfo<>(voLeaseContractList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加租赁合同信息
     * @param sysLeaseContract 租赁合同model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysLeaseContract sysLeaseContract){
        return leaseContractService.insert(sysLeaseContract);
    }

    /**
     * 启用/停用 租赁合同模版
     * @param id 租赁主键id
     * @return map
     */
    @GetMapping("/enable")
    public Map<String,Object> enable(Integer id){
        return leaseContractService.enable(id);
    }

    /**
     * 批量删除租赁合同模版
     * @param voIds 租赁合同模版主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds voIds){
        return leaseContractService.delete(voIds.getIds());
    }


}
