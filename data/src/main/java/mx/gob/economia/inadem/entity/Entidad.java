package mx.gob.economia.inadem.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class Entidad implements Serializable {

	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHAREGISTRO" , nullable = false)
	private Date fechaRegistro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHAMODIFICACION")
	private Date fechaModificacion;

	@Column(name="ACTIVO" , nullable = false)
	private boolean activo;

	@Transient
	private double tempid = Math.random();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public ResultadoTransaccion save() {
		return EntidadController.saveEntidad(this);
	}

	public ResultadoTransaccion delete() {
		return EntidadController.deleteEntidad(this);
	}

	public static synchronized <T extends Entidad> T refresh(T entidad) {
		return EntidadController.refreshEntidad(entidad);
	}

	public static synchronized <T extends Entidad> List<T> list(
			Class<T> entidadType) {
		return EntidadController.listEntidades(entidadType);
	}
	
	public static synchronized Object findAny(Class<?> entityType, Object id){
	    return EntidadController.findAnyEntidad(entityType, id);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		try {
			return o.getClass().equals(getClass())
					& getId().equals(((Entidad) o).getId());
		} catch (Exception e) {
			try {
				return this.tempid == ((Entidad) o).tempid;
			} catch (Exception e1) {
			}
		}
		return false;
	}

	@PrePersist
	public void prePersist(){
		this.fechaRegistro=Calendar.getInstance().getTime();
	}
}
