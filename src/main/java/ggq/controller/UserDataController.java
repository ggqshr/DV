package ggq.controller;

import com.alibaba.fastjson.JSON;
import ggq.service.ReportUserInfoService;
import ggq.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserDataController {

    @Autowired
    ReportUserInfoService service;

    @Autowired
    DateUtils dateUtils;

    @RequestMapping("/api/userdata")
    @ResponseBody
    public String getIntroduceRowData(){
        Map<String, Object> userInfo = service.getUserInfo(dateUtils.getDateSubResult(-1));
        return JSON.toJSONString(userInfo);
    }

}
