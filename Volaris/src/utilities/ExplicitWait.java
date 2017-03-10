package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	public static void explicitWait(WebDriver driver, String locatorId, int timeUnit)
	{
		WebDriverWait explicitWait=new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id(locatorId)));
		//explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorId)));
	}

}
