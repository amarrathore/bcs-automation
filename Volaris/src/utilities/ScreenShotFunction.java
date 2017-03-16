package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotFunction extends DriverInheritedToScreenShotFunction{
	 public static void takeScreenShot(String location, String methodName) {
	    	String timeStamp = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss").format(new Date()) + "_";
	    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	         //This method will save the screenshot with test method name 
	            try {
					FileUtils.copyFile(scrFile, new File(location + timeStamp + methodName + ".png"));
					System.out.println("Saved screen shot in " + location + timeStamp);
				} catch (IOException e) {
					e.printStackTrace();
				}
	    }

}
