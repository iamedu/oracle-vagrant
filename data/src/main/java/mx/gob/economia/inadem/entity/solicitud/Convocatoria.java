package mx.gob.economia.inadem.entity.solicitud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mx.gob.economia.inadem.entity.catalogo.Catalogo;

@Entity
@Table(name="CONVOCATORIA")
public class Convocatoria extends Catalogo {

	private static final long serialVersionUID = 1L;
	
	
	@Column(name="URLPDF" , length=250)
	private String urlPdf;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	private Programa programa;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="CONVOCATORIAAPOYO",
        joinColumns=
            @JoinColumn(name="CONVOCATORIAID", referencedColumnName="ID"),
        inverseJoinColumns=
            @JoinColumn(name="TIPOAPOYOID", referencedColumnName="ID")
        )
	private List<TipoApoyo> tipoApoyos;
	
	@ManyToMany(fetch=FetchType.EAGER
			)
    @JoinTable(name="CONVOCATORIADOCUMENTO",
        joinColumns=
            @JoinColumn(name="CONVOCATORIAID", referencedColumnName="ID"),
        inverseJoinColumns=
            @JoinColumn(name="DOCUMENTOID", referencedColumnName="ID")
        )
	private List<Documento> documentos;
	
	@OneToMany(fetch=FetchType.LAZY,orphanRemoval=true,mappedBy="convocatoria")
	private List<Solicitud> solicitudes;
	
	@Enumerated(EnumType.STRING)
	private TipoSolicitud tipoSolicitud;
	
	public String getUrlPdf() {
		return urlPdf;
	}

	public void setUrlPdf(String urlPdf) {
		this.urlPdf = urlPdf;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public List<TipoApoyo> getTipoApoyos() {
		return tipoApoyos;
	}

	public void setTipoApoyos(List<TipoApoyo> tipoApoyos) {
		this.tipoApoyos = tipoApoyos;
	}

	public List<Documento> getDocumentos() {
		if(this.documentos==null){
			documentos=new ArrayList<Documento>();
		}
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public TipoSolicitud getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

}
