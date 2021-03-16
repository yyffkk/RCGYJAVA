package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerBacklogService;
import com.api.vo.butlerApp.ButlerArticleOutVo;
import com.api.vo.butlerApp.ButlerBacklogVo;
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
 * 管家app 待办事项
 */
@RestController
@RequestMapping("/butlerApp/user/backlog")
public class ButlerBacklogController {
    @Resource
    ButlerBacklogService butlerBacklogService;

    /**
     * 查询所有的待办事务
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param roleId 当前用户所拥有的角色id
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,String roleId,int id){
        PageHelper.startPage(pageNum,size);
        List<ButlerBacklogVo> butlerBacklogVos =butlerBacklogService.list(roleId,id);
        PageInfo<ButlerBacklogVo> pageInfo = new PageInfo<>(butlerBacklogVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
