package test;

import com.alibaba.fastjson.JSON;
import ggq.mapper.*;
import ggq.model.*;
import ggq.service.*;
import ggq.utils.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.Data;
import java.lang.management.MemoryManagerMXBean;
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

    private void printArray(int[] aa) {
        for (int i : aa) {
            System.out.println(i);
        }
    }

    private void printArray(double[] aa) {
        for (double i : aa) {
            System.out.println(i);
        }
    }


    @Test
    public void test2() {
        HashMap<String, Object> pvUvEtcByDataType = webOverviewService.getPvUvEtcByDataType("1");
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

    @Test
    public void test19() {
        System.out.println(userPIcMapper.getAge());
    }

    @Test
    public void test20() {
        System.out.println(userPIcMapper.getEmployee());
    }

    @Test
    public void test21() {
        System.out.println(userPicService.getEmployee());
    }

    @Autowired
    AgentMapper agentMapper;

    @Test
    public void test22() {
        System.out.println(JSON.toJSONString(agentMapper.getAgentTable(null, null, "", "", "")));
    }

    @Test
    public void ttest() {
        Map<String, Object> userInfo = reportUserInfo.getUserInfo(dateUtils.getDateSubResult(-1));
        System.out.println(userInfo);
    }

    @Test
    public void test23() {
        System.out.println(report_userinfoMapper.getRemainUser());
    }

    @Test
    public void test24() {
        System.out.println(reportUserInfo.getRemainUser());
    }

    @Autowired
    ProductService productService;

    @Test
    public void test25() {
        System.out.println(JSON.toJSONString(productService.getProductData()));
    }

    @Autowired
    VisitorServiceImpl visitorService;
    @Autowired
    VisitorMapper visitorMapper;

    @Test
    public void test26() {
        List<VisitorDataModel> deepBetweenSenvenDays = visitorMapper.getDeepBetweenSenvenDays();
        System.out.println(deepBetweenSenvenDays);
    }

    @Test
    public void test27() {
        System.out.println(visitorService.getOldAndNewNum());
    }

    @Test
    public void test28() {
        System.out.println(JSON.toJSONString(webOverviewService.getAvgVistiTime(dateUtils.getCurrentDate(DateUtils.onlyDateFormat))));
    }

    @Test
    public void test29() {
        System.out.println(JSON.toJSONString(webOverviewService.getDetailData(dateUtils.getCurrentDate(DateUtils.onlyDateFormat), "1", 12)));
    }

    @Autowired
    ProductMapper productMapper;

    @Test
    public void test30() throws ParseException {
        System.out.println(productService.getActionData());
    }

    @Test
    public void test31() throws NoSuchFieldException, IllegalAccessException {
        ActionDateShowModel model = new ActionDateShowModel(1, "ggq");
        model.getClass().getField("date1").setInt(model, 2);
        System.out.println(model);
    }

    @Test
    public void test32() {
        System.out.println(JSON.toJSONString(productService.getActionData()));
    }

    @Test
    public void test33() {
        Map<String, List<ProductDetail>> productData = productService.getProductData();
        System.out.println(JSON.toJSONString(productData));
    }
}
