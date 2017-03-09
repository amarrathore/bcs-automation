package utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * @author BCS Technology
 */

public class ExcelUtility {
	/*
	 * create reference of XSSF class.
	*/
	public static XSSFWorkbook excelWorkBook;
	public static XSSFSheet excelWorkSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static void setExcelFile(String path, int sheetName) throws Exception {
			//Open the Excel file
			FileInputStream excelFile = new FileInputStream(path);
			//Access the required test data sheet
			excelWorkBook = new XSSFWorkbook(excelFile);
			excelWorkSheet = excelWorkBook.getSheetAt(sheetName);
	}
	public static XSSFRow getRow(int rowNum) {
		return excelWorkSheet.createRow(rowNum);
	}
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num.
	public static String getCellData(int rowNum, int colNum) throws Exception {
		try {
			cell = excelWorkSheet.getRow(colNum).getCell(colNum);
			String cellData = cell.getStringCellValue();
			return cellData;
		} catch (Exception e) {
			return "";
		}
	}
	//This method is to write in the Excel cell
	public static void setCellData(String result, XSSFRow newRow, int colNum, String file_TestData) throws Exception {
		XSSFCell cell = newRow.createCell(colNum);
		cell.setCellValue(result);
	}
}
