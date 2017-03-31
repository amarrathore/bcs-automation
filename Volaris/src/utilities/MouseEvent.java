package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseEvent extends WebDriverFactory {
	public static Actions action;
	public static WebElement element;
		
	public static WebElement options(String inspectID) {
		try {
			WebElement element = driver.findElement(By.linkText(inspectID));
			action = new Actions(driver);				
			action.moveToElement(element).click().build().perform();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
}
