package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysSurroundingEnterprisesService;
import com.api.model.operationManagement.SurroundingEnterprisesSearch;
import com.api.vo.operationManagement.SysGeographyVo;
import com.api.vo.operationManagement.SysSurroundingEnterprisesVo;
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
 * 周边企业信息管理
 */
@RestController
@RequestMapping("manage/surroundingEnterprises")
public class SysSurroundingEnterprisesController {
    @Resource
    SysSurroundingEnterprisesService sysSurroundingEnterprisesService;

    /**
     * 查询所有的周边企业信息
     * @param surroundingEnterprisesSearch 周边企业 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SurroundingEnterprisesSearch surroundingEnterprisesSearch){
        PageHelper.startPage(surroundingEnterprisesSearch.getPageNum(), surroundingEnterprisesSearch.getSize());
        List<SysSurroundingEnterprisesVo> sysSurroundingEnterprisesVoList = sysSurroundingEnterprisesService.list(surroundingEnterprisesSearch);
        PageInfo<SysSurroundingEnterprisesVo> pageInfo = new PageInfo<>(sysSurroundingEnterprisesVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

}
