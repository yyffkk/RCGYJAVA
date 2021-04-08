package com.api.manage.controller;

import com.api.manage.shiro.ShiroExceptions;
import com.api.util.Base64Util;
import com.api.util.EmojiUtils;
import com.api.util.IdWorker;
import okhttp3.*;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

@RestController
@RequestMapping("manage/test")
public class TestController extends ShiroExceptions {
//    @RequiresPermissions(value = {"0201"})
    @GetMapping("/test")
    public Long test() throws Exception {
//        String s = "哈哈😄大师答";
////        String s1 = Base64Util.encodeData(s);
////        String s2 = Base64Util.decodeData(s1);
////        System.out.println(s1);
////        System.out.println(s2);
//        String content = EmojiUtils.filterEmoji(s, "*");
//        System.out.println(content);
//        IdWorker idWorker = new IdWorker(1, 1, 1);


        String imgUrl = "/img/22.png";
        //传入真实路径（没有文件服务器的情况，用项目目录下的static）
        // 获取项目同级目录，传入static中
        String realPath = new File(ResourceUtils.getURL("classpath:").getPath()).getParentFile().getParentFile().getParent()+"/static";
        File file = new File(realPath+imgUrl);
        InputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);

        String result = "";
        try {
            OkHttpClient httpClient = new OkHttpClient();
            MultipartBody multipartBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("jpeg", multipartFile.getOriginalFilename(),
                            RequestBody.create(MediaType.parse("multipart/form-data;charset=utf-8"),
                                    multipartFile.getBytes()))
                    .addFormDataPart("code","单元码")
                            .addFormDataPart("ts", String.valueOf(new Date()))
                            .addFormDataPart("te", String.valueOf(new Date()))
                    .build();

            Request request = new Request.Builder()
                    .url("http://192.168.31.130:9001/manage/test2/test2")
                    .post(multipartBody)
                    .build();

            Response response = httpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                if (body != null) {
                    result = body.string();
                    if ("false".equals(result)){
                        System.out.println("发送失败");
                    }
                    System.out.println(result);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }
}
