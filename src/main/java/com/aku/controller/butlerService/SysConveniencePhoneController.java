package com.aku.controller.butlerService;

import com.aku.model.butlerService.SearchConveniencePhone;
import com.aku.model.butlerService.SysConveniencePhone;
import com.aku.model.butlerService.SysConveniencePhoneReminder;
import com.aku.service.butlerService.SysConveniencePhoneService;
import com.aku.vo.butlerService.VoConveniencePhone;
import com.aku.vo.butlerService.VoUserAdvice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 便民电话表
 */
@RestController
@RequestMapping("/conveniencePhone")
public class SysConveniencePhoneController {
    @Resource
    SysConveniencePhoneService sysConveniencePhoneService;


    /**
     * 查询便民电话信息（包含条件搜索）
     * @param searchConveniencePhone 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchConveniencePhone searchConveniencePhone){
        PageHelper.startPage(searchConveniencePhone.getPageNum(),searchConveniencePhone.getSize());
        List<VoConveniencePhone> voConveniencePhoneList = sysConveniencePhoneService.list(searchConveniencePhone);
        PageInfo<VoConveniencePhone> pageInfo = new PageInfo<>(voConveniencePhoneList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加便民电话信息
     * @param sysConveniencePhone 便民电话信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysConveniencePhone sysConveniencePhone){
        return sysConveniencePhoneService.insert(sysConveniencePhone);
    }

    /**
     * 根据便民电话主键id查询便民电话信息
     * @param id 便民电话主键id
     * @return 便民电话信息
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysConveniencePhoneService.findById(id);
    }

    /**
     * 更新便民电话信息
     * @param sysConveniencePhone 新便民电话信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysConveniencePhone sysConveniencePhone){
        return sysConveniencePhoneService.update(sysConveniencePhone);
    }


    /**
     * 更新定时检查信息
     * @param sysConveniencePhoneReminder 定时检查信息
     * @return map
     */
    @PostMapping("/updateReminder")
    public Map<String,Object> updateReminder(@RequestBody SysConveniencePhoneReminder sysConveniencePhoneReminder){
        return sysConveniencePhoneService.updateReminder(sysConveniencePhoneReminder);
    }
}
