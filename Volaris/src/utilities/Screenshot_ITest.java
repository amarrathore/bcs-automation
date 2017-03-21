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

public class Screenshot_ITest implements ITestListener {
	WebDriver driver;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String location = SeleniumUtilities.getProperties("screenshotLocation");
    	String methodName = result.getName().toString().trim();
    	String timeStamp = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss").format(new Date()) + "_";
    	
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 	try {
		 		FileUtils.copyFile(sourceFile, new File(location + timeStamp + methodName + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub		
	}	
		
} 