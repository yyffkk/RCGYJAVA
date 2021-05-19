package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysKeyBorrowService;
import com.api.model.operationManagement.SearchKeyBorrow;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 钥匙借取管理
 */
@RestController
@RequestMapping("manage/keyBorrow")
public class SysKeyBorrowController {
    @Resource
    SysKeyBorrowService sysKeyBorrowService;

    @GetMapping("/list")
    public Map<String,Object> list(SearchKeyBorrow searchKeyBorrow){
        return null;
    }
}
