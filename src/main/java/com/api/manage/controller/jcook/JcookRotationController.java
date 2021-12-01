package com.api.manage.controller.jcook;

import com.api.manage.service.jcook.JcookRotationService;
import com.api.model.jcook.manageDto.ManageJcookRotationUpdateDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 京库克商城（后台端）轮播图管理
 */
@RestController
@RequestMapping("manage/jcookRotation")
public class JcookRotationController {
    @Resource
    JcookRotationService jcookRotationService;

    /**
     * 添加初始轮播图
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(){
        return jcookRotationService.insert();
    }

    /**
     * 修改轮播图
     * @param manageJcookRotationUpdateDTO 修改轮播图DTO
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody ManageJcookRotationUpdateDTO manageJcookRotationUpdateDTO){
        return jcookRotationService.update(manageJcookRotationUpdateDTO);
    }

    /**
     * 删除轮播图
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(Integer rotationId){
        return jcookRotationService.delete(rotationId);
    }
}
