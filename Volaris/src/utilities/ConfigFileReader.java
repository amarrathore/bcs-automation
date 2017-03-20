package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
/**
 * @author BCS Technology
 * 
 */
public class ConfigFileReader {
	public static File file;
	public static FileInputStream inputStream;
	public static Properties locators;
	public static String getLocator(String locatorName) {
		try {
			file = new File(System.getProperty("user.dir") + "./config.properties");
			inputStream = new FileInputStream(file);
			locators = new Properties();
			locators.load(inputStream);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return locators.getProperty(locatorName);		
	}
}
