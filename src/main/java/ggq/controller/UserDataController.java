package ggq.controller;

import com.alibaba.fastjson.JSON;
import ggq.model.DateModel;
import ggq.service.ReportUserInfoService;
import ggq.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import static ggq.utils.DateUtils.date2Str;
import static ggq.utils.DateUtils.str2Date;

@Controller
public class UserDataController {

    @Autowired
    ReportUserInfoService service;

    @Autowired
    DateUtils dateUtils;


    /**
     * 昨天的新用户、沉默用户和活跃用户数据
     *
     * @return
     */
    @RequestMapping("/api/userdata")
    @ResponseBody
    public String getIntroduceRowData() {
        Map<String, Object> userInfo = service.getUserInfo(dateUtils.getDateSubResult(-1));
        return JSON.toJSONString(userInfo);
    }

    /**
     * 新访客和活跃访客占比数据
     *
     * @param dateModel 传入的参数封装的模型
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/api/ratedata", method = RequestMethod.POST)
    @ResponseBody
    public String getNewAndActiveRate(@RequestBody DateModel dateModel) throws ParseException {
        String startDate = dateModel.getStartDate();
        String endDate = dateModel.getEndDate();
        //date2Str用来将日期转换成字符串
        Map<String, Object> newAndActiveDataBetweenDate = service.getNewAndActiveDataBetweenDate(
                date2Str.format(str2Date.parse(startDate)),
                date2Str.format(str2Date.parse(endDate))
        );
        return JSON.toJSONString(newAndActiveDataBetweenDate);
    }

    /**
     * 获得指定日期的新老用户数量
     *
     * @param dateModel 传入的参数封装的模型
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/api/oldandnewdata", method = RequestMethod.POST)
    @ResponseBody
    public String getOldAndNewBetweenDate(@RequestBody DateModel dateModel) throws ParseException {
        String startDate = dateModel.getStartDate();
        String endDate = dateModel.getEndDate();

        List<Object> oldAndNewUserPerDay = service.getOldAndNewUserPerDay(
                date2Str.format(str2Date.parse(startDate)),
                date2Str.format(str2Date.parse(endDate))
        );
        return JSON.toJSONString(oldAndNewUserPerDay);
    }
}
