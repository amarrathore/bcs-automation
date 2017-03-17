package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
/**
 * @author BCS Technology
 * 
 */
public class CrossBrowsers {
	public static WebDriver driver;
	// Here this parameters we will take from testng.xml
	//@Parameters ("browser")
	// Passing browser parameter from TestNG xml.
	@Test
	public static void StartBrowser(String Browser) {
		// If the browser is Firefox, then do this
		if(Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}// If browser is googleChrome, then do this
		else if (Browser.equalsIgnoreCase("googleChrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}// If browser is IE, then do this
		else if (Browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}
}
