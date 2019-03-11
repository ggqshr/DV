package ggq.controller;

import com.alibaba.fastjson.JSON;
import ggq.model.ActionDateShowModel;
import ggq.model.ProductDetail;
import ggq.service.ProductService;
import ggq.utils.DateUtils;
import ggq.utils.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.IOException;
import java.io.OutputStream;
import java.net.PortUnreachableException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ExcelUtils excelUtils;
    @Autowired
    DateUtils dateUtils;

    @RequestMapping(value = "/api/product/data", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getData() {
        Map<String, List<ProductDetail>> productData = productService.getProductData();
        return JSON.toJSONString(productData);
    }

    @RequestMapping(value = "/api/product/actiondata", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getActionData() {
        List<ActionDateShowModel> actionData = productService.getActionData();
        return JSON.toJSONString(actionData);
    }

    @RequestMapping(value = "/api/getexcel")
    public void getExcel(HttpServletResponse res) throws ParseException, IOException {
        List<ActionDateShowModel> actionData = productService.getActionData();
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("用户行为分析报表");
        HSSFRow row = null;
        List<String> dates = dateUtils.findDates(dateUtils.getDateSubResult(-6), dateUtils.getCurrentDate());


        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 8);
        sheet.addMergedRegion(rowRegion);

        row = sheet.createRow(0);
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("用户行为报表");
        row.getCell(0).setCellStyle(excelUtils.getStyle(wb, 0));//设置样式
        for (int i = 1; i <= 8; i++) {
            row.createCell(i).setCellStyle(excelUtils.getStyle(wb, 0));
        }


//        CellRangeAddress columnRegion = new CellRangeAddress(1, 4, 0, 0);
//        sheet.addMergedRegion(columnRegion);

        row = sheet.createRow(1);
//        row.createCell(0).setCellStyle(excelUtils.getStyle(wb, 3));
        row.setHeight((short) (22.50 * 20));
        row.createCell(0).setCellValue("行为ID");
        row.createCell(1).setCellValue("行为名");
        row.createCell(2).setCellValue(dates.get(0));
        row.createCell(3).setCellValue(dates.get(1));
        row.createCell(4).setCellValue(dates.get(2));
        row.createCell(5).setCellValue(dates.get(3));
        row.createCell(6).setCellValue(dates.get(4));
        row.createCell(7).setCellValue(dates.get(5));
        row.createCell(8).setCellValue(dates.get(6));

        for (int i = 0; i <= 8; i++) {
            row.getCell(i).setCellStyle(excelUtils.getStyle(wb, 1));
        }

        for (int i = 0; i < actionData.size(); i++) {
            row = sheet.createRow(i + 2);
            ActionDateShowModel user = actionData.get(i);
            row.createCell(0).setCellValue(user.getAction_id());
            row.createCell(1).setCellValue(user.getAction_name());
            row.createCell(2).setCellValue(user.getdata0());
            row.createCell(3).setCellValue(user.getDate1());
            row.createCell(4).setCellValue(user.getDate2());
            row.createCell(5).setCellValue(user.getDate3());
            row.createCell(6).setCellValue(user.getDate4());
            row.createCell(7).setCellValue(user.getDate5());
            row.createCell(8).setCellValue(user.getDate6());
            for (int j = 0; j <= 8; j++) {
                row.getCell(j).setCellStyle(excelUtils.getStyle(wb, 2));
            }
        }

        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }

        res.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = res.getOutputStream();
        wb.write(os);
        os.flush();
        os.close();
    }
}
