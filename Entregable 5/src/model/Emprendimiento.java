package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="emprendimientos", schema="manguito")
public class Emprendimiento {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_emprendimiento")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="url")
	private String url;
	@Column(name="path_banner")
	private String banner;
	@Column(name="visualizar_top_donantes")
	private boolean visualizarTopDonantes;
	@Column(name="visualizar_manguitos")
	private boolean visualizarManguitos;
	
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	private List<Donacion>listaDonaciones;
	
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable
	private List<Categoria>categorias;
	
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	private List<Plan>listaPlanes;
	
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	private List<Posteo>listaPosteos;
	
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	private List<RedSocial>redesSociales;
	
	public Emprendimiento () {
		super();
	}
	
	public Emprendimiento (String nombre) {
		this.setNombre(nombre);
		this.listaPosteos = new ArrayList<Posteo>();
		this.categorias = new ArrayList<Categoria>();
		this.listaPlanes = new ArrayList<Plan>();
		this.redesSociales = new ArrayList<RedSocial>();
		this.listaDonaciones = new ArrayList<Donacion>();
	}
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void seListaCategorias(List<Categoria>categorias) {
		this.categorias= categorias;
	}
	public void agregarCategoria(Categoria categoria) {
		this.categorias.add(categoria);
	}
	public List<Posteo> getPosteos() {
		return listaPosteos;
	}
	public void setPosteos(List<Posteo>posteos) {
		this.listaPosteos=posteos;
	}
	public void nuevoPosteo(Posteo posteo) {
		this.listaPosteos.add(posteo);
	}
	public List<RedSocial> getRedesSociales() {
		return redesSociales;
	}
	public void agregarRedSocial(RedSocial redSocial) {
		this.redesSociales.add(redSocial);
	}
	public boolean isVisualizarTopDonantes() {
		return visualizarTopDonantes;
	}
	public void setVisualizarTopDonantes(boolean visualizarTopDonantes) {
		this.visualizarTopDonantes = visualizarTopDonantes;
	}
	public boolean isVisualizarManguitos() {
		return visualizarManguitos;
	}
	public void setVisualizarManguitos(boolean visualizarManguitos) {
		this.visualizarManguitos = visualizarManguitos;
	}

	public List<Plan> getPlanes() {
		return listaPlanes;
	}
	
	public void setPlanes(List<Plan>planes) {
		this.listaPlanes=planes;
	}

	public void nuevoPlan(Plan plan) {
		this.getPlanes().add(plan);
	}

	public List<Donacion> getListaDonaciones() {
		return listaDonaciones;
	}
	public void agregarDonacion(Donacion donacion) {
		this.getListaDonaciones().add(donacion);
	}

	public int getId() {
		return id;
	}
	

}
