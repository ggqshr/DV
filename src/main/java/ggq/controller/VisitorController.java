package ggq.controller;

import com.alibaba.fastjson.JSON;
import ggq.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class VisitorController {
    @Autowired
    VisitorService visitorService;

    @RequestMapping(value = "/api/visitor/data",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getData(){
        HashMap<Object, Object> map = new HashMap<>();
        Map<String, List<String>> deepData = visitorService.getDeepData();
        List<String> oldAndNewNum = visitorService.getOldAndNewNum();
        map.put("deep",deepData);
        map.put("oldandnew",oldAndNewNum);
        return JSON.toJSONString(map);
    }
}
