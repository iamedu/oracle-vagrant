package mx.gob.economia.inadem.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UtilDowloadFileServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private String path;

	public void download(String path, HttpServletRequest request, HttpServletResponse response) 
		throws FileNotFoundException {
		
		System.out.println("path "+ path);
		File file = new File(path);
		FileInputStream fileToDownload =  null;
	 	
		try {
			fileToDownload = new FileInputStream(path);
			
			ServletContext context = request.getServletContext();
	        String mimetype = context.getMimeType(file.getAbsolutePath());
	        response.setContentType(mimetype);
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Cache-Control", "no-cache");
	        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            response.setContentLength(fileToDownload.available());
            OutputStream out = response.getOutputStream();
            
            int content;
            while( ( content = fileToDownload.read() ) != -1 ) {
            	out.write(content);
            }
            
            out.flush();
            out.close();
            fileToDownload.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new FileNotFoundException();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		path = (String)req.getParameter("path");
		download(path,req,resp);
		
	}
	
	
		
}
