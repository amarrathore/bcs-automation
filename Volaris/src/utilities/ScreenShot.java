package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenShot implements ITestListener{
	WebDriver driver;
	/*
	 * This method is used for taking screenshot.
	 */
	public static void TakeScreenShot (WebDriver driver, String location){
		
		String timeStamp=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss").format(new Date())+".jpg";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		try{			
			//The below method will save the screenshot in the drive with test method name			 
			FileUtils.copyFile(sourceFile, new File(location+timeStamp));
			System.out.println("Screenshot captured successfully");
		}
		catch (IOException e){
			e.printStackTrace();
			System.out.println("error saving screenshot file");
		}
	}

	@Override
	public void onTestStart(ITestResult result) { }
	@Override
	public void onTestSuccess(ITestResult result) { }
	@Override
	public void onTestFailure(ITestResult result) { }
	@Override
	public void onTestSkipped(ITestResult result) { }
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }
	@Override
	public void onStart(ITestContext context) { }
	@Override
	public void onFinish(ITestContext context) { }
}
