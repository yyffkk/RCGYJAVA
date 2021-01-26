package com.api.app.controller.butler;

import com.api.app.service.butler.AppQuestionnaireService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * app问卷调查
 */
@RestController
@RequestMapping("app/user/questionnaire")
public class AppQuestionnaireController {
    @Resource
    AppQuestionnaireService appQuestionnaireService;


    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,Integer id,Integer type){
        return null;
    }
}
