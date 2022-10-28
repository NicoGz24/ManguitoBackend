package model;

import java.util.Date;
import javax.persistence.Entity;


@Entity
public class DonacionManguito extends Donacion{
	private int cantidadManguitos;

	
	
	public DonacionManguito() {
		super();
	}
	
	public DonacionManguito(double valorManguito,String mensajes,Date fechaDeDonacion,String medioDePago,Usuario donador, int cantManguitos) {
		super(valorManguito,mensajes,fechaDeDonacion,medioDePago,donador);
		this.setCantidadManguitos(cantManguitos);
	}
	
	public int getCantidadManguitos() {
		return cantidadManguitos;
	}

	public void setCantidadManguitos(int cantidadManguitos) {
		this.cantidadManguitos = cantidadManguitos;
	}
}
