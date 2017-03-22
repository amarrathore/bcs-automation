package verifyTest;

import org.testng.annotations.Test;
import utilities.BrowserUtilities;
import utilities.SeleniumUtilities;
import utilities.WebDriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
@Listeners(utilities.ScreenshotITest.class)

public class ScreenTest extends WebDriverFactory {
	
	@Parameters({"browser"})
	@Test
	public void TesttoFail(String browser) throws Exception {
		//String browser= SeleniumUtilities.getProperties("browser");		
		driver = BrowserUtilities.getBrowser(browser);
		driver.get(SeleniumUtilities.getProperties("URL"));
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
		try{
			driver.quit();		
		/*Runtime.getRuntime().exec("taskkill /F /IM 	chromeDriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");*/
		/*Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
		Thread.sleep(5000);
		Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
		Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");*/
		} catch (Exception e) {
			e.printStackTrace();
			}
	}	
}
