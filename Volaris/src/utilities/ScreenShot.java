package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot{
	
	/*
	 * This method is used for taking screenshot.
	 */
	public static void TakeScreenShot(WebDriver driver, String location){
		
		String timeStamp=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss").format(new Date())+".jpg";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		try{			
			//Save file into specified location.			 
			FileUtils.copyFile(sourceFile, new File(location+timeStamp));
			System.out.println("Screenshot captured successfully");
		}
		catch (IOException e){
			e.printStackTrace();
			System.out.println("error saving screenshot file");
		}
	}
}
