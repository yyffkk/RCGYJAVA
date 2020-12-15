package com.api.controller.butlerService;

import com.api.model.butlerService.ChargesTemplate;
import com.api.service.butlerService.SysChargesTemplateService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoChargesTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 收费标准管理表
 */
@RestController
@RequestMapping("/chargesTemplate")
public class SysChargesTemplateController {
    @Resource
    SysChargesTemplateService sysChargesTemplateService;

    /**
     * 查询所有的物业收费标准模版
     * @return 物业收费标准模版集合
     */
    @GetMapping("/list")
    public List<VoChargesTemplate> list(){
        return sysChargesTemplateService.list();
    }

    /**
     * 添加物业收费标准模版
     * @param chargesTemplate 物业收费标准模版信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody ChargesTemplate chargesTemplate){
        return sysChargesTemplateService.insert(chargesTemplate);
    }

    /**
     * 根据物业收费标准模版主键id查询物业收费标准模版信息
     * @param id 物业收费标准模版主键id
     * @return 物业收费标准模版信息
     */
    @GetMapping("/findById")
    public VoChargesTemplate findById(Integer id){
        return sysChargesTemplateService.findById(id);
    }


    /**
     * 批量删除物业收费标准模版
     * @param ids 物业收费标准模版主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysChargesTemplateService.delete(ids.getIds());
    }

    /**
     * 更新物业收费标准模版信息
     * @param chargesTemplate 新物业收费标准模版信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody ChargesTemplate chargesTemplate){
        return sysChargesTemplateService.update(chargesTemplate);
    }

    /**
     * 根据物业收费标准模版主键id启用物业收费标准模版
     * @param id 物业收费标准模版主键id
     * @return map
     */
    @GetMapping("/enable")
    public Map<String,Object> enable(Integer id){
        return sysChargesTemplateService.enable(id);
    }


    /**
     * 根据物业收费标准模版主键id禁用物业收费标准模版
     * @param id 物业收费标准模版主键id
     * @return map
     */
    @GetMapping("/disable")
    public Map<String,Object> disable(Integer id){
        return sysChargesTemplateService.disable(id);
    }





}
