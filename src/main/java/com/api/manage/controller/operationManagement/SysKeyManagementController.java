package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysKeyManagementService;
import com.api.model.operationManagement.SearchKeyManagement;
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
 * 钥匙管理
 */
@RestController
@RequestMapping("manage/keyManagement")
public class SysKeyManagementController {
    @Resource
    SysKeyManagementService sysKeyManagementService;

    /**
     * 查询所有的钥匙信息
     * @param searchKeyManagement 钥匙管理 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchKeyManagement searchKeyManagement){
        PageHelper.startPage(searchKeyManagement.getPageNum(),searchKeyManagement.getSize());
//        List<VoNewsManagement> voNewsManagementList = sysNewsManagementService.list(searchKeyManagement);
//        PageInfo<VoNewsManagement> pageInfo = new PageInfo<>(voNewsManagementList);
//        Map<String,Object> map = new HashMap<>();
//        map.put("tableList",pageInfo.getList());
//        map.put("rowCount",pageInfo.getTotal());
//        map.put("pageCount",pageInfo.getPages());
//        return map;
        return null;
    }

}
