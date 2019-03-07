package ggq.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AgentMapper {

    List<ggq.model.UserAgentTable> getAgentTable(@Param("startDate") String startDate, @Param("endData") String endData,
                                                 @Param("domin") String domin, @Param("agent") String agent, @Param("os") String os);
}
