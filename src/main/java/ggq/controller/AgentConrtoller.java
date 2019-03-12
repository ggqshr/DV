package ggq.controller;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.log.LogFactory;
import ggq.model.AgentDataModel;
import ggq.model.ProductDetail;
import ggq.model.UserAgentTable;
import ggq.service.AgentService;
import ggq.utils.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Controller
public class AgentConrtoller {
    @Autowired
    AgentService agentService;
    @Autowired
    ExcelUtils excelUtils;

    /**
     * 根据传入的AgentDataModel查询指定的用户终端分析数据
     *
     * @param model 封装查询的条件字段的数据模型
     * @return JSON格式的终端分析数据
     */
    @RequestMapping(value = "/api/agen/data", method = RequestMethod.POST)
    @ResponseBody
    public String getdata(@RequestBody AgentDataModel model) {
        if (model.getAcdate() == null) {
            List<UserAgentTable> dataByCondition = agentService.getDataByCondition(
                    null,
                    null,
                    "%" + model.getReferdomain() + "%",
                    "%" + model.getUseragent() + "%",
                    "%" + model.getPlatform() + "%");

            return JSON.toJSONString(dataByCondition);
        } else if (model.getAcdate().size() == 0) {
            List<UserAgentTable> dataByCondition = agentService.getDataByCondition(
                    null,
                    null,
                    "%" + model.getReferdomain() + "%",
                    "%" + model.getUseragent() + "%",
                    "%" + model.getPlatform() + "%");

            return JSON.toJSONString(dataByCondition);
        } else {
            List<UserAgentTable> dataByCondition = agentService.getDataByCondition(
                    model.getAcdate().get(0),
                    model.getAcdate().get(1),
                    "%" + model.getReferdomain() + "%",
                    "%" + model.getUseragent() + "%",
                    "%" + model.getPlatform() + "%");

            return JSON.toJSONString(dataByCondition);
        }
    }

    /**
     * 生成产品分析excel报表并返回
     *
     * @param res response
     * @throws ParseException 日期转化异常
     * @throws IOException    IO异常
     */
    @RequestMapping(value = "/api/getexcelagent")
    public void getExcelProduct(HttpServletResponse res) throws ParseException, IOException {
        List<UserAgentTable> dataByCondition = agentService.getDataByCondition(
                null,
                null,
                null, null, null);
        HSSFWorkbook wb = new HSSFWorkbook();

        excelUtils.CreateAgentExcel(wb, dataByCondition);
        res.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = res.getOutputStream();
        wb.write(os);
        os.flush();
        os.close();
    }
}
