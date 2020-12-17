package com.api.controller.butlerService;

import com.api.model.butlerService.SearchDispatchList;
import com.api.service.butlerService.SysDispatchListService;
import com.api.vo.butlerService.VoDispatchList;
import com.api.vo.butlerService.VoGambit;
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
 * 派工单表
 */
@RestController
@RequestMapping("dispatch")
public class SysDispatchListController {
    @Resource
    SysDispatchListService sysDispatchListService;

    /**
     * 查询所有的派工单信息 （包含条件搜素）
     * @param searchDispatchList  搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchDispatchList searchDispatchList){
        PageHelper.startPage(searchDispatchList.getPageNum(),searchDispatchList.getSize());
        List<VoDispatchList> voDispatchListList = sysDispatchListService.list(searchDispatchList);
        PageInfo<VoDispatchList> pageInfo = new PageInfo<>(voDispatchListList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

}
