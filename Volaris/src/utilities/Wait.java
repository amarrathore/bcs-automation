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
	public static WebDriver driver;
	public static WebDriverWait explicitWait;
	
	public static int timeUnitParsing() {
		int timeUnit = Integer.parseInt(SeleniumUtilities.getProperties("waitTimeUnit"));
		explicitWait = new WebDriverWait(driver, timeUnit);
		return timeUnit;
	}
	
	public static void explicitWaitId(WebDriver driver, String inspectElementId) {		
		Wait.timeUnitParsing();
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id(inspectElementId)));
	}
	
	public static void explicitWaitClassName(WebDriver driver, String inspectElementId) {
		Wait.timeUnitParsing();
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.className(inspectElementId)));
	}
	
	public static void explicitWaitName(WebDriver driver, String inspectElementId) {
		Wait.timeUnitParsing();
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.name(inspectElementId)));
	}
	
	public static void explicitWaitLinkText(WebDriver driver, String inspectElementId) {
		Wait.timeUnitParsing();
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.linkText(inspectElementId)));
	}
	
	public static void explicitWaitTagName(WebDriver driver, String inspectElementId) {
		Wait.timeUnitParsing();
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.tagName(inspectElementId)));
	}
	
	public static void explicitWaitPartialLinkText(WebDriver driver, String inspectElementId) {
		Wait.timeUnitParsing();
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(inspectElementId)));
	}
	
	public static void explicitWaitCssSelector(WebDriver driver, String inspectElementId) {
		Wait.timeUnitParsing();
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(inspectElementId)));
	}
	
	public static void explicitWaitXpath(WebDriver driver, String inspectElementId) {
		Wait.timeUnitParsing();
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(inspectElementId)));
	}
	
	public static void implicitWait(WebDriver driver) {
		int timeUnit = Integer.parseInt(SeleniumUtilities.getProperties("waitTimeUnit"));
		driver.manage().timeouts().implicitlyWait(timeUnit, TimeUnit.SECONDS);
	}
}
