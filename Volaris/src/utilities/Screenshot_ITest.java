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
	public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString();
    	takeScreenShot(driver, "location", methodName);
    }
    
    public void takeScreenShot(WebDriver driver, String location, String methodName) {
    	String timeStamp=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss").format(new Date())+".jpg";
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //This method will save the screenshot with test method name 
            try {
				FileUtils.copyFile(scrFile, new File(location+timeStamp + methodName + ".png"));
				System.out.println("Saved screen shot in " + location + timeStamp);
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
	public void onFinish(ITestContext context) { }
	public void onTestStart(ITestResult result) { }  
    public void onTestSuccess(ITestResult result) { }
    public void onTestSkipped(ITestResult result) { }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }
    public void onStart(ITestContext context) { }
}  