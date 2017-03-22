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
public class BrowserUtilities extends WebDriverFactory {
	
	public static WebDriver getBrowser(String browser) throws Exception {
		try {
			switch(browser) {
			case "firefox":
				return firefoxBrowser();
			case "chrome":
				return chromeBrowser();
			case "IE":
				return IEBrowser();
			default:
				throw new Exception("Browser is not correct");
			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public static WebDriver firefoxBrowser() {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("xyzProfile");
		DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();
		firefoxCapabilities.setCapability("unexpectedAlertBehaviour", "ignore");
		firefoxCapabilities.setCapability(ChromeOptions.CAPABILITY, myprofile);
		System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		return driver = new FirefoxDriver(firefoxCapabilities);
	}
	
	public static WebDriver chromeBrowser() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--ignore-certificate-errors");
		option.addArguments("--disable-bundled-ppapi-flash");
		option.addArguments("--disable-extensions");
		option.addArguments("--disable-web-security");
		option.addArguments("--always-authorize-plugins");
		option.addArguments("--allow-running-insecure-content");
		option.addArguments("--test-type");
		option.addArguments("--enable-npapi");
		DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
		chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, option);
		chromeCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		return driver = new ChromeDriver(chromeCapabilities);
	}
	
	public static WebDriver IEBrowser() {
		DesiredCapabilities IECapabilities = DesiredCapabilities.internetExplorer();		  
		IECapabilities.setCapability("enablePersistentHover", false);
		IECapabilities.setCapability("ignoreZoomSetting", true);
		IECapabilities.setCapability("nativeEvents", false);
		IECapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
		return driver = new InternetExplorerDriver(IECapabilities);
	}
}
