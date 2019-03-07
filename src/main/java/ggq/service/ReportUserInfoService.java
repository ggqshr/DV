package ggq.service;

import ggq.model.Report_userinfo;

import java.util.List;
import java.util.Map;

public interface ReportUserInfoService {

    public Map<String,Object> getUserInfo(String date);

    public Map<String,Object> getNewAndActiveDataBetweenDate(String startDate,String endDate);

    public List<Object> getOldAndNewUserPerDay(String startDate,String endDate);

    public Map<String,Object> getRemainUser();
}
