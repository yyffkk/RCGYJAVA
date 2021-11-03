package com.api.app.controller.butler;

import com.api.app.service.butler.AppHouseTypeDescriptionService;
import com.api.model.app.AppHouseTypeDescription;
import com.api.vo.app.AppHouseTypeDescriptionVo;
import com.api.vo.operationManagement.SysHouseTypeDescriptionListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * app 户型说明
 */
@RestController
@RequestMapping("app/user/houseTypeDescription")
public class AppHouseTypeDescriptionController {
    @Resource
    AppHouseTypeDescriptionService appHouseTypeDescriptionService;

    /**
     * 查询所有的已发布的户型说明
     * @param appHouseTypeDescription app户型说明 搜索条件
     * @return 户型说明
     */
    @GetMapping("/list")
    public Map<String,Object> list(AppHouseTypeDescription appHouseTypeDescription){
        PageHelper.startPage(appHouseTypeDescription.getPageNum(),appHouseTypeDescription.getSize());
        List<AppHouseTypeDescriptionVo> appHouseTypeDescriptionVoList = appHouseTypeDescriptionService.list();
        PageInfo<AppHouseTypeDescriptionVo> pageInfo = new PageInfo<>(appHouseTypeDescriptionVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

}
