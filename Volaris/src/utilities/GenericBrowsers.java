package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author BCS Technology
 * 
 */
public class GenericBrowsers {	
	static WebDriver driver;
	// Passing browser parameter from TestNG xml.
	public static WebDriver StartBrowser(String webURL) throws Exception {
		String browser = ConfigFileReader.getLocator("firefoxBrowser");
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
			// lauch the Website
			driver.get(webURL);
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public static void main(String[] args) throws Exception {
		GenericBrowsers.StartBrowser(ConfigFileReader.getLocator("URL"));
		driver.close();
	}
}
