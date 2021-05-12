package com.api.app.controller.butler;

import com.api.app.service.butler.AppPackageCollectionService;
import com.api.model.app.SearchAppPackageCollection;
import com.api.vo.app.AppConfirmCollection;
import com.api.vo.app.AppNewsVo;
import com.api.vo.operationManagement.VoPackageCollection;
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
 * app 包裹代收
 */
@RestController
@RequestMapping("app/user/packageCollection")
public class AppPackageCollection {
    @Resource
    AppPackageCollectionService appPackageCollectionService;


    /**
     * 查询所有的快递包裹（包含条件搜索）
     * @param searchAppPackageCollection 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchAppPackageCollection searchAppPackageCollection){
        PageHelper.startPage(searchAppPackageCollection.getPageNum(),searchAppPackageCollection.getSize());
        List<VoPackageCollection> voPackageCollectionList = appPackageCollectionService.list(searchAppPackageCollection);
        PageInfo<VoPackageCollection> pageInfo = new PageInfo<>(voPackageCollectionList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 确认领取
     * @param appConfirmCollection app 包裹代收确认领取 条件
     * @return map
     */
    @GetMapping("/confirmCollection")
    public Map<String,Object> confirmCollection(AppConfirmCollection appConfirmCollection){
        return appPackageCollectionService.confirmCollection(appConfirmCollection);
    }


}
