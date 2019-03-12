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

    /**
     * 获得用户画像的数据，包括教育情况、男女生比例、Top10职业分布、以及年龄段分布。
     *
     * @return
     */
    @RequestMapping(value = "/api/userpic/getalldata", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getAlldata() {
        HashMap<Object, Object> finalMap = new HashMap<>();

        //获得男女数量
        List<Map<String, String>> manAndWomanNum = userPicService.getManAndWomanNum();
        finalMap.put("peoplenum", manAndWomanNum);

        //获得用户年龄分布数据
        List<String> age = userPicService.getAge();
        finalMap.put("age", age);

        //获得用户教育分布情况
        List<Map<String, String>> education = userPicService.getEducation();
        finalMap.put("education", education);

        //获得用户职业分布情况
        List<Map<String, String>> employee = userPicService.getEmployee();
        finalMap.put("employee", employee);

        return JSON.toJSONString(finalMap);
    }


}
