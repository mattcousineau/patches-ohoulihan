# patches-ohoulihan
A basic file patching service to be utilized in another project of mine.


# TODO:
(complete - 30 min) -Create config file with patchfileurl, remoteserverurl, saltword

(complete - 30 min) -Read config file into data structure for use in application

(complete - 30 min) -Connection to remote URLs

(complete - 30 min) -Read file from patchfileurl

(complete - 45 min) -Local directory reading

(complete - 30 min) -Negotiate differences beteen patchfileurl and local directory 

(in process - 45 min) -Download different files  (currently going to use name -then checksum compare later) 

-build a separate project to build the initial patch file from source local directory  (use relative filepaths and then update this program to use them)

-Add checksum capabiltiies (this will need to be broken out into smaller chunks)

-clean up tasks (remove localdirectory variables in favor of relative paths)

**nice to have** - if there is nothing installed, download a zip instead of independent files and extract
