package com.aku.controller.butlerService;

import com.aku.model.basicArchives.CpmBuilding;
import com.aku.model.butlerService.SearchUserVisitors;
import com.aku.model.butlerService.UserVisitors;
import com.aku.service.butlerService.UserVisitorsService;
import com.aku.vo.basicArchives.VoIds;
import com.aku.vo.butlerService.VoFindByIdVisitors;
import com.aku.vo.butlerService.VoUserVisitors;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 访客管理表
 */
@RestController
@RequestMapping("/visitors")
public class UserVisitorsController {
    @Resource
    UserVisitorsService userVisitorsService;

    /**
     * 查询所有的访客管理信息 （包含条件搜索）
     * @param searchUserVisitors 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchUserVisitors searchUserVisitors){
        PageHelper.startPage(searchUserVisitors.getPageNum(),searchUserVisitors.getSize());
        List<VoUserVisitors> voUserVisitorsList =userVisitorsService.list(searchUserVisitors);
        PageInfo<VoUserVisitors> pageInfo = new PageInfo<>(voUserVisitorsList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据访客管理主键id查询访客管理信息
     * @param id 访客管理主键id
     * @return 访客管理信息
     */
    @GetMapping("/findById")
    public VoFindByIdVisitors findById(Integer id){
        return userVisitorsService.findById(id);
    }

    /**
     * 更新访客管理信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody UserVisitors visitors){
        return userVisitorsService.update(visitors);
    }

    /**
     * 批量作废访客信息
     * @param ids 访客信息主键id数组
     * @return map
     */
    @PostMapping("/cancel")
    public Map<String,Object> cancel(@RequestBody VoIds ids){
        return userVisitorsService.cancel(ids.getIds());
    }

    /**
     * 批量删除访客信息
     * @param ids 访客信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return userVisitorsService.delete(ids.getIds());
    }

    /**
     * 根据访客管理信息主键id查询访客出入记录
     * @param id 访客管理信息主键id
     * @return 访客出入记录
     */
    @GetMapping("listDetail")
    public Map<String,Object> listDetail(Integer id){
        return userVisitorsService.listDetail(id);
    }

}
