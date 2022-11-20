package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="posteos", schema="manguito")
public class Posteo {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id_posteo")
	private int id;
	@Column(name="titulo")
	private String titulo;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="path_imagen")
	private String imagen;
	
	
	public Posteo () {
		super();
	}

	public Posteo(String titulo, String descripcion, String imagen) {
		this.setTitulo(titulo);
		this.setDescripcion(descripcion);
		this.setImagen(imagen);
	}
	
	public int getId() {
		return this.id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


}
