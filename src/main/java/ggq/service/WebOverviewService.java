package ggq.service;

import ggq.model.websiteOverview;

import java.util.HashMap;
import java.util.List;

public interface WebOverviewService {

    HashMap<String, int[]> getPvUvEtcByDataType(String subDateNumber);

    websiteOverview getTotal();

    HashMap<String,double[]> getJumpRatePerHour(String date);

    HashMap<String,double[]> getAvgVistiTime(String date);

    List<HashMap<String,Object>> getDetailData(String date,String dataSubNumber,int currentHours);

}
