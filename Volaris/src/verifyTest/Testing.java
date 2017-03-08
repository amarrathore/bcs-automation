package verifyTest;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Testing {
	
	WebDriver driver;
	@Test
	public void run(){
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.volaris.com/?culture=en-US&Flag=us");
		driver.manage().window().maximize();
		Reporter.log("Open URL");
		
	}
	
	
	

}
