package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	public static void explicitWaitId(WebDriver driver, String locatorId, int timeUnit) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id(locatorId)));
	}
	
	public static void explicitWaitClassName(WebDriver driver, String locatorId, int timeUnit) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.className(locatorId)));
	}
	
	public static void explicitWaitName(WebDriver driver, String locatorId, int timeUnit) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.name(locatorId)));
	}
	
	public static void explicitWaitLinkText(WebDriver driver, String locatorId, int timeUnit) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.linkText(locatorId)));
	}
	
	public static void explicitWaitTagName(WebDriver driver, String locatorId, int timeUnit) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.tagName(locatorId)));
	}
	
	public static void explicitWaitPartialLinkText(WebDriver driver, String locatorId, int timeUnit) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(locatorId)));
	}
	
	public static void explicitWaitCssSelector(WebDriver driver, String locatorId, int timeUnit) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorId)));
	}
	
	public static void explicitWaitXpath(WebDriver driver, String locatorId, int timeUnit) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorId)));
	}
	
	public static void implicitWait(WebDriver driver, int timeUnit, TimeUnit timeUnitName) {
		driver.manage().timeouts().implicitlyWait(timeUnit, timeUnitName);
	}
}
