package ggq.controller;

import com.alibaba.fastjson.JSON;
import ggq.model.Report_userinfo;
import ggq.model.websiteOverview;
import ggq.service.ReportUserInfoService;
import ggq.service.WebOverviewService;
import ggq.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class ChartDataController {
    @Autowired
    WebOverviewService webOverviewService;
    @Autowired
    DateUtils dateUtils;

    /**
     * 获得当前所有的PV、UV等数据
     *
     * @return
     */
    @RequestMapping("/api/totaldata")
    @ResponseBody
    public String getTotalUV() {
        websiteOverview total = webOverviewService.getTotal();
        return JSON.toJSONString(total);
    }

    /**
     * 获取最近三天的PV、UV等以及跳出率和平均访问时间详细数据
     *
     * @return
     */
    @RequestMapping("/api/detaildata")
    @ResponseBody
    public String getDetailData() {
        //默认表格中展示三天的数据，今天，昨天和前天
        //今天的数据，今天的数据只需要获取到当前小时数的数据
        List<HashMap<String, Object>> detailData = webOverviewService.getDetailData(
                dateUtils.getCurrentDate(null),
                "0",
                Integer.parseInt(dateUtils.getCurrentDate(DateUtils.onlyHourFormat)));
        //昨天的数据
        detailData.addAll(webOverviewService.getDetailData(
                dateUtils.getDateSubResult(-1),
                "1",
                24));
        //前天的数据
        detailData.addAll(webOverviewService.getDetailData(
                dateUtils.getDateSubResult(-2),
                "2",
                24));
        return JSON.toJSONString(detailData);
    }

    /**
     * 获取今天，昨天，七天前，30天前的UV、PV等数据
     *
     * @return
     */
    @RequestMapping("/api/dataperhour")
    @ResponseBody
    public String getDatePerOur() {
        HashMap<String, HashMap<String, Object>> map = new HashMap<>();
        //查询今天的数据
        map.put("today", webOverviewService.getPvUvEtcByDataType("0"));
        //查询昨天的数据
        map.put("yestoday", webOverviewService.getPvUvEtcByDataType("1"));
        //查询七天前的数据
        map.put("beforseven", webOverviewService.getPvUvEtcByDataType("7"));
        //查询30天前的数据
        map.put("beformonth", webOverviewService.getPvUvEtcByDataType("30"));
        return JSON.toJSONString(map);
    }


}
