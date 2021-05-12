package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerPackageCollectionService;
import com.api.manage.service.operationManagement.SysPackageCollectionService;
import com.api.model.operationManagement.SysPackageCollection;
import com.api.vo.butlerApp.ButlerDecorationVo;
import com.api.vo.operationManagement.VoPackageCollection;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 包裹代收
 */
@RestController
@RequestMapping("butlerApp/user/packageCollection")
public class ButlerPackageCollectionController {
    @Resource
    ButlerPackageCollectionService butlerPackageCollectionService;
    @Resource
    SysPackageCollectionService sysPackageCollectionService;

    /**
     * 管家app 查询所有的包裹代收信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param collectionStatus 代收状态，1.未领取，2.已领取
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,Integer collectionStatus){
        PageHelper.startPage(pageNum,size);
        List<VoPackageCollection> voPackageCollectionList = butlerPackageCollectionService.list(collectionStatus);
        PageInfo<VoPackageCollection> pageInfo = new PageInfo<>(voPackageCollectionList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加包裹代收信息
     * @param sysPackageCollection 包裹代收model信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysPackageCollection sysPackageCollection){
        return sysPackageCollectionService.insert(sysPackageCollection);
    }

    /**
     * 提醒领取
     * @param packageCollectionId 包裹代收主键id
     * @return map
     */
    @GetMapping("/remind")
    public Map<String,Object> remind(Integer packageCollectionId){
        return null;
    }
}
