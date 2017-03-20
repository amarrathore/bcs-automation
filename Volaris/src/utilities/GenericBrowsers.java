package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author BCS Technology
 * 
 */
public class GenericBrowsers {	
	static WebDriver driver;
	public static WebDriver StartBrowser(String webURL) throws Exception {
		String browser = ConfigFileReader.getLocator("firefoxBrowser");		
			if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else {	
				throw new Exception("Browser is not correct");
			}
		driver.get(webURL);		
		return driver;
	}
	
	public static void main(String[] args) throws Exception {
		GenericBrowsers.StartBrowser(ConfigFileReader.getLocator("URL"));
		driver.close();
	}
}
