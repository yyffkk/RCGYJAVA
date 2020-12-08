package com.api.controller.basicArchives;

import com.api.model.basicArchives.CpmBuildingUnit;
import com.api.vo.basicArchives.VoCpmBuildingUnit;
import com.api.vo.basicArchives.VoFindAll;
import com.api.vo.basicArchives.VoIds;
import com.api.service.basicArchives.CpmBuildingUnitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("cpmBuildingUnit")
@RestController
public class CpmBuildingUnitController {
    @Resource
    CpmBuildingUnitService cpmBuildingUnitService;

    /**
     * 查询楼栋单元信息（包含条件搜索）
     * @param voCpmBuildingUnit 搜索条件
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(VoCpmBuildingUnit voCpmBuildingUnit, int pageNum, int size){
        PageHelper.startPage(pageNum,size);
        List<VoCpmBuildingUnit> voCpmBuildingUnitList =cpmBuildingUnitService.list(voCpmBuildingUnit);
        PageInfo<VoCpmBuildingUnit> pageInfo = new PageInfo<>(voCpmBuildingUnitList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加楼栋单元信息
     * @param cpmBuildingUnit 楼栋单元信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody CpmBuildingUnit cpmBuildingUnit){
        return cpmBuildingUnitService.insert(cpmBuildingUnit);
    }

    /**
     * 根据id查询楼栋单元信息
     * @param id id
     * @return 楼栋单元信息
     */
    @GetMapping("/findById")
    public CpmBuildingUnit findById(Integer id){
        return cpmBuildingUnitService.findById(id);
    }

    /**
     * 修改楼栋单元信息
     * @param cpmBuildingUnit 修改信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody CpmBuildingUnit cpmBuildingUnit){
        return cpmBuildingUnitService.update(cpmBuildingUnit);
    }

    /**
     * 删除楼栋单元信息
     * @param ids id集合
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return cpmBuildingUnitService.delete(ids.getIds());
    }

    /**
     * 查询所有楼栋单元id和name
     * @return List<VoFindAll>
     */
    @GetMapping("/findAll")
    public List<VoFindAll> findAll(){
        return cpmBuildingUnitService.findAll();
    }

    /**
     * 根据楼栋id查询对应的楼栋单元id和name
     * @param id 楼栋id
     * @return List<VoFindAll>
     */
    @GetMapping("/findByBuildingId")
    public List<VoFindAll> findByBuildingId(Integer id){
        return cpmBuildingUnitService.findByBuildingId(id);
    }
}
