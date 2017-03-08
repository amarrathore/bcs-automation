package utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author rakesh.garg
 * @version 1.0
 */

public class ReadExcel_R {
 static Object[][] completeData;

 //This method will read the excel file

 public static String ReadExcel(String sheetName, String location) {
  try {
   File fileName=new File(location);
   FileInputStream fileToRead = new FileInputStream(fileName);
   XSSFWorkbook workbook = new XSSFWorkbook(fileToRead);
   XSSFSheet sheet = workbook.getSheet(sheetName);
   
   int totalRows = sheet.getLastRowNum();
   int totalColumns = sheet.getRow(0).getLastCellNum();
   completeData = new Object[totalRows + 1][totalColumns];
    
   for (int row = 0; row <= totalRows-1; row++) {
    for (int column = 0; column <= totalColumns - 1;column++) {
     XSSFCell currentCell = sheet.getRow(row).getCell(column);
     
     int type;
     Object result;
     type = currentCell.getCellType();
     
     switch (type) {

     case Cell.CELL_TYPE_NUMERIC: //for numeric value
         result = currentCell.getNumericCellValue();
         break;
     case Cell.CELL_TYPE_STRING: // for String Value
         result = currentCell.getStringCellValue();
         break;
     case Cell.CELL_TYPE_BOOLEAN: //for boolean value
         result=currentCell.getBooleanCellValue();
         break;
     default:  
         throw new RuntimeException("There is no support for this type of cell");                        
 }
     return result.toString();
}
   }
  } catch (Exception e) {
   System.out.println("Excel file couldn't be read");
   System.out.println(e.getMessage());
  }
return "";
 }
}


