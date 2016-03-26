import java.io.File ;

public class Controller {

  public Controller() {
  } 

  public File route( String path) {
    if ( !(path instanceof String )) { 
      return new FileGetter().get( "404.html" );  
    }


    Logger.info( "path="+path) ;
    path = path.equals("/") ? "index.html" : path ;
    Logger.info( "path="+path) ;

    return (new FileGetter().get( path )) ;  
  }
}
