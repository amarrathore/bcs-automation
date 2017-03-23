package verifyTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.BrowserUtilities;
import utilities.SeleniumUtilities;
import utilities.WebDriverFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Listeners(utilities.ScreenshotITest.class)
public class Testing extends WebDriverFactory {	

	@Test
	public void testScreenshot() {
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
			driver = BrowserUtilities.getBrowser(SeleniumUtilities.getProperties("browser"));
			driver.get(SeleniumUtilities.getProperties("URL"));			
			System.out.println("This method is working fine");
			Assert.assertTrue(false);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
