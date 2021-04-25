package com.api.manage.controller;

import com.api.manage.shiro.ShiroExceptions;
import com.api.util.Base64Util;
import com.api.util.EmojiUtils;
import com.api.util.IdWorker;
import com.api.util.LiLinSignGetHmac;
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
    public String test() throws Exception {

        String signature ="{\"clientId\":\"70d274b536f930b70314c2d01243ddd3\",\"method\":\"addFaceRecognize\",\"timestamp\":\"1619170441585\",\"nonce\":\"9838a707-156b-429a-b9e1-355f5a20f324\",\"data\":{\"neighNo\":\"450127500001\",\"deviceSn\":\"45012750000102010501\",\"phoneNumber\":15068133808,\"startTime\":1619280000000,\"endTime\":1619366399000,\"photoUrl\":\"http://test.akuhotel.com:8804/static/img/h5/visit/641043db8d9944cb975eeeddcc8089ab.jpeg\",\"floorType\":2}}";

        String s = LiLinSignGetHmac.genHMAC(signature, "18d4873936e0e42ac3510402dee8611c");
//        String imgUrl = "/img/22.png";
//        //传入真实路径（没有文件服务器的情况，用项目目录下的static）
//        // 获取项目同级目录，传入static中
//        String realPath = new File(ResourceUtils.getURL("classpath:").getPath()).getParentFile().getParentFile().getParent()+"/static";
//        File file = new File(realPath+imgUrl);
//        InputStream inputStream = new FileInputStream(file);
//        MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);
//
//        String result = "";
//        try {
//            OkHttpClient httpClient = new OkHttpClient();
//            MultipartBody multipartBody = new MultipartBody.Builder()
//                    .setType(MultipartBody.FORM)
//                    .addFormDataPart("jpeg", multipartFile.getOriginalFilename(),
//                            RequestBody.create(MediaType.parse("multipart/form-data;charset=utf-8"),
//                                    multipartFile.getBytes()))
//                    .addFormDataPart("code","单元码")
//                            .addFormDataPart("ts", String.valueOf(new Date()))
//                            .addFormDataPart("te", String.valueOf(new Date()))
//                    .build();
//
//            Request request = new Request.Builder()
//                    .url("http://192.168.31.130:9001/manage/test2/test2")
//                    .post(multipartBody)
//                    .build();
//
//            Response response = httpClient.newCall(request).execute();
//            if (response.isSuccessful()) {
//                ResponseBody body = response.body();
//                if (body != null) {
//                    result = body.string();
//                    if ("false".equals(result)){
//                        System.out.println("发送失败");
//                    }
//                    System.out.println(result);
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        return null;
        return s;
    }
}
