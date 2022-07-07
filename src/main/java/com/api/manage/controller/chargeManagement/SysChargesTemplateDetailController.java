package com.api.manage.controller.chargeManagement;


import com.api.model.chargeManagement.SearchChargesTemplateDetail;
import com.api.model.chargeManagement.SysChargesTemplateDetail;
import com.api.manage.service.chargeManagement.SysChargesTemplateDetailService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.chargeManagement.VoChargesTemplateDetail;
import com.api.vo.chargeManagement.VoFindByIdChargesTemplateDetail;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 物业收费标准明细表
 */
@RestController
@RequestMapping("manage/chargesTemplateDetail")
public class SysChargesTemplateDetailController   {
    @Resource
    SysChargesTemplateDetailService sysChargesTemplateDetailService;

    /**
     * 根据物业收费标准模版主键id 查询所有的物业收费标准明细 (包含条件搜索)
     * @param searchChargesTemplateDetail 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0401","04"},logical = Logical.AND)
    public Map<String,Object> list(SearchChargesTemplateDetail searchChargesTemplateDetail){
        PageHelper.startPage(searchChargesTemplateDetail.getPageNum(),searchChargesTemplateDetail.getSize());
        List<VoChargesTemplateDetail> voChargesTemplateList = sysChargesTemplateDetailService.list(searchChargesTemplateDetail);
        PageInfo<VoChargesTemplateDetail> pageInfo = new PageInfo<>(voChargesTemplateList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加物业收费标准明细信息
     * @param sysChargesTemplateDetail 物业收费标准明细信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0403","04"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysChargesTemplateDetail sysChargesTemplateDetail){
        return sysChargesTemplateDetailService.insert(sysChargesTemplateDetail);
    }


    /**
     * 根据物业收费标准明细主键id 查询物业收费标准明细信息
     * @param id 物业收费标准明细主键id
     * @return 物业收费标准明细信息
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0402","04"},logical = Logical.AND)
    public Map<String,Object> findById(Integer id){
        return sysChargesTemplateDetailService.findById(id);
    }

    /**
     * 更新物业收费标准明细信息
     * @param sysChargesTemplateDetail 新物业收费标准明细信息
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0405","04"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody SysChargesTemplateDetail sysChargesTemplateDetail){
        return sysChargesTemplateDetailService.update(sysChargesTemplateDetail);
    }

    /**
     * 批量删除物业收费标准明细信息
     * @param ids 物业收费标准明细主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0404","04"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysChargesTemplateDetailService.delete(ids.getIds());
    }

    /**
     * 导出报表（导出EXCEL）
     * @param request request请求
     * @param response response请求
     * @param chargesTemplateId 物业收费标准模版主键id
     */
    @GetMapping("/export")
    @RequiresPermissions(value = {"0401","04"},logical = Logical.AND)
    public void export(HttpServletRequest request, HttpServletResponse response,Integer chargesTemplateId){
        sysChargesTemplateDetailService.export(request,response,chargesTemplateId);
    }

    /**
     * 根据物业收费标准明细主键id 启用/禁用 物业收费标准明细
     * @param id 物业收费标准明细主键id
     * @return map
     */
    @GetMapping("/isEnable")
    @RequiresPermissions(value = {"0406","04"},logical = Logical.AND)
    public Map<String,Object> isEnable(Integer id){
        return sysChargesTemplateDetailService.isEnable(id);
    }




}
