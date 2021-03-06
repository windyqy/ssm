package com.hyl.core.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;
import java.util.Map;

public class ExportExcelUtil {

    private static final String XLSX = ".xlsx";
    private static final String XLS = ".xls";

    /**
     * 导出
     * @param title
     * @param mapList
     * @param suffix
     * @return
     */
    public static Workbook exportExcel(List<String> title, List<Map<String, Object>> mapList, String suffix) {
        Workbook workbook = null;
        if (StringUtils.equals(suffix, XLSX)) {
            workbook = new XSSFWorkbook();
        } else if (StringUtils.equals(suffix, XLS)) {
            workbook = new HSSFWorkbook();
        } else {
            workbook = new XSSFWorkbook();
        }

        Sheet sheet = workbook.createSheet();
        Row titleRow = sheet.createRow(0);//标题
        for (int i = 0; i < title.size(); i++) {
            Cell cell = titleRow.createCell(i);
            cell.setCellValue(title.get(i));
        }

        for (int i = 0; i < mapList.size(); i++) {
            Row row = sheet.createRow(i + 1);
            Map<String, Object> map = mapList.get(i);
            int j = 0;
            for (Object obj:map.values()) {
                row.createCell(j).setCellValue(String.valueOf(obj));
                ++j;
            }
        }

        return workbook;
    }

    /**
     * 导出到模板
     * @param workbook
     * @param mapList
     * @param suffix
     * @param sheetNo
     * @param startRow
     * @return
     */
    public static Workbook exportExcelByTemplate(Workbook workbook, List<Map<String, Object>> mapList, String suffix, int sheetNo, int startRow) {
        Sheet sheet = workbook.getSheetAt(sheetNo);
        for (int i = 0; i < mapList.size(); i++) {
            Row row = sheet.createRow(i + startRow);
            Map<String, Object> map = mapList.get(i);
            int j = 0;
            for (Object obj:map.values()) {
                row.createCell(j).setCellValue(String.valueOf(obj));
                ++j;
            }
        }
        return workbook;
    }
}