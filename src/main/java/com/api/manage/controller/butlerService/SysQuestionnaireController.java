package com.api.manage.controller.butlerService;

import com.api.manage.shiro.ShiroExceptions;
import com.api.model.butlerService.SearchQuestionnaire;
import com.api.model.butlerService.SearchShortAnswer;
import com.api.model.butlerService.SysQuestionnaire;
import com.api.model.butlerService.SysQuestionnaireSubmit;
import com.api.manage.service.butlerService.SysQuestionnaireService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoQuestionnaire;
import com.api.vo.butlerService.VoReportQuestionnaireShort;
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
 * 问卷调查表
 */
@RestController
@RequestMapping("manage/questionnaire")
public class SysQuestionnaireController extends ShiroExceptions {
    @Resource
    SysQuestionnaireService sysQuestionnaireService;

    /**
     * 查询所有问卷调查信息 （包含条件搜索）
     * @return 搜索条件
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301","03"},logical = Logical.AND)
    public Map<String,Object> list(SearchQuestionnaire searchQuestionnaire){
        PageHelper.startPage(searchQuestionnaire.getPageNum(),searchQuestionnaire.getSize());
        List<VoQuestionnaire> voQuestionnaireList = sysQuestionnaireService.list(searchQuestionnaire);
        PageInfo<VoQuestionnaire> pageInfo = new PageInfo<>(voQuestionnaireList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加问卷调查表信息
     * @param sysQuestionnaire 问卷调查表信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0303","03"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysQuestionnaire sysQuestionnaire){
        return sysQuestionnaireService.insert(sysQuestionnaire);
    }

    /**
     * 根据问卷调查主键ID查询问卷调查信息
     * @param id 问卷调查主键ID
     * @return map
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0302","03"},logical = Logical.AND)
    public Map<String,Object> findById(Integer id){
        return sysQuestionnaireService.findById(id);
    }

    /**
     * 更新问卷调查信息
     * @param sysQuestionnaire 问卷调查表信息
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0305","03"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody SysQuestionnaire sysQuestionnaire){
        return sysQuestionnaireService.update(sysQuestionnaire);
    }


    /**
     * 批量删除问卷调查信息（真删除）
     * @param ids 问卷调查id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0304","03"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysQuestionnaireService.delete(ids.getIds());
    }

    /**
     * 批量删除问卷调查信息（假删除）
     * @param ids 问卷调查id数组
     * @return map
     */
    @PostMapping("/falseDelete")
    @RequiresPermissions(value = {"0304","03"},logical = Logical.AND)
    public Map<String,Object> falseDelete(@RequestBody VoIds ids){
        return sysQuestionnaireService.falseDelete(ids.getIds());
    }


    /**
     * 问卷调查提交(转移到app入口)
     * @param sysQuestionnaireSubmit 问卷调查提交信息
     * @return map
     */
    @PostMapping("/sysQuestionnaireSubmit")
    public Map<String,Object> sysQuestionnaireSubmit(@RequestBody SysQuestionnaireSubmit sysQuestionnaireSubmit){
        return sysQuestionnaireService.sysQuestionnaireSubmit(sysQuestionnaireSubmit);
    }

    /**
     * 根据问卷调查主键id查询报表分析信息
     * @param id 问卷调查主键id
     * @return map
     */
    @GetMapping("/reportAnalysis")
    @RequiresPermissions(value = {"0302","03"},logical = Logical.AND)
    public Map<String,Object> reportAnalysis(Integer id){
        return sysQuestionnaireService.reportAnalysis(id);
    }


    /**
     * 根据题目主键id查询开放题内容详情 (包含条件搜索)
     * @param searchShortAnswer 搜索条件
     * @return map
     */
    @GetMapping("/listShortAnswer")
    @RequiresPermissions(value = {"0302","03"},logical = Logical.AND)
    public Map<String,Object> listShortAnswer(SearchShortAnswer searchShortAnswer){
        PageHelper.startPage(searchShortAnswer.getPageNum(),searchShortAnswer.getSize());
        List<VoReportQuestionnaireShort> voReportQuestionnaireShortList = sysQuestionnaireService.listShortAnswer(searchShortAnswer);
        PageInfo<VoReportQuestionnaireShort> pageInfo = new PageInfo<>(voReportQuestionnaireShortList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }




}
