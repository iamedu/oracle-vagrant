package mx.gob.economia.inadem.entity.solicitud;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import mx.gob.economia.inadem.entity.catalogo.Catalogo;

@Entity
@Table(name="TIPOAPOYO")
public class TipoApoyo extends Catalogo {

	private static final long serialVersionUID = 1L;

	@ManyToMany(mappedBy="tipoApoyos")
	private List<Convocatoria> convocatorias;

	public List<Convocatoria> getConvocatorias() {
		return convocatorias;
	}

	public void setConvocatorias(List<Convocatoria> convocatorias) {
		this.convocatorias = convocatorias;
	}
}
