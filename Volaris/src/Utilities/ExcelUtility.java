package Utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	//create reference of XSSF class.
	
	public static XSSFSheet ExcelWSheet;

	public static XSSFWorkbook ExcelWBook;

	public static XSSFCell Cell;

	public static XSSFRow Row;


	public static void setExcelFile(String sPath, String sSheetName)
			throws Exception {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(sPath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(sSheetName);

		} catch (Exception e) {

			throw (e);

		}

	}// End of setExcelFile

	public static XSSFRow getRow(int iRowNum) {

		return ExcelWSheet.createRow(iRowNum);

	}// End of getRow

	// This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num.

	public static String getCellData(int iRowNum, int iColNum) throws Exception {

		try {
			Cell = ExcelWSheet.getRow(iRowNum).getCell(iColNum);
			String CellData = Cell.getStringCellValue();
			
			return CellData;

		} catch (Exception e) {
			return "";
		}

	}// End of getCellData

	// This method is to write in the Excel cel

	public static void setCellData(String sResult, XSSFRow newRow, int iColNum,
			String File_TestData) throws Exception {

		XSSFCell Cell = newRow.createCell(iColNum);
		Cell.setCellValue(sResult);

	}
}
