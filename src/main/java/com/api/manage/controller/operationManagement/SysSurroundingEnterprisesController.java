package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysSurroundingEnterprisesService;
import com.api.model.operationManagement.SurroundingEnterprisesInsert;
import com.api.model.operationManagement.SurroundingEnterprisesSearch;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.SysGeographyVo;
import com.api.vo.operationManagement.SysSurroundingEnterprisesVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 新增周边企业
     * @param surroundingEnterprisesInsert 周边企业新增model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SurroundingEnterprisesInsert surroundingEnterprisesInsert){
        return sysSurroundingEnterprisesService.insert(surroundingEnterprisesInsert);
    }

    /**
     * 根据周边企业主键id查询周边企业
     * @param surroundingEnterprisesId 周边企业主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer surroundingEnterprisesId){
        return sysSurroundingEnterprisesService.findById(surroundingEnterprisesId);
    }

    /**
     * 修改周边企业
     * @param surroundingEnterprisesInsert 周边企业新增model
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SurroundingEnterprisesInsert surroundingEnterprisesInsert){
        return sysSurroundingEnterprisesService.update(surroundingEnterprisesInsert);
    }

    /**
     * 删除周边企业
     * @param ids 周边企业主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysSurroundingEnterprisesService.delete(ids.getIds());
    }

    /**
     * 发布消息
     * @param surroundingEnterprisesId 周边企业主键id
     * @return map
     */
    @GetMapping("/release")
    public Map<String,Object> release(Integer surroundingEnterprisesId){
        return sysSurroundingEnterprisesService.release(surroundingEnterprisesId);
    }

    /**
     * 取消发布消息
     * @param surroundingEnterprisesId 周边企业主键id
     * @return map
     */
    @GetMapping("/noRelease")
    public Map<String,Object> noRelease(Integer surroundingEnterprisesId){
        return sysSurroundingEnterprisesService.noRelease(surroundingEnterprisesId);
    }


}
