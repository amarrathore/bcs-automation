package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author BCS Technology
 * 
 */
public class SelectBrowser {
	
	
	public static WebDriver StartBrowser(String browser, WebDriver driver) throws Exception {
		try {
			switch(browser) {
			case "firefox":
				ProfilesIni profile = new ProfilesIni();
				FirefoxProfile myprofile = profile.getProfile("xyzProfile");				
				DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();
				firefoxCapabilities.setCapability("unexpectedAlertBehaviour", "ignore");
				firefoxCapabilities.setCapability(ChromeOptions.CAPABILITY, myprofile);
				System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
				driver = new FirefoxDriver(firefoxCapabilities);
				break;
			case "chrome":
				ChromeOptions opt = new ChromeOptions();
				opt.addArguments("--ignore-certificate-errors");
				opt.addArguments("--disable-bundled-ppapi-flash");
				opt.addArguments("--disable-extensions");
				opt.addArguments("--disable-web-security");
				opt.addArguments("--always-authorize-plugins");
				opt.addArguments("--allow-running-insecure-content");
				opt.addArguments("--test-type");
				opt.addArguments("--enable-npapi");
				DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
				chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, opt);
				chromeCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);				
				System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
				driver = new ChromeDriver(chromeCapabilities);
				break;
			case "IE":
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();				  
				ieCapabilities.setCapability("enablePersistentHover", false);
				ieCapabilities.setCapability("ignoreZoomSetting", true);
				ieCapabilities.setCapability("nativeEvents", false);
				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
				driver = new InternetExplorerDriver(ieCapabilities);
				break;
			default:
				throw new Exception("Browser is not correct");
			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		driver.get(SeleniumUtilities.getProperties("URL"));
		return driver;
	}
}
