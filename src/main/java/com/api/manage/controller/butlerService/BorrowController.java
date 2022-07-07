package com.api.manage.controller.butlerService;


import com.api.model.butlerService.BorrowRemind;
import com.api.model.butlerService.SearchBorrow;
import com.api.manage.service.butlerService.BorrowService;
import com.api.vo.butlerService.VoBorrow;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 借还管理
 */
@RestController
@RequestMapping("manage/borrow")
public class BorrowController   {
    @Resource
    BorrowService borrowService;

    /**
     * 查询所有的借还管理信息 （包含条件搜索）
     * @param searchBorrow 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301","03"},logical = Logical.AND)
    public Map<String,Object> list(SearchBorrow searchBorrow){
        PageHelper.startPage(searchBorrow.getPageNum(),searchBorrow.getSize());
        List<VoBorrow> voBorrowList = borrowService.list(searchBorrow);
        PageInfo<VoBorrow> pageInfo = new PageInfo<>(voBorrowList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 提醒(管理员发送)
     * @param borrowRemind 借还提醒
     * @return map
     */
    @PostMapping("/remind")
    @RequiresPermissions(value = {"0306","03"},logical = Logical.AND)
    public Map<String,Object> remind(@RequestBody BorrowRemind borrowRemind){
        return borrowService.remind(borrowRemind);
    }



}
