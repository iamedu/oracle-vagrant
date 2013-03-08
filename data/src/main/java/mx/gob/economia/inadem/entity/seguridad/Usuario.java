package mx.gob.economia.inadem.entity.seguridad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Query;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import mx.gob.economia.inadem.entity.Entidad;
import mx.gob.economia.inadem.entity.EntidadController;

@Entity
@Table(name="USUARIO")
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario extends Entidad {

	private static final long serialVersionUID = 1L;

	@Column(name="USUARIOID" , length = 50 , unique = true , nullable = false)
	private String usuarioId;
	
	@Column(name="EMAIL" , length = 100 , unique = true , nullable = false)
	private String email;
	
	@Column(name="NOMBRE" , length = 100 , nullable = false)
	private String nombre;
	
	@Column(name="APELLIDOPATERNO" , length = 100 )
	private String apellidoPaterno;
	
	@Column(name="APELLIDOMATERNO" , length = 100 )
	private String apellidoMaterno;
	
	@Column(name="PASSWORD" , length = 100 , nullable = false)
	private String password;

	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name="USUARIOROL",
        joinColumns=
            @JoinColumn(name="USUARIOID", referencedColumnName="ID"),
        inverseJoinColumns=
            @JoinColumn(name="ROLID", referencedColumnName="ID")
        )
	private List<Rol> roles;
	
	

	public String geUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public String getUsuarioId() {
		return usuarioId;
	}
	
	public static synchronized Usuario usuarioLogin(String usrId,String pwd){
		EntityManager em = EntidadController.getEntityManager();
	    try {
	      Query q = em.createQuery("select a from Usuario a where a.usuarioId = :uid and a.password = :pwd'", Usuario.class);
	      q.setParameter("uid", usrId);
	      q.setParameter("pwd", pwd);
	      return (Usuario)q.getSingleResult();
	    } catch (Exception ex) {
	      ex.printStackTrace();
	      return null;
	    } finally {
	      em.close();
	    }
	}
	
}
