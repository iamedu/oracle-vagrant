package mx.gob.economia.inadem.ui.solicitud;

import javax.faces.event.ActionEvent;


import mx.gob.economia.inadem.business.solicitud.SolicitudManager;
import mx.gob.economia.inadem.entity.solicitud.Participacion;
import mx.gob.economia.inadem.entity.solicitud.ParticipacionAnterior;
import mx.gob.economia.inadem.entity.solicitud.Solicitud;
import mx.gob.economia.inadem.entity.solicitud.SolicitudApoyo;
import mx.gob.economia.inadem.ui.PageBase;

public class SolicitudPageBean extends PageBase {
	
	private static final long serialVersionUID = 1L;
	
	
	private Solicitud currentSolicitud;
	
	
	
	public Solicitud getCurrentSolicitud() {
		return currentSolicitud;
	}
	
	public void setCurrentSolicitud(Solicitud currentSolicitud) {
		this.currentSolicitud = currentSolicitud;
	}
	
	public void btnAgregarParticipacionAction(ActionEvent actionEvent){
		Participacion participacion=new Participacion();
		participacion.setSolicitud(getCurrentSolicitud());
		((SolicitudApoyo)getCurrentSolicitud()).getParticipaciones().add(participacion);
	}
	
	public void btnAgregarParticipacionAnteriorAction(ActionEvent actionEvent){
		ParticipacionAnterior participacion=new ParticipacionAnterior();
		participacion.setSolicitud(getCurrentSolicitud());
		((SolicitudApoyo)getCurrentSolicitud()).getParticipacionesAnteriores().add(participacion);
		}
	
	public void btnEliminaParticipacionAction(ActionEvent actionEvent){
		Participacion participacion=(Participacion)actionEvent.getComponent().getAttributes().get("participacion");
		((SolicitudApoyo)getCurrentSolicitud()).getParticipaciones().remove(participacion);
	}
	
	public void btnEliminaParticipacionAnteriorAction(ActionEvent actionEvent){
		ParticipacionAnterior participacion=(ParticipacionAnterior)actionEvent.getComponent().getAttributes().get("participacion");
		((SolicitudApoyo)getCurrentSolicitud()).getParticipacionesAnteriores().remove(participacion);
	}
	
	public void btnGuardaSlicitudAction(ActionEvent actionEvent){
		SolicitudManager.guardaSolicitud(getCurrentSolicitud());
		getSessionBean().refreshUser();
		redirect("listaSolicitudes.faces");
	}
	
}
