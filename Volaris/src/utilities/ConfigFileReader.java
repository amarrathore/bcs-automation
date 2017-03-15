package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileReader {
	public static FileInputStream inputStream;
	public static Properties property;
	
	// This method will return value from config properties file.
	public static String readConfigFile(String propertyHeader)
	{
		try {
			// Creating InputStream object to read data.
			inputStream=new FileInputStream(System.getProperty("user.dir") + "config.properties");
			//Create Object of Properties Class.
			property=new Properties();
			// Pass object reference inputStream to load method of Properties object.
			property.load(inputStream);
		} catch (Exception e) {
			System.out.println("Config file couldn't be found");
			System.out.println(e.getMessage());
		}
		return property.getProperty(propertyHeader);
	}
}
