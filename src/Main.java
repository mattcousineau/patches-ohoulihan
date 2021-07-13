import java.io.IOException;
import java.util.Map;

import patches.helper.PropertiesFileHelper;

public class Main {

	public static void main(String[] args) throws IOException {
		PropertiesFileHelper properties = new PropertiesFileHelper();
		Map<String, String> configs = properties.getPropertyValues();
		System.out.println(configs);
	}

}
