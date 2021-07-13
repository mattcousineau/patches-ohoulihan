package patches.helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesFileHelper {

	Map<String, String> results = new HashMap<>();
	InputStream inputStream;
	
	public Map<String, String> getPropertyValues() throws IOException {
		
		try {
			Properties prop = new Properties();
			String propFileName = "resources/config.properties";
			
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + " not found...");
			}
			
			results.put("patchfileurl", prop.getProperty("patchfileurl"));
			results.put("fileserverurl", prop.getProperty("fileserverurl"));
			results.put("saltword", prop.getProperty("saltword"));

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return results;
	}
}
