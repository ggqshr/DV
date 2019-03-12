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

    /**
     * 获得当前访客的所有数据,包括新老访客数，以及平均访问深度
     *
     * @return
     */
    @RequestMapping(value = "/api/visitor/data", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getData() {
        HashMap<Object, Object> map = new HashMap<>();

        //获得平均访问深度数据
        Map<String, List<String>> deepData = visitorService.getDeepData();
        map.put("deep", deepData);

        //获得新老用户数量
        List<String> oldAndNewNum = visitorService.getOldAndNewNum();
        map.put("oldandnew", oldAndNewNum);
        return JSON.toJSONString(map);
    }
}
