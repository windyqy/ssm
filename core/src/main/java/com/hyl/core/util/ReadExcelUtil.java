package com.hyl.core.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: WangYaMeng
 * @Date: 2018-12-17 16:32
 * @Descripton:
 */
public class ReadExcelUtil {

    private static final String XLSX = ".xlsx";
    private static final String XLS = ".xls";

    /**
     * 获取Excel文件（.xls和.xlsx都支持）
     *
     * @param file
     * @return 解析excle后的List数据
     */
    public static List<Map<String, Object>> readExcel(File file) throws Exception {
        if (file == null)
            return null;
        FileInputStream fis = new FileInputStream(file);
        return readExcel(fis, file.getName());
    }

    /**
     * 获取Excel文件（.xls和.xlsx都支持）
     *
     * @param file
     * @return 返回Workbook以供后续操作
     */
    public static Workbook readExcelTemplate(File file) throws Exception {
        if (file == null)
            return null;
        FileInputStream fis = new FileInputStream(file);
        return readExcelTemplate(fis, file.getName());
    }

    /**
     * @param is       输入流
     * @param fileName 文件名称
     * @return
     * @throws Exception
     */
    public static List<Map<String, Object>> readExcel(InputStream is, String fileName) throws Exception {
        if (is == null)
            return null;
        int res = checkFile(fileName);
        if (res == 0) {
            System.out.println("File not found");
            return null;
        } else if (res == 1) {
            return readXLSX(is);
        } else if (res == 2) {
            return readXLS(is);
        }
        return null;
    }

    /**
     *
     * @param is       输入流
     * @param fileName 文件名称
     * @return
     * @throws Exception
     */
    public static Workbook readExcelTemplate(InputStream is, String fileName) throws Exception {
        if (is == null)
            return null;
        int res = checkFile(fileName);
        if (res == 0) {
            System.out.println("File not found");
            return null;
        } else if (res == 1) {
            return readTemplateXLSX(is);
        } else if (res == 2) {
            return readTemplateXLS(is);
        }
        return null;
    }

    /**
     *
     * @param book
     * @param sheetNo
     * @param startRow
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static List<Map<String, Object>> read(Workbook book, int sheetNo, int startRow) throws IOException, ParseException {
        return read(book, startRow, sheetNo, false);
    }

    /**
     *
     * @param book
     * @param sheetNo
     * @param startRow
     * @param isReplaceKey
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static List<Map<String, Object>> read(Workbook book, int sheetNo, int startRow, boolean isReplaceKey) throws IOException, ParseException {
        Sheet sheet = book.getSheetAt(sheetNo);
        return read(sheet, book, startRow, isReplaceKey);
    }

    /**
     * 判断File文件的类型
     *
     * @param flieName 传入的文件名
     * @return 0-文件为空，1-XLSX文件，2-XLS文件，3-其他文件
     */
    private static int checkFile(String flieName) {
        if (StringUtils.isEmpty(flieName)) {
            return 0;
        }

        if (flieName.toLowerCase().endsWith(XLSX)) {
            return 1;
        }
        if (flieName.toLowerCase().endsWith(XLS)) {
            return 2;
        }
        return 3;
    }

    /**
     * 读取XLSX文件
     *
     * @param is
     * @return
     * @throws IOException
     * @throws org.apache.poi.openxml4j.exceptions.InvalidFormatException
     */
    private static List<Map<String, Object>> readXLSX(InputStream is) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException, ParseException {
        Workbook book = new XSSFWorkbook(is);
        Sheet sheet = book.getSheetAt(0);
        return read(sheet, book);
    }

    /**
     * 读取模板XLSX文件
     *
     * @param is
     * @return
     * @throws IOException
     * @throws org.apache.poi.openxml4j.exceptions.InvalidFormatException
     */
    private static Workbook readTemplateXLSX(InputStream is) throws InvalidFormatException, IOException, ParseException {
        Workbook book = new XSSFWorkbook(is);
        return book;
    }

