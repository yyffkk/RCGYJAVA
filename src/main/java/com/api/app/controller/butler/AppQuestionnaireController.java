package com.api.app.controller.butler;

import com.api.app.service.butler.AppQuestionnaireService;
import com.api.vo.app.AppQuestionnaireVo;
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
 * app问卷调查
 */
@RestController
@RequestMapping("app/user/questionnaire")
public class AppQuestionnaireController {
    @Resource
    AppQuestionnaireService appQuestionnaireService;


    /**
     * app查询所有的问卷调查list
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户主键id
     * @param type 用户类型
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,Integer id,Integer type){
        PageHelper.startPage(pageNum,size);
        List<AppQuestionnaireVo> appQuestionnaireVos =appQuestionnaireService.list(id,type);
        PageInfo<AppQuestionnaireVo> pageInfo = new PageInfo<>(appQuestionnaireVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


}
