package com.api.manage.controller.butlerService;

import com.api.model.butlerService.SearchUserAdvice;
import com.api.model.butlerService.SysAdvice;
import com.api.model.butlerService.SysAdviceDetail;
import com.api.manage.service.butlerService.ComplaintPraiseService;
import com.api.manage.service.butlerService.UserAdviceService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoUserAdvice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 投诉表扬表(与咨询建议使用同一个表)
 */
@RestController
@RequestMapping("complaintPraise")
public class ComplaintPraiseController {
    @Resource
    ComplaintPraiseService complaintPraiseService;
    @Resource
    UserAdviceService userAdviceService;

    /**
     * 查询所有的投诉表扬信息（包含条件搜索）
     * @param searchUserAdvice 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchUserAdvice searchUserAdvice){
        PageHelper.startPage(searchUserAdvice.getPageNum(),searchUserAdvice.getSize());
        List<VoUserAdvice> voUserAdviceList = complaintPraiseService.list(searchUserAdvice);
        PageInfo<VoUserAdvice> pageInfo = new PageInfo<>(voUserAdviceList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 回复投诉表扬（添加反馈信息）[同咨询建议]【住户，装修公司，物业】【已替换违禁关键字】
     * @param sysAdviceDetail 投诉表扬表信息
     * @return map
     */
    @PostMapping("/insertDetail")
    public Map<String,Object> insertDetail(@RequestBody SysAdviceDetail sysAdviceDetail){
        return userAdviceService.insertDetail(sysAdviceDetail);
    }

    /**
     * 新增投诉表扬(未测)【已替换违禁关键字】
     * @param sysAdvice 投诉表扬表信息
     * @return map
     */
    @PostMapping("/insertAdvice")
    public Map<String,Object> insertAdvice(@RequestBody SysAdvice sysAdvice, HttpServletRequest request){
        return complaintPraiseService.insertAdvice(sysAdvice,request);
    }

    /**
     * 批量删除投诉表扬信息（真删除）
     * @param ids 投诉表扬主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return complaintPraiseService.delete(ids.getIds());
    }

    /**
     * 批量删除投诉表扬信息（假删除）
     * @param ids 投诉表扬主键id数组
     * @return map
     */
    @PostMapping("/falseDelete")
    public Map<String,Object> falseDelete(@RequestBody VoIds ids){
        return complaintPraiseService.falseDelete(ids.getIds());
    }

    /**
     * 根据投诉表扬主键id查询投诉表扬详情
     * @param id 投诉表扬主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return complaintPraiseService.findById(id);
    }

    /**
     * 查询今日投诉条数
     * @return map
     */
    @GetMapping("/countComplaintNew")
    public Map<String,Object> countComplaintNew(){
        return complaintPraiseService.countComplaintNew();
    }

    /**
     * 查询今日表扬条数
     * @return map
     */
    @GetMapping("/countPraiseNew")
    public Map<String,Object> countPraiseNew(){
        return complaintPraiseService.countPraiseNew();
    }


}
