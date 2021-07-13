package patches.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import patches.common.Constants;

public class RemoteFileHandler {

	public List<String> processRemotePatchFile(Map<String, String> configs) throws IOException {
		InputStream patchStream = getRemotePatchFileFromURL(configs.get(Constants.PATCH_FILE_URL));
		BufferedReader br = new BufferedReader(new InputStreamReader(patchStream));
		
	    List<String> fileNameList = new ArrayList<String>();
		String line;
		
		while ((line = br.readLine()) != null) {
            System.out.println("processRemotePatchFile: Adding file path to fileList: " + line);
			fileNameList.add(line);
		}
		
		patchStream.close();
		br.close();
		
		return fileNameList;
	}
	
	private InputStream getRemotePatchFileFromURL(String patchFileUrl) throws IOException {
		URL url = new URL(patchFileUrl);
		InputStream inputStream = url.openStream();
		
		return inputStream;
	}
	
	public void getFilesFromRemoteDirectory(String fileServerUrl) throws MalformedURLException {
		URL url = new URL(fileServerUrl);

	}
	//get server files
}
