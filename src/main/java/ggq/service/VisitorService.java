package ggq.service;

import java.util.List;
import java.util.Map;

public interface VisitorService {
    Map<String,List<String>> getDeepData();

    List<String> getOldAndNewNum();
}
