import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import patches.common.Constants;
import patches.handler.LocalFileHandler;
import patches.handler.RemoteFileHandler;
import patches.helper.PropertiesFileHelper;

public class PatchingProcessor {

	public void process() {

		try {
			PropertiesFileHelper properties = new PropertiesFileHelper();
			Map<String, String> configs = properties.loadPropertyValues();	
			RemoteFileHandler remoteFileHandler = new RemoteFileHandler();
			List<String> remoteFileNameList = remoteFileHandler.processRemotePatchFile(configs);
			
			LocalFileHandler localFileHandler = new LocalFileHandler();
		    List<String> localFileNameList = new ArrayList<String>();
			localFileHandler.scanLocalDirectory(System.getProperty("user.dir"), System.getProperty("user.dir"), localFileNameList);
			
			negotiateFileDifferences(configs.get(Constants.REMOTE_FILESERVER_URL), System.getProperty("user.dir"), remoteFileNameList, localFileNameList);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			}
	
	public void negotiateFileDifferences(String remoteDirectory, String localDirectory, List<String> remoteFileNameList, List<String> localFileNameList) {
		if (remoteFileNameList.hashCode() == localFileNameList.hashCode()) {
			System.out.println("hash codes of the remote and local file lists match");
			return;
		}
		
		remoteFileNameList.removeAll(localFileNameList);
		if (remoteFileNameList.size() > 0) {
			for (String remoteFile : remoteFileNameList) {
				try {
					String localFile = remoteFile.split("\\$",2)[0];
					remoteFile = remoteFile.split("\\$",2)[0].replace("\\", "/");
					RemoteFileHandler.downloadMissingRemoteFile(new URL(remoteDirectory + remoteFile), localDirectory + localFile);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
