package ggq.mapper;

import ggq.model.websiteOverview;
import org.apache.ibatis.annotations.MapKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface websiteOverviewMapper {

    @MapKey("accesshour")
    HashMap<Integer, websiteOverview> getPV(String subDateNumber);

    websiteOverview getTotal();

    List<Map<String,Integer>> getjump(String date);

    List<Map<String,String>> getAvgVisitTime(String date);
}
