package ggq.service;

import ggq.model.Report_userinfo;

import java.util.List;
import java.util.Map;

public interface ReportUserInfoService {

    Map<String, Object> getUserInfo(String date);

    Map<String, Object> getNewAndActiveDataBetweenDate(String startDate, String endDate);

    List<Object> getOldAndNewUserPerDay(String startDate, String endDate);

    Map<String, Object> getRemainUser();

    Map<String, double[]> getNewAndActiveRemainUserRate();
}
