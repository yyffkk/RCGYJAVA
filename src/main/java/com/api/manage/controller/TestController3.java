package com.api.manage.controller;

import com.api.model.test.River;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@Slf4j
@RequestMapping("manage/test3")
public class TestController3 {

    //陕西水文信息网址
    private static String url = "http://www.shxsw.com.cn";
    //获取数据的地址
    private static String hedaoAction = "iframe/hdsqxx_list.aspx";

    @GetMapping("/test3")
    public Boolean test2(HttpServletRequest request) throws IOException {
        List hedaoList= getRiverInfoList(url+"/" + hedaoAction);
        System.out.println(hedaoList.size());
        if (hedaoList!=null&&hedaoList.size()>0) {
            System.out.println(hedaoList);
        }
        log.info("这个测试log日志");
        return false;
    }

    /**
     * 河道水情信息获取
     * @param dataUrl
     * @return
     */
    public static List getRiverInfoList (String dataUrl) {
        Long startDate=System.currentTimeMillis();
        Document doc = null;
        List<River> riversList=new ArrayList<>();
        Map<String, String> zhanmingAndShiDateMap=new LinkedHashMap();
        String VIEWSTATE="/wEPDwUKMTU1NzczODAwMA9kFgICAw9kFgQCAQ8WAh4LXyFJdGVtQ291bnQCDxYeZg9kFgJmDxUIIOa4reaysyAgICAgICAgICAgICAgICAgICAgICAgICAgIemtj+WutuWgoSAgICAgICAgICAgICAgICAgICAgICAgIAsyMuaXpSAxOOaXtgY0OTQuNjYDMzM5A+iQvQgyNTAwLjAwMAg1MDAwLjAwMGQCAQ9kFgJmDxUIIOaxieaxnyAgICAgICAgICAgICAgICAgICAgICAgICAgIOeZveaysyAgICAgICAgICAgICAgICAgICAgICAgICAgCzIy5pelIDE45pe2BjE3Mi43OAM2NTID5raoCTEzMDAwLjAwMAkyMjUwMC4wMDBkAgIPZBYCZg8VCCHljJfmtJvmsrMgICAgICAgICAgICAgICAgICAgICAgICAg54q2IOWktCAgICAgICAgICAgICAgICAgICAgICAgICALMjLml6UgMTjml7YGMzYyLjU2AzEwNwPmtqgIMjUwMC4wMDAIMzMwMC4wMDBkAgMPZBYCZg8VCCDkuLnmsZ8gICAgICAgICAgICAgICAgICAgICAgICAgICHov4fpo47mpbwgICAgICAgICAgICAgICAgICAgICAgICALMjLml6UgMTjml7YFOTMuMzUEMTYuMQPlubMAAGQCBA9kFgJmDxUIIOaxieaxnyAgICAgICAgICAgICAgICAgICAgICAgICAgIOefs+aziSAgICAgICAgICAgICAgICAgICAgICAgICAgCzIy5pelIDE45pe2BjM2MS41NQAD5raoCTEyMDAwLjAwMAkxNTAwMC4wMDBkAgUPZBYCZg8VCCDkuLnmsZ8gICAgICAgICAgICAgICAgICAgICAgICAgICDkuLnlh6QgICAgICAgICAgICAgICAgICAgICAgICAgIAsyMuaXpSAxOOaXtgY1NDYuOTcEMTYuMgPokL0HODAwLjAwMAgxNTAwLjAwMGQCBg9kFgJmDxUIIOa4reaysyAgICAgICAgICAgICAgICAgICAgICAgICAgIOS4tOa9vCAgICAgICAgICAgICAgICAgICAgICAgICAgCzIy5pelIDE45pe2BTM1Mi43AzM2OAPmtqgIMzAwMC4wMDAIODAwMC4wMDBkAgcPZBYCZg8VCCDms77msrMgICAgICAgICAgICAgICAgICAgICAgICAgICHlvKDlrrblsbEgICAgICAgICAgICAgICAgICAgICAgICALMjLml6UgMTfml7YGNDIzLjQ4AzYyMwPokL0IMzAwMC4wMDAINjAwMC4wMDBkAggPZBYCZg8VCCDms77msrMgICAgICAgICAgICAgICAgICAgICAgICAgICHlvKDlrrblsbEgICAgICAgICAgICAgICAgICAgICAgICALMjLml6UgMTfml7YFNDIzLjUDNjEwA+W5swgzMDAwLjAwMAg2MDAwLjAwMGQCCQ9kFgJmDxUIIOa4reaysyAgICAgICAgICAgICAgICAgICAgICAgICAgIOWSuOmYsyAgICAgICAgICAgICAgICAgICAgICAgICAgCzIy5pelIDE35pe2BjM4Mi4xMgMyNDgD5raoCDMwMDAuMDAwCDUwMDAuMDAwZAIKD2QWAmYPFQgh5YyX5rSb5rKzICAgICAgICAgICAgICAgICAgICAgICAgIOeKtiDlpLQgICAgICAgICAgICAgICAgICAgICAgICAgCzIy5pelIDE35pe2BjM2Mi41MQMxMDED5raoCDI1MDAuMDAwCDMzMDAuMDAwZAILD2QWAmYPFQgg5Li55rGfICAgICAgICAgICAgICAgICAgICAgICAgICAh6L+H6aOO5qW8ICAgICAgICAgICAgICAgICAgICAgICAgCzIy5pelIDE35pe2BTkzLjM1BDE2LjED5raoAABkAgwPZBYCZg8VCCDkuLnmsZ8gICAgICAgICAgICAgICAgICAgICAgICAgICDkuLnlh6QgICAgICAgICAgICAgICAgICAgICAgICAgIAsyMuaXpSAxN+aXtgY1NDYuOTgEMTcuMQPokL0HODAwLjAwMAgxNTAwLjAwMGQCDQ9kFgJmDxUIIOaxieaxnyAgICAgICAgICAgICAgICAgICAgICAgICAgIOefs+aziSAgICAgICAgICAgICAgICAgICAgICAgICAgCzIy5pelIDE35pe2BTM2MS40AAPlubMJMTIwMDAuMDAwCTE1MDAwLjAwMGQCDg9kFgJmDxUIIOaxieaxnyAgICAgICAgICAgICAgICAgICAgICAgICAgIOeZveaysyAgICAgICAgICAgICAgICAgICAgICAgICAgCzIy5pelIDE35pe2BjE3Mi43NgM2NDID5raoCTEzMDAwLjAwMAkyMjUwMC4wMDBkAgMPDxYEHhBDdXJyZW50UGFnZUluZGV4Ag4eC1JlY29yZGNvdW50AtYCZGRk";
        int num=1;
        Date now=new Date();
        while(num<=30){
            try {
                Connection con = Jsoup.connect(dataUrl).userAgent("Mozilla/5.0").timeout(3000);
                con.data("__EVENTTARGET","pager");
                con.data("__EVENTARGUMENT", num+"");
                con.data("__VIEWSTATE",VIEWSTATE);
                doc=con.post();
            } catch (IOException e) {
                e.printStackTrace();
            }
            VIEWSTATE=doc.getElementById("__VIEWSTATE").val();
            Elements elements = doc.getElementsByTag("tr");
            SimpleDateFormat fro1=new SimpleDateFormat("dd日 HH时");
            for (int j=1; j<elements.size();j++) {
                River river=new River();
                String rivers[]=elements.get(j).toString().replace("<tr>", "").replace("</tr>", "").replace("<td>", "").replace("<td bgcolor=\"#D8EDFF\">", "").split("</td>");
                String riverName=rivers[0].trim();
                String zhanName=rivers[1].trim();
                String date=rivers[2].trim();
                String shuiWei=rivers[3].trim();
                String liuliang=rivers[4].trim();
                String shuishi=rivers[5].trim();
                String jingjieliangliang=rivers[6].trim();
                String baozhengliuliang=rivers[7].trim();
                //封装数据
                river.setRiverName(riverName);
                river.setZhanName(zhanName);
                //"--"标识无效数据
                river.setWaterLevel(StringUtil.isBlank(shuiWei)?"--":shuiWei);
                river.setTraffic(StringUtil.isBlank(liuliang)?"--":liuliang);
                river.setAlertTraffic((StringUtil.isBlank(jingjieliangliang)?"--":jingjieliangliang));
                river.setEnsureTraffic((StringUtil.isBlank(baozhengliuliang)?"--":baozhengliuliang));
                river.setShuiShi(shuishi);
                try {
                    river.setDate(fro1.parse(date));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //对今日重复数据进行过滤
                if (!date.equals(zhanmingAndShiDateMap.get(date+zhanName))) {
                    riversList.add(river);
                    zhanmingAndShiDateMap.put(date+zhanName, date);
                }
            }
            num++;
        }
        Long endDate=System.currentTimeMillis();
        log.info(new SimpleDateFormat("yyyy月MM月dd日 HH时mm分").format(now)+"共爬取爬取"+riversList.size()+"河道水情信息,共耗时"+(endDate-startDate)/1000+"秒");
        return riversList;
    }
}
