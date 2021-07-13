package patches.handler;

import java.io.File;

public class LocalFileHandler {

	public void scanLocalDirectory(String directoryName) {
	    File directory = new File(directoryName);

	    // Get all files from a directory.
	    File[] fileList = directory.listFiles();
	    if(fileList != null)
	        for (File file : fileList) {      
	            if (file.isFile()) {
	                System.out.println("file.getPatch(): +++++   " + file.getPath());
	            } else if (file.isDirectory()) {
	            	scanLocalDirectory(file.getAbsolutePath());
	            }
	        }
	    }
	}
