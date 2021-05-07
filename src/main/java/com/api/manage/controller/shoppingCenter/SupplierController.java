package com.api.manage.controller.shoppingCenter;

import com.api.manage.service.shoppingCenter.SupplierService;
import com.api.model.shoppingCenter.Supplier;
import com.api.model.shoppingCenter.SupplierSearch;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoActivityManagement;
import com.api.vo.shoppingCenter.SupplierVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 供应商管理
 */
@RestController
@RequestMapping("manage/shop/supplier")
public class SupplierController {
    @Resource
    SupplierService supplierService;


    /**
     * 查询所有的供应商 包含条件查询
     * @param supplierSearch 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SupplierSearch supplierSearch){
        PageHelper.startPage(supplierSearch.getPageNum(),supplierSearch.getSize());
        List<SupplierVo> supplierVos = supplierService.list(supplierSearch);
        PageInfo<SupplierVo> pageInfo = new PageInfo<>(supplierVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加供应商信息
     * @param supplier 供应商信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody Supplier supplier){
        return supplierService.insert(supplier);
    }

    /**
     * 根据供应商主键id 查询 供应商信息 Vo findById 回显
     * @param id 供应商主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return supplierService.findById(id);
    }

    /**
     * 修改供应商信息
     * @param supplier 供应商信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody Supplier supplier){
        return supplierService.update(supplier);
    }

    /**
     * 删除供应商信息
     * @param ids 供应商信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return supplierService.delete(ids.getIds());
    }
}
