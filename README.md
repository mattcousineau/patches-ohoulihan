# patches-ohoulihan
A basic file patching service to be utilized in another project of mine.


# TODO:
(complete - 30 min) -Create config file with patchfileurl, remoteserverurl, saltword

(complete - 30 min) -Read config file into data structure for use in application

(complete - 30 min) -Connection to remote URLs

(complete - 30 min) -Read file from patchfileurl

(complete - 45 min) -Local directory reading

(complete - 30 min) -Negotiate differences beteen patchfileurl and local directory 

(complete - 45 min) -Download different files  (currently going to use name -then checksum compare later) 

(complete - 60 min) -build a separate project to build the initial patch file from source local directory  (use relative filepaths and then update this program to use them)
https://github.com/mattcousineau/patch-adams

(complete - 20 min)--read source files into memory and create a checksum representation string

(complete - 20 min)--write each checksum representation to a txt file


-Add checksum capabiltiies to patches-ohoulihan

--read local files into memory and create checksum representation string

--compare to string in the patch file

(complete 10 min) -replace placeholder name negotiation logic with above

-efficiency tasks (need to improve the checksum creation.  I/O is slooowwwwww

-ability to select URL or FTP and add FTP processing

**nice to have** - if there is nothing installed, download a zip instead of independent files and extract

**nice to have** - retry on failed download

-clean up tasks (remove localdirectory variables in favor of relative paths)
