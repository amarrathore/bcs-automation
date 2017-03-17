package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileReader {
	public static File file;
	public static FileInputStream inputStream;
	public static Properties locators;
	
	// This method will return value from config properties file.
	public static String getLocator(String locatorName) {
		try {
			// Creating file object to connect config file.
			file = new File(System.getProperty("user.dir") + "\\src\\config.properties");
			// Creating InputStream object to read data.
			inputStream = new FileInputStream(file);
			//Create Object of Properties Class.
			locators = new Properties();
			// Pass object reference inputStream to load method of Properties object.
			locators.load(inputStream);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return locators.getProperty(locatorName);		
	}
	
}
