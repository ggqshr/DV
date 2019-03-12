package ggq.service;

import java.util.List;
import java.util.Map;

public interface VisitorService {
    /**
     * 获得近七天 每天的用户平均访问深度
     * @return
     */
    Map<String,List<String>> getDeepData();

    /**
     * 获得新老访客的数目
     * @return
     */
    List<String> getOldAndNewNum();
}
