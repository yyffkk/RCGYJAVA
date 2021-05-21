package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerGreenService;
import com.api.model.butlerApp.ButlerGreenSearch;
import com.api.vo.butlerApp.ButlerBorrowVo;
import com.api.vo.butlerApp.ButlerDecorationVo;
import com.api.vo.butlerApp.ButlerGreenVo;
import com.api.vo.butlerApp.ButlerTypeAndBorrowListVo;
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
 * 管家app 绿化管理
 */
@RestController
@RequestMapping("butlerApp/user/green")
public class ButlerGreenController {
    @Resource
    ButlerGreenService butlerGreenService;

    /**
     * 查询所有的绿化管理
     * @param butlerGreenSearch 管家app 绿化任务搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerGreenSearch butlerGreenSearch){
        PageHelper.startPage(butlerGreenSearch.getPageNum(),butlerGreenSearch.getSize());
        List<ButlerGreenVo> butlerGreenVoList =butlerGreenService.list(butlerGreenSearch);
        PageInfo<ButlerGreenVo> pageInfo = new PageInfo<>(butlerGreenVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
