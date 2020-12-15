package com.api.controller.butlerService;

import com.api.model.butlerService.SearchChargesTemplateDetail;
import com.api.model.butlerService.SysChargesTemplateDetail;
import com.api.service.butlerService.SysChargesTemplateDetailService;
import com.api.vo.butlerService.VoChargesTemplate;
import com.api.vo.butlerService.VoChargesTemplateDetail;
import com.api.vo.butlerService.VoGambit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chargesTemplateDetail")
public class SysChargesTemplateDetailController {
    @Resource
    SysChargesTemplateDetailService sysChargesTemplateDetailService;

    /**
     * 根据物业收费标准模版主键id 查询所有的物业收费标准明细 (包含条件搜索)
     * @param searchChargesTemplateDetail 搜索条件
     * @return map
     */
    @GetMapping("/list")
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
    public Map<String,Object> insert(@RequestBody SysChargesTemplateDetail sysChargesTemplateDetail){
        return sysChargesTemplateDetailService.insert(sysChargesTemplateDetail);
    }


}
