package com.api.manage.controller.butlerService;

import com.api.manage.shiro.ShiroExceptions;
import com.api.model.butlerService.CancelWorkOrder;
import com.api.model.butlerService.RevisitWorkOrder;
import com.api.model.butlerService.SearchDispatchList;
import com.api.model.butlerService.SysDispatchListDetail;
import com.api.manage.service.butlerService.SysDispatchListService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoDispatchList;
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
 * 派工单表
 */
@RestController
@RequestMapping("manage/dispatch")
public class SysDispatchListController extends ShiroExceptions {
    @Resource
    SysDispatchListService sysDispatchListService;

    /**
     * 查询所有的派工单信息 （包含条件搜素）
     * @param searchDispatchList  搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301","03"},logical = Logical.AND)
    public Map<String,Object> list(SearchDispatchList searchDispatchList){
        PageHelper.startPage(searchDispatchList.getPageNum(),searchDispatchList.getSize());
        List<VoDispatchList> voDispatchListList = sysDispatchListService.list(searchDispatchList);
        PageInfo<VoDispatchList> pageInfo = new PageInfo<>(voDispatchListList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 假删除工单
     * @param ids 订单主键Id数组
     * @return map
     */
    @PostMapping("/falseDelete")
    @RequiresPermissions(value = {"0304","03"},logical = Logical.AND)
    public Map<String,Object> falseDelete(@RequestBody VoIds ids){
        return sysDispatchListService.falseDelete(ids.getIds());
    }

    /**
     * 作废工单
     * @param cancelWorkOrder 作废原因
     * @return map
     */
    @PostMapping("/cancel")
    @RequiresPermissions(value = {"0308","03"},logical = Logical.AND)
    public Map<String,Object> cancel(@RequestBody CancelWorkOrder cancelWorkOrder){
        return sysDispatchListService.cancel(cancelWorkOrder);
    }


    /**
     * 回访
     * @param revisitWorkOrder 回访信息
     * @return map
     */
    @PostMapping("/revisit")
    @RequiresPermissions(value = {"0309","03"},logical = Logical.AND)
    public Map<String,Object> revisit(@RequestBody RevisitWorkOrder revisitWorkOrder){
        return sysDispatchListService.revisit(revisitWorkOrder);
    }

    /**
     * 回退
     * @param id 主键id
     * @return map
     */
    @GetMapping("/rollback")
    @RequiresPermissions(value = {"0310","03"},logical = Logical.AND)
    public Map<String,Object> rollback(Integer id){
        return sysDispatchListService.rollback(id);
    }


    /**
     * 派工
     * @param sysDispatchListDetail 派工单详情信息
     * @return map
     */
    @PostMapping("/dispatch")
    @RequiresPermissions(value = {"0311","03"},logical = Logical.AND)
    public Map<String,Object> dispatch(@RequestBody SysDispatchListDetail sysDispatchListDetail){
        return sysDispatchListService.dispatch(sysDispatchListDetail);
    }

    /**
     * 根据真实名字模糊查询用户信息（需要有派工权限）
     * @param actualName 真实名字
     * @return map
     */
    @GetMapping("/findSysUserLikeActualName")
    @RequiresPermissions(value = {"0311","03"},logical = Logical.AND)
    public Map<String,Object> findSysUserLikeActualName(String actualName){
        return sysDispatchListService.findSysUserLikeActualName(actualName);
    }


    /**
     * 报修工单详情
     * @param id 工单主键id
     * @return map
     */
    @GetMapping("/repairWorkOrderDetail")
    @RequiresPermissions(value = {"0302","03"},logical = Logical.AND)
    public Map<String,Object> repairWorkOrderDetail(Integer id){
        return sysDispatchListService.repairWorkOrderDetail(id);
    }

}
