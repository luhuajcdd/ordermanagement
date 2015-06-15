package com.dehua.order.read;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.dehua.order.read.aliexpress.ExpressOrderRead;

public class ReadController {

	public int controller(String path, ExcelType type){
		int result = 0;
		switch (type) {
		case ALI_EXCEL:
			IRead read = new ExpressOrderRead();
			try {
				result = read.read(path);
			} catch (FileNotFoundException e) {
				Logger.getGlobal().log(Level.WARNING, null, e);
			}
			break;

		case YAN_WEN_EXCEL:
			break;
		default:
			break;
		}
		
		return result;
	}
	
}
