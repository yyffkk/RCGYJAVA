package com.aku.controller.basicArchives;

import com.aku.model.basicArchives.TestUnit;
import com.aku.model.vo.VoUnit;
import com.aku.service.basicArchives.UnitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("unit")
@RestController
public class UnitController {
    @Resource
    UnitService unitService;

    /**
     * 查询单元信息（包含搜索条件）
     * @param voUnit 单元信息Vo
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/list")
    public Map<String, Object> list(VoUnit voUnit, int pageNum, int size){
        PageHelper.startPage(pageNum,size);
        List<VoUnit> unitList = unitService.list(voUnit);
        PageInfo<VoUnit> pageInfo = new PageInfo<>(unitList);
        Map<String,Object> map = new HashMap<>();
        map.put("unitList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加单元信息
     * @param testUnit 单元信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(TestUnit testUnit){
        return unitService.insert(testUnit);
    }

    /**
     * 根据单元ID查询单元信息
     * @param id 单元ID
     * @return 单元信息
     */
    @GetMapping("/findById")
    public TestUnit findById(Integer id){
        return unitService.findById(id);
    }

    /**
     * 修改单元信息
     * @param testUnit 单元信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(TestUnit testUnit){
        return unitService.update(testUnit);
    }

    /**
     * 删除单元信息
     * @param id 单元ID
     * @return map
     */
    @GetMapping("/delete")
    public Map<String,Object> delete(Integer id){
        return unitService.delete(id);
    }

}
