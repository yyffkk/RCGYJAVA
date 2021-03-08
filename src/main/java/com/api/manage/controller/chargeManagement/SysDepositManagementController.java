package com.api.manage.controller.chargeManagement;

import com.api.manage.shiro.ShiroExceptions;
import com.api.model.chargeManagement.SearchDepositManagement;
import com.api.model.chargeManagement.SysDepositManagement;
import com.api.model.chargeManagement.SysDepositManagementOrder;
import com.api.manage.service.chargeManagement.SysDepositManagementService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.chargeManagement.VoDepositManagement;
import com.api.vo.chargeManagement.VoRefundDecorationDetail;
import com.api.vo.chargeManagement.VoFindByIdDepositManagement;
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
 * 押金管理
 */
@RestController
@RequestMapping("manage/depositManagement")
public class SysDepositManagementController extends ShiroExceptions {
    @Resource
    SysDepositManagementService sysDepositManagementService;

    /**
     * 查询所有的押金信息 （包含条件搜索）
     * @param searchDepositManagement 搜索条件
     * @return map
     */
    @GetMapping("/list")
//    @RequiresPermissions(value = {"0401","04"},logical = Logical.AND)
    public Map<String,Object> list(SearchDepositManagement searchDepositManagement){
        PageHelper.startPage(searchDepositManagement.getPageNum(),searchDepositManagement.getSize());
        List<VoDepositManagement> voDepositManagementList = sysDepositManagementService.list(searchDepositManagement);
        PageInfo<VoDepositManagement> pageInfo = new PageInfo<>(voDepositManagementList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加押金管理信息
     * @param sysDepositManagement 押金管理信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0403","04"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysDepositManagement sysDepositManagement){
        return sysDepositManagementService.insert(sysDepositManagement);
    }


    /**
     * 根据押金主键id查询押金信息
     * @param id 押金主键id
     * @return map
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0402","04"},logical = Logical.AND)
    public VoFindByIdDepositManagement findById(Integer id){
        return sysDepositManagementService.findById(id);
    }

    /**
     * 批量删除押金管理信息
     * @param ids 押金管理主键id 数组
     * @return map
     */
    @PostMapping("/falseDelete")
    @RequiresPermissions(value = {"0404","04"},logical = Logical.AND)
    public Map<String,Object> falseDelete(@RequestBody VoIds ids){
        return sysDepositManagementService.falseDelete(ids.getIds());
    }


    /**
     * 修改押金管理
     * @param sysDepositManagement 押金管理信息
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0405","04"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody SysDepositManagement sysDepositManagement){
        return sysDepositManagementService.update(sysDepositManagement);
    }

    /**
     * 根据押金管理主键id查询押金退款装修情况（点击退款按钮触发的请求）
     * @param id 押金管理主键id
     * @return 押金退款装修情况Vo
     */
    @GetMapping("/refundDecorationDetail")
    @RequiresPermissions(value = {"0402","04"},logical = Logical.AND)
    public VoRefundDecorationDetail refundDecorationDetail(Integer id){
        return sysDepositManagementService.refundDecorationDetail(id);
    }

    /**
     * 退押金
     * @param sysDepositManagementOrder 押金退款单信息
     * @return map
     */
    @PostMapping("/refund")
    @RequiresPermissions(value = {"0408","04"},logical = Logical.AND)
    public Map<String,Object> refund(@RequestBody SysDepositManagementOrder sysDepositManagementOrder){
        return sysDepositManagementService.refund(sysDepositManagementOrder);
    }
}
