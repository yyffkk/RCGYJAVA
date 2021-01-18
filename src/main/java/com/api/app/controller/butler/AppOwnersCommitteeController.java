package com.api.app.controller.butler;

import com.api.app.service.butler.AppOwnersCommitteeService;
import com.api.vo.app.AppConvenientTelephoneVo;
import com.api.vo.butlerService.VoOwnersCommittee;
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
 * 业委会管理
 */
@RestController
@RequestMapping("app/ownersCommittee")
public class AppOwnersCommitteeController {
    @Resource
    AppOwnersCommitteeService appOwnersCommitteeService;

    /**
     * 查询业委会所有人员信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/findAll")
    public Map<String,Object> findAll(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<VoOwnersCommittee> voOwnersCommitteeList =appOwnersCommitteeService.findAll();
        PageInfo<VoOwnersCommittee> pageInfo = new PageInfo<>(voOwnersCommitteeList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
