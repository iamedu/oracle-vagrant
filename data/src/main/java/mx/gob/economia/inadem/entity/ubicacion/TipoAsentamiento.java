package mx.gob.economia.inadem.entity.ubicacion;

import javax.persistence.Entity;
import javax.persistence.Table;

import mx.gob.economia.inadem.entity.catalogo.Catalogo;

@Entity
@Table(name="TIPOASENTAMIENTO")
public class TipoAsentamiento extends Catalogo {

	private static final long serialVersionUID = 1L;

}
