package ggq.mapper;

import ggq.model.websiteOverview;
import org.apache.ibatis.annotations.MapKey;

import java.util.HashMap;

public interface websiteOverviewMapper {

    @MapKey("accesshour")
    HashMap<Integer, websiteOverview> getPV(String dataType);
}
