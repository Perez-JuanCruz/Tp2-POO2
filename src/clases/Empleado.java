package clases;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public abstract class Empleado {

	private String nombre;
	
	private String direccion;
	
	private boolean estadoCivil;
	
	private LocalDate nacimiento;
	
	private int sueldoBasico;
	
	public Empleado(String nombre, String direccion, boolean estadoCivil, LocalDate nacimiento, int sueldoBasico) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.nacimiento = nacimiento;
		this.sueldoBasico= sueldoBasico;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public boolean getEstadoCivil() {
		return estadoCivil;
	}
	
	public LocalDate getNacimiento() {
		return nacimiento;
	}
	
	public int getSueldoBasico() {
		return sueldoBasico;
	}
	
	public int edad() {
		return Period.between(getNacimiento(), LocalDate.now()).getYears();
	}
	
	public int getSueldoBruto() {
		return this.getSueldoBasico();
	}
	
	public abstract double getRetenciones();
	
	public double getSueldoNeto() {
		return this.getSueldoBruto() - this.getRetenciones();
	}
	
	protected abstract double obraSocial();
	
	protected abstract double aportesJubilatorios();
	
	public abstract List<String> getDesglose();
}
