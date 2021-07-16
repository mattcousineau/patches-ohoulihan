package patches.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.security.NoSuchAlgorithmException;

import patches.utils.MD5;

public class ChecksumHelper {

	public static String createFileChecksum(String filePath) throws NoSuchAlgorithmException, FileNotFoundException, IOException {
		String hash = MD5.asHex(MD5.getHash(new File(filePath)));
		return hash;
	}
}
