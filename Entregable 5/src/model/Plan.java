package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="planes", schema="manguito")
public class Plan {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_plan")
	private int id;
	 @Column(name="costo")
	private double costo;
	 @Column(name="destallesBeneficio")
	private	String destallesBeneficio;
	
	@ManyToOne 
	private Emprendimiento emprendimiento;
	
	public Plan () {
		super();
	}
	
	public Plan(Emprendimiento Emprendimiento, double costo) {
		this.setEmprendimiento(Emprendimiento);
		this.setCostoSuscripcion(costo);
		//el detalle del beneficio es opcional
	}
	public Emprendimiento getEmprendimiento() {
		//recuperar de la bd el emprendimiento con el id
		return null;
	}

	public void setEmprendimiento(Emprendimiento emprendimiento) {
		this.emprendimiento = emprendimiento;
	}
	public double getCostoSuscripcion() {
		return costo;
	}
	public void setCostoSuscripcion(double costo) {
		this.costo = costo;
	}
	public String getDestallesBeneficio() {
		return destallesBeneficio;
	}
	public void setDestallesBeneficio(String destallesBeneficio) {
		this.destallesBeneficio = destallesBeneficio;
	}
	public int getId() {
		return id;
	}
}
