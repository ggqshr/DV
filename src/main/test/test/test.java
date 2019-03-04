package test;

import ggq.model.Report_userinfo;
import ggq.service.ReportUserInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



public class test extends SpringTestBase{
    @Autowired
    ReportUserInfo reportUserInfo;

    Logger logger =  LoggerFactory.getLogger(test.class);

    @Test
    public void test1() {
    Report_userinfo user = reportUserInfo.getUser();
    System.out.println(user);
}
}
