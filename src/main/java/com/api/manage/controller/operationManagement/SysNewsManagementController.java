package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysNewsManagementService;

import com.api.model.operationManagement.SearchNewsManagement;
import com.api.model.operationManagement.SettingNewsRotation;
import com.api.model.operationManagement.SysNewsManagement;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoNewsCategoryManagement;
import com.api.vo.operationManagement.VoNewsManagement;
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
 * 资讯管理
 */
@RestController
@RequestMapping("manage/newsManagement")
public class SysNewsManagementController   {
    @Resource
    SysNewsManagementService sysNewsManagementService;


    /**
     * 查询所有的资讯信息 （包含条件搜索）
     * @param searchNewsManagement 资讯管理搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0501"},logical = Logical.AND)
    public Map<String,Object> list(SearchNewsManagement searchNewsManagement){
        PageHelper.startPage(searchNewsManagement.getPageNum(),searchNewsManagement.getSize());
        List<VoNewsManagement> voNewsManagementList = sysNewsManagementService.list(searchNewsManagement);
        PageInfo<VoNewsManagement> pageInfo = new PageInfo<>(voNewsManagementList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 添加资讯信息
     * @param sysNewsManagement 资讯信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysNewsManagement sysNewsManagement){
        return sysNewsManagementService.insert(sysNewsManagement);
    }

    /**
     * 根据资讯主键id 查询 资讯信息
     * @param newsId 资讯主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer newsId){
        return sysNewsManagementService.findById(newsId);
    }

    /**
     * 修改资讯信息
     * @param sysNewsManagement 资讯信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysNewsManagement sysNewsManagement){
        return sysNewsManagementService.update(sysNewsManagement);
    }

    /**
     * 批量删除资讯信息
     * @param ids 资讯信息主键id
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysNewsManagementService.delete(ids.getIds());
    }

    /**
     * 手动更新爬取信息（医药网，学信网）
     * @return map
     */
    @GetMapping("/updateCrawling")
    public Map<String,Object> updateCrawling(){
        HashMap<String, Object> map = new HashMap<>();
        int num = 0;
        //更新医药网爬取信息并返回更新条数
        int medicalNum = sysNewsManagementService.updateMedical();
        //更新学信网爬取信息并返回更新条数
        int educationNum = sysNewsManagementService.updateEducation();

        num = medicalNum + educationNum;

        map.put("message","更新成功");
        map.put("status",true);
        map.put("num",num);//更新条数
        return map;
    }

    /**
     * 设置轮播信息
     * @param settingNewsRotation 设置轮播信息model
     * @return
     */
    @PostMapping("/settingRotation")
    public Map<String,Object> settingRotation(@RequestBody SettingNewsRotation settingNewsRotation){
        return sysNewsManagementService.settingRotation(settingNewsRotation);
    }
}
