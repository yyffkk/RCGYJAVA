package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysKeyBorrowDao;
import com.api.manage.service.operationManagement.SysKeyBorrowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysKeyBorrowServiceImpl implements SysKeyBorrowService {
    @Resource
    SysKeyBorrowDao sysKeyBorrowDao;
}
