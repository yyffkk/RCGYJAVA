package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerKeyService;
import com.api.model.butlerApp.ButlerKeyBorrow;
import com.api.model.butlerApp.ButlerKeySearch;
import com.api.model.butlerApp.ButlerRecordSearch;
import com.api.util.IdWorker;
import com.api.vo.butlerApp.ButlerInspectionVo;
import com.api.vo.butlerApp.ButlerKeyVo;
import com.api.vo.butlerApp.ButlerRecordVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管家app钥匙管理
 */
@RestController
@RequestMapping("butlerApp/user/key")
public class ButlerKeyController {
    @Resource
    ButlerKeyService butlerKeyService;

    /**
     * 查询所有的钥匙信息
     * @param butlerKeySearch 管家app 钥匙搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerKeySearch butlerKeySearch){
        PageHelper.startPage(butlerKeySearch.getPageNum(),butlerKeySearch.getSize());
        List<ButlerKeyVo> butlerKeyVoList = butlerKeyService.list(butlerKeySearch);
        PageInfo<ButlerKeyVo> pageInfo = new PageInfo<>(butlerKeyVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询所有的未归还钥匙信息
     * @param butlerKeySearch 管家app 钥匙搜索条件
     * @return map
     */
    @GetMapping("/noReturnList")
    public Map<String,Object> noReturnList(ButlerKeySearch butlerKeySearch){
        PageHelper.startPage(butlerKeySearch.getPageNum(),butlerKeySearch.getSize());
        List<ButlerKeyVo> butlerKeyVoList = butlerKeyService.noReturnList(butlerKeySearch);
        PageInfo<ButlerKeyVo> pageInfo = new PageInfo<>(butlerKeyVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 申请钥匙
     * @param butlerKeyBorrow 管家app 钥匙借取model信息
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/apply")
    public Map<String,Object> apply(@RequestBody ButlerKeyBorrow butlerKeyBorrow, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        return butlerKeyService.apply(butlerKeyBorrow,id);
    }

    /**
     * 申请归还钥匙
     * @param keyId 钥匙主键id
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/returnKey")
    public Map<String,Object> returnKey(Integer keyId,Integer id){
        return butlerKeyService.returnKey(keyId,id);
    }


    /**
     * 查询所有的申请记录（包含条件搜索）
     * @param butlerRecordSearch 管家app 申请记录搜索条件
     * @return map
     */
    @GetMapping("/record")
    public Map<String,Object> record(ButlerRecordSearch butlerRecordSearch){
        PageHelper.startPage(butlerRecordSearch.getPageNum(),butlerRecordSearch.getSize());
        List<ButlerRecordVo> butlerRecordVoList = butlerKeyService.record(butlerRecordSearch);
        PageInfo<ButlerRecordVo> pageInfo = new PageInfo<>(butlerRecordVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

}
