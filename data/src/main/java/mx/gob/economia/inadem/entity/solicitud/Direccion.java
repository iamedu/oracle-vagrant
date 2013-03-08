package mx.gob.economia.inadem.entity.solicitud;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mx.gob.economia.inadem.entity.catalogo.Catalogo;

@Entity
@Table(name="DIRECCION")
public class Direccion extends Catalogo {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="direccion",orphanRemoval=true)
	private List<Programa> programas;

	public List<Programa> getProgramas() {
		return programas;
	}

	public void setProgramas(List<Programa> programas) {
		this.programas = programas;
	}
}
