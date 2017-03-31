package com.testing.util;

import java.util.Hashtable;
import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ReadExcel {
//public static void Main(){	
	static Sheet wrkSheet;
	static Workbook wrkBook = null;
 	static Hashtable dictionary = new Hashtable();
	String path = "";
	
	public ReadExcel(String path, String sheetName) throws BiffException,
	IOException {
		wrkBook = Workbook.getWorkbook(new File(path));
		wrkSheet = wrkBook.getSheet(sheetName);
		columnDictionary();
	}	
	
	//return no of rows
		public int getRowCount(){
			return wrkSheet.getRows();
		}
		
		public int getColumnCount(){
			return wrkSheet.getColumns();
		}
		//return cell value for column,row
		public String readCell(int col, int row){
			return wrkSheet.getCell(col, row).getContents();
		}
		
		public String readCell(String colName, int row){
			return readCell(getColIndex(colName), row);
		}
		
		//create col dictionary to save all the col names
		public void columnDictionary(){
			for (int col=0; col < wrkSheet.getColumns(); col++){
				dictionary.put(readCell(col,0), col);
			}			
		}
		
		//Read column names from column dictionary 
		public int getColIndex(String colName) {
			try {
				int value;
				value = ((Integer) dictionary.get(colName)).intValue();
				return value;
			} catch (NullPointerException e) {
				return (0);
			}
		}
	
	
	
//	//return no of rows
//	public static int getRowCount(){
//		return wrkSheet.getRows();
//	}
//	
//	public static int getColumnCount(){
//		return wrkSheet.getColumns();
//	}
//	//return cell value for column,row
//	public static String readCell(int col, int row){
//		return wrkSheet.getCell(col, row).getContents();
//	}
//	
//	public static String readCell(String colName, int row){
//		return readCell(getColIndex(colName), row);
//	}
//	
//	//create col dictionary to save all the col names
//	public static void columnDictionary(){
//		for (int col=0; col < wrkSheet.getColumns(); col++){
//			dictionary.put(readCell(col,0), col);
//		}			
//	}
//	
//	//Read column names from column dictionary 
//	public static int getColIndex(String colName) {
//		try {
//			int value;
//			value = ((Integer) dictionary.get(colName)).intValue();
//			return value;
//		} catch (NullPointerException e) {
//			return (0);
//		}
//	}
	
	
}




