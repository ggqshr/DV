package ggq.utils;

import ggq.model.ActionDateShowModel;
import ggq.model.ProductDetail;
import ggq.model.UserAgentTable;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

@Component
public class ExcelUtils {
    @Autowired
    DateUtils dateUtils;

    public HSSFCellStyle getStyle(HSSFWorkbook hssfWorkbook, Integer styleNum) {
        HSSFCellStyle style = hssfWorkbook.createCellStyle();
        style.setBorderRight(BorderStyle.THIN);//右边框
        style.setBorderBottom(BorderStyle.THIN);//下边框

        HSSFFont font = hssfWorkbook.createFont();
        font.setFontName("微软雅黑");//设置字体为微软雅黑

        HSSFPalette palette = hssfWorkbook.getCustomPalette();//拿到palette颜色板,可以根据需要设置颜色
        switch (styleNum) {
            case (0): {
                style.setAlignment(HorizontalAlignment.CENTER_SELECTION);//跨列居中
                font.setBold(true);//粗体
                font.setFontHeightInPoints((short) 14);//字体大小
                style.setFont(font);
                palette.setColorAtIndex(HSSFColor.BLUE.index, (byte) 184, (byte) 204, (byte) 228);//替换颜色板中的颜色
                style.setFillForegroundColor(HSSFColor.BLUE.index);
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            }
            break;
            case (1): {
                style.setAlignment(HorizontalAlignment.CENTER);
                font.setBold(true);//粗体
                font.setFontHeightInPoints((short) 11);//字体大小
                style.setFont(font);
            }
            break;
            case (2): {
                font.setFontHeightInPoints((short) 10);
                style.setAlignment(HorizontalAlignment.CENTER);
                style.setFont(font);
            }
            break;
            case (3): {
                style.setFont(font);

                palette.setColorAtIndex(HSSFColor.GREEN.index, (byte) 0, (byte) 32, (byte) 96);//替换颜色板中的颜色
                style.setFillForegroundColor(HSSFColor.GREEN.index);
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            }
            break;
        }

        return style;
    }

    public void CreateBuyExcel(HSSFWorkbook wb,HSSFSheet sheet, List<ProductDetail> actionData) throws ParseException {
        HSSFRow row = null;
        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 3);
        sheet.addMergedRegion(rowRegion);


        row = sheet.createRow(0);
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("产品购买Top10");
        row.getCell(0).setCellStyle(getStyle(wb, 0));//设置样式
        for (int i = 1; i <= 3; i++) {
            row.createCell(i).setCellStyle(getStyle(wb, 0));
        }


        row = sheet.createRow(1);
        row.setHeight((short) (22.50 * 20));
        row.createCell(0).setCellValue("排名");
        row.createCell(1).setCellValue("产品ID");
        row.createCell(2).setCellValue("产品名称");
        row.createCell(3).setCellValue("产品购买数");

        for (int i = 0; i <= 3; i++) {
            row.getCell(i).setCellStyle(getStyle(wb, 1));
        }

        for (int i = 0; i < actionData.size(); i++) {
            row = sheet.createRow(i + 2);
            ProductDetail user = actionData.get(i);
            row.createCell(0).setCellValue(user.getRank());
            row.createCell(1).setCellValue(user.getProId());
            row.createCell(2).setCellValue(user.getProName());
            row.createCell(3).setCellValue(user.getProBuyNum());
            for (int j = 0; j <= 3; j++) {
                row.getCell(j).setCellStyle(getStyle(wb, 2));
            }
        }

        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    public void CreateClickExcel(HSSFWorkbook wb,HSSFSheet sheet, List<ProductDetail> actionData) throws ParseException {
        HSSFRow row = null;
        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 3);
        sheet.addMergedRegion(rowRegion);


        row = sheet.createRow(0);
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("产品点击Top10");
        row.getCell(0).setCellStyle(getStyle(wb, 0));//设置样式
        for (int i = 1; i <= 3; i++) {
            row.createCell(i).setCellStyle(getStyle(wb, 0));
        }


        row = sheet.createRow(1);
        row.setHeight((short) (22.50 * 20));
        row.createCell(0).setCellValue("排名");
        row.createCell(1).setCellValue("产品ID");
        row.createCell(2).setCellValue("产品名称");
        row.createCell(3).setCellValue("产品点击数");

        for (int i = 0; i <= 3; i++) {
            row.getCell(i).setCellStyle(getStyle(wb, 1));
        }

        for (int i = 0; i < actionData.size(); i++) {
            row = sheet.createRow(i + 2);
            ProductDetail user = actionData.get(i);
            row.createCell(0).setCellValue(user.getRank());
            row.createCell(1).setCellValue(user.getProId());
            row.createCell(2).setCellValue(user.getProName());
            row.createCell(3).setCellValue(user.getProClickNum());
            for (int j = 0; j <= 3; j++) {
                row.getCell(j).setCellStyle(getStyle(wb, 2));
            }
        }

        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }
    }


    public void CreateAgentExcel(HSSFWorkbook wb, List<UserAgentTable> actionData) throws ParseException {
        HSSFSheet sheet = wb.createSheet("终端分析报表");
        HSSFRow row = null;
        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 7);
        sheet.addMergedRegion(rowRegion);


        row = sheet.createRow(0);
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("终端分析报表数据");
        row.getCell(0).setCellStyle(getStyle(wb, 0));//设置样式
        for (int i = 1; i <= 7; i++) {
            row.createCell(i).setCellStyle(getStyle(wb, 0));
        }


        row = sheet.createRow(1);
        row.setHeight((short) (22.50 * 20));
        row.createCell(0).setCellValue("访问日期");
        row.createCell(1).setCellValue("访问时间");
        row.createCell(2).setCellValue("操作系统");
        row.createCell(3).setCellValue("操作系统累计数量");
        row.createCell(4).setCellValue("来源域名");
        row.createCell(5).setCellValue("来源域名累计数量");
        row.createCell(6).setCellValue("浏览器类型");
        row.createCell(7).setCellValue("浏览器类型累计数量");

        for (int i = 0; i <= 7; i++) {
            row.getCell(i).setCellStyle(getStyle(wb, 1));
        }

        for (int i = 0; i < actionData.size(); i++) {
            row = sheet.createRow(i + 2);
            UserAgentTable user = actionData.get(i);
            row.createCell(0).setCellValue(user.getAcdate());
            row.createCell(1).setCellValue(user.getActime());
            row.createCell(2).setCellValue(user.getPlatform());
            row.createCell(3).setCellValue(user.getPnum());
            row.createCell(4).setCellValue(user.getReferdomain());
            row.createCell(5).setCellValue(user.getDnum());
            row.createCell(6).setCellValue(user.getUseragent());
            row.createCell(7).setCellValue(user.getAnum());
            for (int j = 0; j <= 7; j++) {
                row.getCell(j).setCellStyle(getStyle(wb, 2));
            }
        }

        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }
    }
}
