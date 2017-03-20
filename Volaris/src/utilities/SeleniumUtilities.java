package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
/**
 * @author BCS Technology
 * 
 */
public class SeleniumUtilities {
	public static File file;
	public static FileInputStream inputStream;
	public static XSSFWorkbook excelWorkBook;
	public static XSSFSheet excelWorkSheet;
	public static Properties locators;
	
	public static File getFile(String fileLocation) {
		try {
			file = new File(fileLocation);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return file;
	}
	public static FileInputStream getInputSteam(File file) {
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return inputStream;
	}	
    
    public static Object cellToString(Cell cell) {
    	switch (cell.getCellType()) {
    	case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
                return getExcelDateValue(cell);
            } else {
            	return getExcelNumericData(cell);
            }		
		case Cell.CELL_TYPE_STRING:
	        return getExcelStringData(cell);
		case Cell.CELL_TYPE_BOOLEAN:
	        return getExcelBooleanData(cell);
	        default:
	        return null;
	    }
	}    
    
	public static String getLocator(String locatorName) {		
		try {
			SeleniumUtilities.getFile(System.getProperty("user.dir") + "./config.properties");
			SeleniumUtilities.getInputSteam(file);
			locators = new Properties();
			locators.load(inputStream);		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return locators.getProperty(locatorName);
	}
	
	public static int getRowCount() {
		int rowCount = excelWorkSheet.getLastRowNum();
		return rowCount;		
	}
	
	public static int getColCount() {
		return 0;
			
	}
    
    public static void setExcelFile(String fileLocation, int excelSheetNumber) throws IOException {
		SeleniumUtilities.getFile(fileLocation);
		SeleniumUtilities.getInputSteam(file);
		excelWorkBook = new XSSFWorkbook(inputStream);
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
		inputStream.close();
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
	
	public static void main(String[] args) throws IOException {
		//SeleniumUtilities.setExcelFile(ConfigFileReader.getLocator("excelFileLocation"), 0);
		System.out.println(SeleniumUtilities.getLocator("URL"));
	}
} 