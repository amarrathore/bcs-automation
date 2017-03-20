package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Screenshot_ITest implements ITestListener {

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
		String location = ConfigFileReader.getLocator("screenshotLocation");
    	String methodName = result.getName().toString().trim();
    	ScreenShotFunction.takeScreenShot(location, methodName);
		
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