package exceptions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class NoUserException extends Exception {

	public NoUserException(String message) {
		super(message);
		PropertyConfigurator.configure("log4j.properties");
		log.error(message);
	}
	
	public NoUserException(Throwable Cause){
		super(Cause);
	}
	
	static Logger log = 
			Logger.getLogger(NoUserException.class);	

}