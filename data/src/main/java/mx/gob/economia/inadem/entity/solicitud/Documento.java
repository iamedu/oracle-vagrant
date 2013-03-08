package mx.gob.economia.inadem.entity.solicitud;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import mx.gob.economia.inadem.entity.catalogo.Catalogo;

@Entity
@Table(name="DOCUMENTO")
public class Documento extends Catalogo {

	private static final long serialVersionUID = 1L;

	@ManyToMany(mappedBy="documentos")
	private List<Convocatoria> convocatorias;

	public List<Convocatoria> getConvocatorias() {
		return convocatorias;
	}

	public void setConvocatorias(List<Convocatoria> convocatorias) {
		this.convocatorias = convocatorias;
	}
}

