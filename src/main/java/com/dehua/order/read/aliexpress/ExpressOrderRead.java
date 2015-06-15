package com.dehua.order.read.aliexpress;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.dehua.order.read.IRead;
import com.dehua.util.ExcelUtil;

public class ExpressOrderRead implements IRead {

	/**
	 * @param path excel file path 
	 * @return 
	 *  	-1: param error
	 *  	-2: not excel
	 */
	@Override
	public int read(String path) throws FileNotFoundException {
		
		if(path == null){
			
			return -1 ;
		}
		
		if(! ExcelUtil.isExcel(path)){
			return -2;
		}
		
		
		InputStream inputStream = new FileInputStream(path);
		
		boolean isXLS = false;
		isXLS = ExcelUtil.isExcel2003(path);
		
		int result = readAndSaveToDB(inputStream,isXLS);
		
		return result;
	}

	private int readAndSaveToDB(InputStream inputStream,boolean isXLS) {
		
		List<AliExpressOrder> aos = null;
		AliExpressExcelRead read = new AliExpressExcelRead();
		try {
			if(isXLS){
				aos = read.readXls(inputStream);
			}else{
				aos = read.readXlsx(inputStream);
			}
		} catch (IOException e) {
			Logger.getGlobal().log(Level.WARNING, null, e);
		}
		
		System.out.println(aos.size());
		
		return 0;
	}

}
