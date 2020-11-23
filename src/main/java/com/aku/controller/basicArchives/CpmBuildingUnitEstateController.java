package com.aku.controller.basicArchives;

import com.aku.model.basicArchives.CpmBuildingUnitEstate;
import com.aku.model.basicArchives.UserResident;
import com.aku.model.basicArchives.EstateAndResidentList;
import com.aku.vo.basicArchives.VoCpmBuildingUnitEstate;
import com.aku.service.basicArchives.CpmBuildingUnitEstateService;
import com.aku.service.basicArchives.UserResidentService;
import com.aku.vo.basicArchives.VoFindAll;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("cpmBuildingUnitEstate")
@RestController
public class CpmBuildingUnitEstateController {
    //房产状态为4时，未售
    private static final int ESTATE_STATUS = 4;
    @Resource
    CpmBuildingUnitEstateService cpmBuildingUnitEstateService;
    @Resource
    UserResidentService userResidentService;

    /**
     * 查询楼栋单元房产信息（包含条件搜索）
     * @param voCpmBuildingUnitEstate 搜索条件
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(VoCpmBuildingUnitEstate voCpmBuildingUnitEstate,int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<VoCpmBuildingUnitEstate> voCpmBuildingUnitEstateList =cpmBuildingUnitEstateService.list(voCpmBuildingUnitEstate);
        PageInfo<VoCpmBuildingUnitEstate> pageInfo = new PageInfo<>(voCpmBuildingUnitEstateList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加楼栋单元房产信息(或关联业主信息)
     * @param cpmBuildingUnitEstate 楼栋单元房产信息
     * @param userResidentList 关联业主信息集合
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody CpmBuildingUnitEstate cpmBuildingUnitEstate,@RequestBody List<UserResident> userResidentList){
        //判断是否有业主需要关联
        if (cpmBuildingUnitEstate.getStatus() == ESTATE_STATUS){
            //不关联业主
            return cpmBuildingUnitEstateService.insert(cpmBuildingUnitEstate);
        } else {
            //关联业主
            return cpmBuildingUnitEstateService.insert(userResidentList, cpmBuildingUnitEstate);
        }
    }

    /**
     * 根据楼栋单元房产主键Id查询楼栋单元房产信息（或当房产不为未售状态查询其关联业主）
     * @param id 楼栋单元房产主键ID
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        Map<String,Object> map = new HashMap<>();
        //根据楼栋单元房产Id查询楼栋单元房产信息
        CpmBuildingUnitEstate cpmBuildingUnitEstate = cpmBuildingUnitEstateService.findById(id);
        //判断楼栋单元房产是否是未售状态（即无业主）
        if (cpmBuildingUnitEstate != null && cpmBuildingUnitEstate.getStatus() != ESTATE_STATUS){
            //如果有业主，则根据楼栋单元房产ID查询业主信息
            List<UserResident> userResidentList = userResidentService.findByBuildingUnitEstateId(cpmBuildingUnitEstate.getId());
            map.put("userResidentList",userResidentList);
        }else {
            map.put("userResident",null);
        }
        map.put("cpmBuildingUnitEstate",cpmBuildingUnitEstate);
        return map;
    }
    /**
     * 修改楼栋单元房产信息(或关联业主信息)
     * @param estateAndResident 楼栋单元房产信息 和 业主信息集合
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody EstateAndResidentList estateAndResident){
        Map<String,Object> map = new HashMap<>();
        if (estateAndResident.getEstate().getId() == null){
            map.put("message","ID不存在");
            map.put("status",false);
            return map;
        }
        return cpmBuildingUnitEstateService.update(estateAndResident);
    }

    /**
     * 假删除，修改楼栋单元房产的is_delete字段  0删除 1非删
     * @param id 楼栋单元房产ID
     * @return map
     */
    @GetMapping("/delete")
    public Map<String,Object> delete(Integer id){
        return cpmBuildingUnitEstateService.delete(id);
    }

    /**
     * 查询所有楼栋单元房产id和name
     * @return List<VoFindAll>
     */
    @GetMapping("/findAll")
    public List<VoFindAll> findAll(){
        return cpmBuildingUnitEstateService.findAll();
    }

    /**
     * 根据楼栋单元id查询对应的楼栋单元房产id和name
     * @param id 楼栋单元id
     * @return List<VoFindAll>
     */
    @GetMapping("/findByBuildingUnitId")
    public List<VoFindAll> findByBuildingUnitId(Integer id){
        return cpmBuildingUnitEstateService.findByBuildingUnitId(id);
    }
}
