package com.api.controller.butlerService;

import com.api.model.butlerService.CancelWorkOrder;
import com.api.model.butlerService.RevisitWorkOrder;
import com.api.model.butlerService.SearchDispatchList;
import com.api.model.butlerService.SysDispatchListDetail;
import com.api.service.butlerService.SysDispatchListService;
import com.api.vo.butlerService.VoDispatchList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 派工单表
 */
@RestController
@RequestMapping("dispatch")
public class SysDispatchListController {
    @Resource
    SysDispatchListService sysDispatchListService;

    /**
     * 查询所有的派工单信息 （包含条件搜素）
     * @param searchDispatchList  搜索条件
     * @return map
     */
    @GetMapping("/list")
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
     * @param id 订单
     * @return map
     */
    @GetMapping("/falseDelete")
    public Map<String,Object> falseDelete(Integer id){
        return sysDispatchListService.falseDelete(id);
    }

    /**
     * 作废工单
     * @param cancelWorkOrder 作废原因
     * @return map
     */
    @GetMapping("/cancel")
    public Map<String,Object> cancel(CancelWorkOrder cancelWorkOrder){
        return sysDispatchListService.cancel(cancelWorkOrder);
    }


    /**
     * 回访
     * @param revisitWorkOrder 回访信息
     * @return map
     */
    @GetMapping("/revisit")
    public Map<String,Object> revisit(RevisitWorkOrder revisitWorkOrder){
        return sysDispatchListService.revisit(revisitWorkOrder);
    }

    /**
     * 回退
     * @param id 主键id
     * @return map
     */
    @GetMapping("/rollback")
    public Map<String,Object> rollback(Integer id){
        return sysDispatchListService.rollback(id);
    }


    /**
     * 派工
     * @param sysDispatchListDetail 派工单详情信息
     * @return map
     */
    @PostMapping("/dispatch")
    public Map<String,Object> dispatch(@RequestBody SysDispatchListDetail sysDispatchListDetail){
        return sysDispatchListService.dispatch(sysDispatchListDetail);
    }


    /**
     * 报修工单详情
     * @param id 工单主键id
     * @return map
     */
    @GetMapping("/repairWorkOrderDetail")
    public Map<String,Object> repairWorkOrderDetail(Integer id){
        return sysDispatchListService.repairWorkOrderDetail(id);
    }

}
