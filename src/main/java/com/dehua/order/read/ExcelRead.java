package com.dehua.order.read;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;

public abstract class ExcelRead<T> {

    /**
     * Read the Excel 2003
     * @param path the path of the Excel
     * @return
     * @throws IOException
     */
    public List<T> readXls(InputStream inputStream) throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        List<T> list = new ArrayList<>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow row = hssfSheet.getRow(rowNum);
                if (row != null) {
                	T t = get(row);
                	if(t != null){
                		list.add(t);
                	}
                }
            }
        }
        return list;
    }

    public abstract T get(Row row);
    
    public String getStringValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
        	String value = hssfCell.getStringCellValue();
        	if(value == null || "".equals(value.trim())){
        		return null;
        	}
            return hssfCell.getStringCellValue().trim();
        }
    }
    
    public long getLongValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            return (long)hssfCell.getNumericCellValue();
        } else {
        	String value = hssfCell.getStringCellValue();
        	if(value == null || "".equals(value.trim())){
        		return 0;
        	}
            return Long.valueOf(value.trim());
        }
    }
    
    public int getIntValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            return (int)hssfCell.getNumericCellValue();
        } else {
        	String value = hssfCell.getStringCellValue();
        	if(value == null || "".equals(value.trim())){
        		return 0;
        	}
            return Integer.valueOf(value.trim());
        }
    }
    

    public double getDoubleValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            return (int)hssfCell.getNumericCellValue();
        } else {
        	String value = hssfCell.getStringCellValue();
        	if(value == null || "".equals(value.trim())){
        		return 0;
        	}
            return Double.valueOf(value.trim());
        }
    }
    
    /**
     * Read the Excel 2007 2010
     * @param path the path of the excel file
     * @return
     * @throws IOException
     */
    public List<T> readXlsx(InputStream inputStream) throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
        List<T> list = new ArrayList<>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                	T t = get(xssfRow);
                	if(t != null){
                		list.add(t);
                	}
                }
            }
        }
        return list;
    }
   
    
    public String getStringValue(XSSFCell xssfRow) {
        if (xssfRow.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
        	String value = xssfRow.getStringCellValue();
        	if(value == null || "".equals(value.trim())){
        		return null;
        	}
            return value.trim();
        }
    }
    
    public long getLongValue(XSSFCell xssfRow){
    	if (xssfRow.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
            return (long)xssfRow.getNumericCellValue();
        }else{
        	String value = xssfRow.getStringCellValue();
        	if(value == null || "".equals(value.trim())){
        		return 0;
        	}
        	return Long.valueOf(value.trim());
        }
    }
    
    public int getIntValue(XSSFCell xssfRow){
    	if (xssfRow.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
            return (int)xssfRow.getNumericCellValue();
        }else{
        	String value = xssfRow.getStringCellValue();
        	if(value == null || "".equals(value.trim())){
        		return 0;
        	}
        	return Integer.valueOf(value.trim());
        }
    }

    public double getDoubleValue(XSSFCell xssfRow){
    	if (xssfRow.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
            return (int)xssfRow.getNumericCellValue();
        }else{
        	String value = xssfRow.getStringCellValue();
        	if(value == null || "".equals(value.trim())){
        		return 0;
        	}
        	return Double.valueOf(value.trim());
        }
    }


	
}



