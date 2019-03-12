package ggq.controller;

import com.alibaba.fastjson.JSON;
import ggq.service.ReportUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ReportUserInfoController {
    @Autowired
    ReportUserInfoService reportUserInfoService;

    /**
     * 返回最近七天的用户留存数据
     * @return
     */
    @RequestMapping(value = "/api/report/remain", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getData() {
        Map<String, Object> remainUser = reportUserInfoService.getRemainUser();
        return JSON.toJSONString(remainUser);
    }

    /**
     * 返回最近七天的新用户和活跃用户的留存率数据
     * @return
     */
    @RequestMapping(value = "/api/report/newandactiveremain", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getData2() {
        Map<String, double[]> newAndActiveRemainUserRate = reportUserInfoService.getNewAndActiveRemainUserRate();
        return JSON.toJSONString(newAndActiveRemainUserRate);
    }

}
