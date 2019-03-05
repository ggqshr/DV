package test;

import com.alibaba.fastjson.JSON;
import ggq.model.Report_userinfo;
import ggq.service.ReportUserInfo;
import ggq.service.WebOverviewService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class test extends SpringTestBase {
    @Autowired
    ReportUserInfo reportUserInfo;
    @Autowired
    ggq.mapper.websiteOverviewMapper websiteOverviewMapper;
    @Autowired
    WebOverviewService webOverviewService;

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
    public void test1() {
        Report_userinfo user = reportUserInfo.getUser();
        System.out.println(user);
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
}
