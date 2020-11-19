package com.aku.controller.basicArchives;

import com.aku.model.basicArchives.CpmBuildingUnitEstate;
import com.aku.model.basicArchives.UserResident;
import com.aku.vo.basicArchives.VoCpmBuildingUnitEstate;
import com.aku.vo.basicArchives.VoEstateAndResident;
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
        map.put("voCpmBuildingUnitEstateList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加楼栋单元房产信息(或关联业主信息)
     * @param cpmBuildingUnitEstate 楼栋单元房产信息
     * @param userResident 关联业主
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody CpmBuildingUnitEstate cpmBuildingUnitEstate,@RequestBody UserResident userResident){
        //判断是否有业主需要关联
        if (cpmBuildingUnitEstate.getStatus() == ESTATE_STATUS){
            //不关联业主
            return cpmBuildingUnitEstateService.insert(cpmBuildingUnitEstate);
        } else {
            //关联业主
            return cpmBuildingUnitEstateService.insert(userResident, cpmBuildingUnitEstate);
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
            UserResident userResident = userResidentService.findByBuildingUnitEstateId(cpmBuildingUnitEstate.getId());
            map.put("userResident",userResident);
        }else {
            map.put("userResident",null);
        }
        map.put("cpmBuildingUnitEstate",cpmBuildingUnitEstate);
        return map;
    }
    /**
     * 修改楼栋单元房产信息(或关联业主信息)
     * @param voEstateAndResident 楼栋单元房产信息 和 业主信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody VoEstateAndResident voEstateAndResident){
        Map<String,Object> map = new HashMap<>();
        //根据楼栋单元房产Id查询楼栋单元房产信息
        CpmBuildingUnitEstate cpmBuildingUnitEstate2 = cpmBuildingUnitEstateService.findById(voEstateAndResident.getEstate().getId());

        if (cpmBuildingUnitEstate2 == null){
            map.put("message","ID不存在");
            map.put("status",false);
            return map;
        }
        //判断旧数据是否有业主关联
        if (cpmBuildingUnitEstate2.getStatus() == ESTATE_STATUS){
            //无关联业主
            //判断新数据是否 需要 添加 关联业主
            if (voEstateAndResident.getEstate().getStatus() != ESTATE_STATUS){
                //更新楼栋单元房产信息及添加业主信息
                return cpmBuildingUnitEstateService.updateOne(voEstateAndResident.getEstate(), voEstateAndResident.getResident());
            }else {
                //更新楼栋单元房产信息，不添加业主信息
                return cpmBuildingUnitEstateService.updateOne(voEstateAndResident.getEstate());
            }
        } else {
            //有关联业主
            //判断新数据 房间状态是否正确（不可为未售状态）
            if (voEstateAndResident.getEstate().getStatus() != ESTATE_STATUS) {
                //更新楼栋单元房产信息及更新业主信息
                return cpmBuildingUnitEstateService.updateTwo(voEstateAndResident.getEstate(),voEstateAndResident.getResident());
            }else {
                //已有关联业主，不可选择未售状态
                map.put("message","已有关联业主，不可选择未售状态");
                map.put("status",false);
                return map;
            }
        }
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

}
