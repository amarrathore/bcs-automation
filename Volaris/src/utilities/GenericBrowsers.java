package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GenericBrowsers {
	//@Parameters ("browser")
	static WebDriver driver;
	// Passing browser parameter from TestNG xml.
	public static WebDriver StartBrowser(String webURL){
		String Browser = ConfigFileReader.getLocator("browser");
		try {
			// If the browser is Firefox, then do this
			if(Browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			// If browser is googleChrome, then do this
			else if (Browser.equalsIgnoreCase("googleChrome")) {
				System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
				driver = new ChromeDriver();
			}
			// If browser is IE, then do this
			else if (Browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			//lauch the Website
			driver.get(webURL);			
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
