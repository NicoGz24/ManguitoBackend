package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="redesSociales", schema="manguito")
public class RedSocial {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_red_social")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="url")
	private String url;
	

	public RedSocial () {
		super();
	}
	
	public RedSocial(String nombre, String url) {
		this.setNombre(nombre);
		this.setUrl(url);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}
}
