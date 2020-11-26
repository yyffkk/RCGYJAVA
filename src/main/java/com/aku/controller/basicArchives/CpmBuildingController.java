package com.aku.controller.basicArchives;

import com.aku.model.basicArchives.CpmBuilding;
import com.aku.vo.basicArchives.VoFindAll;
import com.aku.vo.basicArchives.VoIds;
import com.aku.service.basicArchives.CpmBuildingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 楼栋管理
 */
@RequestMapping("cpmBuilding")
@RestController
public class CpmBuildingController {

    @Resource
    CpmBuildingService cpmBuildingService;


    /**
     * 查询楼栋信息（包含条件搜索）
     * @param cpmBuilding 搜索条件（楼栋名称，楼栋编号）
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(CpmBuilding cpmBuilding,Integer pageNum,Integer size){
        PageHelper.startPage(pageNum,size);
        List<CpmBuilding> cpmBuildingList =cpmBuildingService.list(cpmBuilding);
        PageInfo<CpmBuilding> pageInfo = new PageInfo<>(cpmBuildingList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 添加楼栋信息
     * @param cpmBuilding 楼栋信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody CpmBuilding cpmBuilding){
        return cpmBuildingService.insert(cpmBuilding);
    }

    /**
     * 根据ID查询楼栋信息
     * @param id ID
     * @return 楼栋信息
     */
    @GetMapping("/findById")
    public CpmBuilding findById(Integer id){
        return cpmBuildingService.findById(id);
    }

    /**
     * 修改楼栋信息
     * @param cpmBuilding 楼栋信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody CpmBuilding cpmBuilding){
        return cpmBuildingService.update(cpmBuilding);
    }

    /**
     * 删除楼栋信息
     * @param ids id集合
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return cpmBuildingService.delete(ids.getIds());
    }

    /**
     * 查询所有楼栋id和name
     * @return List<VoFindAll>
     */
    @GetMapping("/findAll")
    public List<VoFindAll> findAll(){
        return cpmBuildingService.findAll();
    }


}
