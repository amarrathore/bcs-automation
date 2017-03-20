package utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author BCS Technology
 * 
 */
public class Wait {
	public static void explicitWaitId(WebDriver driver, String inspectElementId) {
		int timeUnit = Integer.parseInt(ConfigFileReader.getLocator("waitTimeUnit"));
		WebDriverWait explicitWait = new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id(inspectElementId)));
	}
	
	public static void explicitWaitClassName(WebDriver driver, String inspectElementId) {
		int timeUnit = Integer.parseInt(ConfigFileReader.getLocator("waitTimeUnit"));
		WebDriverWait explicitWait = new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.className(inspectElementId)));
	}
	
	public static void explicitWaitName(WebDriver driver, String inspectElementId) {
		int timeUnit = Integer.parseInt(ConfigFileReader.getLocator("waitTimeUnit"));
		WebDriverWait explicitWait = new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.name(inspectElementId)));
	}
	
	public static void explicitWaitLinkText(WebDriver driver, String inspectElementId) {
		int timeUnit = Integer.parseInt(ConfigFileReader.getLocator("waitTimeUnit"));
		WebDriverWait explicitWait = new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.linkText(inspectElementId)));
	}
	
	public static void explicitWaitTagName(WebDriver driver, String inspectElementId) {
		int timeUnit = Integer.parseInt(ConfigFileReader.getLocator("waitTimeUnit"));
		WebDriverWait explicitWait = new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.tagName(inspectElementId)));
	}
	
	public static void explicitWaitPartialLinkText(WebDriver driver, String inspectElementId) {
		int timeUnit = Integer.parseInt(ConfigFileReader.getLocator("waitTimeUnit"));
		WebDriverWait explicitWait = new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(inspectElementId)));
	}
	
	public static void explicitWaitCssSelector(WebDriver driver, String inspectElementId) {
		int timeUnit = Integer.parseInt(ConfigFileReader.getLocator("waitTimeUnit"));
		WebDriverWait explicitWait = new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(inspectElementId)));
	}
	
	public static void explicitWaitXpath(WebDriver driver, String inspectElementId) {
		int timeUnit = Integer.parseInt(ConfigFileReader.getLocator("waitTimeUnit"));
		WebDriverWait explicitWait = new WebDriverWait(driver, timeUnit);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(inspectElementId)));
	}
	
	public static void implicitWait(WebDriver driver) {
		int timeUnit = Integer.parseInt(ConfigFileReader.getLocator("waitTimeUnit"));
		driver.manage().timeouts().implicitlyWait(timeUnit, TimeUnit.SECONDS);
	}
}
