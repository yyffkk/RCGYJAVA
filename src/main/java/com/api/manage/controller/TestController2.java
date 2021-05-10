package com.api.manage.controller;

import com.api.util.WebSocketService;
//import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("manage/test2")
public class TestController2 {
    @GetMapping("/test2")
    public Boolean test2(HttpServletRequest request) throws IOException {
        WebSocketService ws = new WebSocketService();
//        JSONObject jo = new JSONObject();
//        jo.put("message", "这是后台返回的消息！");
//        jo.put("To","All");
//        ws.onMessage(jo.toString());
        ws.broadcast("这是后台返回的消息");
        return false;
    }
}
