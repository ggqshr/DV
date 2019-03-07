package ggq.mapper;

import ggq.model.VisitorDataModel;

import java.util.List;
import java.util.Map;

public interface VisitorMapper {
    List<VisitorDataModel> getDeepBetweenSenvenDays();

    List<VisitorDataModel> getOldAndNewVistor();
}
