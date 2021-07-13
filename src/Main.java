import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import patches.common.Constants;
import patches.handler.LocalFileHandler;
import patches.handler.RemoteFileHandler;
import patches.helper.PropertiesFileHelper;

public class Main {
	
	public static void main(String[] args) throws IOException {
		PropertiesFileHelper properties = new PropertiesFileHelper();
		Map<String, String> configs = properties.loadPropertyValues();
		
		RemoteFileHandler remoteFileHandler = new RemoteFileHandler();
		List<String> remoteFileNameList = remoteFileHandler.processRemotePatchFile(configs);
		
		LocalFileHandler localFileHandler = new LocalFileHandler();
	    List<String> localFileNameList = new ArrayList<String>();
		localFileHandler.scanLocalDirectory(configs.get(Constants.LOCAL_FILE_DIRECTORY), localFileNameList);
		
		localFileHandler.negotiateFileDifferences(remoteFileNameList, localFileNameList);
		
		System.out.println(configs);
	}
	
}
