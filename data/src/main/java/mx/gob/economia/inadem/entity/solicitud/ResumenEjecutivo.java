package mx.gob.economia.inadem.entity.solicitud;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ResumenEjecutivo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="OBJETIVO" , length = 1000)
	private String objetivo;
	
	@Column(name="DESCRIPCION" , length = 1000)
	private String descripcion;
	
	@Column(name="MESESDURACION")
	private int mesesDuracion;

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getMesesDuracion() {
		return mesesDuracion;
	}

	public void setMesesDuracion(int mesesDuracion) {
		this.mesesDuracion = mesesDuracion;
	}
	
}
