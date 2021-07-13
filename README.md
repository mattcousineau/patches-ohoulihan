# patches-ohoulihan
A basic file patching service to be utilized in another project of mine.


# TODO:
(complete - 30 min) -Create config file with patchfileurl, remoteserverurl, saltword

(complete - 30 min) -Read config file into data structure for use in application

(complete - 30 min) -Connection to remote URLs

(complete - 30 min) -Read file from patchfileurl

(in process) -Local directory reading

-Negotiate differences beteen patchfileurl and local directory 

-Download different files  (currently going to use name -then checksum compare later) 

-Add checksum capabiltiies (this will need to be broken out into smaller chunks)

-build a separate project to build the initial patch file from source local directory
