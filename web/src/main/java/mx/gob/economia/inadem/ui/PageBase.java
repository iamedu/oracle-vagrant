package mx.gob.economia.inadem.ui;

import java.io.Serializable;
import java.util.Map;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import mx.gob.economia.inadem.beans.InademSessionBean;
import mx.gob.economia.inadem.business.catalogo.CatalogoItemsMap;

public abstract class PageBase implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String errorMessage;
	
	public String menuBarCommand() {
		String param = (String) getParameters().get("menuParam");
		if (param.equals("LOGOUT")) {
			getSessionScope().put("inademSessionBean", new InademSessionBean());
		}
		
		return param;
	}
	
	public void dumbAction(ActionEvent actionEvent){
		
	}
	
    public void dumbChangeAction(ValueChangeEvent actionEvent){
		
	}

	public void redirect(String url){
		try{
			getFacesContext().getExternalContext().redirect(url);
	
		}catch(Exception e){}
	}
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public Map<String, Object> getSessionScope() {
		return getFacesContext().getExternalContext().getSessionMap();
	}

	public Map<String, Object> getApplicationScope() {
		return getFacesContext().getExternalContext().getApplicationMap();
	}

	public Map<String, Object> getRequestScope() {
		return getFacesContext().getExternalContext().getRequestMap();
	}

	public Map<String, String> getParameters() {
		return getFacesContext().getExternalContext().getRequestParameterMap();
	}

	public InademSessionBean getSessionBean() {
		if (getSessionScope().get("inademSessionBean") == null)
			getSessionScope().put("inademSessionBean", new InademSessionBean());
		return (InademSessionBean) getSessionScope().get("inademSessionBean");
	}

	public void putMessage(FacesMessage.Severity severity, String sumary,
			String detail) {
		FacesMessage message = new FacesMessage();
		message.setSeverity(severity);
		message.setSummary(sumary);
		message.setDetail(!detail.trim().isEmpty() ? detail : sumary);
		getFacesContext().addMessage(null, message);
	}

	public void putFatalMessage(String sumary, String detail) {
		putMessage(FacesMessage.SEVERITY_FATAL, sumary, detail);
	}

	public void putErrorMessage(String sumary, String detail) {
		putMessage(FacesMessage.SEVERITY_ERROR, sumary, detail);
	}

	public void putWarnMessage(String sumary, String detail) {
		putMessage(FacesMessage.SEVERITY_WARN, sumary, detail);
	}

	public void putInfoMessage(String sumary, String detail) {
		putMessage(FacesMessage.SEVERITY_INFO, sumary, detail);
	}

	public TimeZone getTimeZone() {
		return TimeZone.getDefault();
	}
	
	public int getRandomNumber() {
		return (int) (Math.random() * 10.0D);
	}
	
	public CatalogoItemsMap getCatalogoItemsMap(){
		return CatalogoItemsMap.getInstance();
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
