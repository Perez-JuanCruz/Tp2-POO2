package clases;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	
	private String nombre;
	
	private int cuit;
	
	private List<Empleado> empleados;
	
	private List<ReciboDeHaberes> recibosDeHaberes;

	public Empresa(String nombre, int cuit, List<Empleado> empleados) {
		this.nombre = nombre;
		this.cuit = cuit;
		this.empleados = empleados;
		this.recibosDeHaberes = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getCuit() {
		return cuit;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}
	
	public List<ReciboDeHaberes> getRecibosDeHaberes() {
		return recibosDeHaberes;
	}
	
	public double getSueldosNetos() {
		return this.getEmpleados().stream().mapToDouble(empleado -> empleado.getSueldoNeto()).sum();
	}
	
	public int getSueldosBrutos() {
		return this.getEmpleados().stream().mapToInt(empleado -> empleado.getSueldoBruto()).sum();
	}
	
	public double getRetenciones() {
		return this.getEmpleados().stream().mapToDouble(empleado -> empleado.getRetenciones()).sum();
	}
	
	public void liquidarSueldos() {
		for (Empleado empleado : this.getEmpleados()) {
			ReciboDeHaberes recibo = new ReciboDeHaberes(empleado);
			this.recibosDeHaberes.add(recibo);
		}
	}
}
