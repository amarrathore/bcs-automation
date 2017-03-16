package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;
/**
 * @author BCS Technology
 * 
 */
public class ConfigFileReader {
	public static File file;
	public static FileInputStream inputStream;
	public static Properties pro;
	
	@Test
	// This method will return value from config properties file.
	public static void readConfigFile() {
		try {
			// Creating file object to connect config file.
			file=new File(System.getProperty("user.dir") + "\\src\\config.properties");
			// Creating InputStream object to read data.
			inputStream=new FileInputStream(file);
			//Create Object of Properties Class.
			pro=new Properties();
			// Pass object reference inputStream to load method of Properties object.
			pro.load(inputStream);			
			inputStream.close();
		} catch (Exception e) {
			System.out.println("Config file couldn't be found");
			System.out.println(e.getMessage());
		}
	}
}
