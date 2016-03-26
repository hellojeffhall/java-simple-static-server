public class Runner{

  public static void main( String[] args ) {

    if ( 
      args.length < 1              || 
      !(args[0] instanceof String)/* || 
      !(args[1] instanceof String) */
    ) {
      Logger.error("Incorrect arguments were given when Runner was called.");
      return ;
    } 
  
    String route = args[0] ; 

    Controller testController = new Controller() ;
    Logger.info("Runner:was-returned:" + testController.route( route ).toURI().toString()) ;
  }


}
