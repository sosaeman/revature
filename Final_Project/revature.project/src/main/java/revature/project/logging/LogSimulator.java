package revature.project.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static revature.project.colors.consoleColor.*;

public class LogSimulator {

	private static Logger logger = LogManager.getLogger();
 
	public static Logger getLogger() {
		System.out.println(GREY);
		return logger;
	}
	
	public static void main(String[] args) {

		logMethod();
		
	}
	
	
	public static void logMethod() {
    	LogSimulator.logger.trace("authenticating Customer ");
		getLogger().info("TRACE LOG!");
		getLogger().trace("TRACE LOG!");
		getLogger().trace("TRACE LOG!");
		getLogger().trace("TRACE LOG!");

	
	}
}
