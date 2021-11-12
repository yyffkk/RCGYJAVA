package com.api.app.service.butler.impl;

import com.api.app.service.butler.AppSurroundingEnterprisesService;
import com.api.mapper.manage.SysSurroundingEnterprisesMapper;
import com.api.model.entity.SysSurroundingEnterprisesDo;
import com.api.util.PropertyUtils;
import com.api.util.UploadUtil;
import com.api.vo.app.AppSurroundingEnterprisesVo;
import com.api.vo.resources.VoResourcesImg;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AppSurroundingEnterprisesServiceImpl implements AppSurroundingEnterprisesService {
    private static Map<String,Object> map = null;
    @Resource
    SysSurroundingEnterprisesMapper sysSurroundingEnterprisesMapper;


    @Override
    public List<AppSurroundingEnterprisesVo> list() {

        QueryWrapper<SysSurroundingEnterprisesDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("release_status",1);//1.发布
        List<SysSurroundingEnterprisesDo> selectList = sysSurroundingEnterprisesMapper.selectList(queryWrapper);
        ArrayList<AppSurroundingEnterprisesVo> appSurroundingEnterprisesVoList = new ArrayList<>();
        if (selectList != null && selectList.size()>0){
            for (SysSurroundingEnterprisesDo sysSurroundingEnterprisesDo : selectList) {
                AppSurroundingEnterprisesVo appSurroundingEnterprisesVo = new AppSurroundingEnterprisesVo();
                PropertyUtils.copyProperties(sysSurroundingEnterprisesDo,appSurroundingEnterprisesVo);
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysSurroundingEnterprises", sysSurroundingEnterprisesDo.getId(), "surroundingEnterprisesImg");
                appSurroundingEnterprisesVo.setImgList(imgByDate);
                appSurroundingEnterprisesVoList.add(appSurroundingEnterprisesVo);
            }
        }

        return appSurroundingEnterprisesVoList;
    }
}
