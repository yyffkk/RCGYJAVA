package com.api.app.controller.share_h5;

import com.api.app.service.butler.AppVisitorInviteService;
import com.api.manage.service.system.UploadService;
import com.api.model.app.AppUserVisitorsInvite;
import com.api.model.app.AppUserVisitorsInviteSubmit;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

/**
 * app访客邀请h5分享接口
 */
@RestController
@RequestMapping("app/share/decorationApplication")
public class ShareVisitorInviteController {
    @Resource
    AppVisitorInviteService appVisitorInviteService;
    @Resource
    UploadService uploadService;

    /**
     * 根据分享连接编号查询访客信息（H5页面接口）
     * @param code 分享连接编号
     * @return map
     */
    @GetMapping("/findByUrlCode")
    public Map<String,Object> findByUrlCode(String code){
        return appVisitorInviteService.findByUrlCode(code);
    }

    /**
     * 上传访客邀请自拍照(H5页面)
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadH5Visit")
    public Map<String,Object> uploadH5Visit(MultipartFile file){
        return uploadService.uploadH5Visit(file);
    }

    /**
     * 提交访客信息(H5页面)
     * @param visitorsInviteSubmit 访客邀请提交信息(H5提交model)
     * @return map
     */
    @PostMapping("/submit")
    public Map<String,Object> submit(@RequestBody AppUserVisitorsInviteSubmit visitorsInviteSubmit){
        return appVisitorInviteService.submit(visitorsInviteSubmit);
    }
}
