package mx.gob.economia.inadem.business.solicitud;

import java.util.List;

import mx.gob.economia.inadem.entity.Entidad;
import mx.gob.economia.inadem.entity.beneficiario.Beneficiario;
import mx.gob.economia.inadem.entity.solicitud.Convocatoria;
import mx.gob.economia.inadem.entity.solicitud.EstadoSolicitud;
import mx.gob.economia.inadem.entity.solicitud.Solicitud;
import mx.gob.economia.inadem.entity.solicitud.SolicitudApoyo;
import mx.gob.economia.inadem.entity.solicitud.SolicitudApoyoDirecto;
import mx.gob.economia.inadem.entity.solicitud.SolicitudApoyoFinanciera;
import mx.gob.economia.inadem.entity.solicitud.SolicitudApoyoTics;

public final class SolicitudManager {

	public static synchronized List<Convocatoria> consultaConvocatorias(){
		return Entidad.list(Convocatoria.class);
	}
	
	public static synchronized Solicitud createSolicitud(Beneficiario beneficiario,Convocatoria convocatoria){
		Solicitud solicitud=null;
		EstadoSolicitud estadoSolicitud=(EstadoSolicitud)Entidad.findAny(EstadoSolicitud.class, 1L);
		switch(convocatoria.getTipoSolicitud()){
		case APOYO: 
			solicitud=new SolicitudApoyo();
			break;
		case APOYODIRECTO:
			solicitud=new SolicitudApoyoDirecto();
			break;
		case APOYOACCESOTICS:
			solicitud=new SolicitudApoyoTics();
			break;
		case APOYOASESORIAFINANCIERA:
			solicitud=new SolicitudApoyoFinanciera();
			break;
		}
		solicitud.setBeneficiario(beneficiario);
		solicitud.setConvocatoria(convocatoria);
		solicitud.setEstadoSolicitud(estadoSolicitud);
		beneficiario.getSolicitudes().add(solicitud);
		return solicitud;		
	}
	
	public static synchronized Solicitud abreSolicitud(Solicitud solicitud){
		Solicitud s=null;
		/*switch(solicitud.getTipoSolicitud()){
		case APOYO:*/ 
			s=(SolicitudApoyo)Entidad.findAny(SolicitudApoyo.class, solicitud.getId());
		/*	break;
		case APOYODIRECTO:
			s=(SolicitudApoyoDirecto)Entidad.findAny(SolicitudApoyoDirecto.class, solicitud.getId());
			break;
		case APOYOACCESOTICS:
			s=(SolicitudApoyoTics)Entidad.findAny(SolicitudApoyoTics.class, solicitud.getId());
			break;
		case APOYOASESORIAFINANCIERA:
			s=(SolicitudApoyoFinanciera)Entidad.findAny(SolicitudApoyoFinanciera.class, solicitud.getId());
			break;
		}*/
		return s;
	}
	
	public static synchronized void guardaSolicitud(Solicitud solicitud){
		
		System.out.println(solicitud.save());
	}
}
