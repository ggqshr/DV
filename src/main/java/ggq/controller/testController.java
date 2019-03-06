package ggq.controller;

import com.alibaba.fastjson.JSON;
import ggq.model.Report_userinfo;
import ggq.model.websiteOverview;
import ggq.service.ReportUserInfo;
import ggq.service.WebOverviewService;
import ggq.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class testController {
    @Autowired
    ReportUserInfo reportUserInfo;
    @Autowired
    WebOverviewService webOverviewService;
    @Autowired
    DateUtils dateUtils;

    @RequestMapping("/api/fake_chart_data")
    @ResponseBody
    public String test() {
        return "/html/test";
    }

    @RequestMapping("/api/reportUserInfo")
    @ResponseBody
    public String ReportInfo() {
        Report_userinfo user = reportUserInfo.getUser();
        return JSON.toJSONString(user);
    }

    @RequestMapping("/api/totaldata")
    @ResponseBody
    public String getTotalUV() {
        websiteOverview total = webOverviewService.getTotal();
        return JSON.toJSONString(total);
    }

    @RequestMapping("/api/detaildata")
    @ResponseBody
    public String getDetailData() {
        //默认表格中展示三天的数据，今天，昨天和前天
        List<HashMap<String, Object>> detailData = webOverviewService.getDetailData(
                dateUtils.getCurrentDate(null),
                "0",
                Integer.parseInt(dateUtils.getCurrentDate(DateUtils.onlyHourFormat)));
        detailData.addAll(webOverviewService.getDetailData(
                dateUtils.getDateSubResult(-1),
                "1",
                24));
        detailData.addAll(webOverviewService.getDetailData(
                dateUtils.getDateSubResult(-2),
                "2",
                24));
        return JSON.toJSONString(detailData);
    }

    @RequestMapping("/api/dataperhour")
    @ResponseBody
    public String getDatePerOur(){
        HashMap<String,HashMap<String, int[]>> map = new HashMap<>();
        map.put("today",webOverviewService.getPvUvEtcByDataType("0"));
        map.put("yestoday",webOverviewService.getPvUvEtcByDataType("1"));
        map.put("beforseven",webOverviewService.getPvUvEtcByDataType("7"));
        map.put("beformonth",webOverviewService.getPvUvEtcByDataType("30"));
        return JSON.toJSONString(map);
    }

}
