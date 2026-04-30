package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Temporaria extends Empleado {

	private int cantHorasExtra;
	
	private LocalDate fechaFin;
	
	public Temporaria(String nombre, String direccion, boolean estadoCivil, LocalDate nacimiento, int sueldoBasico, int horas, LocalDate fechaFin) {
		super(nombre, direccion, estadoCivil, nacimiento, sueldoBasico);
		this.cantHorasExtra = horas;
		this.fechaFin = fechaFin;
	}
	
	public int getCantHorasExtra() {
		return cantHorasExtra;
	}
	
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	
	private int horasExtras() {
		return 40 * this.getCantHorasExtra();
	}
	
	@Override
	public int getSueldoBruto() {
		return super.getSueldoBruto() + this.horasExtras();
	}
	
	private int supera50() {
		if (this.edad() > 50) {
			return 25;
		} else {
			return 0;
		}
	}
	
	private double obraSocial() {
		return 0.1 * this.getSueldoBruto() + this.supera50();
	}
	
	private double aportesJubilatorios() {
		return this.getSueldoBruto() * 0.1 + 5 * this.getCantHorasExtra();
	}
	
	@Override
	public double getRetenciones() {
		return this.aportesJubilatorios() + this.obraSocial();
	}
	
	@Override
	public List<String> getDesglose() {
	    List<String> desglose = new ArrayList<>();
	    desglose.add("Sueldo Básico: $" + this.getSueldoBasico());
	    desglose.add("Horas Extras: $" + this.horasExtras()); 
	    desglose.add("Obra Social: -$" + this.obraSocial()); 
	    desglose.add("Aportes Jubilatorios: -$" + this.aportesJubilatorios()); 
	    
	    return desglose;
	}
}
	
