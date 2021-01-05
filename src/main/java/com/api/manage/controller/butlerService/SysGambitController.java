package com.api.manage.controller.butlerService;

import com.api.model.butlerService.SearchGambit;
import com.api.model.butlerService.SysGambit;
import com.api.manage.service.butlerService.SysGambitService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoFindByIdGambit;
import com.api.vo.butlerService.VoGambit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 话题管理表
 */
@RestController
@RequestMapping("manage/gambit")
public class SysGambitController {
    @Resource
    SysGambitService sysGambitService;

    /**
     * 查询所有的话题信息 （包含条件搜索）
     * @param searchGambit  搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchGambit searchGambit){
        PageHelper.startPage(searchGambit.getPageNum(),searchGambit.getSize());
        List<VoGambit> voGambitList = sysGambitService.list(searchGambit);
        PageInfo<VoGambit> pageInfo = new PageInfo<>(voGambitList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加话题信息(物业后台添加)
     * @param sysGambit 话题信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysGambit sysGambit){
        return sysGambitService.insert(sysGambit);
    }

    /**
     * 根据话题主键id查询话题详情
     * @param id 话题主键id
     * @return map
     */
    @GetMapping("/findById")
    public VoFindByIdGambit findById(Integer id){
        return sysGambitService.findById(id);
    }


    /**
     * 修改话题信息(物业后台修改)
     * @param sysGambit 新话题信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysGambit sysGambit){
        return sysGambitService.update(sysGambit);
    }

    /**
     * 批量删除话题信息（假删除）
     * @param ids 话题信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> falseDelete(@RequestBody VoIds ids){
        return sysGambitService.falseDelete(ids.getIds());
    }

    /**
     * 启用社区话题
     * @param id 话题主键id
     * @return map
     */
    @GetMapping("/enableGambit")
    public Map<String,Object> enableGambit(Integer id){
        return sysGambitService.enableGambit(id);
    }

    /**
     * 禁用社区话题
     * @param id 话题主键id
     * @return map
     */
    @GetMapping("/disableGambit")
    public Map<String,Object> disableGambit(Integer id){
        return sysGambitService.disableGambit(id);
    }
}
