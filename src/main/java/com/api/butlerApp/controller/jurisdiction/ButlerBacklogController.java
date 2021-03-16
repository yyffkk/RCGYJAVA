package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerBacklogService;
import com.api.vo.butlerApp.ButlerBacklogVo;
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
     * @param roleId 当前用户所拥有的角色id
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(String roleId,int id){
        Map<String,Object> map = new HashMap<>();
        List<ButlerBacklogVo> butlerBacklogVos =butlerBacklogService.list(roleId,id);
        map.put("data",butlerBacklogVos);
        return map;
    }

    /**
     * 查询处理事项的数量
     * @param roleId 当前用户所拥有的角色id
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/findItemNum")
    public Map<String,Object> findItemNum(String roleId,int id){
        return butlerBacklogService.findItemNum(roleId,id);
    }
}
