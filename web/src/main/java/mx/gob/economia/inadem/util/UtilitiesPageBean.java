package mx.gob.economia.inadem.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import mx.gob.economia.inadem.ui.PageBase;


public class UtilitiesPageBean extends PageBase {
	
	private String 	errorMessage_; 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void descargarDocumento(ActionEvent actionEvent){
		String file=(String)actionEvent.getComponent().getAttributes().get("archivo");
		ExternalContext ec =  getFacesContext().getExternalContext();
		String store = ec.getInitParameter("app-store-path");
		System.out.println("strore " + store);
		String encodedURL = ec.encodeResourceURL(ec.getRequestContextPath() + "/download?path="+store+file);
		redirect(encodedURL);
		FacesContext.getCurrentInstance().responseComplete ();
	
	}

	public String getErrorMessage_() {
		return errorMessage_;
	}

	public void setErrorMessage_(String errorMessage_) {
		this.errorMessage_ = errorMessage_;
	}
	
	
}
