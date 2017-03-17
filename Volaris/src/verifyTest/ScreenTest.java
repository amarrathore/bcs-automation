package verifyTest;

import org.testng.annotations.Test;
import utilities.DriverInheritedToScreenShotFunction;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
@Listeners(utilities.Screenshot_ITest.class)

public class ScreenTest extends DriverInheritedToScreenShotFunction {
	
	@Test
	public void TesttoFail()
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.google.com");
		System.out.println("This method is working fine");
		Assert.assertTrue(false);
		
	}
}
