package mx.gob.economia.inadem.entity.ubicacion;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mx.gob.economia.inadem.entity.catalogo.Catalogo;

@Entity
@Table(name="ESTADO")
public class Estado extends Catalogo {

	private static final long serialVersionUID = 1L;

	@OneToMany(fetch=FetchType.EAGER,mappedBy="estado")
	private List<Municipio> municipios;

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}
}
