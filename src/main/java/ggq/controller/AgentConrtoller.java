package ggq.controller;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.log.LogFactory;
import ggq.model.AgentDataModel;
import ggq.model.UserAgentTable;
import ggq.service.AgentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AgentConrtoller {
    Logger log = LoggerFactory.getLogger(AgentConrtoller.class);
    @Autowired
    AgentService agentService;

    @RequestMapping(value = "/api/agen/data", method = RequestMethod.POST)
    @ResponseBody
    public String getdata(@RequestBody AgentDataModel model) {
        log.warn(model.toString());
        if (model.getAcdate() == null) {
            List<UserAgentTable> dataByCondition = agentService.getDataByCondition(null, null, "%"+model.getReferdomain()+"%",
                    "%"+model.getUseragent()+"%",  "%"+model.getPlatform()+"%");
            return JSON.toJSONString(dataByCondition);
        } else if (model.getAcdate().size() == 0) {
            List<UserAgentTable> dataByCondition = agentService.getDataByCondition(null, null, "%"+model.getReferdomain()+"%",
                    "%"+model.getUseragent()+"%",  "%"+model.getPlatform()+"%");
            return JSON.toJSONString(dataByCondition);
        } else {
            List<UserAgentTable> dataByCondition = agentService.getDataByCondition(model.getAcdate().get(0), model.getAcdate().get(1), "%"+model.getReferdomain()+"%",
                    "%"+model.getUseragent()+"%", "%"+model.getPlatform()+"%");
            return JSON.toJSONString(dataByCondition);
        }
    }

}