    /**
     * 读取XLS文件
     *
     * @param is
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     */
    private static List<Map<String, Object>> readXLS(InputStream is) throws FileNotFoundException, IOException, ParseException {
        POIFSFileSystem poifsFileSystem = new POIFSFileSystem(is);
        Workbook book = new HSSFWorkbook(poifsFileSystem);
        Sheet sheet = book.getSheetAt(0);
        return read(sheet, book);
    }

    /**
     * 读取模板XLS文件
     *
     * @param is
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     */
    private static Workbook readTemplateXLS(InputStream is) throws FileNotFoundException, IOException, ParseException {
        POIFSFileSystem poifsFileSystem = new POIFSFileSystem(is);
        Workbook book = new HSSFWorkbook(poifsFileSystem);
        return book;
    }

    /**
     * 判断行数
     *
     * @param sheet 表格sheet对象
     * @param book  用于流关闭
     * @return
     * @throws IOException
     */
    private static List<Map<String, Object>> read(Sheet sheet, Workbook book, int startRow, boolean isReplaceKey) throws IOException, ParseException {
        List<Map<String, Object>> result = new ArrayList<>();
        // 首行下标
        int rowStart = startRow;
        // 尾行下标
        int rowEnd = sheet.getLastRowNum();
        // 如果首行与尾行相同，表明只有一行，直接返回空数组
        if (rowStart >= rowEnd) {
            book.close();
            return result;
        }
        return readValue(sheet, book, startRow, isReplaceKey);
    }

    /**
     * 判断行数
     *
     * @param sheet 表格sheet对象
     * @param book  用于流关闭
     * @return
     * @throws IOException
     */
    private static List<Map<String, Object>> read(Sheet sheet, Workbook book) throws IOException, ParseException {
        List<Map<String, Object>> result = new ArrayList<>();
        // 首行下标
        int rowStart = sheet.getFirstRowNum();
        // 尾行下标
        int rowEnd = sheet.getLastRowNum();
        // 如果首行与尾行相同，表明只有一行，直接返回空数组
        if (rowStart == rowEnd) {
            book.close();
            return result;
        }
        return readValue(sheet, book, rowStart);
    }

    /**
     * 解析数据
     *
     * @param sheet 表格sheet对象
     * @param book  用于流关闭
     * @return
     * @throws IOException
     */
    private static List<Map<String, Object>> readValue(Sheet sheet, Workbook book, int startRow) throws IOException, ParseException {
        return readValue(sheet, book, startRow, false);
    }

    /**
     * 解析数据
     *
     * @param sheet 表格sheet对象
     * @param book  用于流关闭
     * @return
     * @throws IOException
     */
    private static List<Map<String, Object>> readValue(Sheet sheet, Workbook book, int startRow, boolean isReplaceKey) throws IOException, ParseException {
        List<Map<String, Object>> result = new ArrayList<>();
        // 获取第一行对象键
        Row firstRow = sheet.getRow(startRow);
        int cellStart = firstRow.getFirstCellNum();
        int cellEnd = firstRow.getLastCellNum();
        Map<Integer, Object> keyMap = new HashMap<>();
        for (int j = cellStart; j < cellEnd; j++) {
            keyMap.put(j, getValue(firstRow.getCell(j), startRow, j, book, true));
        }

        if (isReplaceKey)//替换字段名
            replaceKeys(keyMap);

        // 获取每行对象的值
        for (int i = startRow + 1; i <= sheet.getLastRowNum(); i++) {
            Row eachRow = sheet.getRow(i);
            Map<String, Object> map = new HashMap<>();
            StringBuffer sb = new StringBuffer();
            for (int k = cellStart; k < cellEnd; k++) {//一行
                if (eachRow != null) {
                    Object val = getValue(eachRow.getCell(k), i, k, book, false);
                    // 所有数据添加到里面，用于判断该行是否为空
                    sb.append(val);
                    map.put(String.valueOf(keyMap.get(k)), val);
                }
            }
            if (sb.toString().length() > 0) {
                result.add(map);
            }
        }
        book.close();
        return result;
    }

