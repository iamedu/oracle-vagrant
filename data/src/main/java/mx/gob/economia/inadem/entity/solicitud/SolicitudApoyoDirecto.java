package mx.gob.economia.inadem.entity.solicitud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class SolicitudApoyoDirecto extends Solicitud {

	private static final long serialVersionUID = 1L;

	@Column(name="NOMBREPROYECTO" , length=550 )
	private String nombreProyecto;
	
	@Embedded
	private ResumenEjecutivo resumenEjecutivo;
	
	@Column(name="METAS",length=2000)
	private String metas;
	
	@OneToMany(fetch=FetchType.LAZY,orphanRemoval=true,mappedBy="solicitud",cascade=CascadeType.ALL)
	private List<DocumentoSolicitud> documentosSolicitud;

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public ResumenEjecutivo getResumenEjecutivo() {
		if(resumenEjecutivo==null){
			resumenEjecutivo=new ResumenEjecutivo();
		}
		return resumenEjecutivo;
	}

	public void setResumenEjecutivo(ResumenEjecutivo resumenEjecutivo) {
		this.resumenEjecutivo = resumenEjecutivo;
	}

	public String getMetas() {
		return metas;
	}

	public void setMetas(String metas) {
		this.metas = metas;
	}

	public List<DocumentoSolicitud> getDocumentosSolicitud() {
		if(documentosSolicitud==null){
			if(this.getConvocatoria()==null){
				return null;
			}
			documentosSolicitud=new ArrayList<DocumentoSolicitud>();
			for(Documento documento:getConvocatoria().getDocumentos()){
				DocumentoSolicitud documentoSolicitud=new DocumentoSolicitud();
				documentoSolicitud.setDocumento(documento);
				documentoSolicitud.setSolicitud(this);
				documentosSolicitud.add(documentoSolicitud);
			}
		}
		return documentosSolicitud;
	}

	public void setDocumentosSolicitud(List<DocumentoSolicitud> documentosSolicitud) {
		this.documentosSolicitud = documentosSolicitud;
	}
}
