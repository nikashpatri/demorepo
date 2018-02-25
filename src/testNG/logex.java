package testNG;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class logex {
	Logger log=Logger.getLogger(logex.class);

  @Test
  public void f() {
	
	  	  log.setLevel(Level.OFF);
	  	  log.debug("Debug msg");
	  	  log.info("info msg");
	  	  log.warn("Warn msg");
	  	  log.error("Error msg");
	  	  log.fatal("fatal msg");
	  	  
	    }
	  

  }

