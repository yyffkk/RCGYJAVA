package com.api.systemDataBigScreen.controller;

import com.api.systemDataBigScreen.service.SystemDataService;
import com.api.vo.app.AppActivityVo;
import com.api.vo.systemDataBigScreen.SDSysAdviceVo;
import com.api.vo.systemDataBigScreen.SDSysAnnouncementVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统数据
 */
@RestController
@RequestMapping("/systemData")
public class SystemDataController {
    @Resource
    SystemDataService systemDataService;

    /**
     * 查询派工单报修信息集合（每日新增/解决报修单的数量、当前待分配/处理中报修单数量）
     * @return map
     */
    @GetMapping("/sysDispatchList")
    public Map<String,Object> sysDispatchList(){
        return systemDataService.sysDispatchList();
    }

    /**
     * 查询投诉表扬信息集合（创建时间、类型、内容）
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/sysAdviceList")
    public Map<String,Object> sysAdviceList(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<SDSysAdviceVo> sdSysAdviceVos =systemDataService.sysAdviceList();
        PageInfo<SDSysAdviceVo> pageInfo = new PageInfo<>(sdSysAdviceVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询公共资讯信息集合（发布时间、标题）
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/sysAnnouncementList")
    public Map<String,Object> sysAnnouncementList(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<SDSysAnnouncementVo> sdSysAnnouncementVos =systemDataService.sysAnnouncementList();
        PageInfo<SDSysAnnouncementVo> pageInfo = new PageInfo<>(sdSysAnnouncementVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 基础数据:(楼栋数、房屋总数、已入住房屋数)
     * @return map
     */
    @GetMapping("/sysEstate")
    public Map<String,Object> sysEstate(){
        return systemDataService.sysEstate();
    }

    /**
     * 基础数据:(车位总数、已售车位数、已租车位数)
     * @return map
     */
    @GetMapping("/sysParkingSpace")
    public Map<String,Object> sysParkingSpace(){
        return systemDataService.sysParkingSpace();
    }

    /**
     * 基础数据:(登记车辆总数)
     * @return map
     */
    @GetMapping("/sysCar")
    public Map<String,Object> sysCar(){
        return systemDataService.sysCar();
    }









}
