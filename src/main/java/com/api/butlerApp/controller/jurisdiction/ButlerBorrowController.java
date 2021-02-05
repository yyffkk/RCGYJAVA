package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerBorrowService;
import com.api.model.butlerApp.ButlerBorrowSearch;
import com.api.vo.butlerApp.ButlerBorrowVo;
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
 * 管家app 借还管理
 */
@RestController
@RequestMapping("butlerApp/user/borrow")
public class ButlerBorrowController {
    @Resource
    ButlerBorrowService butlerBorrowService;

    /**
     * 查询所有的借还信息（包含条件搜索）
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerBorrowSearch butlerBorrowSearch){
        PageHelper.startPage(butlerBorrowSearch.getPageNum(),butlerBorrowSearch.getSize());
        ButlerTypeAndBorrowListVo typeAndBorrowListVo =butlerBorrowService.list(butlerBorrowSearch);
        PageInfo<ButlerBorrowVo> pageInfo = new PageInfo<>(typeAndBorrowListVo.getButlerBorrowVos());
        Map<String,Object> map = new HashMap<>();
        map.put("type",typeAndBorrowListVo.getType());
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
