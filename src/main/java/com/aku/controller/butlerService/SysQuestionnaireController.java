package com.aku.controller.butlerService;

import com.aku.model.butlerService.SearchQuestionnaire;
import com.aku.model.butlerService.SysQuestionnaire;
import com.aku.service.butlerService.SysQuestionnaireService;
import com.aku.vo.butlerService.VoConveniencePhone;
import com.aku.vo.butlerService.VoQuestionnaire;
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
     * 添加问卷调查表信息(?????上传照片没做??????)
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



}
