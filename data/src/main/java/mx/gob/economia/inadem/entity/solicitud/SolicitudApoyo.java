package mx.gob.economia.inadem.entity.solicitud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
import javax.persistence.Transient;

import mx.gob.economia.inadem.entity.Entidad;
import mx.gob.economia.inadem.entity.ubicacion.Estado;
import mx.gob.economia.inadem.entity.ubicacion.Ubicacion;

@Entity
@Table(name="SOLICITUDAPOYO")
public class SolicitudApoyo extends Solicitud {

	private static final long serialVersionUID = 1L;

    public enum Cobertura{NACIONAL,ESTATAL,REGIONAL,OTRAS}
	
	@Column(name="NOMBREPROYECTO" , length=550 )
	private String nombreProyecto;
	
	@Enumerated(EnumType.STRING)
	private Cobertura cobertura;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private CoberturaGeografica coberturaGeografica;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Estado estadoCobertura;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="SOLICITUDESTADOCOBERTURA",
        joinColumns=
            @JoinColumn(name="SOLICITUDID", referencedColumnName="ID"),
        inverseJoinColumns=
            @JoinColumn(name="ESTADOID", referencedColumnName="ID")
        )
	private List<Estado> estadosCobertura;
	
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Ubicacion ubicacionEventos;
	
	@Embedded
	private ResumenEjecutivo resumenEjecutivo;
	
	@Embedded
	private MetaProyecto metaProyecto;
	
	@OneToMany(fetch=FetchType.LAZY,orphanRemoval=true,mappedBy="solicitud",cascade=CascadeType.ALL)
	private List<DocumentoSolicitud> documentosSolicitud;
	
	@OneToMany(fetch=FetchType.LAZY,orphanRemoval=true,mappedBy="solicitud",cascade=CascadeType.ALL)
	private List<PresupuestoParticipante> presupuestoParticipantes;
	
	@OneToMany(fetch=FetchType.LAZY,orphanRemoval=true,mappedBy="solicitud",cascade=CascadeType.ALL)
	private List<Participacion> participaciones;
	
	@OneToMany(fetch=FetchType.LAZY,orphanRemoval=true,mappedBy="solicitud",cascade=CascadeType.ALL)
	private List<ParticipacionAnterior> participacionesAnteriores;

	@Transient
	private List<Participante> participantesActivos;
	
	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public Cobertura getCobertura() {
		return cobertura;
	}

	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}

	public CoberturaGeografica getCoberturaGeografica() {
		return coberturaGeografica;
	}

	public void setCoberturaGeografica(CoberturaGeografica coberturaGeografica) {
		this.coberturaGeografica = coberturaGeografica;
	}

	public Estado getEstadoCobertura() {
		return estadoCobertura;
	}

	public void setEstadoCobertura(Estado estadoCobertura) {
		this.estadoCobertura = estadoCobertura;
	}

	public List<Estado> getEstadosCobertura() {
		if(estadosCobertura == null){
			estadosCobertura=new ArrayList<Estado>();
		}
		return estadosCobertura;
	}

	public void setEstadosCobertura(List<Estado> estadosCobertura) {
		this.estadosCobertura = estadosCobertura;
	}

	public Ubicacion getUbicacionEventos() {
		if(ubicacionEventos==null){
			ubicacionEventos=new Ubicacion();
		}
		return ubicacionEventos;
	}

	public void setUbicacionEventos(Ubicacion ubicacionEventos) {
		this.ubicacionEventos = ubicacionEventos;
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

	public MetaProyecto getMetaProyecto() {
		if(metaProyecto==null){
			metaProyecto=new MetaProyecto();
		}
		return metaProyecto;
	}

	public void setMetaProyecto(MetaProyecto metaProyecto) {
		this.metaProyecto = metaProyecto;
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

	public List<PresupuestoParticipante> getPresupuestoParticipantes() {
		if(presupuestoParticipantes==null){
			List<Participante> participantes=Entidad.list(Participante.class);
			
			presupuestoParticipantes=new ArrayList<PresupuestoParticipante>();
			
			for(Participante participante:participantes){
				PresupuestoParticipante presupuestoParticipante=new PresupuestoParticipante();
				presupuestoParticipante.setParticipante(participante);
				presupuestoParticipante.setSolicitud(this);
				presupuestoParticipantes.add(presupuestoParticipante);
			}
		}
		return presupuestoParticipantes;
	}

	public void setPresupuestoParticipantes(
			List<PresupuestoParticipante> presupuestoParticipantes) {
		this.presupuestoParticipantes = presupuestoParticipantes;
	}

	public List<Participacion> getParticipaciones() {
		if(participaciones==null){
			participaciones = new ArrayList<Participacion>();
		}
		return participaciones;
	}

	public void setParticipaciones(List<Participacion> participaciones) {
		this.participaciones = participaciones;
	}

	public List<ParticipacionAnterior> getParticipacionesAnteriores() {
		if(participacionesAnteriores==null){
			participacionesAnteriores = new ArrayList<ParticipacionAnterior>();
		}
		return participacionesAnteriores;
	}

	public void setParticipacionesAnteriores(
			List<ParticipacionAnterior> participacionesAnteriores) {
		this.participacionesAnteriores = participacionesAnteriores;
	}
	
	@Transient
	public List<Participante> getParticipantes(){
		if(participantesActivos==null){
			participantesActivos=new ArrayList<Participante>();
		}
		participantesActivos.clear();
		for(PresupuestoParticipante presupuestoParticipante:this.getPresupuestoParticipantes()){
			if(presupuestoParticipante.getMonto()>0)
				participantesActivos.add(presupuestoParticipante.getParticipante());
		}
		
		return participantesActivos;
	}
	
	@Transient
	public double getTotalPresupuesto(){
		double total=0;
		for(PresupuestoParticipante presupuestoParticipante:this.getPresupuestoParticipantes()){
			total+=presupuestoParticipante.getMonto();
		}
		return total;
	}
}
