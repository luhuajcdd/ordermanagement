package com.dehua.util;

public class ExcelUtil {

	public static boolean isExcel(String filePath){
		return isExcel2003(filePath) || isExcel2007(filePath);
	}
	
	public static boolean isExcel2003(String filePath){
  
        return filePath.matches("^.+\\.(?i)(xls)$");  
  
    } 
	
	public static boolean isExcel2007(String filePath){  
  
        return filePath.matches("^.+\\.(?i)(xlsx)$");  
  
    } 
	
}
