package com.api.manage.service.jcook.impl;

import com.api.manage.dao.basicArchives.UserResidentDao;
import com.api.manage.service.jcook.JcookOrderService;
import com.api.mapper.jcook.JcookOrderMapper;
import com.api.model.basicArchives.UserResident;
import com.api.model.jcook.entity.JcookOrder;
import com.api.model.jcook.manageDto.ManageJcookOrderSearch;
import com.api.util.PropertyUtils;
import com.api.vo.jcook.manageOrder.ManageJcookOrderVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class JcookOrderServiceImpl implements JcookOrderService {
    @Resource
    JcookOrderMapper jcookOrderMapper;
    @Resource
    UserResidentDao userResidentDao;

    @Override
    public List<ManageJcookOrderVo> list(ManageJcookOrderSearch manageJcookOrderSearch) {
        QueryWrapper<JcookOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(manageJcookOrderSearch.getCode()),"code",manageJcookOrderSearch.getCode());
        queryWrapper.like(StringUtils.isNotBlank(manageJcookOrderSearch.getJcookCode()),"jcook_code",manageJcookOrderSearch.getJcookCode());
        queryWrapper.eq(manageJcookOrderSearch.getTradeStatus() != null,"trade_no",manageJcookOrderSearch.getTradeStatus());

        List<JcookOrder> jcookOrderList = jcookOrderMapper.selectList(queryWrapper);
        ArrayList<ManageJcookOrderVo> manageJcookOrderVoList = new ArrayList<>();
        if (jcookOrderList != null && jcookOrderList.size()>0){
            for (JcookOrder jcookOrder : jcookOrderList) {
                ManageJcookOrderVo manageJcookOrderVo = new ManageJcookOrderVo();
                PropertyUtils.copyProperties(jcookOrder,manageJcookOrderVo);
                UserResident byId = userResidentDao.findById(jcookOrder.getCreateId());
                manageJcookOrderVo.setCreateName(byId.getName());//填入创建人
                manageJcookOrderVoList.add(manageJcookOrderVo);
            }
        }

        return manageJcookOrderVoList;
    }
}
