package verifyTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.BrowserUtilities;
import utilities.MouseEvent;
import utilities.SeleniumUtilities;
import utilities.WebDriverFactory;

public class TestMouseHover extends WebDriverFactory {
	@Test
	public void test() throws Exception {
		driver = BrowserUtilities.getBrowser(SeleniumUtilities.getProperties("browser"));
		driver.get(SeleniumUtilities.getProperties("URL"));
		driver.manage().window().maximize();
		driver.findElement(By.className("dropdown-toggle")).click();;
		String inspectID = "JMeter Tutorials";
		System.out.println(MouseEvent.options(inspectID).getText());
	}
	

}
