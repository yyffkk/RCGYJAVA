package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerKeyService;
import com.api.model.butlerApp.ButlerKeySearch;
import com.api.vo.butlerApp.ButlerInspectionVo;
import com.api.vo.butlerApp.ButlerKeyVo;
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
 * 管家app钥匙管理
 */
@RestController
@RequestMapping("butlerApp/user/key")
public class ButlerKeyController {
    @Resource
    ButlerKeyService butlerKeyService;

    /**
     * 查询所有的钥匙信息
     * @param butlerKeySearch 管家app 钥匙搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerKeySearch butlerKeySearch){
        PageHelper.startPage(butlerKeySearch.getPageNum(),butlerKeySearch.getSize());
        List<ButlerKeyVo> butlerKeyVoList = butlerKeyService.list(butlerKeySearch);
        PageInfo<ButlerKeyVo> pageInfo = new PageInfo<>(butlerKeyVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询所有的未归还钥匙信息
     * @param butlerKeySearch 管家app 钥匙搜索条件
     * @return map
     */
    @GetMapping("/noReturnList")
    public Map<String,Object> noReturnList(ButlerKeySearch butlerKeySearch){
        PageHelper.startPage(butlerKeySearch.getPageNum(),butlerKeySearch.getSize());
        List<ButlerKeyVo> butlerKeyVoList = butlerKeyService.noReturnList(butlerKeySearch);
        PageInfo<ButlerKeyVo> pageInfo = new PageInfo<>(butlerKeyVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }




}
