package patches.helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import patches.common.Constants;

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
			
			results.put(Constants.PATCH_FILE_URL, prop.getProperty(Constants.PATCH_FILE_URL));
			results.put(Constants.REMOTE_FILESERVER_URL, prop.getProperty(Constants.REMOTE_FILESERVER_URL));
			results.put(Constants.SALT_WORD, prop.getProperty(Constants.SALT_WORD));

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return results;
	}
}
