package mx.gob.economia.inadem.entity.solicitud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.gob.economia.inadem.entity.Entidad;

@Entity
@Table(name="DOCUMENTOSOLICITUD")
public class DocumentoSolicitud extends Entidad {

	private static final long serialVersionUID = 1L;

	@Column(name="PATH" , length=250)
	private String path;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	private Documento documento;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	private Solicitud solicitud;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}
}