# patches-ohoulihan
A basic file patching service to be utilized in another project of mine.

# Instructions
Configure the application variables in `config.properties`.
1. `patchfileurl` is the location of the patch .txt file generated with patch-adams
2. `fileserverurl` is where you keep the master file copies to be downloaded (don't use any slashes at end of URL)
3. `saltword` is currently un-used, but you can add it to the hashing function for more security
4. `localfiledirectory` is un-used, but may be helpful to use for testing in external directories
5. `fileretryattempts` is un-used, but will be added in the near future

Compile and run patches-ohoulihan.jar in any folder you wish to check the contents against the `patchfileurl` file.  
It will:
1. Use the same algorithm to compile the local file checksums as was used to compile the remote file checksum list
2. Compare the local vs. the remote
3. Download any files that are different

It will not: 
1. Delete any exisitng files that don't exist in the `patchfileurl` file (this is useful for saving user profiles, custom settings, etc.)

# TODO:
-ability to configure URL or FTP and add FTP processing

**nice to have** - if there is nothing installed, download a zip instead of independent files and extract

**nice to have** - retry on failed download

# Credit
I borrowed the 'Fast MD5' implementation from http://www.twmacinta.com/myjava/fast_md5.php .
