package mx.gob.economia.inadem.entity.solicitud;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.gob.economia.inadem.entity.Entidad;
import mx.gob.economia.inadem.entity.beneficiario.Beneficiario;
import mx.gob.economia.inadem.entity.representante.RepresentanteLegal;
import mx.gob.economia.inadem.entity.ubicacion.Ubicacion;

@Entity
@Table(name="SOLICITUD")
@Inheritance(strategy=InheritanceType.JOINED)
public class Solicitud extends Entidad {

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING) 
	private TipoSolicitud tipoSolicitud;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Convocatoria convocatoria;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Beneficiario beneficiario;
	
	@Column(name="RFC" , length=50 )
	private String rfc;
	
	@Column(name="RAZONSOCIAL" , length=550 )
	private String razonSocial;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Ubicacion ubicacion;
	
	@Embedded
	private RepresentanteLegal representanteLegal;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private EstadoSolicitud estadoSolicitud;

	public TipoSolicitud getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public Convocatoria getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(Convocatoria convocatoria) {
		this.convocatoria = convocatoria;
	}

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public String getRfc() {
		if(getBeneficiario()!=null)
			rfc=beneficiario.getRfc();
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getRazonSocial() {
		if(getBeneficiario()!=null)
			razonSocial=beneficiario.getNombre();
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Ubicacion getUbicacion() {
		if(ubicacion==null){
			ubicacion=new Ubicacion();
			if(getBeneficiario()!=null){
				ubicacion.setCalle(getBeneficiario().getUbicacion().getCalle());
				ubicacion.setCodigoPostal(getBeneficiario().getUbicacion().getCodigoPostal());
				ubicacion.setColonia(getBeneficiario().getUbicacion().getColonia());
				ubicacion.setDescripcion(getBeneficiario().getUbicacion().getDescripcion());
				ubicacion.setEstado(getBeneficiario().getUbicacion().getEstado());
				ubicacion.setLocalidad(getBeneficiario().getUbicacion().getLocalidad());
				ubicacion.setMunicipio(getBeneficiario().getUbicacion().getMunicipio());
				ubicacion.setNumeroExterior(getBeneficiario().getUbicacion().getNumeroExterior());
				ubicacion.setNumeroExterior2(getBeneficiario().getUbicacion().getNumeroExterior2());
				ubicacion.setNumeroInterior(getBeneficiario().getUbicacion().getNumeroInterior());
				ubicacion.setTipoAsentamiento(getBeneficiario().getUbicacion().getTipoAsentamiento());
				ubicacion.setTipoVialidad(getBeneficiario().getUbicacion().getTipoVialidad());
				ubicacion.setTipoVialidad1(getBeneficiario().getUbicacion().getTipoVialidad1());
				ubicacion.setTipoVialidad2(getBeneficiario().getUbicacion().getTipoVialidad2());
				ubicacion.setTipoVialidadPosterior(getBeneficiario().getUbicacion().getTipoVialidadPosterior());
				ubicacion.setVialidad1(getBeneficiario().getUbicacion().getVialidad1());
				ubicacion.setVialidad2(getBeneficiario().getUbicacion().getVialidad2());
				ubicacion.setVialidadPosterior(getBeneficiario().getUbicacion().getVialidadPosterior());				
				
			}
		}
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public RepresentanteLegal getRepresentanteLegal() {
		if(representanteLegal==null){
			representanteLegal=new RepresentanteLegal();
			if(getBeneficiario()!=null){
				representanteLegal.setNombre(getBeneficiario().getRepresentanteLegal().getNombre());
				representanteLegal.setApellidoPaterno(getBeneficiario().getRepresentanteLegal().getApellidoPaterno());
				representanteLegal.setApellidoMaterno(getBeneficiario().getRepresentanteLegal().getApellidoPaterno());
				representanteLegal.setCargo(getBeneficiario().getRepresentanteLegal().getCargo());
				representanteLegal.setCurp(getBeneficiario().getRepresentanteLegal().getCurp());
				representanteLegal.setTelefono(getBeneficiario().getRepresentanteLegal().getTelefono());
				representanteLegal.setEmail(getBeneficiario().getRepresentanteLegal().getEmail());
				
			}
		}
		return representanteLegal;
	}

	public void setRepresentanteLegal(RepresentanteLegal representanteLegal) {
		this.representanteLegal = representanteLegal;
	}

	public EstadoSolicitud getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}
}
