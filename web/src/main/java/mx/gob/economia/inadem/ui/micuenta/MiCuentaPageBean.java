package mx.gob.economia.inadem.ui.micuenta;

import javax.faces.event.ActionEvent;

import com.icesoft.faces.component.panelpopup.PanelPopup;

import mx.gob.economia.inadem.beans.InademSessionBean;
import mx.gob.economia.inadem.business.micuenta.MiCuentaManager;
import mx.gob.economia.inadem.business.registro.RegistroManager;
import mx.gob.economia.inadem.entity.beneficiario.Beneficiario;
import mx.gob.economia.inadem.entity.seguridad.Usuario;
import mx.gob.economia.inadem.ui.PageBase;
import mx.gob.economia.inadem.ui.solicitud.SolicitudPageBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiCuentaPageBean extends PageBase {	
	
	private static Logger log = LoggerFactory.getLogger(SolicitudPageBean.class);
	private static final long serialVersionUID = 1L;
	
	private Beneficiario currentBeneficiario;
	
	private String passwordAnterior;
	private String passwordActual;
	private String confirmacionCorreo;
	private String confirmacionPassword;
	private String errorMessagePassword;
	private boolean panelConfirmacionVisible;
	private boolean panelPasswordVisible=false;
	


	public Beneficiario getCurrentBeneficiario() {
		if(currentBeneficiario==null){
			if(getSessionScope().get("inademSessionBean")!=null){
				InademSessionBean inademSessionBean=(InademSessionBean) getSessionScope().get("inademSessionBean");
				currentBeneficiario=inademSessionBean.getBeneficiario();
				confirmacionCorreo=currentBeneficiario.getEmail();
				confirmacionPassword=currentBeneficiario.getPassword();
				passwordActual=currentBeneficiario.getPassword();
			}
		}
		return currentBeneficiario;
	}

	public void setCurrentBeneficiario(Beneficiario currentBeneficiario) {
		this.currentBeneficiario = currentBeneficiario;
	}
	
	

	public String getConfirmacionCorreo() {
		return confirmacionCorreo;
	}

	public void setConfirmacionCorreo(String confirmacionCorreo) {
		this.confirmacionCorreo = confirmacionCorreo;
	}
	public boolean isPanelConfirmacionVisible() {
		return panelConfirmacionVisible;
	}
	
	public String getConfirmacionPassword() {
		return confirmacionPassword;
	}

	public void setConfirmacionPassword(String confirmacionPassword) {
		this.confirmacionPassword = confirmacionPassword;
	}
	public boolean validaBeneficiario(){
		if(!this.currentBeneficiario.getEmail().equals(confirmacionCorreo)){
			this.errorMessage = "Las cuentas de correo electronico proporcionadas deben ser iguales.";
			return false;
		} 
		if(!this.currentBeneficiario.getPassword().equals(confirmacionPassword)){
			errorMessage = "Las contraseñas proporcionadas deben ser iguales.";
			return false;
		}
		if(this.currentBeneficiario.getPreguntaSeguridad()==null){
			errorMessage = "El campo pregunta de seguridad es requerido";
			return false;
		}
		if(this.currentBeneficiario.getUbicacion().getTipoVialidad()==null){
			errorMessage = "El campo tipo vialidad es requerido";
			return false;
		}
		if(this.currentBeneficiario.getUbicacion().getEstado()==null){
			errorMessage = "El campo estado es requerido";
			return false;
		}
		if(this.currentBeneficiario.getUbicacion().getMunicipio()==null){
			errorMessage = "El campo municipio es requerido";
			return false;
		}
		if(this.currentBeneficiario.getUbicacion().getTipoVialidad1()==null){
			errorMessage = "El campo tipo vialidad 1 es requerido";
			return false;
		}
		if(this.currentBeneficiario.getUbicacion().getTipoVialidad2()==null){
			errorMessage = "El campo tipo vialidad 2 es requerido";
			return false;
		}
		
		return true;
	}

	public void btnEnviarAction(ActionEvent actionEvent){
		log.info("ENTRANDO A EDITAR BENEFICIARIO"); 
		if(validaBeneficiario()){
			panelConfirmacionVisible = true;
		}
	}
	public void btnAceptarConfirmacionAction(ActionEvent actionEvent){
		try{
			log.info("CONFIRMO EDITAR BENEFICIARIO:"+passwordAnterior+" "+passwordActual); 
			if(passwordAnterior.compareTo(passwordActual)==0){
				MiCuentaManager.modificarBeneficiario(currentBeneficiario);
				log.info("SE GUARDO LOS CAMBIOS"); 
				panelConfirmacionVisible = false;
				errorMessagePassword="";
				passwordAnterior="";
			}else{
				this.errorMessagePassword="La contraseña no coincide con la actual, ingresela nuevamente";
				passwordAnterior="";
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void btnCancelConfirmacionAction(){
		panelConfirmacionVisible = false;
		errorMessagePassword="";
		passwordAnterior="";
		if(getSessionScope().get("inademSessionBean")!=null){
			InademSessionBean inademSessionBean=(InademSessionBean) getSessionScope().get("inademSessionBean");
			currentBeneficiario=inademSessionBean.getBeneficiario();
			confirmacionCorreo=currentBeneficiario.getEmail();
			confirmacionPassword=currentBeneficiario.getPassword();
			passwordActual=currentBeneficiario.getPassword();
		}
	}
	

	public String getPasswordAnterior() {
		return passwordAnterior;
	}

	public void setPasswordAnterior(String passwordAnterior) {
		this.passwordAnterior = passwordAnterior;
	}

		public boolean isPanelPasswordVisible() {
		return panelPasswordVisible;
	}

	public void setPanelPasswordVisible(boolean panelPasswordVisible) {
		this.panelPasswordVisible = panelPasswordVisible;
	}

	
	public String getPasswordActual() {
		return passwordActual;
	}

	public void setPasswordActual(String passwordActual) {
		this.passwordActual = passwordActual;
	}

	public String getErrorMessagePassword() {
		return errorMessagePassword;
	}

	public void setErrorMessagePassword(String errorMessagePassword) {
		this.errorMessagePassword = errorMessagePassword;
	}
	
}
