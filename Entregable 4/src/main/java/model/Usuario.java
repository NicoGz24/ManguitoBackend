package model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="usuarios",schema = "manguito")
public class Usuario {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
	private int id;
	@Column(name="usuario", unique=true)
	private String usuario;
	@Column(name="email")
	private String email;
	@Column(name="contraseña")
	private String contraseña;
	@Column(name="esAdmin")
	private boolean esAdmin;
	@Column(name="id_emprendimiento")
	private int id_emprendimiento;
	
	@OneToOne
	private Emprendimiento emprendimiento;
	
	@OneToMany
	private List<Donacion>donaciones;
	
	
	public Usuario () {
		super();
	}
	public Usuario(String usuario, String email, String contraseña,boolean admin) {
		this.setNombre(usuario);
		this.setEmail(email);
		this.setContraseña(contraseña);
		this.setEsAdmin(admin);
		this.donaciones = new ArrayList<Donacion>();
	}
	public String getNombre() {
		return usuario;
	}
	public void setNombre(String nombre) {
		this.usuario = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public void donarManguitos(Donacion donacion) {
		this.getDonaciones().add(donacion);
		
	}
	public void comprarSuscripcion(String emprendimiento) {
		
	}
	public void desuscribirse(String emprendimiento) {	
	}
	public boolean isEsAdmin() {
		return esAdmin;
	}
	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}
	public Emprendimiento getEmprendimiento() {
		return emprendimiento;
	}
	public void registrarEmprendimiento(Emprendimiento emprendimiento) {
		this.emprendimiento = emprendimiento;
	}
	public void eliminarEmprendimiento() {
		
	}
	public List<Donacion> getDonaciones() {
		return donaciones;
	}
	public int getId() {
		return this.id;
	}
}
