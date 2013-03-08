package mx.gob.economia.inadem.business.registro;

import mx.gob.economia.inadem.entity.ResultadoTransaccion;
import mx.gob.economia.inadem.entity.beneficiario.Beneficiario;

public final class RegistroManager {

	public static synchronized void registraBeneficiario(Beneficiario beneficiario){
		beneficiario.setUsuarioId(beneficiario.getEmail());
		ResultadoTransaccion resultadoTransaccion=beneficiario.save();
		if(resultadoTransaccion==ResultadoTransaccion.OK){
			//
		}
	}
}
