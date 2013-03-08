package mx.gob.economia.inadem.entity.solicitud;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mx.gob.economia.inadem.entity.catalogo.Catalogo;

@Entity
@Table(name="PROGRAMA")
public class Programa extends Catalogo {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	private Direccion direccion;
	
	@OneToMany(mappedBy="programa",orphanRemoval=true)
	private List<Convocatoria> convocatorias;

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Convocatoria> getConvocatorias() {
		return convocatorias;
	}

	public void setConvocatorias(List<Convocatoria> convocatorias) {
		this.convocatorias = convocatorias;
	}
}
