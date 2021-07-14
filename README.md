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

(in process) -build a separate project to build the initial patch file from source local directory  (use relative filepaths and then update this program to use them)

--read source files into memory and create a checksum representation string

--write each checksum representation to a txt file

-Add checksum capabiltiies to patches-ohoulihan (this will need to be broken out into smaller chunks)

--read local files into memory and create checksum representation string

--compare to string in the patch file

--replace name check with above

-clean up tasks (remove localdirectory variables in favor of relative paths)

**nice to have** - if there is nothing installed, download a zip instead of independent files and extract
