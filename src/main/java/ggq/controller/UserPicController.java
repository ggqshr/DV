package ggq.controller;

import com.alibaba.fastjson.JSON;
import ggq.service.UserPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserPicController {
    @Autowired
    UserPicService userPicService;

    @RequestMapping("/api/userpic/manandwomannum")
    @ResponseBody
    public String getManAndWomanData() {
        List<Map<String, String>> manAndWomanNum = userPicService.getManAndWomanNum();
        return JSON.toJSONString(manAndWomanNum);
    }
    @RequestMapping("/api/userpic/education")
    @ResponseBody
    public String getEducation() {
        List<Map<String, String>> education = userPicService.getEducation();
        return JSON.toJSONString(education);
    }

}
