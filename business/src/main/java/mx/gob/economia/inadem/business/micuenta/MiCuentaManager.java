package mx.gob.economia.inadem.business.micuenta;

import mx.gob.economia.inadem.entity.ResultadoTransaccion;
import mx.gob.economia.inadem.entity.beneficiario.Beneficiario;

public final class MiCuentaManager {
	public static synchronized void modificarBeneficiario(Beneficiario beneficiario){
		beneficiario.setUsuarioId(beneficiario.getEmail());
		ResultadoTransaccion resultadoTransaccion=beneficiario.save();
		if(resultadoTransaccion==ResultadoTransaccion.OK){
			//
		}
	}
}
