package ggq.controller;

import com.alibaba.fastjson.JSON;
import ggq.service.UserPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserPicController {
    @Autowired
    UserPicService userPicService;

    @RequestMapping(value="/api/userpic/getalldata" ,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getAlldata(){
        HashMap<Object, Object> finalMap = new HashMap<>();
        List<Map<String, String>> manAndWomanNum = userPicService.getManAndWomanNum();
        finalMap.put("peoplenum",manAndWomanNum);
        List<String> age = userPicService.getAge();
        finalMap.put("age",age);
        List<Map<String, String>> education = userPicService.getEducation();
        finalMap.put("education",education);
        List<Map<String, String>> employee = userPicService.getEmployee();
        finalMap.put("employee",employee);
        return JSON.toJSONString(finalMap);
    }

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
