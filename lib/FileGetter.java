import java.io.File ;
import java.io.IOException ;

public class FileGetter{

  private File getStaticFilesDirectory(){
    File currentParentDirectory = new File (
      System.getProperty("user.dir") 
    ).getParentFile();

    File staticFilesDirectory = new File (
      currentParentDirectory , "static_files"
    );

    return staticFilesDirectory ;
  }
 
  private File get404file (){
    return new File( getStaticFilesDirectory() , "404.html" ) ;
  }
 
  private File preventTraversal( File fileToReturn ) {
    try {
      String canonicalPath  = fileToReturn.getCanonicalPath() ;
      String absolutePath   = fileToReturn.getAbsolutePath()  ;

      if( ! canonicalPath.equals(absolutePath) ) {
        Logger.warn("Prevent directory traversal:" + canonicalPath ) ;
        return get404file(); 
      }
      return fileToReturn ;
    }
    catch( IOException err ) {
      Logger.error(err.toString()) ;
      return get404file(); 
    }
  } 

  private File preventFileDoesNotExist( File fileToReturn ) {
    if( !fileToReturn.exists() || fileToReturn.isDirectory() ) {
      Logger.warn("Prevent fileDoesNotExist:" + fileToReturn.getName() ) ;
      Logger.warn("Prevent fileDoesNotExist:exists=" + fileToReturn.exists() ) ;
      Logger.warn("Prevent fileDoesNotExist:isDirectory=" + fileToReturn.isDirectory()) ;
      return get404file();
    } 
    return fileToReturn ;
  } 

  private File readFile( File fileToReturn ) {
    return fileToReturn ; 
  } 

  public File get( String fileName ) {

    if( !( fileName instanceof String) ) { 
      Logger.error("Bad fileName in FileGetter.get.") ;
      return get404file();
    }

    File fileToReturn = new File (
      getStaticFilesDirectory() , fileName 
    );

    return readFile(
      preventFileDoesNotExist(
        preventTraversal( fileToReturn )
      )
    );
  }
}
