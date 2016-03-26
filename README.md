This is a basic static fileserver written in Java. It's still a work in progress, especaily since we can't actually serve anything yet. However, it can pull files from the file system, while being smart enough to refuse to return directories, stop directory traversal attacks, and prevent crashing on requests for files that don't exist.

For now, to test, one has to naviage to the lib diectory and run... 
```bash
java Runner filePath 
```
...where filePath is replaced by the path to the file relative to static_files (e.g., "index.html" or "/subfolder/stuff.html"). Typing "/" will also alias to "index.html".

The "Runner" test has only been tested on Linux, but should work on OS X as well. It may work on Windows, but there are some manual path joins (for now) that may or may not play nicely with Windows.

It is a requirement that 404.html remain in static_files, but the server won't check to see whether or not it exists before attempting to move it. I intend to hard code a default page into the Java code that can be served if the user accidentally moves, deletes, or renames 404.html. 

The server also doesn't yet check for a lack of permissions to grab a file, so trapping for that case is still necessary.
