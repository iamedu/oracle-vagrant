package mx.gob.economia.inadem.ui.solicitud;

import javax.faces.event.ActionEvent;

import mx.gob.economia.inadem.business.solicitud.SolicitudManager;
import mx.gob.economia.inadem.entity.Entidad;
import mx.gob.economia.inadem.entity.solicitud.Solicitud;
import mx.gob.economia.inadem.entity.solicitud.SolicitudApoyo;
import mx.gob.economia.inadem.entity.solicitud.SolicitudApoyoDirecto;
import mx.gob.economia.inadem.entity.solicitud.SolicitudApoyoFinanciera;
import mx.gob.economia.inadem.entity.solicitud.SolicitudApoyoTics;
import mx.gob.economia.inadem.ui.PageBase;

public class ListaSolicitudesPageBean extends PageBase {

	private static final long serialVersionUID = 1L;

	public SolicitudPageBean getSolicitudPageBean(){
		
		if (getSessionScope().get("pbSolicitud") == null)
			getSessionScope().put("pbSolicitud", new SolicitudPageBean());
		return (SolicitudPageBean) getSessionScope().get("pbSolicitud");
	
    }
	
	public void btnAbrirSolicitudAction(ActionEvent actionEvent){
		Solicitud solicitud=(Solicitud)actionEvent.getComponent().getAttributes().get("solicitud");
		getSolicitudPageBean().setCurrentSolicitud(SolicitudManager.abreSolicitud(solicitud));
		/*switch(solicitud.getTipoSolicitud()){
		case APOYO: 
			redirect("solicitudApoyo.faces");
			break;
		case APOYODIRECTO:
			redirect("solicitudApoyo.faces");
			break;
		case APOYOACCESOTICS:
			redirect("solicitudApoyo.faces");
			break;
		case APOYOASESORIAFINANCIERA:
			redirect("solicitudApoyo.faces");
			break;
		}*/
		redirect("solicitudApoyo.faces");
	}
}
