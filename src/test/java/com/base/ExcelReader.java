package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	private FileInputStream fis;
	private FileOutputStream fos;
	private Workbook book;
	private Sheet sh;
	private Cell cell;
	private Row row;
	private CellStyle cellStyle;
	private String excelFilePath;
	private Map<String, Integer> columns = new HashMap<>();

	public void setExcelFile(String ExcelPath, String SheetName) throws Exception {
		try {
			File file = new File(ExcelPath);
			book = WorkbookFactory.create(file);
			sh = book.getSheet(SheetName);
			this.excelFilePath = ExcelPath;
			//adding all the column header names to the map
			sh.getRow(0).forEach(cell ->{
				columns.put(cell.getStringCellValue(), cell.getColumnIndex());
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("incomplete-switch")
	public String getCellData(int rownum, int colnum) throws Exception {
		try {
			cell = sh.getRow(rownum).getCell(colnum);
			String cellData = null;
			switch(cell.getCellType()) {
			case STRING:
				cellData = cell.getStringCellValue();
				break;
			case NUMERIC:
				if(DateUtil.isCellDateFormatted(cell)) {
					cellData = String.valueOf(cell.getDateCellValue());
				}else {
					cellData = String.valueOf((long)cell.getNumericCellValue());
				}
				break;
			case BOOLEAN:
				cellData = Boolean.toString(cell.getBooleanCellValue());
				break;
			case BLANK:
				cellData = "";
				break;
			}
			return cellData;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			return"";
		}
	}
	
	public String getCellData(String columnName, int rownum) throws Exception {
		return getCellData(rownum, columns.get(columnName));
	}
	
	public static void main (String[] args) throws Exception {
		ExcelReader excel = new ExcelReader();
		excel.setExcelFile("src//test//resources//TestData.xlsx", "Sheet1");
		System.out.println(excel.getCellData("FullName", 1));
		System.out.println(excel.getCellData("Email", 1));
		System.out.println(excel.getCellData("Telephone", 1));
		System.out.println(excel.getCellData(0, 0));
		System.out.println(excel.getCellData(0, 1));
	}

}
