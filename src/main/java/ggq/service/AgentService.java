package ggq.service;

import ggq.model.UserAgentTable;

import java.util.List;

public interface AgentService {
    /**
     * 通过开始时间、结束时间以及来源域名和终端和操作系统获得特定的数据
     *
     * @param startDate 查询的起始时间
     * @param endData   结束时间
     * @param domin     来源域名
     * @param agent     使用终端
     * @param os        使用的操作系统
     * @return
     */
    public List<UserAgentTable> getDataByCondition(String startDate, String endData,
                                                   String domin, String agent, String os);
}
