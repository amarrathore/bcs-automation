package verifyTest;

import org.testng.annotations.Test;
import utilities.SelectBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
@Listeners(utilities.Screenshot_ITest.class)

public class ScreenTest {
	WebDriver driver;
	@Parameters({"browser"})
	@Test
	public void TesttoFail(String browser) throws Exception {
		//String browser = SeleniumUtilities.getProperties("firefoxBrowser");		
		driver = SelectBrowser.StartBrowser(browser, driver);	
		//SeleniumUtilities.setExcelFile(SeleniumUtilities.getProperties("excelFileLocation"), 0);
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
		try{
		Runtime.getRuntime().exec("taskkill /F /IM 	chromeDriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
		} catch (Exception e) {
			}
	}
}
