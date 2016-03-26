import java.util.HashMap ;

/**
*
* 20160325_2140h JRH
* A class to take care of deciding whether or not
* a request is authorized, based on request type,
* username, and password.
*
**/

public class Authenticator{
  private String connectionString ;  
  private Boolean isConnected ;
  private HashMap<String,String> authDB ; 

  public Authenticator(){
    /** FOR TESTING ONLY **/
    authDB = new HashMap<String,String>();
    authDB.put("testUser","testPass");
    /** END FOR TESTING ONLY **/
  }

  private Authenticator setConnectionString( String newString ) {
    if( !(newString instanceof String) ){
      Logger.error("setConnectionString not given a String." ) ;
      return this;
    } 
    this.connectionString = newString ;
    return this;
  } 

  private Authenticator setConnectedFlag( Boolean newState ) {
    if( !(newState instanceof Boolean ) ) {
      Logger.error("setConnectedFlag not given a Boolean." ) ;
      return this;
    } 
    this.isConnected = newState ;
    return this;
  } 

  public Authenticator connect( String connectionString ){
    if( !(connectionString instanceof String) ){
      Logger.error("connect not given a String." ) ;
      return this;
    } 
    Logger.info("Connected to DB");
    return this
      .setConnectionString( "test:connection:string" ) 
      .setConnectedFlag( true ) 
    ;
  }
  
  public Authenticator disconnect(){
    Logger.info("Disconnected from DB");
    this.setConnectedFlag( false ) ;
    return this;
  }

  public boolean isAuthenticated( 
    String password , 
    String username  
  ) {
    
    if( 
      !( password    instanceof String) ||    
      !( username    instanceof String) 
    ){
      Logger.error("Incorrect arguments given to boolean isAuthenticated.") ;
    }
    if( authDB.containsKey(username) ) {
      Logger.info("That user IS in the system!");
      return true ;
    }
    else {
      Logger.info("That user IS NOT in the system!");
      return false;
    }
      
  } 
  
  
  
}
