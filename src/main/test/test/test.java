package test;

import com.alibaba.fastjson.JSON;
import ggq.mapper.Report_userinfoMapper;
import ggq.mapper.UserPIcMapper;
import ggq.model.Report_userinfo;
import ggq.service.ReportUserInfoService;
import ggq.service.UserPicService;
import ggq.service.WebOverviewService;
import ggq.utils.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class test extends SpringTestBase {
    @Autowired
    ReportUserInfoService reportUserInfo;
    @Autowired
    ggq.mapper.websiteOverviewMapper websiteOverviewMapper;
    @Autowired
    WebOverviewService webOverviewService;
    @Autowired
    DateUtils dateUtils;
    @Autowired
    Report_userinfoMapper report_userinfoMapper;
    @Autowired
    UserPIcMapper userPIcMapper;
    @Autowired
    UserPicService userPicService;
    private void printArray(int[] aa){
        for (int i : aa) {
            System.out.println(i);
        }
    }
    private void printArray(double[] aa){
        for (double i : aa) {
            System.out.println(i);
        }
    }


    @Test
    public void test2() {
        HashMap<String, int[]> pvUvEtcByDataType = webOverviewService.getPvUvEtcByDataType("1");
        System.out.println(JSON.toJSONString(pvUvEtcByDataType));
    }

    @Test
    public void test3() {
        System.out.println(webOverviewService.getTotal());
    }

    @Test
    public void test4() {
        System.out.println(websiteOverviewMapper.getjump("2019-03-04"));
    }

    @Test
    public void test5() {
        System.out.println(websiteOverviewMapper.getAvgVisitTime("2019-03-04"));
    }

    @Test
    public void test6() {
        HashMap<String, double[]> avgVistiTime = webOverviewService.getAvgVistiTime("2019-03-04");
        printArray(avgVistiTime.get("avgvisittime"));
    }

    @Test
    public void test7() {
        List<HashMap<String, Object>> detailData = webOverviewService.getDetailData("2019-03-04", "1", 24);
        System.out.println(JSON.toJSON(detailData));
    }

    @Test
    public void test8() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -2);
        System.out.println((new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()));
//        System.out.println(date.getHours());// new Date()为获取当前系统时间
    }

    @Test
    public void test9() {
        System.out.println(dateUtils.getCurrentDate(DateUtils.onlyDateFormat));
        System.out.println(dateUtils.getDateSubResult(-1));
    }

    @Test
    public void test10() {
        System.out.println(report_userinfoMapper.getTotalUserNum("2019-03-05"));
    }


    @Test
    public void test11() {
        System.out.println(JSON.toJSONString(reportUserInfo.getUserInfo(dateUtils.getDateSubResult(-1))));
    }

    @Test
    public void test12() {
        System.out.println(report_userinfoMapper.getNewUserDataAndActiveDataBetweenDate("2019-02-25", "2019-03-05"));
    }

    @Test
    public void test13() throws ParseException {
        System.out.println(dateUtils.findDates("2019-02-25", "2019-03-05"));
    }

    @Test
    public void test14() {
        System.out.println(reportUserInfo.getNewAndActiveDataBetweenDate("2019-02-25", "2019-03-05"));
    }

    @Test
    public void test15() {
        System.out.println(report_userinfoMapper.getOldAndNewUserPerDay("2019-02-25", "2019-03-05"));
    }

    @Test
    public void name() {
        System.out.println(JSON.toJSONString(reportUserInfo.getOldAndNewUserPerDay("2019-02-25", "2019-03-05")));
    }

    @Test
    public void test16() {
        System.out.println(userPIcMapper.getManNumAndWomanNum());
    }

    @Test
    public void test17() {
        System.out.println(userPicService.getManAndWomanNum());
    }

    @Test
    public void test18() {
        System.out.println(userPicService.getEducation());
    }
}
