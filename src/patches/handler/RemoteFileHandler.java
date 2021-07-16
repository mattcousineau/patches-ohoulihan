package patches.handler;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
	
    public static void downloadMissingRemoteFile(URL url, String fileName) throws IOException {
    	System.out.println("url is " + url.getPath());
    	File yourFile = new File(fileName);
    	yourFile.getParentFile().mkdirs();
    	yourFile.createNewFile();
        try (InputStream in = url.openStream();
                BufferedInputStream bis = new BufferedInputStream(in);
                FileOutputStream fos = new FileOutputStream(fileName)) {
        	System.out.println("Trying to write file from " + url.getPath() + " to " + fileName);
            byte[] data = new byte[1024];
            int count;
            while ((count = bis.read(data, 0, 1024)) != -1) {
                fos.write(data, 0, count);
            }
        } catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void downloadAndExtractZipFile() {
    	//download zip file
    	//extract it
    }
    
	private InputStream getRemotePatchFileFromURL(String patchFileUrl) throws IOException {
		URL url = new URL(patchFileUrl);
		InputStream inputStream = url.openStream();
		
		return inputStream;
	}
	
	private void getRemotePatchFileFromFTP() {
		
	}
}
