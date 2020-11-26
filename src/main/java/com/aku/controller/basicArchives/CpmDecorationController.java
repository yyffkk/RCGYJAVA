package com.aku.controller.basicArchives;

import com.aku.model.basicArchives.CpmDecoration;
import com.aku.model.basicArchives.DecorationAndStaff;
import com.aku.model.basicArchives.DecorationIdAndStaffId;
import com.aku.model.basicArchives.SearchDecoration;
import com.aku.service.basicArchives.CpmDecorationService;
import com.aku.vo.basicArchives.VoCpmBuildingUnitEstate;
import com.aku.vo.basicArchives.VoDecoration;
import com.aku.vo.basicArchives.VoIds;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/decoration")
@RestController
public class CpmDecorationController {
    @Resource
    CpmDecorationService cpmDecorationService;


    /**
     * 查询所有的装修信息（包含条件搜索）
     * @param searchDecoration 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchDecoration searchDecoration){
        PageHelper.startPage(searchDecoration.getPageNum(),searchDecoration.getSize());
        List<VoDecoration> voDecorationList =cpmDecorationService.list(searchDecoration);
        PageInfo<VoDecoration> pageInfo = new PageInfo<>(voDecorationList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加装修信息
     * @param decorationAndStaff 装修信息 和 附属员工信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody DecorationAndStaff decorationAndStaff){
        return cpmDecorationService.insert(decorationAndStaff);
    }

    /**
     * 修改装修信息
     * @param decorationAndStaff 装修信息 和 附属员工信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody DecorationAndStaff decorationAndStaff){
        return cpmDecorationService.update(decorationAndStaff);
    }

    /**
     * 根据主键id查询装修信息
     * @param id 主键id
     * @return 装修信息 和 附属员工信息
     */
    @GetMapping("/findById")
    public DecorationAndStaff findById(Integer id){
        return cpmDecorationService.findById(id);
    }


    /**
     * 根据主键id删除装修信息
     * @param ids 装修主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return cpmDecorationService.delete(ids.getIds());
    }
    /**
     * 根据主键id删除关联成员信息
     * @param decorationIdAndStaffId 装修id 和 附属员工id
     * @return map
     */
    @GetMapping("/deleteStaff")
    public Map<String,Object> deleteStaff(DecorationIdAndStaffId decorationIdAndStaffId){
        return cpmDecorationService.deleteStaff(decorationIdAndStaffId);
    }



}
