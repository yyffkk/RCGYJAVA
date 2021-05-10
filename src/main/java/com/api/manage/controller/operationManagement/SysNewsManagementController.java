package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysNewsManagementService;
import com.api.model.operationManagement.SearchNewsManagement;
import com.api.vo.operationManagement.VoNewsCategoryManagement;
import com.api.vo.operationManagement.VoNewsManagement;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资讯管理
 */
@RestController
@RequestMapping("manage/newsManagement")
public class SysNewsManagementController {
    @Resource
    SysNewsManagementService sysNewsManagementService;


    /**
     * 查询所有的资讯信息 （包含条件搜索）
     * @param searchNewsManagement 资讯管理搜索条件
     * @return map
     */
    @GetMapping("/list")
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
}
