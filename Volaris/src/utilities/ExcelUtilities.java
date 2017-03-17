package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
/**
 * @author BCS Technology
 * 
 */
public class ExcelUtilities {
	public static File excel;
	public static FileInputStream excelFile;
	public static XSSFWorkbook excelWorkBook;
	public static XSSFSheet excelWorkSheet;
	
	public static void setExcelFile(String fileLocation, int excelSheetNumber) throws IOException {		
    	// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream(fileLocation);
		// Access the required test data sheet
		excelWorkBook = new XSSFWorkbook(ExcelFile);
		excelWorkSheet = excelWorkBook.getSheetAt(excelSheetNumber);
		Iterator<Row> iterator = excelWorkSheet.iterator();
		while (iterator.hasNext()) {
			Row currentRow = iterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				Object value = cellToString(cell);
				System.out.print("\t" + value);
			}
			System.out.println();
        }
		excelFile.close();
	}
    
    public static Object cellToString(Cell cell) {
    	switch (cell.getCellType()) {
    	case Cell.CELL_TYPE_NUMERIC:
    		//Numeric/Date Value in Excel File
				if (DateUtil.isCellDateFormatted(cell)) {
	                return getExcelDateValue(cell);
	            } else {
	            	return getExcelNumericData(cell);
	            }			
		case Cell.CELL_TYPE_STRING:
			//String Value in Excel File
	        return getExcelStringData(cell);
		case Cell.CELL_TYPE_BOOLEAN:
			//Boolean Value in Excel File
	        return getExcelBooleanData(cell);
	        default:
	        return null;
	    }
	}
	
	public static double getExcelNumericData(Cell cell) {
		double getExcelNumericData = cell.getNumericCellValue();
		return getExcelNumericData;
	}
	
	private static Date getExcelDateValue(Cell cell) {
		Date getExcelDateData = cell.getDateCellValue();
		return getExcelDateData;
	}

	public static String getExcelStringData(Cell cell) {
		String getExcelStringData = cell.getStringCellValue();
		return getExcelStringData;
	}
	
	public static boolean getExcelBooleanData(Cell cell) {
		boolean getExcelBooleanData = cell.getBooleanCellValue();
		return getExcelBooleanData;
	}
} 