package Generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

		public static void takeScreenshot(WebDriver driver, String screenshotname) throws IOException
	{
		//It will capture screenshot.
		
			//create reference of Takescreenshot.
			TakesScreenshot capture=(TakesScreenshot)driver;
			File input=capture.getScreenshotAs(OutputType.FILE);
			//Save file to specified location then it will save in folder <Screenshots> of project directory.
			FileUtils.copyFile(input, new File("./Screenshots/"+screenshotname+".png"));
		
	}
}
