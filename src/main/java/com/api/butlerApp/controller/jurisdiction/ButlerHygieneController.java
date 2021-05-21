package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerHygieneService;
import com.api.model.butlerApp.ButlerGreenSearch;
import com.api.model.butlerApp.ButlerHygieneSearch;
import com.api.vo.butlerApp.ButlerGreenVo;
import com.api.vo.butlerApp.ButlerHygieneVo;
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
 * 管家app 卫生管理
 */
@RestController
@RequestMapping("butlerApp/user/hygiene")
public class ButlerHygieneController {
    @Resource
    ButlerHygieneService butlerHygieneService;

    /**
     * 查询所有的卫生管理
     * @param butlerHygieneSearch 管家app 卫生任务搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerHygieneSearch butlerHygieneSearch){
        PageHelper.startPage(butlerHygieneSearch.getPageNum(),butlerHygieneSearch.getSize());
        List<ButlerHygieneVo> butlerHygieneVoList =butlerHygieneService.list(butlerHygieneSearch);
        PageInfo<ButlerHygieneVo> pageInfo = new PageInfo<>(butlerHygieneVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
