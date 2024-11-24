package utils;

import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	//we made it private, so only Configuration class can call it
	private Properties properties = new Properties();
	
	public Configuration() { 
		loadProperty();
	}
	
	public void loadProperty() {
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Individual return type Parameterized method created
	public String getProperties(String KEY) {
		return properties.getProperty(KEY);
	}

}
