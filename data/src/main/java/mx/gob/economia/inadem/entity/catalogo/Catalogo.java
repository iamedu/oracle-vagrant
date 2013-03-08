package mx.gob.economia.inadem.entity.catalogo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import mx.gob.economia.inadem.entity.Entidad;

@MappedSuperclass
public abstract class Catalogo extends Entidad {

	private static final long serialVersionUID = 1L;

	@Column(name="NOMBRE" , length=250 ,nullable = false)
	private String nombre;
	
	@Column(name="DESCRIPCION" , length=1000 )
	private String descripcion;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
