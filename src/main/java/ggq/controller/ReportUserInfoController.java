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

        @RequestMapping(value = "/api/report/remain", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getData() {
        Map<String, Object> remainUser = reportUserInfoService.getRemainUser();
        return JSON.toJSONString(remainUser);
    }
}
