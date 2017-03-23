package utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
/**
 * @author BCS Technology
 * 
 */
public class SeleUtility {
	public static File file;
	public static FileInputStream inputStream;
	public static XSSFWorkbook excelWorkBook;
	public static XSSFSheet excelWorkSheet;
	public static Properties property;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileOutputStream outputStream;
	
	public static String newFileLoaction = null;
	public static String fileName = null;
	public static String reportPath = null;
	public static String sheetName = "Details";

	
	public static File getFile(String fileLocation) {
		try {
			file = new File(fileLocation);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return file;
	}
	
	public static FileInputStream getInputSteam() {
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return inputStream;
	}	

    public static void setExcelFile(String fileLocation, String excelSheetName) throws IOException {
		SeleUtility.getFile(fileLocation);
		SeleUtility.getInputSteam();
		excelWorkBook = new XSSFWorkbook(inputStream);
		excelWorkSheet = excelWorkBook.getSheet(excelSheetName);
		Iterator<Row> iterator = excelWorkSheet.iterator();
		while (iterator.hasNext()) {
			Row currentRow = iterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				Object value = cellToType(cell);
				System.out.print("\t" + value);
			}
			System.out.println();
        }
		inputStream.close();
	}
	
    
    public static void setCellData(String result, XSSFRow newRow, int colNum, String FileTestData) throws Exception {
		cell = newRow.createCell(colNum);
		cell.setCellValue(result);
		SeleUtility.writeData(FileTestData);
	}
    
    public static void writeData(String newFileTestData) throws Exception {
		outputStream = new FileOutputStream(newFileTestData);
		excelWorkBook.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}
    
    public static void setStaticCellData(String result, int rowNum, int colNum, String newFileTestData) throws Exception {
		try {
			row = excelWorkSheet.getRow(rowNum);
			cell = row.getCell(colNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(result);
			} else {
				cell.setCellValue(result);
			}
			outputStream = new FileOutputStream(newFileTestData);
			excelWorkBook.write(outputStream);
			XSSFFormulaEvaluator.evaluateAllFormulaCells(excelWorkBook);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			throw (e);
		}
	}
    
    public static void setPathForResultUpdate(String sheetName, String testStartDate, String timeZone, String browserInfo, String OSInfo) {
    	String reportPath = newFileLoaction + fileName;
    	try {
			SeleUtility.setExcelFile(reportPath, sheetName);
			//Log.info("Writing Test Details in " + sheetName);
			int rowNo = 2, colNo = 6;
			SeleUtility.setStaticCellData(testStartDate, rowNo, colNo, reportPath);
			rowNo = rowNo + 1;
			SeleUtility.setStaticCellData(timeZone, rowNo, colNo, reportPath);
			rowNo = rowNo + 1;
			SeleUtility.setStaticCellData(browserInfo,rowNo, colNo, reportPath);
			rowNo = rowNo + 1;
			SeleUtility.setStaticCellData(OSInfo, rowNo, colNo, reportPath);
			//Log.info("Sucess Updating Details for " + sheetName);			
		} catch (Exception e) {
			e.printStackTrace();
			//Log.error("Error Updating Details for " + sheetName + e.toString().substring(0,10));
		}
		return;
    }
    
    
    
    
    
    
	public static int getRowCount() {
		int rowCount = excelWorkSheet.getLastRowNum()-1;
		return rowCount;
	}
	
	public static int getColCount() {
		int colCount = excelWorkSheet.getRow(getRowCount()).getLastCellNum();
		return colCount;
	}
    
    public static Object cellToType(Cell cell) {
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
    
	public static String getProperties(String locatorName) {
		try {
			SeleUtility.getFile(System.getProperty("user.dir") + "/src/config.properties");
			SeleUtility.getInputSteam();
			property = new Properties();
			property.load(inputStream);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return property.getProperty(locatorName);
	}
	
	public static void captureScreenshot(ITestResult result, WebDriver driver) throws WebDriverException, Exception {
		String location = SeleUtility.getProperties("screenshotLocation");
    	String methodName = result.getName().toString().trim();    	
    	String timeStamp = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss").format(new Date()) + "_";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 	try {
	 		FileUtils.copyFile(sourceFile, new File(location + timeStamp + methodName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
} 