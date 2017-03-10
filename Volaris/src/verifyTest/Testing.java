package verifyTest;

import org.testng.annotations.Test;

import utilities.Screenshot_ITest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {
	
	WebDriver driver;
	@Test
	public void run() throws Exception{
		/*PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
		//PropertyConfigurator.configure("log4j.properties");
		final Logger logInfo=Logger.getLogger(Testing.class);
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();
		logInfo.debug("debug");
		logInfo.info("info");
		logInfo.warn("warn");
		logInfo.error("error");
		logInfo.fatal("fatal");*/
		driver.get("https://www.volaris.com/?culture=en-US&Flag=us");
		driver.manage().window().maximize();
		
		
		driver.quit();
	}
}
