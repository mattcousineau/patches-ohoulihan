package patches.handler;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class RemoteFileHandler {

	public void processRemotePatchFile(Map<String, String> configs) throws IOException {
		InputStream patchStream = getRemotePatchFileFromURL(configs.get("patchfileurl"));
		//do stuff
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
