package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public static void TakeScreenShot(WebDriver driver, String sLocation)
			throws Exception {
		String sTimeStamp=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss").format(new Date())+".jpg";
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		try {
			//Save file into specified location.
			FileUtils.copyFile(scrFile, new File(sLocation+sTimeStamp));
			System.out.println("Screenshot captured successfully");
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("error saving screenshot file");
		}
	}
}
