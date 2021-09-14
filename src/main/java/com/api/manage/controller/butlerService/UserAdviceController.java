package com.api.manage.controller.butlerService;


import com.api.model.butlerService.SearchUserAdvice;
import com.api.model.butlerService.SysAdvice;
import com.api.model.butlerService.SysAdviceDetail;
import com.api.manage.service.butlerService.UserAdviceService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoUserAdvice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 咨询建议表
 */
@RequestMapping("manage/advice")
@RestController
public class UserAdviceController   {

    @Resource
    UserAdviceService userAdviceService;

    /**
     * 查询所有的咨询建议 （包含条件搜索）
     * @param searchUserAdvice 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> list(SearchUserAdvice searchUserAdvice){
        PageHelper.startPage(searchUserAdvice.getPageNum(),searchUserAdvice.getSize());
        List<VoUserAdvice> voUserAdvices = userAdviceService.list(searchUserAdvice);
        PageInfo<VoUserAdvice> pageInfo = new PageInfo<>(voUserAdvices);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 回复咨询建议（添加反馈信息）【住户，装修公司，物业】【已替换违禁关键字】
     * @param sysAdviceDetail 建议反馈表信息
     * @return map
     */
    @PostMapping("/insertDetail")
    @RequiresPermissions(value = {"0307"},logical = Logical.AND)
    public Map<String,Object> insertDetail(@RequestBody SysAdviceDetail sysAdviceDetail){
        return userAdviceService.insertDetail(sysAdviceDetail);
    }

    /**
     * 新增咨询建议(未测)【已替换违禁关键字】
     * @param sysAdvice 咨询建议表信息
     * @return map
     */
    @PostMapping("/insertAdvice")
    @RequiresPermissions(value = {"0303"},logical = Logical.AND)
    public Map<String,Object> insertAdvice(@RequestBody SysAdvice sysAdvice,HttpServletRequest request){
        return userAdviceService.insertAdvice(sysAdvice,request);
    }

    /**
     * 批量删除咨询建议信息（真删除）
     * @param ids 咨询建议主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0304"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return userAdviceService.delete(ids.getIds());
    }

    /**
     * 批量删除咨询建议信息（假删除）
     * @param ids 咨询建议主键id数组
     * @return map
     */
    @PostMapping("/falseDelete")
    @RequiresPermissions(value = {"0304"},logical = Logical.AND)
    public Map<String,Object> falseDelete(@RequestBody VoIds ids){
        return userAdviceService.falseDelete(ids.getIds());
    }

    /**
     * 根据咨询建议主键id查询咨询建议详情
     * @param id 咨询建议主键id
     * @return map
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0302"},logical = Logical.AND)
    public Map<String,Object> findById(Integer id){
        return userAdviceService.findById(id);
    }

    /**
     * 查询今日建议条数
     * @return map
     */
    @GetMapping("/countAdviceNew")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> countAdviceNew(){
        return userAdviceService.countAdviceNew();
    }

    /**
     * 查询今日咨询条数
     * @return map
     */
    @GetMapping("/countConsultNew")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> countConsultNew(){
        return userAdviceService.countConsultNew();
    }





}
