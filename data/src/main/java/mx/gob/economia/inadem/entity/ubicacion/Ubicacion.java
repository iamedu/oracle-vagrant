package mx.gob.economia.inadem.entity.ubicacion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.gob.economia.inadem.entity.Entidad;

@Entity
@Table(name="UBICACION" )
public class Ubicacion extends Entidad {

	private static final long serialVersionUID = 1L;

	@Column(name="CALLE" , length = 100)
	private String calle;
	
	@Column(name="NUMEROEXTERIOR" , length = 100)
	private String numeroExterior;
	
	@Column(name="NUMEROEXTERIOR2" , length = 100)
	private String numeroExterior2;
	
	@Column(name="NUMEROINTERIOR" , length = 100)
	private String numeroInterior;
	
	@Column(name="COLONIA" , length = 100)
	private String colonia;
	
	@Column(name="LOCALIDAD" , length = 100)
	private String localidad;
	
	@Column(name="CODIGOPOSTAL" , length = 5)
	private String codigoPostal;
	
	@Column(name="VIALIDAD1" , length = 100)
	private String vialidad1;
	
	@Column(name="VIALIDAD2" , length = 100)
	private String vialidad2;
	
	@Column(name="VIALIDADPOSTERIOR" , length = 100)
	private String vialidadPosterior;
	
	@Column(name="DESCRIPCION" , length = 100)
	private String descripcion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Estado estado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Municipio municipio;

	@ManyToOne(fetch=FetchType.LAZY)
	private TipoVialidad tipoVialidad;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private TipoAsentamiento tipoAsentamiento;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private TipoVialidad tipoVialidad1;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private TipoVialidad tipoVialidad2;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private TipoVialidad tipoVialidadPosterior;
	
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public String getNumeroInterior() {
		return numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getVialidad1() {
		return vialidad1;
	}

	public void setVialidad1(String vialidad1) {
		this.vialidad1 = vialidad1;
	}

	public String getVialidad2() {
		return vialidad2;
	}

	public void setVialidad2(String vialidad2) {
		this.vialidad2 = vialidad2;
	}

	public String getVialidadPosterior() {
		return vialidadPosterior;
	}

	public void setVialidadPosterior(String vialidadPosterior) {
		this.vialidadPosterior = vialidadPosterior;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getNumeroExterior2() {
		return numeroExterior2;
	}

	public void setNumeroExterior2(String numeroExterior2) {
		this.numeroExterior2 = numeroExterior2;
	}

	public TipoVialidad getTipoVialidad() {
		return tipoVialidad;
	}

	public void setTipoVialidad(TipoVialidad tipoVialidad) {
		this.tipoVialidad = tipoVialidad;
	}

	public TipoAsentamiento getTipoAsentamiento() {
		return tipoAsentamiento;
	}

	public void setTipoAsentamiento(TipoAsentamiento tipoAsentamiento) {
		this.tipoAsentamiento = tipoAsentamiento;
	}

	public TipoVialidad getTipoVialidad1() {
		return tipoVialidad1;
	}

	public void setTipoVialidad1(TipoVialidad tipoVialidad1) {
		this.tipoVialidad1 = tipoVialidad1;
	}

	public TipoVialidad getTipoVialidad2() {
		return tipoVialidad2;
	}

	public void setTipoVialidad2(TipoVialidad tipoVialidad2) {
		this.tipoVialidad2 = tipoVialidad2;
	}

	public TipoVialidad getTipoVialidadPosterior() {
		return tipoVialidadPosterior;
	}

	public void setTipoVialidadPosterior(TipoVialidad tipoVialidadPosterior) {
		this.tipoVialidadPosterior = tipoVialidadPosterior;
	}
}
