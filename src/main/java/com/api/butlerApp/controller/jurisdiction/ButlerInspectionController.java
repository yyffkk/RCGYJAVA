package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerInspectionService;
import com.api.vo.butlerApp.ButlerArticleOutVo;
import com.api.vo.butlerApp.ButlerInspectionVo;
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
 * 巡检管理
 */
@RestController
@RequestMapping("butlerApp/user/inspection")
public class ButlerInspectionController {
    @Resource
    ButlerInspectionService butlerInspectionService;

    /**
     * 查询所有的巡检管理信息（包含条件搜索）
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param status 状态
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,int status){
        PageHelper.startPage(pageNum,size);
        List<ButlerInspectionVo> butlerInspectionVoList = butlerInspectionService.list(status);
        PageInfo<ButlerInspectionVo> pageInfo = new PageInfo<>(butlerInspectionVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
