package patches.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import patches.common.Constants;

public class RemoteFileHandler {

	public void processRemotePatchFile(Map<String, String> configs) throws IOException {
		InputStream patchStream = getRemotePatchFileFromURL(configs.get(Constants.PATCH_FILE_URL));
		//do stuff
		BufferedReader br = new BufferedReader(new InputStreamReader(patchStream));
		
		String line;
		while ((line = br.readLine()) != null) {
			//TODO: compare this line tp local directory file for file and see if they match up.  If they don't, download file
			System.out.println("line +++++" + line);
		}
		patchStream.close();
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
