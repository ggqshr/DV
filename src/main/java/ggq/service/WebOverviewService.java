package ggq.service;

import ggq.model.websiteOverview;

import java.util.HashMap;

public interface WebOverviewService {

    HashMap<String, int[]> getPvUvEtcByDataType(String dataType);

    websiteOverview getTotal();

    HashMap<String,double[]> getJumpRatePerHour(String date);

    HashMap<String,double[]> getAvgVistiTime(String date);
}
