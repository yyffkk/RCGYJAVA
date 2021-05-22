package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysTrainService;
import com.api.model.businessManagement.SearchTrain;
import com.api.model.businessManagement.SysTrain;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.businessManagement.VoTrain;
import com.api.vo.businessManagement.VoUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 培训管理
 */
@RestController
@RequestMapping("manage/train")
public class SysTrainController {
    @Resource
    SysTrainService sysTrainService;

    /**
     * 查询所有的培训信息
     * @param searchTrain 培训管理搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchTrain searchTrain){
        PageHelper.startPage(searchTrain.getPageNum(),searchTrain.getSize());
        List<VoTrain> voTrainList = sysTrainService.list(searchTrain);
        PageInfo<VoTrain> pageInfo = new PageInfo<>(voTrainList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加培训信息
     * @param sysTrain 培训信息model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysTrain sysTrain){
        return sysTrainService.insert(sysTrain);
    }

    /**
     * 批量删除培训信息
     * @param ids 培训信息主键id数组
     * @return map
     */
    @PostMapping
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysTrainService.delete(ids.getIds());
    }
}
