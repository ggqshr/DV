package ggq.service;

import ggq.model.UserAgentTable;

import java.util.List;

public interface AgentService {
    public List<UserAgentTable> getDataByCondition(String startDate, String endData,
                                                   String domin, String agent, String os);
}
