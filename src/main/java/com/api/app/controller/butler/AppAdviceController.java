package com.api.app.controller.butler;

import com.api.app.service.butler.AppAdviceService;
import com.api.model.app.SearchAppAdvice;
import com.api.model.butlerService.SysAdvice;
import com.api.vo.app.AppAdviceVo;
import com.api.vo.app.AppMyArticleBorrowVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("app/user/advice")
public class AppAdviceController {
    @Resource
    AppAdviceService appAdviceService;

    /**
     * 查询所有的app建议咨询信息（包含条件搜索 type）
     * @param searchAppAdvice 建议咨询/投诉表扬 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchAppAdvice searchAppAdvice){
        PageHelper.startPage(searchAppAdvice.getPageNum(),searchAppAdvice.getSize());
        List<AppAdviceVo> appAdviceVos =appAdviceService.list(searchAppAdvice);
        PageInfo<AppAdviceVo> pageInfo = new PageInfo<>(appAdviceVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加建议咨询信息
     * @param sysAdvice 咨询建议表信息
     * @return
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysAdvice sysAdvice){
        return appAdviceService.insert(sysAdvice);
    }

}
