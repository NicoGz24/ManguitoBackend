package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="donaciones", schema="manguito")
public class Donacion {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_donacion")
	private int id;
	@Column(name="valor")
	private double valor;
	@Column(name="cant_manguitos")
	private int cantidadManguitos;
	@Column(name="mensaje")
	private	String mensaje;
	@Column(name="fecha_de_donacion")
	private	Date fechaDeDonacion;
	@Column(name="medio_de_pago")
	private String medioDePago;
	@Column(name="beneficio_canjeado")
	private boolean beneficionCanjeado;
	@Column(name="id_plan")
	private int id_plan;
	
	@OneToOne
	
	private Plan plan;
	
	@ManyToOne
	
	private Usuario donador;
	
	
	public Donacion() {
		super();
	}
	public Donacion(double valorManguito,int cantidadManguitos,String mensajes,Date fechaDeDonacion,String medioDePago,Plan plan,Usuario donador, Emprendimiento emprendimiento) {
		this.setBeneficionCanjeado(false);
		this.setCantidadManguitos(cantidadManguitos);
		this.setDonador(donador);
		this.setFechaDeDonacion(fechaDeDonacion);
		this.setMedioDePago(medioDePago);
		this.setMensajes(mensajes);
		this.setPlan(plan);
		this.setValorManguito(valorManguito);
	}
	
	
	public int getCantidadManguitos() {
		return cantidadManguitos;
	}
	public void setCantidadManguitos(int cantidadManguitos) {
		this.cantidadManguitos = cantidadManguitos;
	}
	public double getValorManguito() {
		return valor;
	}
	public void setValorManguito(double valorManguito) {
		this.valor = valorManguito;
	}
	public String getMensajes() {
		return mensaje;
	}
	public void setMensajes(String mensajes) {
		this.mensaje = mensajes;
	}
	public Date getFechaDeDonacion() {
		return fechaDeDonacion;
	}
	public void setFechaDeDonacion(Date fechaDeDonacion) {
		this.fechaDeDonacion = fechaDeDonacion;
	}
	public String getMedioDePago() {
		return medioDePago;
	}
	public void setMedioDePago(String medioDePago) {
		this.medioDePago = medioDePago;
	}
	public boolean isBeneficionCanjeado() {
		return beneficionCanjeado;
	}
	public void setBeneficionCanjeado(boolean beneficionCanjeado) {
		this.beneficionCanjeado = beneficionCanjeado;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public Usuario getDonador() {
		return donador;
	}
	public void setDonador(Usuario donador) {
		this.donador = donador;
	}
	public int getId() {
		return id;
	}

}
