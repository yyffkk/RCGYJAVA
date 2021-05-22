package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysSalaryService;
import com.api.model.businessManagement.SearchSalary;
import com.api.model.businessManagement.SysSalary;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.businessManagement.VoSalary;
import com.api.vo.businessManagement.VoTrain;
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
@RequestMapping("manage/salary")
public class SysSalaryController {
    @Resource
    SysSalaryService sysSalaryService;

    /**
     * 查询所有的薪资管理信息
     * @param searchSalary 薪资管理搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchSalary searchSalary){
        PageHelper.startPage(searchSalary.getPageNum(),searchSalary.getSize());
        List<VoSalary> voSalaryList = sysSalaryService.list(searchSalary);
        PageInfo<VoSalary> pageInfo = new PageInfo<>(voSalaryList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加薪资信息
     * @param sysSalary 薪资信息model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysSalary sysSalary){
        return sysSalaryService.insert(sysSalary);
    }

    /**
     * 批量删除薪资信息
     * @param ids 薪资管理主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysSalaryService.delete(ids.getIds());
    }
}
