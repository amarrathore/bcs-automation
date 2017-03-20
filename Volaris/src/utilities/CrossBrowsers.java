package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author BCS Technology
 * 
 */
public class CrossBrowsers {
	static WebDriver driver;
	@Test
	// Passing browser parameter from TestNG xml.	
	@Parameters("browser")
	public static void StartBrowser(String browser) throws Exception {	
			try {
				// If the browser is Firefox, then do this
				if(browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
					driver = new FirefoxDriver();					
				}
				// If browser is googleChrome, then do this
				else if (browser.equalsIgnoreCase("googleChrome")) {
					System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				// If browser is IE, then do this
				else if (browser.equalsIgnoreCase("IE")) {
					System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}
				else{
				// If no browser passed throw exception
					throw new Exception("Browser is not correct");
				}
				driver.get(ConfigFileReader.getLocator("URL"));
			} catch (WebDriverException e) {
				e.printStackTrace();
			}
			driver .get(ConfigFileReader.getLocator("URL"));
	}

	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
