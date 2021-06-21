package make.my.trip.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	public static String readDataFromPropertiesFile(String value) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//config.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		return properties.getProperty(value);

	}
}
