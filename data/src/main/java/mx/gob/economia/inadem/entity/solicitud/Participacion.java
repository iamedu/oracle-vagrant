package mx.gob.economia.inadem.entity.solicitud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.gob.economia.inadem.entity.Entidad;

@Entity
@Table(name="PARTICIPACION")
public class Participacion extends Entidad {

	private static final long serialVersionUID = 1L;
	
	@Column(name="MONTO")
	private double monto;
	
	@Column(name="DESCRIPCION" ,length=250)	
	private String descripcion;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	private Participante participante;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	private Solicitud solicitud;

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

}
