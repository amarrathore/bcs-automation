package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	public static void explicitWait_id(WebDriver driver, String locatorId, int timeUnit) {
		WebDriverWait explicitWait=new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id(locatorId)));
	}
	public static void explicitWait_className(WebDriver driver, String locatorId, int timeUnit) {
		WebDriverWait explicitWait=new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.className(locatorId)));
	}
	public static void explicitWait_name(WebDriver driver, String locatorId, int timeUnit) {
		WebDriverWait explicitWait=new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.name(locatorId)));
	}
	public static void explicitWait_linkText(WebDriver driver, String locatorId, int timeUnit) {
		WebDriverWait explicitWait=new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.linkText(locatorId)));
	}
	public static void explicitWait_tagName(WebDriver driver, String locatorId, int timeUnit) {
		WebDriverWait explicitWait=new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.tagName(locatorId)));
	}
	public static void explicitWait_partialLinkText(WebDriver driver, String locatorId, int timeUnit) {
		WebDriverWait explicitWait=new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(locatorId)));
	}
	public static void explicitWait_cssSelector(WebDriver driver, String locatorId, int timeUnit) {
		WebDriverWait explicitWait=new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorId)));
	}
	public static void explicitWait_xPath(WebDriver driver, String locatorId, int timeUnit) {
		WebDriverWait explicitWait=new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorId)));
	}
}
