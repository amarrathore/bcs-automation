package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author BCS Technology
 */

public class ExcelUtilities_cellData {
	public static File excel;
	public static FileInputStream excelFile;
	public static XSSFWorkbook excelWorkBook;
	public static XSSFSheet excelWorkSheet;
	public static XSSFRow row;
	public static XSSFCell cell;

    public static Object[][] setExcelFile(String fileLocation, int sheetNumber) throws IOException {
    	excel = new File(fileLocation);
    	excelFile = new FileInputStream(excel);
    	excelWorkBook = new XSSFWorkbook(excelFile);
    	excelWorkSheet = excelWorkBook.getSheetAt(sheetNumber);
    	int rowNum = excelWorkSheet.getLastRowNum() + 1;
    	int colNum = excelWorkSheet.getRow(0).getLastCellNum();
    	String[][] data = new String[rowNum][colNum];
    	for (int rowCount = 0; rowCount < rowNum; rowCount++) {
	    	row = excelWorkSheet.getRow(rowCount);
            for (int colCount = 0; colCount < colNum; colCount++) {
            	cell = row.getCell(colCount);
                String value = cellToString(cell);
                data[rowCount][colCount] = value;              
            }
        }
    	return data;
    }
    
	public static String cellToString(XSSFCell cell){
		int type;
		Object result;
		type = cell.getCellType();
		switch (type) {
			case Cell.CELL_TYPE_NUMERIC:
	        	//Numeric/Date Value in Excel File
	        	if (DateUtil.isCellDateFormatted(cell)) {
	                java.util.Date date = cell.getDateCellValue();
	                System.out.println(date);
	            } else {
	            	
	            }
	        	result = cell.getNumericCellValue();
	            break;
	        case Cell.CELL_TYPE_STRING:
	        	//String Value in Excel File	            
	        case Cell.CELL_TYPE_BOOLEAN:
	        	//Boolean Value in Excel File	        	
	        default:
	        	throw new RuntimeException("There is no support for this type of cell");                    
	    }
	    return result.toString();
	}
	
	public static String getExcelStringData() {
		String getExcelStringData = cell.getStringCellValue();
		return getExcelStringData;
	}
	
	public static double getExcelNumericData() {
		double getExcelNumericData = cell.getNumericCellValue();
		return getExcelNumericData;
	}
	
	public static boolean getExcelBooleanData() {
		boolean getExcelBooleanData = cell.getBooleanCellValue();
		return getExcelBooleanData;
	}
} 