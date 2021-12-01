package com.api.manage.service.jcook.impl;

import com.api.manage.service.jcook.JcookRotationService;
import com.api.mapper.jcook.JcookRotationMapper;
import com.api.model.jcook.entity.JcookRotation;
import com.api.model.jcook.manageDto.ManageJcookRotationUpdateDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Service
public class JcookRotationServiceImpl implements JcookRotationService {
    private static Map<String,Object> map = new HashMap<>();
    @Resource
    JcookRotationMapper jcookRotationMapper;

    @Override
    public Map<String, Object> insert() {
        JcookRotation jcookRotation = new JcookRotation();
        jcookRotation.setSkuId(new BigInteger("0"));//初始sku编码为0

        int insert = jcookRotationMapper.insert(jcookRotation);
        if (insert >0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> update(ManageJcookRotationUpdateDTO manageJcookRotationUpdateDTO) {
        return null;
    }
}
