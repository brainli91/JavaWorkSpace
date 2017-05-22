package exceptions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class InvalidInputException extends Exception{

	public InvalidInputException(String message){
		super(message);
		PropertyConfigurator.configure("log4j.properties");
		log.error(message);
	}
	
	public InvalidInputException(Throwable Cause){
		super(Cause);
	}
	
	static Logger log = 
			Logger.getLogger(InvalidInputException.class);
}
