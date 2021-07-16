package patches.handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import patches.helper.ChecksumHelper;

public class LocalFileHandler {

	public void scanLocalDirectory(String baseDirectory, String directoryName, List<String> fileNameList) throws NoSuchAlgorithmException, FileNotFoundException, IOException {
	    File directory = new File(directoryName);

	    File[] fileList = directory.listFiles();
	    
	    if (fileList != null) {
	        for (File file : fileList) {      
	            if (file.isFile()) {
	                System.out.println("processLocalPatchFile: Adding file path to fileList: " + file.getPath());
	            	fileNameList.add(file.getPath().replace(baseDirectory, "") + "$" + ChecksumHelper.createFileChecksum(file.getAbsolutePath()));
	            } else if (file.isDirectory()) {
	            	scanLocalDirectory(baseDirectory, file.getAbsolutePath(), fileNameList);
	            }
	        }   
	    }
	}
}

