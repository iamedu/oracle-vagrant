package mx.gob.economia.inadem.beans;

import java.io.Serializable;

import mx.gob.economia.inadem.entity.Entidad;
import mx.gob.economia.inadem.entity.beneficiario.Beneficiario;
import mx.gob.economia.inadem.entity.seguridad.Usuario;

public class InademSessionBean implements Serializable{
	  private static final long serialVersionUID = 1L;
	  private Usuario usuario;


	  public void refreshUser(){
		   if (this.usuario != null)
	       setUser((Usuario)Entidad.refresh(this.usuario));  
	  }
	  
	  public Usuario getUser()
	  {
	   // if (this.usuario != null)
	   //   return (Usuario)Entidad.refresh(this.usuario);
	   // return null;
		  return this.usuario;
	  }

	  public void setUser(Usuario user) {
	    this.usuario = user;
	  }
	  
	  public Beneficiario getBeneficiario(){
		 return (Beneficiario)this.getUser();
	  }
 
	  public boolean isLoggedIn() {
	    return getUser() != null;
	  }

}
