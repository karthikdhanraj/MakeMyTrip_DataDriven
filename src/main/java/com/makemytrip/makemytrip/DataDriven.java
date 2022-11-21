package com.makemytrip.makemytrip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

public class DataDriven {
	static String value;
	static int a;
    static double d;
	public static void main(String[] args) throws IOException {
		particularData("passengers", 1, 0);
		
			}
		public static String particularData(String name,int Row ,int Cell) throws IOException {
		
		File f = new File((System.getProperty("user.dir") + "/DataDriven/MAkeMyTrip.xlsx"));
		
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(name);
		Row r = s.getRow(Row);
		Cell c = r.getCell(Cell);
		CellType ce = c.getCellType();
		if (ce.equals(CellType.STRING)) {
		     value = c.getStringCellValue();
			
			
		}else
			if (ce.equals(CellType.NUMERIC)) {
			double d = c.getNumericCellValue();
			int a =(int)d;
			value = Integer.toString(a);
			
			
		}return value;
		}
		public static double cellDataNumeric(String name,int Row ,int Cell) throws IOException {
			File f = new File((System.getProperty("user.dir") + "/DataDriven/MAkeMyTrip.xlsx"));
			
			FileInputStream fi = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fi);
			Sheet s = w.getSheet(name);
			Row r = s.getRow(Row);
			Cell c = r.getCell(Cell);
			CellType ce = c.getCellType();
			 if (ce.equals(CellType.NUMERIC)) {
				double d = c.getNumericCellValue();
				
				
				
			}
			return d;
			}
	public static void alldata() throws IOException {

         File f = new File((System.getProperty("user.dir") + "/DataDriven/MAkeMyTrip.xlsx"));
		
		FileInputStream fi = new FileInputStream(f);
        Workbook w = new XSSFWorkbook(fi);
        Sheet s = w.getSheet("amazon");
        int rowsize = s.getPhysicalNumberOfRows();
        for (int i = 0; i <rowsize; i++) {
    	  Row r = s.getRow(i);
    	  int cellsize = r.getPhysicalNumberOfCells();
		  for (int j = 0; j < cellsize; j++) {
			Cell c = r.getCell(j);
			CellType ce = c.getCellType();
			if (ce.equals(CellType.STRING)) {
				 value = c.getStringCellValue();
				
				   
			}else if (ce.equals(CellType.NUMERIC)) {
				double d = c.getNumericCellValue();
				int a =(int)d;
				 value = Integer.toString(a);
				
				}
			System.out.print("     |     ");
			}
		System.out.println();
	}
	}
	
	public static String writeData(String sheetname,int row,int cell,String cellvalue) throws IOException {
        File f = new File((System.getProperty("user.dir") + "/DataDriven/MAkeMyTrip.xlsx"));
		
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.createSheet(sheetname);
		Row r = s.createRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(cellvalue);
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		w.close();
		
		return value;
	}
	public static void createSheet(String sheetname ) throws IOException {
        File f = new File((System.getProperty("user.dir") + "/DataDriven/MAkeMyTrip.xlsx"));
		
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.createSheet(sheetname);
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		w.close();
		
		

	}
	public static String write(String sheetname,int row,int cell,String cellvalue) throws IOException {
        File f = new File((System.getProperty("user.dir") + "/DataDriven/MAkeMyTrip.xlsx"));
		
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheetname);
		Row r = s.createRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(cellvalue);
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		w.close();
		return value;

	}


	
}
