package ggq.service;

import ggq.mapper.websiteOverviewMapper;
import ggq.model.websiteOverview;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;

public interface WebOverviewService {
    HashMap<Integer, websiteOverview> get( String dataType);

    HashMap<String, ArrayList<Integer>> getPvUvEtcByDataType(String dataType);
}
