package com.api.controller.butlerService;

import com.api.model.butlerService.SearchQuestionnaire;
import com.api.model.butlerService.SysQuestionnaire;
import com.api.model.butlerService.SysQuestionnaireSubmit;
import com.api.service.butlerService.SysQuestionnaireService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoQuestionnaire;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 问卷调查表
 */
@RestController
@RequestMapping("questionnaire")
public class SysQuestionnaireController {
    @Resource
    SysQuestionnaireService sysQuestionnaireService;

    /**
     * 查询所有问卷调查信息 （包含条件搜索）
     * @return 搜索条件
     */
    @GetMapping("/list")
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
    public Map<String,Object> insert(@RequestBody SysQuestionnaire sysQuestionnaire){
        return sysQuestionnaireService.insert(sysQuestionnaire);
    }

    /**
     * 根据问卷调查主键ID查询问卷调查信息
     * @param id 问卷调查主键ID
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysQuestionnaireService.findById(id);
    }

    /**
     * 更新问卷调查信息
     * @param sysQuestionnaire 问卷调查表信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysQuestionnaire sysQuestionnaire){
        return sysQuestionnaireService.update(sysQuestionnaire);
    }


    /**
     * 批量删除问卷调查信息（真删除）
     * @param ids 问卷调查id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysQuestionnaireService.delete(ids.getIds());
    }

    /**
     * 批量删除问卷调查信息（假删除）
     * @param ids 问卷调查id数组
     * @return map
     */
    @PostMapping("/falseDelete")
    public Map<String,Object> falseDelete(@RequestBody VoIds ids){
        return sysQuestionnaireService.falseDelete(ids.getIds());
    }


    /**
     * 问卷调查提交
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
    public Map<String,Object> reportAnalysis(Integer id){
        return sysQuestionnaireService.reportAnalysis(id);
    }


}
