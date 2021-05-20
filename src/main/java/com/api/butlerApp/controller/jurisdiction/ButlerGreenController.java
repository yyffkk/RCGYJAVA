package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerGreenService;
import com.api.vo.butlerApp.ButlerBorrowVo;
import com.api.vo.butlerApp.ButlerTypeAndBorrowListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
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
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param greenStatus 状态
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,Integer greenStatus){
        PageHelper.startPage(pageNum,size);
//        ButlerTypeAndBorrowListVo typeAndBorrowListVo =butlerGreenService.list(greenStatus);
//        PageInfo<ButlerBorrowVo> pageInfo = new PageInfo<>(typeAndBorrowListVo.getButlerBorrowVos());
        Map<String,Object> map = new HashMap<>();
//        map.put("type",typeAndBorrowListVo.getType());
//        map.put("tableList",pageInfo.getList());
//        map.put("rowCount",pageInfo.getTotal());
//        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
