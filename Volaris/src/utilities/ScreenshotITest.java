package utilities;

import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotITest extends WebDriverFactory implements ITestListener {
	
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
		try {
			SeleniumUtilities.captureScreenshot(result, driver);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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