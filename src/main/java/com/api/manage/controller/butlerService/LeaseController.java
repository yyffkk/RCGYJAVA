package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.LeaseService;
import com.api.model.butlerService.SearchLease;
import com.api.model.butlerService.SysLease;
import com.api.model.butlerService.SysLeaseRenew;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoLease;
import com.api.vo.butlerService.VoLeaseContract;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 租赁（租户）管理
 */
@RestController
@RequestMapping("manage/lease")
public class LeaseController {
    @Resource
    LeaseService leaseService;

    /**
     * 查询所有的租赁管理信息
     * @param searchLease 租赁管理 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchLease searchLease){
        PageHelper.startPage(searchLease.getPageNum(),searchLease.getSize());
        List<VoLease> voLeaseList = leaseService.list(searchLease);
        PageInfo<VoLease> pageInfo = new PageInfo<>(voLeaseList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加租赁信息
     * @param sysLease 租赁管理model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysLease sysLease){
        return leaseService.insert(sysLease);
    }

    /**
     * 根据租赁管理主键id查询租赁信息
     * @param id 租赁管理主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return leaseService.findById(id);
    }

    /**
     * 修改租赁信息
     * @param sysLease 租赁管理model
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysLease sysLease){
        return leaseService.update(sysLease);
    }

    /**
     * 批量删除租赁信息
     * @param ids 租赁信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return leaseService.delete(ids.getIds());
    }

    /**
     * 审核签署合同内容
     * @param sysLease 租赁管理model
     * @return map
     */
    @PostMapping("/reviewer")
    public Map<String,Object> reviewer(@RequestBody SysLease sysLease){
        return leaseService.reviewer(sysLease);
    }

    /**
     * 审核合同终止申请
     * @param sysLease 租赁管理model
     * @return map
     */
    @PostMapping("/reviewTerminationApplication")
    public Map<String,Object> reviewTerminationApplication(@RequestBody SysLease sysLease){
        return leaseService.reviewTerminationApplication(sysLease);
    }

    /**
     * 审核保证金退还申请
     * @param sysLease 租赁管理model
     * @return map
     */
    @PostMapping("/reviewDepositRefundApplication")
    public Map<String,Object> reviewDepositRefundApplication(@RequestBody SysLease sysLease){
        return leaseService.reviewDepositRefundApplication(sysLease);
    }


    /**
     * 续签//TODO 未完成
     * @param sysLeaseRenew 租赁续签model
     * @return map
     */
    @PostMapping("/renew")
    public Map<String,Object> renew(@RequestBody SysLeaseRenew sysLeaseRenew){
        return leaseService.renew(sysLeaseRenew);
    }
}