    /**
     * 获取每个单元格的数据
     *
     * @param cell   单元格对象
     * @param rowNum 第几行
     * @param index  该行第几个
     * @param book   主要用于关闭流
     * @param isKey  是否为键：true-是，false-不是。 如果解析Json键，值为空时报错；如果不是Json键，值为空不报错
     * @return
     * @throws IOException
     */
    private static Object getValue(Cell cell, int rowNum, int index, Workbook book, boolean isKey) throws IOException, ParseException {

        // 空白或空
        if (cell == null || cell.getCellType() == CellType.BLANK) {
            if (isKey) {
                book.close();
                throw new NullPointerException(String.format("the key on row %s index %s is null ", ++rowNum, ++index));
            } else {
                return "";
            }
        }

        // 0. 数字 类型
        if (cell.getCellType() == CellType.NUMERIC) {
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                Date date = cell.getDateCellValue();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateStr = df.format(date);
                return df.parse(dateStr);
            }
            String val = cell.getNumericCellValue() + "";
            val = val.toUpperCase();
            if (val.contains("E")) {
                val = val.split("E")[0].replace("", "");
                return val;
            } else {
                return new BigDecimal(val);
            }
        }

        // 1. String类型
        if (cell.getCellType() == CellType.STRING) {
            String val = cell.getStringCellValue();
            if (val == null || val.trim().length() == 0) {
                if (book != null) {
                    book.close();
                }
                return "";
            }
            return val.trim();
        }

        // 2. 公式 CELL_TYPE_FORMULA
        if (cell.getCellType() == CellType.FORMULA) {
            return cell.getStringCellValue();
        }

        // 4. 布尔值 CELL_TYPE_BOOLEAN
        if (cell.getCellType() == CellType.BOOLEAN) {
            return cell.getBooleanCellValue() + "";
        }

        // 5.	错误 CELL_TYPE_ERROR
        return "";
    }

    private static void replaceKeys(Map<Integer, Object> map) {
        for (Map.Entry<Integer, Object> entry:map.entrySet()) {
            switch (String.valueOf(entry.getValue())) {
                case "投保日期":
                    entry.setValue("gmtCreate");
                    break;
                case "订单号":
                    entry.setValue("orderNo");
                    break;
                case "合作机构":
                    entry.setValue("boss");
                    break;
                case "团体单位名称":
                    entry.setValue("merchantName");
                    break;
                case "单位地址":
                    entry.setValue("merchantAddress");
                    break;
                case "单位联系人":
                    entry.setValue("merchantContact");
                    break;
                case "单位联系电话":
                    entry.setValue("merchantTel");
                    break;
                case "投保人邮箱":
                    entry.setValue("email");
                    break;
                case "统一社会信用代码":
                    entry.setValue("code");
                    break;
                case "被保险人姓名":
                    entry.setValue("insuredName");
                    break;
                case "被保人性别":
                    entry.setValue("sexType");
                    break;
                case "被保人出生日期":
                    entry.setValue("birthday");
                    break;
                case "被保人证件类型":
                    entry.setValue("certType");
                    break;
                case "被保人证件号码":
                    entry.setValue("certNo");
                    break;
                case "被保人联系电话":
                    entry.setValue("insuredMobile");
                    break;
                case "被保人职业":
                    entry.setValue("insuredWork");
                    break;
                case "保单生效日（含时间）":
                    entry.setValue("beginDate");
                    break;
                case "保单到期日（含时间）":
                    entry.setValue("endeDate");
                    break;
                case "保费":
                    entry.setValue("insAmount");
                    break;
                case "份数":
                    entry.setValue("insNumber");
                    break;
                case "保额":
                    entry.setValue("insTotalAmount");
                    break;
                case "保障计划":
                    entry.setValue("insuranceNo");
                    break;
                case "保单号":
                    entry.setValue("policyNo1");
                    break;
                case "分单号":
                    entry.setValue("policyNo2");
                    break;
                default:
            }
        }
    }
}
