package mx.gob.economia.inadem.business.seguridad;

import mx.gob.economia.inadem.entity.beneficiario.Beneficiario;
import mx.gob.economia.inadem.entity.seguridad.Usuario;

public final class SeguridadManager {

	public static synchronized Usuario usuarioLogin(String usuarioId,String password){
		return Usuario.usuarioLogin(usuarioId, password);
	}
	
	public static synchronized Beneficiario beneficiarioLogin(String usuarioId,String password){
		return Beneficiario.beneficiarioLogin(usuarioId, password);
	}
	
}
