package com.api.controller.operationManagement;

import com.api.model.operationManagement.ActivityManagement;
import com.api.model.operationManagement.SearchActivityManagement;
import com.api.service.operationManagement.SysActivityManagementService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoActivityManagement;
import com.api.vo.operationManagement.VoActivityRegistration;
import com.api.vo.operationManagement.VoFindByIdActivityManagement;
import com.api.vo.operationManagement.VoNotificationManagement;
import com.api.vo.resources.VoResourcesImg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 活动管理
 */
@RestController
@RequestMapping("/activityManagement")
public class SysActivityManagementController {
    @Resource
    SysActivityManagementService sysActivityManagementService;


    /**
     * 查询所有的活动信息（包含条件搜索）
     * @param searchActivityManagement  搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchActivityManagement searchActivityManagement){
        PageHelper.startPage(searchActivityManagement.getPageNum(),searchActivityManagement.getSize());
        List<VoActivityManagement> voActivityManagementList = sysActivityManagementService.list(searchActivityManagement);
        PageInfo<VoActivityManagement> pageInfo = new PageInfo<>(voActivityManagementList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据主键id查询照片资源信息
     * @param id 主键id
     * @return 照片资源信息
     */
    @GetMapping("/findImgById")
    public List<VoResourcesImg> findImgById(Integer id){
        return sysActivityManagementService.findImgById(id);
    }

    /**
     * 根据活动主键id查询报名记录信息
     * @param id 活动主键id
     * @return 报名记录信息集合
     */
    @GetMapping("/findRegistrationById")
    public List<VoActivityRegistration> findRegistrationById(Integer id){
        return sysActivityManagementService.findRegistrationById(id);
    }

    /**
     * 添加活动信息
     * @param activityManagement 活动信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody ActivityManagement activityManagement){
        return sysActivityManagementService.insert(activityManagement);
    }

    /**
     * 根据主键id查询活动信息
     * @param id 主键id
     * @return 活动信息
     */
    @GetMapping("/findById")
    public VoFindByIdActivityManagement findById(Integer id){
        return sysActivityManagementService.findById(id);
    }

    /**
     * 修改活动信息
     * @param activityManagement 活动信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody ActivityManagement activityManagement){
        return sysActivityManagementService.update(activityManagement);
    }

    /**
     * 批量删除活动信息
     * @param ids 活动信息主键id 数组
     * @return map
     */
    @PostMapping("/falseDelete")
    public Map<String,Object> falseDelete(@RequestBody VoIds ids){
        return sysActivityManagementService.falseDelete(ids.getIds());
    }






}
