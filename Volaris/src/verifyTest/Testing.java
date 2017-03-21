package verifyTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.Screenshot_ITest;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Listeners(utilities.Screenshot_ITest.class)
public class Testing {
	
	static WebDriver driver;
	@Test
	public void testToFail() {
		/*PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
		//PropertyConfigurator.configure("log4j.properties");
		final Logger logInfo=Logger.getLogger(Testing.class);
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();
		logInfo.debug("debug");
		logInfo.info("info");
		logInfo.warn("warn");
		logInfo.error("error");
		logInfo.fatal("fatal");*/
		
		try {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://www.google.com");
			System.out.println("This method is working fine");
			Assert.assertTrue(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//onTestFailure(new ITestResult(),driver);
		}		
		driver.quit();
	}
}
