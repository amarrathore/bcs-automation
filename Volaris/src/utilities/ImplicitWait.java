package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class ImplicitWait {

	public static void implicitWait(WebDriver driver, int timeUnit, TimeUnit timeUnitName)
	{
		driver.manage().timeouts().implicitlyWait(timeUnit, timeUnitName);
	}
}
