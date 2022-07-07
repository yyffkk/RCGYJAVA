package com.api.manage.controller;

import com.api.util.webSocket.WebSocketService;
//import net.sf.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@Slf4j
@RequestMapping("manage/test2")
public class TestController2 {
    @GetMapping("/test2")
    public Boolean test2(HttpServletRequest request) throws IOException {
//        WebSocketService ws = new WebSocketService();
//        JSONObject jo = new JSONObject();
//        jo.put("message", "这是后台返回的消息！");
//        jo.put("To","All");
//        ws.onMessage(jo.toString());
//        ws.broadcast("这是后台返回的消息");

//        //爬取医药网列表页面
//        Document doc = Jsoup.connect("https://www.chsi.com.cn/jyzx").get();
//        Element body = doc.body();
//        System.out.println(body);
//        Elements select = body.select(".content-l .news-list .news-title a");
//        //创建map存储器
//        HashMap<String, Object> map = new HashMap<>();
//        for (Element element : select) {
//            String href = element.attr("href");
//            String text = element.text();
//            //存进map中
//            map.put(text,href);
//        }
//
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            String mapKey = entry.getKey();
//            Object mapValue = entry.getValue();
//            System.out.println(mapKey+":"+mapValue);
//            //爬取医药网详情页
//            Document doc2 = Jsoup.connect("https://www.chsi.com.cn"+mapValue).get();
//            Element body2 = doc2.body();
//            Elements select2 = body2.select(".content-l");
//            String text = select2.text();
//            System.out.println(text);
//            map.put(mapKey,text);
//        }
//        System.out.println(map);

//        log.trace("日志输出 trace");
//        log.debug("日志输出 debug");
//        log.info("日志输出 info");
//        log.warn("日志输出 warn");
//        log.error("日志输出 error");

        Date date=new Date();
        //SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
        String year=String.format("%tY",date);
        String month=String.format("%tB",date);
        int day= Integer.parseInt(String.format("%td",date));
        System.out.println("今年是"+year+"年");
        System.out.println("现在是"+month+"月");
        System.out.println("今天是"+day+"号");
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("2008-02-14");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        cal.set(Calendar.DAY_OF_MONTH, 1);

        cal.add(Calendar.MONTH, 1);

        cal.add(Calendar.DATE, -1);
        Date time = cal.getTime();
        String format = new SimpleDateFormat("yyyy-MM-dd").format(time);

        return false;
    }
}
