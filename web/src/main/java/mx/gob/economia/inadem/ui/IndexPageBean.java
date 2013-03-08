package mx.gob.economia.inadem.ui;

import javax.faces.event.ActionEvent;

import mx.gob.economia.inadem.business.seguridad.SeguridadManager;
import mx.gob.economia.inadem.entity.beneficiario.Beneficiario;
import mx.gob.economia.inadem.util.Constantes;
import mx.gob.economia.inadem.util.UtilitiesPageBean;

public class IndexPageBean extends PageBase {

	private static final long serialVersionUID = 1L;
	private UtilitiesPageBean util;
	private String usuarioId;
	
	private String password;
	
	private String politicasPrivacidad;
	
	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void btnLoginAction(ActionEvent actionEvent){
		Beneficiario beneficiario=SeguridadManager.beneficiarioLogin(getUsuarioId(), getPassword());
		if(validaUsuario(beneficiario)){
			this.getSessionBean().setUser(beneficiario);
			//redirect("./solicitud/convocatorias.faces");
		}
		
	}
	
	public void btnCancelarAction(ActionEvent actionEvent){
		redirect("./index.faces");
	}
	
	public void verPoliticas(ActionEvent actionEvent){
		redirect("politicas.faces");
	}
	
	public boolean validaUsuario(Beneficiario beneficiario){
		if(beneficiario==null){
			this.util.setErrorMessage_("hola mundo");
			errorMessage = "Correo electronico y/o contraseña invalido.";
			return false;
		}
		
		return true;
	}
	
	public void linkRegistroAction(ActionEvent actionEvent){
			redirect("./registro/registro.faces");
		
	}

	public String getPoliticasPrivacidad() {
		this.politicasPrivacidad = Constantes.MSG_POLITICAS;
		return politicasPrivacidad;
	}

	public void setPoliticasPrivacidad(String politicasPrivacidad) {
		this.politicasPrivacidad = politicasPrivacidad;
	}

	public UtilitiesPageBean getUtil() {
		return util;
	}

	public void setUtil(UtilitiesPageBean util) {
		this.util = util;
	}
	
	
}
