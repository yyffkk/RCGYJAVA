package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerDecorationService;
import com.api.model.butlerApp.ButlerDecorationSearch;
import com.api.vo.butlerApp.ButlerBorrowVo;
import com.api.vo.butlerApp.ButlerDecorationVo;
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
 * 管家app 装修管理
 */
@RestController
@RequestMapping("butlerApp/user/decoration")
public class ButlerDecorationController {
    @Resource
    ButlerDecorationService butlerDecorationService;

    /**
     * 查询装修管理信息list列表
     * @param decorationSearch 管家app 装修管理搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerDecorationSearch decorationSearch){
        PageHelper.startPage(decorationSearch.getPageNum(),decorationSearch.getSize());
        List<ButlerDecorationVo> butlerDecorationVos = butlerDecorationService.list(decorationSearch);
        PageInfo<ButlerDecorationVo> pageInfo = new PageInfo<>(butlerDecorationVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据装修主键id查询装修详情
     * @param decorationId 装修主键id
     * @return map
     */
    public Map<String,Object> findById(Integer decorationId){
        return butlerDecorationService.findById(decorationId);
    }



}
