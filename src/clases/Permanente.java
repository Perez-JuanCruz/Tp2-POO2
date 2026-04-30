package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Permanente extends Empleado{
	
	private int cantHijos;
	
	private int antiguedad;
	
	public Permanente(String nombre, String direccion, boolean estadoCivil, LocalDate nacimiento, int sueldoBasico,int hijos, int años) {
		super(nombre, direccion, estadoCivil, nacimiento, sueldoBasico);
		this.cantHijos = hijos;
		this.antiguedad = años;
	}
	
	public int getCantHijos() {
		return cantHijos;
	}
	
	public int getAntigüedad() {
		return antiguedad;
	}
	
	private int asignacionXConyuge() {
		if (this.getEstadoCivil()) {
		return 100;
		} else {
			return 0;
		}
	}
	
	private int asignacionXHijo() {
		return 150 * this.getCantHijos();
	}
	
	private int antigüedad() {
		return 50 * this.getAntigüedad();
	}
	
	private int getSueldoFamiliar() {
		return this.asignacionXHijo() + this.antigüedad() + this.asignacionXConyuge();
	}
	
	@Override
	public int getSueldoBruto() {
		return super.getSueldoBruto() + this.getSueldoFamiliar();
	}
	
	@Override
	public double getRetenciones() {
		return (this.getSueldoBruto() * 0.10 + 20 * this.getCantHijos()) + (this.getSueldoBruto() * 0.15);
	}
	
	@Override
	public List<String> getDesglose() {
	    List<String> desglose = new ArrayList<>();
	    desglose.add("Sueldo Básico: $" + this.getSueldoBasico());
	    desglose.add("Salario Familiar (Hijos, Cónyuge, Antigüedad): $" + this.getSueldoFamiliar()); 
	    desglose.add("Obra Social: -$" + (this.getSueldoBruto() * 0.10 + 20 * this.getCantHijos()));
	    desglose.add("Aportes Jubilatorios: -$" + (this.getSueldoBruto() * 0.15));
	    
	    return desglose;
	}
}
