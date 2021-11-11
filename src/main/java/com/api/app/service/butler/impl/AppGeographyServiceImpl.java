package com.api.app.service.butler.impl;

import com.api.app.service.butler.AppGeographyService;
import com.api.mapper.manage.SysGeographyMapper;
import com.api.model.entity.SysGeographyDo;
import com.api.util.PropertyUtils;
import com.api.util.UploadUtil;
import com.api.vo.app.AppGeographyVo;
import com.api.vo.resources.VoResourcesImg;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppGeographyServiceImpl implements AppGeographyService {
    private static Map<String,Object> map = null;
    @Resource
    SysGeographyMapper sysGeographyMapper;
    @Override
    public Map<String, Object> findGeographyInfo() {
        map = new HashMap<>();
        QueryWrapper<SysGeographyDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",1);//1.启用

        SysGeographyDo sysGeographyDo = sysGeographyMapper.selectOne(queryWrapper);
        AppGeographyVo appGeographyVo = new AppGeographyVo();
        PropertyUtils.copyProperties(sysGeographyDo,appGeographyVo);

        UploadUtil uploadUtil = new UploadUtil();
        List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysGeography", sysGeographyDo.getId(), "geographyImg");
        appGeographyVo.setImgList(imgByDate);

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",appGeographyVo);
        return map;
    }
}
