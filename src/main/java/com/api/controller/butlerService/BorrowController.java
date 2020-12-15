package com.api.controller.butlerService;

import com.api.model.butlerService.SearchBorrow;
import com.api.model.butlerService.SysMessage;
import com.api.service.butlerService.BorrowService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoArticleDetail;
import com.api.vo.butlerService.VoBorrow;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 借还管理
 */
@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Resource
    BorrowService borrowService;

    /**
     * 查询所有的借还管理信息 （包含条件搜索）
     * @param searchBorrow 搜索条件
     * @return map
     */
    @GetMapping("/list")
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
     * @param sysMessage 提醒的消息
     * @return map
     */
    @PostMapping("/remind")
    public Map<String,Object> remind(@RequestBody SysMessage sysMessage){
        return borrowService.remind(sysMessage);
    }



}
