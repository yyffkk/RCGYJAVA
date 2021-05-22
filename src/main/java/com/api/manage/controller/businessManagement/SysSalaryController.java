package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysSalaryService;
import com.api.model.businessManagement.SearchSalary;
import com.api.vo.businessManagement.VoSalary;
import com.api.vo.businessManagement.VoTrain;
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
}
