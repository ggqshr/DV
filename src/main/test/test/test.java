package test;

import com.alibaba.fastjson.JSON;
import ggq.model.Report_userinfo;
import ggq.model.websiteOverview;
import ggq.service.ReportUserInfo;
import ggq.service.WebOverviewService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class test extends SpringTestBase {
    @Autowired
    ReportUserInfo reportUserInfo;
    Logger logger = LoggerFactory.getLogger(test.class);
    @Autowired
    WebOverviewService webOverviewService;

    @Test
    public void test1() {
        Report_userinfo user = reportUserInfo.getUser();
        System.out.println(user);
    }

    @Test
    public void test2() {
        System.out.println(webOverviewService.getPvUvEtcByDataType("yestoday"));
    }
}
