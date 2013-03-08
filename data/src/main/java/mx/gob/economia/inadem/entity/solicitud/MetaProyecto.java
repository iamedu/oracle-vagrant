package mx.gob.economia.inadem.entity.solicitud;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MetaProyecto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="EMPRESASBENEFICIADAS")
	private int empresasBeneficiadas;
	
	@Column(name="EMPRESASCREADAS")
	private int empresasCreadas;
	
	@Column(name="EMPLEOSCONSERVADOSM")
	private int empleosConservadosM;
	
	@Column(name="EMPLEOSCREADOSM")
	private int empleosCreadosM;
	
	@Column(name="EMPLEOSCONSERVADOSH")
	private int empleosConservadosH;
	
	@Column(name="EMPLEOSCREADOSH")
	private int empleosCreadosH;
	
	@Column(name="EMPLEOSCONSERVADOSD")
	private int empleosConservadosD;
	
	@Column(name="EMPLEOSCREADOSD")
	private int empleosCreadosD;
	
	@Column(name="EMPLEOSCONSERVADOSI")
	private int empleosConservadosI;
	
	@Column(name="EMPLEOSCREADOSI")
	private int empleosCreadosI;
	
	@Column(name="ATENCIONEMPRENDEDORES")
	private int atencionEmprendedores;

	public int getEmpresasBeneficiadas() {
		return empresasBeneficiadas;
	}

	public void setEmpresasBeneficiadas(int empresasBeneficiadas) {
		this.empresasBeneficiadas = empresasBeneficiadas;
	}

	public int getEmpresasCreadas() {
		return empresasCreadas;
	}

	public void setEmpresasCreadas(int empresasCreadas) {
		this.empresasCreadas = empresasCreadas;
	}

	public int getEmpleosConservadosM() {
		return empleosConservadosM;
	}

	public void setEmpleosConservadosM(int empleosConservadosM) {
		this.empleosConservadosM = empleosConservadosM;
	}

	public int getEmpleosCreadosM() {
		return empleosCreadosM;
	}

	public void setEmpleosCreadosM(int empleosCreadosM) {
		this.empleosCreadosM = empleosCreadosM;
	}

	public int getEmpleosConservadosH() {
		return empleosConservadosH;
	}

	public void setEmpleosConservadosH(int empleosConservadosH) {
		this.empleosConservadosH = empleosConservadosH;
	}

	public int getEmpleosCreadosH() {
		return empleosCreadosH;
	}

	public void setEmpleosCreadosH(int empleosCreadosH) {
		this.empleosCreadosH = empleosCreadosH;
	}

	public int getEmpleosConservadosD() {
		return empleosConservadosD;
	}

	public void setEmpleosConservadosD(int empleosConservadosD) {
		this.empleosConservadosD = empleosConservadosD;
	}

	public int getEmpleosCreadosD() {
		return empleosCreadosD;
	}

	public void setEmpleosCreadosD(int empleosCreadosD) {
		this.empleosCreadosD = empleosCreadosD;
	}

	public int getEmpleosConservadosI() {
		return empleosConservadosI;
	}

	public void setEmpleosConservadosI(int empleosConservadosI) {
		this.empleosConservadosI = empleosConservadosI;
	}

	public int getEmpleosCreadosI() {
		return empleosCreadosI;
	}

	public void setEmpleosCreadosI(int empleosCreadosI) {
		this.empleosCreadosI = empleosCreadosI;
	}

	public int getAtencionEmprendedores() {
		return atencionEmprendedores;
	}

	public void setAtencionEmprendedores(int atencionEmprendedores) {
		this.atencionEmprendedores = atencionEmprendedores;
	}
	
	public int getEmpleosCreadosTotal() {
		return  empleosCreadosM+
				empleosCreadosH+
				empleosCreadosD+
				empleosCreadosI
				;
	}
	
	public int getEmpleosConservadosTotal() {
		return  empleosConservadosM+
				empleosConservadosH+
				empleosConservadosD+
				empleosConservadosI
				;
	}

}
