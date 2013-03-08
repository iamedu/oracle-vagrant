package mx.gob.economia.inadem.entity.ubicacion;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.gob.economia.inadem.entity.catalogo.Catalogo;

@Entity
@Table(name="MUNICIPIO")
public class Municipio extends Catalogo {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.LAZY)
	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
