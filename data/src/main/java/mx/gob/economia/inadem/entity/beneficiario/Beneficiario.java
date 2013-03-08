package mx.gob.economia.inadem.entity.beneficiario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import mx.gob.economia.inadem.entity.EntidadController;
import mx.gob.economia.inadem.entity.representante.RepresentanteLegal;
import mx.gob.economia.inadem.entity.seguridad.Usuario;
import mx.gob.economia.inadem.entity.solicitud.Solicitud;
import mx.gob.economia.inadem.entity.ubicacion.Ubicacion;

@Entity
@Table(name="BENEFICIARIO")
public class Beneficiario extends Usuario {

	private static final long serialVersionUID = 1L;
	
	public enum TipoPersona{FISICA,MORAL}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHAACTIVACION")
	private Date fechaActivacion;
	
	@Column(name="RFC" , length = 30)
	private String rfc;
	
	@Column(name="RESPUESTAPREGUNTA" , length=250 ,nullable = false)
	private String respuestaPregunta;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	private PreguntaSeguridad preguntaSeguridad;
	
	@OneToMany(mappedBy="beneficiario",cascade=CascadeType.ALL)
	private List<Solicitud> solicitudes;
	
	@Enumerated(EnumType.STRING)
	private TipoPersona tipoPersona;
	
	@Embedded
	private RepresentanteLegal representanteLegal;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Ubicacion ubicacion;
	
	public String getRfc(){
		return rfc;
	}
	
	public void setRfc(String rfc){
		this.rfc=rfc;
	}

	public Date getFechaActivacion() {
		return fechaActivacion;
	}

	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	public String getRespuestaPregunta() {
		return respuestaPregunta;
	}

	public void setRespuestaPregunta(String respuestaPregunta) {
		this.respuestaPregunta = respuestaPregunta;
	}

	public PreguntaSeguridad getPreguntaSeguridad() {
		return preguntaSeguridad;
	}

	public void setPreguntaSeguridad(PreguntaSeguridad preguntaSeguridad) {
		this.preguntaSeguridad = preguntaSeguridad;
	}

	public List<Solicitud> getSolicitudes() {
		if(this.solicitudes==null){
			this.solicitudes=new ArrayList<>();
		}
		return solicitudes;
	}

	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(TipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	
	public RepresentanteLegal getRepresentanteLegal() {
		if(representanteLegal==null)
			representanteLegal=new RepresentanteLegal();
		if(getTipoPersona()!=null && getTipoPersona().equals(TipoPersona.FISICA)){
			representanteLegal.setNombre(getNombre());
			representanteLegal.setApellidoPaterno(getApellidoPaterno());
			representanteLegal.setApellidoMaterno(getApellidoMaterno());
			representanteLegal.setEmail(getEmail());
			
		}
		return representanteLegal;
	}

	public void setRepresentanteLegal(RepresentanteLegal representanteLegal) {
		this.representanteLegal = representanteLegal;
	}

	public Ubicacion getUbicacion() {
		if(ubicacion==null)
			ubicacion=new Ubicacion();
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}


	public static synchronized Beneficiario beneficiarioLogin(String usrId,String pwd){
		EntityManager em = EntidadController.getEntityManager();
	    try {
	      Query q = em.createQuery("select a from Beneficiario a where a.usuarioId = :uid and a.password = :pwd'", Usuario.class);
	      q.setParameter("uid", usrId);
	      q.setParameter("pwd", pwd);
	      return (Beneficiario)q.getSingleResult();
	    } catch (Exception ex) {
	      ex.printStackTrace();
	      return null;
	    } finally {
	      em.close();
	    }
	}

	
	
}
