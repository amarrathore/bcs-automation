package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Screenshot_ITest implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		String location = ConfigFileReader.getLocator("screenshotLocation");
    	String methodName = result.getName().toString().trim();
    	ScreenShotFunction.takeScreenShot(location, methodName);
    }    
   
	public void onFinish(ITestContext context) { }
	public void onTestStart(ITestResult result) { }  
    public void onTestSuccess(ITestResult result) { }
    public void onTestSkipped(ITestResult result) { }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }
    public void onStart(ITestContext context) { }	
} 