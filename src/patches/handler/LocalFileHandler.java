package patches.handler;

import java.io.File;
import java.util.List;

public class LocalFileHandler {

	public void scanLocalDirectory(String directoryName, List<String> fileNameList) {
	    File directory = new File(directoryName);

	    // Get all file names from a directory.
	    File[] fileList = directory.listFiles();
	    
	    if(fileList != null) {
	        for (File file : fileList) {      
	            if (file.isFile()) {
	                System.out.println("processLocalPatchFile: Adding file path to fileList: " + file.getPath());
	            	fileNameList.add(file.getPath());
	            } else if (file.isDirectory()) {
	            	scanLocalDirectory(file.getAbsolutePath(), fileNameList);
	            }
	        }   
	    }
	}
	
	public void negotiateFileDifferences(List<String> remoteFileNameList, List<String> localFileNameList) {
		if (remoteFileNameList.size() == localFileNameList.size()) {
			System.out.println("Remote and Local FileNameList size matches");
		} else {
			System.out.println("FAILED: sizes:" + remoteFileNameList.size() + "  " + localFileNameList.size());
		}
		
		if (remoteFileNameList.hashCode() == localFileNameList.hashCode()) {
			System.out.println("Remote and Local FileNameList hashCodes match");
		} else {
			System.out.println("FAILED: hashCodes do not match!");
		}
	}
}
