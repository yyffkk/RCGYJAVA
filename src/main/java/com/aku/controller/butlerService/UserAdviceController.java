package com.aku.controller.butlerService;

import com.aku.model.butlerService.SearchUserAdvice;
import com.aku.service.butlerService.UserAdviceService;
import com.aku.vo.butlerService.VoUserAdvice;
import com.aku.vo.butlerService.VoUserDecorationTrackRecord;
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
 * 咨询建议表
 */
@RequestMapping("/advice")
@RestController
public class UserAdviceController {
    @Resource
    UserAdviceService userAdviceService;

    /**
     * 查询所有的咨询建议 （包含条件搜索）
     * @param searchUserAdvice 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchUserAdvice searchUserAdvice){
        PageHelper.startPage(searchUserAdvice.getPageNum(),searchUserAdvice.getSize());
        List<VoUserAdvice> voUserAdvices = userAdviceService.list(searchUserAdvice);
        PageInfo<VoUserAdvice> pageInfo = new PageInfo<>(voUserAdvices);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

//    public Map<String,Object>
}
