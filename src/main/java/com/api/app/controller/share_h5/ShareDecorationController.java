package com.api.app.controller.share_h5;

import com.api.app.service.butler.DecorationApplicationService;
import com.api.model.app.AppUserDecorationSubmit;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
/**
 * app装修h5分享接口
 */
@RestController
@RequestMapping("app/share/decorationApplication")
public class ShareDecorationController {
    @Resource
    DecorationApplicationService decorationApplicationService;
    /**
     * 添加装修人员信息(H5页面接口提交)
     * @param decorationSubmit 装修公司提交信息
     * @return map
     */
    @PostMapping("/insertDecorationPerson")
    public Map<String,Object> insertDecorationPerson(@RequestBody AppUserDecorationSubmit decorationSubmit){
        return decorationApplicationService.insertDecorationPerson(decorationSubmit);
    }
}
