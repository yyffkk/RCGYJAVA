package com.api.manage.service.operationManagement.impl;

import com.api.manage.service.operationManagement.SysSurroundingEnterprisesService;
import com.api.model.operationManagement.SurroundingEnterprisesSearch;
import com.api.vo.operationManagement.SysSurroundingEnterprisesVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysSurroundingEnterprisesServiceImpl implements SysSurroundingEnterprisesService {
    private static Map<String,Object> map = null;


    @Override
    public List<SysSurroundingEnterprisesVo> list(SurroundingEnterprisesSearch surroundingEnterprisesSearch) {
        return null;
    }
}
