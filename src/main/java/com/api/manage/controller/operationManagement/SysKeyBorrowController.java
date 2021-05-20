package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysKeyBorrowService;
import com.api.model.operationManagement.KeyBorrow;
import com.api.model.operationManagement.SearchKeyBorrow;
import com.api.vo.operationManagement.VoKeyBorrow;
import com.api.vo.operationManagement.VoKeyManagement;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 钥匙借取管理
 */
@RestController
@RequestMapping("manage/keyBorrow")
public class SysKeyBorrowController {
    @Resource
    SysKeyBorrowService sysKeyBorrowService;

    /**
     * 查询所有的钥匙审核信息(包含条件搜素)
     * @param searchKeyBorrow 钥匙审核搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchKeyBorrow searchKeyBorrow){
        PageHelper.startPage(searchKeyBorrow.getPageNum(),searchKeyBorrow.getSize());
        List<VoKeyBorrow> voKeyBorrowList = sysKeyBorrowService.list(searchKeyBorrow);
        PageInfo<VoKeyBorrow> pageInfo = new PageInfo<>(voKeyBorrowList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 审核
     * @param keyBorrow 钥匙借还/钥匙审核model管理
     * @return map
     */
    @PostMapping("/examine")
    public Map<String,Object> examine(@RequestBody KeyBorrow keyBorrow){
        return sysKeyBorrowService.examine(keyBorrow);
    }
}
