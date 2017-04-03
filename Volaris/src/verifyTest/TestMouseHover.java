package verifyTest;


import org.testng.annotations.Test;
import utilities.BrowserUtilities;
import utilities.SeleniumUtilities;
import utilities.WebDriverFactory;

public class TestMouseHover extends WebDriverFactory {
	@Test
	public void test() throws Exception {
		driver = BrowserUtilities.getBrowser(SeleniumUtilities.getProperties("browser"));
		driver.get(SeleniumUtilities.getProperties("URL"));
		driver.manage().window().maximize();
		
	}
	

}
