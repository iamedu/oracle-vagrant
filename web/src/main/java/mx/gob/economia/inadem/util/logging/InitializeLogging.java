package mx.gob.economia.inadem.util.logging;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

public class InitializeLogging extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void init(){   
	       String prefix = getServletContext().getRealPath("/");   
	       String filename= getInitParameter("log4j-config-file");   
	       if( filename != null ){   
	          PropertyConfigurator.configure( prefix+filename );   
	       }   
	     }   
	

}
