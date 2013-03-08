package mx.gob.economia.inadem.entity.solicitud;

import javax.persistence.Entity;
import javax.persistence.Table;

import mx.gob.economia.inadem.entity.catalogo.Catalogo;

@Entity
@Table(name="PARTICIPANTE")
public class Participante extends Catalogo {

	private static final long serialVersionUID = 1L;

}
