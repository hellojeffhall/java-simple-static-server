/**
*
* 20160325_2146h JRH
* A basic system for logging server information.
*
**/
public class Logger{

  public static void info( String input ) {
    System.out.println("Logger:info:" + input ) ;
  }
  public static void warn( String input ) {
    System.out.println("Logger:warn:" + input ) ;
  }
  public static void error( String input ) {
    System.out.println("Logger:error:" + input ) ;
  }

}
