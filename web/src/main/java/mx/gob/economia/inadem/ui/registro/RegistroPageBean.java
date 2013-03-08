package mx.gob.economia.inadem.ui.registro;

import javax.faces.event.ActionEvent;

import mx.gob.economia.inadem.business.registro.RegistroManager;
import mx.gob.economia.inadem.entity.beneficiario.Beneficiario;
import mx.gob.economia.inadem.ui.PageBase;
import mx.gob.economia.inadem.ui.solicitud.ConvocatoriaPageBean;
import mx.gob.economia.inadem.util.Constantes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistroPageBean extends PageBase {

	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(ConvocatoriaPageBean.class);
	 
	private Beneficiario currentBeneficiario;
	
	private String confirmacionCorreo;
	
	private String confirmacionPassword;
	
	private Boolean terminos; 
	
	private String terminosCondiciones;
	
	private boolean panelConfirmacionVisible;

	public Beneficiario getCurrentBeneficiario() {
		if(this.currentBeneficiario==null){
			this.currentBeneficiario=new Beneficiario();
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
	public String getConfirmacionPassword() {
		return confirmacionPassword;
	}
	public void setConfirmacionPassword(String confirmacionPassword) {
		this.confirmacionPassword = confirmacionPassword;
	}
	public Boolean getTerminos() {
		return terminos;
	}
	public void setTerminos(Boolean terminos) {
		this.terminos = terminos;
	}
	public String getTerminosCondiciones() {
		this.terminosCondiciones = Constantes.MSG_TERMINOS;
		return terminosCondiciones;
	}
	public void setTerminosCondiciones(String terminosCondiciones) {
		this.terminosCondiciones = terminosCondiciones;
	}
	public boolean isPanelConfirmacionVisible() {
		return panelConfirmacionVisible;
	}
	
	public void btnEnviarAction(ActionEvent actionEvent){
		log.info("ENTRANDO"); 
		if(validaBeneficiario()){
			RegistroManager.registraBeneficiario(currentBeneficiario);
			panelConfirmacionVisible = true;
			
		}
	}
	
	public void btnCancelarAction(ActionEvent actionEvent){
		log.info("ENTRANDO"); 
		redirect("../index.faces");
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
	
	public void btnAceptarConfirmacionAction(ActionEvent actionEvent){
		try{
			panelConfirmacionVisible=false;
			getFacesContext().getExternalContext().redirect("../index.faces");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
}
