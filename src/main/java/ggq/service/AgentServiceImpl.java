package ggq.service;

import ggq.mapper.AgentMapper;
import ggq.model.UserAgentTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("AgentService")
public class AgentServiceImpl implements AgentService {

    @Autowired
    AgentMapper agentMapper;

    @Override
    public List<UserAgentTable> getDataByCondition(String startDate, String endData, String domin, String agent, String os) {
        List<UserAgentTable> agentTable = agentMapper.getAgentTable(startDate, endData, domin, agent, os);
        return agentTable;
    }
}
