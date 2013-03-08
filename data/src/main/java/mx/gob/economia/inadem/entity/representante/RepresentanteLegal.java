package mx.gob.economia.inadem.entity.representante;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RepresentanteLegal implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="REPCURP" , length = 30)
	private String curp;
	
	@Column(name="REPNOMBRE" , length = 100)
	private String nombre;
	
	@Column(name="REPAPELLIDOPATERNO" , length = 100)
	private String apellidoPaterno;
	
	@Column(name="REPAPELLIDOMATERNO" , length = 100)
	private String apellidoMaterno;
	
	@Column(name="REPCARGO" , length = 100)
	private String cargo;
	
	@Column(name="REPTELEFONO" , length = 100)
	private String telefono;
	
	@Column(name="REPEMAIL" , length = 100)
	private String email;

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
