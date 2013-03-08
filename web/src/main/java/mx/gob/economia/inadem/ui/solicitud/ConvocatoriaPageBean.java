package mx.gob.economia.inadem.ui.solicitud;

import java.util.List;

import javax.faces.event.ActionEvent;

import mx.gob.economia.inadem.business.solicitud.SolicitudManager;
import mx.gob.economia.inadem.entity.beneficiario.Beneficiario;
import mx.gob.economia.inadem.entity.solicitud.Convocatoria;
import mx.gob.economia.inadem.entity.solicitud.Solicitud;
import mx.gob.economia.inadem.ui.PageBase;

public class ConvocatoriaPageBean extends PageBase {
	
	private static final long serialVersionUID = 1L;
	 
	private List<Convocatoria> listConvocatorias;
	
	public List<Convocatoria> getListConvocatorias() {
		if(listConvocatorias==null){
			listConvocatorias=SolicitudManager.consultaConvocatorias();
		}
		return listConvocatorias;
	}
 
	public SolicitudPageBean getSolicitudPageBean(){
		
			if (getSessionScope().get("pbSolicitud") == null)
				getSessionScope().put("pbSolicitud", new SolicitudPageBean());
			return (SolicitudPageBean) getSessionScope().get("pbSolicitud");
		
	}

	public void btnCrearSolicitudAction(ActionEvent actionEvent){
		Convocatoria convocatoria=(Convocatoria)actionEvent.getComponent().getAttributes().get("convocatoria");
		Solicitud solicitud=SolicitudManager.createSolicitud((Beneficiario)getSessionBean().getUser(), convocatoria);
		getSolicitudPageBean().setCurrentSolicitud(solicitud);
		redirect("solicitudApoyo.faces");
		
	}


	
}
